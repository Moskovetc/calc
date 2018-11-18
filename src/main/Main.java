package main;

import main.calculator.Calculator;
import main.calculator.exceptions.InvalidExpressionException;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.run();
        } catch (InvalidExpressionException e) {
            e.printStackTrace();
        }
    }
}
