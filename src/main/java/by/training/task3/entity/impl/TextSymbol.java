package by.training.task3.entity.impl;

import by.training.task3.entity.Component;

public class TextSymbol implements Component {

    private String symbolStr;

    public TextSymbol(String symbolStr) {
        this.symbolStr = symbolStr;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }


    @Override
    public String toString() {
        return symbolStr;
    }
}
