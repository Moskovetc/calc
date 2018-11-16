package main.calculator.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineParser {
    private final String line;

    public LineParser(String line) {
        this.line = line;
    }

    private boolean isOperator(String item) {
        boolean result = false;
        switch (item) {
            case "+":
                result = true;
                break;
            case "-":
                result = true;
                break;
            case "*":
                result = true;
                break;
            case "/":
                result = true;
                break;
        }
        return result;
    }

    private boolean isOperand(String item){
        boolean result = false;
        Pattern operator = Pattern.compile("[\\-\\+]?\\d+");
        Matcher matcher = operator.matcher(item);
        if (item.equals(matcher.group(0))) result = true;
        return result;
    }
    public List<String> getOperands() throws InvalidExpressionException {
        List<String> items = new ArrayList<>();
        StringBuilder item = new StringBuilder();
        int i = 0;
//        if ('-' == line.charAt(0) & !Character.isDigit(line.charAt(1))) throw new InvalidExpressionException();
        while (i < line.length()){
            char firstSymbol = line.charAt(i);
            char secondSymbol = line.charAt(i++);
            char thirdSymbol = line.charAt(i++);

            if ('-' == symbol) item.append(symbol);
            if (Character.isDigit(symbol)) item.append(symbol);
            else if (Character)
        }
    }

    public List<String> getOperators() {
    }
}
