package by.training.task3.entity.impl;


import by.training.task3.entity.Component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {

    private List<Component> textComponentsList;
    private TextComponentType textComponentType;

    public TextComposite(TextComponentType textComponentType) {
        this.textComponentType = textComponentType;
        this.textComponentsList = new ArrayList<>();
    }

    @Override
    public void add(Component component) {
        textComponentsList.add(component);
    }

    @Override
    public void remove(Component component) {
        textComponentsList.remove(component);
    }

    @Override
    public Component getElement(int index) {
        return textComponentsList.get(index);
    }

    public TextComponentType getTextComponentType() {
        return textComponentType;
    }

    public List<Component> getTextComponentsList() {
        return textComponentsList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : textComponentsList) {
            stringBuilder.append(component);
        }
        return stringBuilder.toString();
    }
}
