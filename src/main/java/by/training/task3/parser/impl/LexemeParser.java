package by.training.task3.parser.impl;

import by.training.task3.enums.TextComponentType;
import by.training.task3.entity.impl.TextComposite;
import by.training.task3.parser.CompositeParser;
import by.training.task3.parser.Parser;

public class LexemeParser implements Parser {
    private static final String WORD_REGEX = "(?m)(\\W|\\D)*(\\w|\\d)+(\\W|\\D)*";
    private Parser nextParser;

    public LexemeParser() {
        this.nextParser = new WordParser();
    }

    @Override
    public TextComposite parse(String textToParse) {
        return CompositeParser.parseComposite(textToParse, TextComponentType.LEXEME, WORD_REGEX, nextParser);
    }
}
