package by.training.task3.util;

import by.training.task3.exception.CalculateException;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    private String expressionStr;
    private Deque<Integer> resultDeque;
    private Deque<Character> operationsDeque;
    private int i;
    private char symbol;

    public Calculator(String expressionStr) {
        this.expressionStr = expressionStr;
        operationsDeque = new ArrayDeque<>();
        resultDeque = new ArrayDeque<>();
        i = 0;
    }


    public int calculate() throws CalculateException {
        replaceOperatorsInExpression();
        while (i < expressionStr.length()) {
            symbol = expressionStr.charAt(i);
            checkSymbolForDigital();
        }
        doWhileOperationsDequeIsNotEmpty();
        return resultDeque.pop();
    }

    private void replaceOperatorsInExpression() {
        expressionStr = expressionStr.replace("<<", "<");
        expressionStr = expressionStr.replace(">>", ">");
    }

    private void checkSymbolForDigital() throws CalculateException {
        if (isDigit(symbol)) {
            pushDigitToResultDeque();
        } else {
            doIfNotDigit();
        }
    }

    private void pushDigitToResultDeque() {
        StringBuilder number = new StringBuilder();
        while (i < expressionStr.length() && isDigit(expressionStr.charAt(i))) {
            number.append(symbol);
            i++;
        }
        resultDeque.push(Integer.valueOf(number.toString()));
    }


    private void doIfNotDigit() throws CalculateException {
        if (operationsDeque.isEmpty() || getPriority(symbol) < getPriority(operationsDeque.peek())) {
            operationsDeque.push(symbol);
        } else {
            if (symbol == ')') {
                doIfSymbolIsCloseBracket();
            } else {
                doIfSymbolNotCloseBracket();
            }
        }
        ++i;
    }

    private void doIfSymbolIsCloseBracket() throws CalculateException {
        while (operationsDeque.peek() != null && operationsDeque.peek() != '(') {
            calculate(operationsDeque.pop(), resultDeque);
        }
        operationsDeque.pop();
    }

    private void doIfSymbolNotCloseBracket() throws CalculateException {
        while (!operationsDeque.isEmpty() && operationsDeque.peek() != '(' &&
                getPriority(symbol) > getPriority(operationsDeque.peek())) {
            calculate(operationsDeque.pop(), resultDeque);
        }
        operationsDeque.push(symbol);
    }

    private void doWhileOperationsDequeIsNotEmpty() throws CalculateException {
        while (!operationsDeque.isEmpty()) {
            calculate(operationsDeque.pop(), resultDeque);
        }
    }

    private boolean isDigit(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }

    private void calculate(char operation, Deque<Integer> result) throws CalculateException {
        int firstNumber;
        int secondNumber;
        switch (operation) {
            case '~':
                firstNumber = result.pop();
                result.push(~firstNumber);
                return;
            case '&':
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(firstNumber & secondNumber);
                return;
            case '|':
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(firstNumber | secondNumber);
                return;
            case '>':
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(secondNumber >> firstNumber);
                return;
            case '<':
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(secondNumber << firstNumber);
                return;
            case '^':
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(firstNumber ^ secondNumber);
                return;
            default:
                throw new CalculateException();
        }
    }

    private int getPriority(char symbol) {
        switch (symbol) {
            case '(':
                return 0;
            case '~':
                return 1;
            case '>':
            case '<':
                return 2;
            case '&':
                return 3;
            case '^':
                return 4;
            case '|':
                return 5;
            default:
                return 100;
        }
    }
}
