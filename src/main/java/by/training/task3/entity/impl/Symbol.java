package by.training.task3.entity.impl;

import by.training.task3.entity.Component;

public class Symbol implements Component {

    private String symbolStr;

    public Symbol(String symbolStr) {
        this.symbolStr = symbolStr;
    }


    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getElement(int index) {
        throw new UnsupportedOperationException();
    }

    @Override

    public String toString() {
        return symbolStr;
    }
}
