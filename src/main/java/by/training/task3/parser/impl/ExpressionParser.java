package by.training.task3.parser.impl;

import by.training.task3.entity.impl.TextComposite;
import by.training.task3.enums.TextComponentType;
import by.training.task3.exception.CalculateException;
import by.training.task3.parser.Parser;
import by.training.task3.util.ExpressionCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser implements Parser {
    public static final String EXPRESSION_REGEX = "(?m)(~|~\\(*|\\(*~|\\()?\\d+(\\.\\d+)?(( *\\)* *)([-+*/&|^]|<<|>>) *~* *\\(* *~* *\\d+(\\.\\d+)?\\)*)+";
    private static final Logger LOGGER = LogManager.getLogger(ExpressionParser.class.getName());
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
            ExpressionCalculator expressionCalculator = new ExpressionCalculator(expressionString);
            int expressionValue = 0;
            try {
                expressionValue = expressionCalculator.calculateExpression();
            } catch (CalculateException e) {
                LOGGER.error("Error in calculating number");
            }
            textToParse = textToParse.replace(expressionString, String.valueOf(expressionValue));
        }
        TextComposite text = nextParser.parse(textToParse);
        composite.add(text);
        return composite;

    }
}
