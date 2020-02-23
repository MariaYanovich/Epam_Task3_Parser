package by.training.task3.parser.impl;

import by.training.task3.entity.impl.TextComponentType;
import by.training.task3.entity.impl.TextComposite;
import by.training.task3.parser.CompositeParser;
import by.training.task3.parser.Parser;

public class ParagraphParser implements Parser {

    private static final String SENTENCE_REGEX = "(?m)(?s)([^\\.!?]+)([\\.!?]+)[\r\n\t]*";
    private Parser nextParser;

    public ParagraphParser() {
        this.nextParser = new SentenceParser();
    }

    @Override
    public TextComposite parse(String textToParse) {
        return CompositeParser.parseComposite(textToParse, TextComponentType.PARAGRAPH, SENTENCE_REGEX, nextParser);
    }
}
