package main.calculator;

import main.calculator.parser.LineParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public void run() {
        System.out.print("Claculator started!\n:");
        Scanner scanner = new Scanner(System.in);
        String result = calculate(scanner.nextLine());
        System.out.println(">" + result);
    }

    private String removeSpaces(String line) {
        return line.replaceAll("\\s+", "");
    }

    private String calculate(String line) {
        line = removeSpaces(line);
        LineParser parser= new LineParser(line);
        List<String> operands = parser.getOperands();
        List<String> operators = parser.getOperators();

        System.out.println(operands + " " + operators);
        return line;
    }

}
