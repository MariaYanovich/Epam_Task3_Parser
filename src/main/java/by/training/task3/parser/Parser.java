package by.training.task3.parser;

import by.training.task3.entity.impl.TextComposite;

public interface Parser {
    TextComposite parse(String text);
}
