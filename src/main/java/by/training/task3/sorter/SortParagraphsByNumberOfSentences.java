package by.training.task3.sorter;

import by.training.task3.entity.Component;
import by.training.task3.entity.impl.TextComposite;
import by.training.task3.enums.TextComponentType;
import by.training.task3.exception.SorterException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class SortParagraphsByNumberOfSentences {

    private static final Logger LOGGER = LogManager.getLogger(SortParagraphsByNumberOfSentences.class.getName());

    public TextComposite sort(TextComposite text) throws SorterException {
        if (text.getTextComponentType() == TextComponentType.TEXT) {
            List<Component> components = text.getTextComponentsList();
            components.sort(new ComparatorParagraphs());
            return text;
        } else {
            LOGGER.error("Error in sorting");
            throw new SorterException();
        }
    }

    private static class ComparatorParagraphs implements Comparator<Component> {
        @Override
        public int compare(Component o1, Component o2) {
            return Integer.compare(o1.getTextComponentsList().size(), o2.getTextComponentsList().size());
        }
    }
}
