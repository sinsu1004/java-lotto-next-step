package stringCalculator.domain;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;


public enum ArithmeticOperator {

    PLUS("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
    MINUS("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDE("/", (firstNumber, secondNumber) -> firstNumber / secondNumber);

    private final String operator;
    private final IntBinaryOperator experssion;

    ArithmeticOperator(String operator, IntBinaryOperator expression) {
        this.operator = operator;
        this.experssion = expression;
    }

    public int calculate(int firstNumber, int secondNumber) {
        return experssion.applyAsInt(firstNumber, secondNumber);
    }

    public static ArithmeticOperator from(String operator) {
        return Arrays.stream(values())
                .filter(value -> operator.equals(value.operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }
}