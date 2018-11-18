package main.calculator;

import main.calculator.exceptions.InvalidExpressionException;
import main.calculator.expression.MyExpression;
import main.calculator.parser.LineParser;

import java.util.*;

public class Calculator {
    public void run() throws InvalidExpressionException {
        System.out.print("Claculator started!\n:");
        Scanner scanner = new Scanner(System.in);
        double result = calculate(scanner.nextLine());
        System.out.println(">" + result);
    }

    private double calculate(String line) throws InvalidExpressionException {
        MyExpression expression = new MyExpression(line);
        expression.removeSpaces();
        LineParser parser = new LineParser();
        if (expression.validate()){
            parser.parse(expression.getExpression());
        } else throw new InvalidExpressionException();
        MyExpression simpleExpression = new MyExpression(parser.getSimpleExpression());
        simpleExpression.removeSpaces();
        RPN rpn = new RPN(parser.getNegativeOperands(), parser.getPositiveOperands(), simpleExpression.getExpression());

        System.out.println(simpleExpression.getExpression());
        System.out.println(parser.getNegativeOperands());
        System.out.println(parser.getPositiveOperands());
        System.out.println(rpn.getPostFixNotation());

        double result = 0;
        Deque<Double> tempStack = new ArrayDeque<>();
        List<String> postfixNotation = rpn.getPostFixNotation();
        for (String item : postfixNotation){
            if (item.matches("-?\\d+"))
                tempStack.push(Double.valueOf(item));
            else {
                double firstOperand = tempStack.pop();
                double secondOperand = tempStack.pop();
                switch (item) {
                    case "+": result = Operation.plus(firstOperand, secondOperand); break;
                    case "-": result = Operation.minus(firstOperand, secondOperand); break;
                    case "*": result = Operation.mult(firstOperand, secondOperand); break;
                    case "/": result = Operation.div(firstOperand, secondOperand); break;
                }
                tempStack.push(result);
            }
        }
        return tempStack.peek();
    }

}
