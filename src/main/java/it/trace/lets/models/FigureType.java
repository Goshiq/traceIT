package it.trace.lets.models;

public enum FigureType {
    NEW ("No type"),
    CYLINDER ("Цилиндр"),
    PLANE ("Плоскость"),
    SPHERE ("Сфера"),
    SQUARE ("Квадрат"),
    TRIANGLE ("Треугольник");

    private String  name;

    FigureType (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
