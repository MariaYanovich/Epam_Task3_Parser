package by.training.task3.parser.impl;


import by.training.task3.enums.TextComponentType;
import by.training.task3.entity.impl.TextComposite;
import by.training.task3.parser.CompositeParser;
import by.training.task3.parser.Parser;

public class SentenceParser implements Parser {
    private static final String LEXEME_REGEX = "(?m)([^ ]+)( *)";
    private Parser nextParser;

    public SentenceParser() {
        this.nextParser = new LexemeParser();
    }

    @Override
    public TextComposite parse(String textToParse) {

        return CompositeParser.parseComposite(textToParse, TextComponentType.SENTENCE, LEXEME_REGEX, nextParser);
    }
}
