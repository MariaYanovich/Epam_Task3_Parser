package by.training.task3.parser.impl;

import by.training.task3.entity.impl.TextComposite;
import by.training.task3.enums.TextComponentType;
import by.training.task3.exception.CalculateException;
import by.training.task3.parser.Parser;
import by.training.task3.util.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser implements Parser {
    public static final String EXPRESSION_REGEX = "(?m)(~|~\\(*|\\(*~|\\()?\\d+(\\.\\d+)?(( *\\)* *)([-+*/&|^]|<<|>>) *~* *\\(* *~* *\\d+(\\.\\d+)?\\)*)+";
    private Parser nextParser;

    public ExpressionParser() {
        this.nextParser = new TextParser();
    }

    @Override
    public TextComposite parse(String textToParse) {

        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        Pattern pattern = Pattern.compile(EXPRESSION_REGEX);
        Matcher matcher = pattern.matcher(textToParse);
        while (matcher.find()) {
            String expressionString = matcher.group();
            Calculator calculator = new Calculator(expressionString);
            int expressionValue = 0;
            try {
                expressionValue = calculator.calculate();
            } catch (CalculateException e) {
                e.printStackTrace();
            }
            textToParse = textToParse.replace(expressionString, String.valueOf(expressionValue));
        }
        TextComposite text = nextParser.parse(textToParse);
        composite.add(text);
        return composite;

    }
}
