package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw2.Task4.callingInfo;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Получение имени класса")
    public void classNameTest() {
        assertThat(callingInfo().className()).isEqualTo("edu.hw2.Task4Test");
    }

    @Test
    @DisplayName("Получение имени метода")
    public void methodNameTest() {
        assertThat(callingInfo().methodName()).isEqualTo("methodNameTest");
    }
}
