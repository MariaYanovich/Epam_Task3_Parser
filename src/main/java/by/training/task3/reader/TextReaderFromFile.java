package by.training.task3.reader;

import by.training.task3.exception.TextReaderFromFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class TextReaderFromFile {
    private static final Logger LOGGER = LogManager.getLogger(TextReaderFromFile.class.getName());

    private String textStr;
    private File file;

    public TextReaderFromFile() throws TextReaderFromFileException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try {
            this.textStr = "";
            this.file = new File(Objects.requireNonNull(classLoader.
                    getResource("text.txt")).getFile());
            readTextFromFile();
        } catch (NullPointerException e) {
            LOGGER.error("Error in reading from txt file");
            throw new TextReaderFromFileException();
        }
    }

    private void readTextFromFile() throws TextReaderFromFileException {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                textStr = textStr.concat(sc.nextLine()).concat("\n");
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Can't find txt file");
            throw new TextReaderFromFileException();
        }
    }

    public String getTextStr() {
        return textStr;
    }
}
