package com.example.app;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

// For Structured Concurrency (preview)
import jdk.incubator.concurrent.StructuredTaskScope;

public class Java21Examples {

    public static void main(String[] args) throws Exception {

        // =========================
        // 1. Virtual Threads
        // =========================

        System.out.println("Virtual Threads Example:");

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            List<Callable<String>> tasks = IntStream.range(1, 5)
                    .mapToObj(i -> (Callable<String>) () -> {
                        Thread.sleep(100);
                        return "Task " + i + " executed by " + Thread.currentThread();
                    })
                    .toList();

            List<Future<String>> results = executor.invokeAll(tasks);

            for (Future<String> f : results) {
                System.out.println(f.get());
            }
        }

        // =========================
        // 2. Structured Concurrency (Preview)
        // =========================

        System.out.println("\nStructured Concurrency Example:");

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            Future<String> task1 = scope.fork(() -> {
                Thread.sleep(200);
                return "Result from Task 1";
            });

            Future<String> task2 = scope.fork(() -> {
                Thread.sleep(300);
                return "Result from Task 2";
            });

            scope.join();           // wait for all
            scope.throwIfFailed(); // fail fast

            System.out.println(task1.resultNow());
            System.out.println(task2.resultNow());
        }

        // =========================
        // 3. Record Patterns
        // =========================

        System.out.println("\nRecord Pattern Example:");

        Object obj = new Person("Rahul", 30);

        if (obj instanceof Person(String name, int age)) {
            System.out.println("Name: " + name + ", Age: " + age);
        }

        // =========================
        // 4. Pattern Matching for Switch
        // =========================

        System.out.println("\nSwitch Pattern Matching:");

        Object input = 42;

        String result = switch (input) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: " + s;
            case Person p -> "Person: " + p.name();
            default -> "Unknown";
        };

        System.out.println(result);

        // =========================
        // 5. Sequenced Collections
        // =========================

        System.out.println("\nSequenced Collections:");

        SequencedCollection<String> seq = new ArrayList<>();
        seq.add("A");
        seq.add("B");
        seq.add("C");

        System.out.println("First: " + seq.getFirst());
        System.out.println("Last: " + seq.getLast());

        System.out.println("Reversed:");
        seq.reversed().forEach(System.out::println);
    }
}

// =========================
// Record Example
// =========================

record Person(String name, int age) { }
