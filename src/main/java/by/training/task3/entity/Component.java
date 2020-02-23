package by.training.task3.entity;

import java.util.List;

public interface Component {

    void add(Component component);

    List<Component> getTextComponentsList();
}
