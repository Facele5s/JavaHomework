package edu.hw2;

import edu.hw2.Expr.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Тест из примера")
    public void exampleTest() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        assertThat(res.evaluate()).isEqualTo(37);
    }

    @Test
    @DisplayName("Тест на создание константы")
    public void createConstantTest() {
        Constant constant = new Constant(6);
        double actual = constant.evaluate();
        assertThat(actual).isEqualTo(6.0);

        constant = new Constant(-7);
        actual = constant.evaluate();
        assertThat(actual).isEqualTo(-7.0);

        constant = new Constant(0);
        actual = constant.evaluate();
        assertThat(actual).isEqualTo(0.0);
    }

    @Test
    @DisplayName("Тест на смену знака числа")
    public void negateTest() {
        Negate negate = new Negate(new Constant(5));
        double actual = negate.evaluate();
        assertThat(actual).isEqualTo(-5.0);

        negate = new Negate(new Constant(-105));
        actual = negate.evaluate();
        assertThat(actual).isEqualTo(105.0);

        negate = new Negate(new Constant(0));
        actual = negate.evaluate();
        assertThat(actual).isEqualTo(0.0);
    }

    @Test
    @DisplayName("Тест сложения")
    public void additionTest() {
        Addition addition = new Addition(new Constant(-1), new Constant(10));
        double actual = addition.evaluate();
        assertThat(actual).isEqualTo(9.0);

        addition = new Addition(new Constant(-2), new Constant(-7));
        actual = addition.evaluate();
        assertThat(actual).isEqualTo(-9.0);
    }

    @Test
    @DisplayName("Тест умножения")
    public void multiplicationTest() {
        Multiplication multiplication = new Multiplication(new Constant(15), new Constant(4));
        double actual = multiplication.evaluate();
        assertThat(actual).isEqualTo(60.0);

        multiplication = new Multiplication(new Constant(-2), new Constant(-7));
        actual = multiplication.evaluate();
        assertThat(actual).isEqualTo(14.0);

        multiplication = new Multiplication(new Constant(-8), new Constant(60));
        actual = multiplication.evaluate();
        assertThat(actual).isEqualTo(-480.0);

        multiplication = new Multiplication(new Constant(54), new Constant(-2));
        actual = multiplication.evaluate();
        assertThat(actual).isEqualTo(-108.0);
    }

    @Test
    @DisplayName("Тест возведения в степень")
    public void expTest() {
        Exponent exponent = new Exponent(new Constant(10), 2);
        double actual = exponent.evaluate();
        assertThat(actual).isEqualTo(100.0);

        exponent = new Exponent(new Constant(-2), 2);
        actual = exponent.evaluate();
        assertThat(actual).isEqualTo(4.0);

        exponent = new Exponent(new Constant(0.5), 3);
        actual = exponent.evaluate();
        assertThat(actual).isEqualTo(0.125);
    }
}
