package by.training.task3.entity;

public interface Component {

    void add(Component component);

    void remove(Component component);

    Component getElement(int index);

}
