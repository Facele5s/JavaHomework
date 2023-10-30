package edu.hw2;

public sealed interface Expr permits Expr.Constant, Expr.Negate, Expr.Exponent, Expr.Addition, Expr.Multiplication {
    double evaluate();

    public record Constant(double value) implements Expr {
        public double evaluate() {
            return value;
        }
    }

    public record Negate(Expr value) implements Expr {
        public double evaluate() {
            if (value.evaluate() == 0) {
                return 0.0;
            } else {
                return -value.evaluate();
            }
        }
    }

    public record Exponent(Expr base, int n) implements Expr {
        public double evaluate() {
            return Math.pow(base.evaluate(), n);
        }
    }

    public record Addition(Expr a, Expr b) implements Expr {
        public double evaluate() {
            return a.evaluate() + b.evaluate();
        }
    }

    public record Multiplication(Expr a, Expr b) implements Expr {
        public double evaluate() {
            return a.evaluate() * b.evaluate();
        }
    }
}
