package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.MethodVisitor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import net.bytebuddy.jar.asm.Label;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.objectweb.asm.Opcodes.*;

public class Task3Test {
    @Test
    @DisplayName("Проверка вычисления числа Фибоначчи")
    public void fibonacciTest()
    throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        DynamicType.Unloaded unloadedType = new ByteBuddy()
            .subclass(Object.class)
            .name("SimpleClass")
            .defineMethod("fib", long.class, ACC_PUBLIC | ACC_STATIC)
            .withParameters(int.class)
            .intercept(new Implementation.Simple(new ByteCodeAppender() {
                @Override
                public Size apply(
                    MethodVisitor visitor,
                    Implementation.Context context,
                    MethodDescription methodDescription
                ) {
                    Label label1 = new Label();
                    Label label2 = new Label();
                    visitor.visitCode();
                    visitor.visitInsn(LCONST_0);
                    visitor.visitVarInsn(LSTORE, 1);
                    visitor.visitInsn(LCONST_1);
                    visitor.visitVarInsn(LSTORE, 3);
                    visitor.visitInsn(LCONST_1);
                    visitor.visitVarInsn(LSTORE, 5);
                    visitor.visitIincInsn(0, -1);
                    visitor.visitVarInsn(ILOAD, 0);

                    visitor.visitJumpInsn(IFEQ, label2);
                    visitor.visitLabel(label1);

                    visitor.visitFrame(F_FULL, 4,
                        new Object[] {
                            INTEGER,
                            LONG,
                            LONG,
                            LONG
                        }, 0, null);

                    visitor.visitVarInsn(LLOAD, 3);
                    visitor.visitVarInsn(LLOAD, 1);
                    visitor.visitInsn(LADD);
                    visitor.visitVarInsn(LSTORE, 5);
                    visitor.visitIincInsn(0, -1);

                    visitor.visitVarInsn(ILOAD, 0);
                    visitor.visitVarInsn(LLOAD, 5);
                    visitor.visitVarInsn(LLOAD, 3);
                    visitor.visitVarInsn(LSTORE, 1);
                    visitor.visitVarInsn(LSTORE, 3);
                    visitor.visitJumpInsn(IFNE, label1);

                    visitor.visitFrame(F_FULL, 4,
                        new Object[] {
                            INTEGER,
                            LONG,
                            LONG,
                            LONG
                        }, 0, null);

                    visitor.visitLabel(label2);
                    visitor.visitVarInsn(LLOAD, 5);
                    visitor.visitInsn(LRETURN);
                    visitor.visitEnd();

                    return new Size(5, 7);
                }
            }))
            .make();

        Class<?> dynamicType = unloadedType.load(getClass()
            .getClassLoader())
            .getLoaded();

        Method fib = dynamicType.getMethod("fib", int.class);

        Long actual = (Long) fib.invoke(dynamicType.getDeclaredConstructor().newInstance(), 15);
        long expected = 610L;

        assertEquals(expected, actual);
    }
}
