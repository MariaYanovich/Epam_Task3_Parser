package by.training.task3.parser.impl;

import by.training.task3.entity.impl.TextSymbol;
import by.training.task3.enums.TextComponentType;
import by.training.task3.entity.impl.TextComposite;
import by.training.task3.parser.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser implements Parser {
    public static final String SYMBOL_REGEX = ".|\\n";

    @Override
    public TextComposite parse(String textToParse) {
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        Pattern symbolPattern = Pattern.compile(SYMBOL_REGEX);
        Matcher symbolMatcher = symbolPattern.matcher(textToParse);
        String symbol;
        while (symbolMatcher.find()) {
            symbol = symbolMatcher.group();
            composite.add(new TextSymbol(symbol));
        }
        return composite;
    }
}
