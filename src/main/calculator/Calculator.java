package main.calculator;

import main.calculator.exceptions.InvalidExpressionException;
import main.calculator.expression.MyExpression;
import main.calculator.parser.LineParser;

import java.util.Scanner;

public class Calculator {
    public void run() throws InvalidExpressionException {
        System.out.print("Claculator started!\n:");
        Scanner scanner = new Scanner(System.in);
        String result = calculate(scanner.nextLine());
        System.out.println(">" + result);
    }

    private String calculate(String line) throws InvalidExpressionException {
        MyExpression expression = new MyExpression(line);
        expression.removeSpaces();
        LineParser parser = new LineParser();
        if (expression.validate()){
            parser.parse(expression.getExpression());
        } else throw new InvalidExpressionException();
        MyExpression simpleExpression = new MyExpression(parser.getSimpleExpression());
        simpleExpression.removeSpaces();
        System.out.println(simpleExpression.getExpression());
        System.out.println(parser.getNegativeOperands());
        System.out.println(parser.getPositiveOperands());
        return expression.getExpression();
    }

}
