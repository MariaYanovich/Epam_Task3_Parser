package by.training.task3.runner;

import by.training.task3.entity.impl.TextComposite;
import by.training.task3.exception.SorterException;
import by.training.task3.exception.TextReaderFromFileException;
import by.training.task3.parser.Parser;
import by.training.task3.parser.impl.ExpressionParser;
import by.training.task3.parser.impl.TextParser;
import by.training.task3.reader.TextReaderFromFile;
import by.training.task3.sorter.SortParagraphsByNumberOfSentences;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class.getName());

    public static void run() {

        TextReaderFromFile textReaderFromFile = null;
        try {
            textReaderFromFile = new TextReaderFromFile();
        } catch (TextReaderFromFileException e) {
            LOGGER.error("Error in reading from file");
        }

        TextComposite textComponents;
        Parser parser;
        if (textReaderFromFile != null) {
            parser = new TextParser();
            textComponents = parser.parse(textReaderFromFile.getTextStr());
            LOGGER.debug(textComponents.getTextComponentsList());
            SortParagraphsByNumberOfSentences sortParagraphsByNumberOfSentences = new
                    SortParagraphsByNumberOfSentences();
            try {
                LOGGER.debug(sortParagraphsByNumberOfSentences.sort(textComponents));
            } catch (SorterException e) {
                LOGGER.error("Error in sorting");
            }
            parser = new ExpressionParser();
            textComponents = parser.parse(textReaderFromFile.getTextStr());
            LOGGER.debug(textComponents.getTextComponentsList());
        }
    }
}
