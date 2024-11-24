package factory;

import java.util.ArrayList;

/*
    The Factory Design Pattern is a Creational pattern that provides a way to instantiate objects
    without specifying their exact class.
    It delegates the responsibility of object creation to a factory method or class.

    Purpose
    => To centralize the creation of objects.
    => To avoid exposing the client to the instantiation logic.

    ========

    1. Factory Design Pattern / Factory Method Design Pattern:
        -> Use when you need to create objects of a single type (e.g., shape Interface).
        -> The ShapeFactory is responsible for creating objects of a single product type (Shape interface),
            such as Circle, Rectangle, or Square.

    2. Abstract Factory Design Pattern:
        Use when you need to create groups of related objects (e.g., UI components for different platforms).
 */
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(shapeFactory.getShape("Rectangle"));
        shapes.add(shapeFactory.getShape("Circle"));
        shapes.add(shapeFactory.getShape("Square"));

        for(Shape shape: shapes){
            shape.draw();
        }
    }
}
