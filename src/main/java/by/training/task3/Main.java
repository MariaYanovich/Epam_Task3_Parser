package by.training.task3;

import by.training.task3.entity.impl.TextComposite;
import by.training.task3.exception.SorterException;
import by.training.task3.parser.Parser;
import by.training.task3.parser.impl.TextParser;
import by.training.task3.reader.TextReaderFromFile;
import by.training.task3.sorter.SortParagraphsByNumberOfSentences;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws SorterException {

        TextReaderFromFile textReaderFromFile = new TextReaderFromFile();
        TextComposite textComponents;
        Parser parser;
        parser = new TextParser();
        textComponents = parser.parse(textReaderFromFile.getTextStr());
        LOGGER.debug(textComponents.getTextComponentsList());
        SortParagraphsByNumberOfSentences sortParagraphsByNumberOfSentences = new
                SortParagraphsByNumberOfSentences();
        LOGGER.debug(sortParagraphsByNumberOfSentences.sort(textComponents));

    }
}
