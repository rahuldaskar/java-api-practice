package com.example.app;
import java.net.URI;
import java.net.http.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;


public class Java17Examples {

    public static void main(String[] args) {

        // =========================
        // 1. Records
        // =========================

        Person p = new Person("Rahul", 30);
        System.out.println("Record: " + p);
        System.out.println("Name: " + p.name());

        // =========================
        // 2. Pattern Matching (instanceof)
        // =========================

        Object obj = "Hello Java 17";

        if (obj instanceof String str) {
            System.out.println("Length: " + str.length());
        }

        // =========================
        // 3. Switch Expressions
        // =========================

        int day = 3;

        String result = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Other";
        };

        System.out.println("Switch result: " + result);

        // =========================
        // 4. Text Blocks
        // =========================

        String json = """
                {
                  "name": "Rahul",
                  "age": 30
                }
                """;

        System.out.println("Text Block JSON:\n" + json);

        // =========================
        // 5. Sealed Classes
        // =========================

        Shape shape = new Circle(5);
        System.out.println("Area: " + calculateArea(shape));

        shape = new Rectangle(4, 6);
        System.out.println("Area: " + calculateArea(shape));

        // =========================
        // 6. Enhanced Random API
        // =========================

        Random random = new Random();
        System.out.println("Random int: " + random.nextInt(100));
    }

    // =========================
    // Switch + Sealed usage
    // =========================

    static double calculateArea(Shape shape) {
        return switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Rectangle r -> r.length() * r.width();
        };
    }
}

// =========================
// Record Example
// =========================

record Person(String name, int age) { }

// =========================
// Sealed Classes Example
// =========================

sealed interface Shape permits Circle, Rectangle { }

record Circle(double radius) implements Shape { }

record Rectangle(double length, double width) implements Shape { }