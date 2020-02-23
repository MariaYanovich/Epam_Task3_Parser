package by.training.task3.parser.impl;

import by.training.task3.entity.impl.TextComposite;
import by.training.task3.enums.TextComponentType;
import by.training.task3.parser.CompositeParser;
import by.training.task3.parser.Parser;


public class TextParser implements Parser {

    private static final String PARAGRAPH_REGEX = "(?m)(?s)[^\n]+[\r\n\t]*";

    private Parser nextParser;

    public TextParser() {
        this.nextParser = new ParagraphParser();
    }

    @Override
    public TextComposite parse(String textToParse) {
        return CompositeParser.parseComposite(textToParse, TextComponentType.TEXT, PARAGRAPH_REGEX, nextParser);
    }
}
