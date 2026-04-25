package com.example.app;
import java.time.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.Base64;

public class Java8Examples {

public static void main(String[] args) {

    // =========================
    // 1. Functional Interfaces
    // =========================

    Predicate<Integer> isEven = x -> x % 2 == 0;
    System.out.println("Predicate: " + isEven.test(4));

    Function<String, Integer> lengthFn = String::length;
    System.out.println("Function: " + lengthFn.apply("Java"));

    Consumer<String> printer = System.out::println;
    printer.accept("Consumer: Hello");

    Supplier<Double> random = Math::random;
    System.out.println("Supplier: " + random.get());

    // =========================
    // 2. Stream API
    // =========================

    List<Integer> list = Arrays.asList(1,2,3,4,5,6);

    List<Integer> processed = list.stream()
            .filter(x -> x % 2 == 0)
            .map(x -> x * x)
            .collect(Collectors.toList());

    System.out.println("Stream processed: " + processed);

    // flatMap
    List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1,2),
            Arrays.asList(3,4)
    );

    List<Integer> flat = nested.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

    System.out.println("FlatMap: " + flat);

    // reduce
    int sum = list.stream().reduce(0, Integer::sum);
    System.out.println("Reduce sum: " + sum);

    // =========================
    // 3. Method References
    // =========================

    list.forEach(System.out::println);

    Function<String, Integer> parse = Integer::parseInt;
    System.out.println("Method Ref parse: " + parse.apply("10"));

    Supplier<List<String>> listSupplier = ArrayList::new;
    System.out.println("Constructor Ref: " + listSupplier.get());

    // =========================
    // 4. Default & Static Methods
    // =========================

    Vehicle vehicle = new Car();
    vehicle.start();
    Vehicle.info();

    // =========================
    // 5. Optional
    // =========================

    Optional<String> name = Optional.ofNullable(null);
    System.out.println("Optional: " + name.orElse("Default"));

    // =========================
    // 6. Date-Time API
    // =========================

    LocalDate today = LocalDate.now();
    System.out.println("Today: " + today);

    LocalDateTime now = LocalDateTime.now();
    System.out.println("Now: " + now);

    ZonedDateTime zoned = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
    System.out.println("Zoned: " + zoned);

    // =========================
    // 7. forEach
    // =========================

    list.forEach(x -> {
        if (x % 2 == 0) System.out.println("Even: " + x);
    });

    Map<String, Integer> map = Map.of("A",1,"B",2);
    map.forEach((k,v) -> System.out.println(k + ":" + v));

    // =========================
    // 8. Parallel Streams
    // =========================

    list.parallelStream()
            .map(x -> x * x)
            .forEach(System.out::println);

    // =========================
    // 9. Collectors
    // =========================

    Map<Boolean, List<Integer>> partition =
            list.stream()
                    .collect(Collectors.partitioningBy(x -> x % 2 == 0));

    System.out.println("Partition: " + partition);

    Map<Integer, List<String>> grouped =
            Arrays.asList("a","bb","ccc")
                    .stream()
                    .collect(Collectors.groupingBy(String::length));

    System.out.println("Grouped: " + grouped);

    String joined =
            Arrays.asList("Java","8","Rocks")
                    .stream()
                    .collect(Collectors.joining(" "));

    System.out.println("Joined: " + joined);

    // =========================
    // 10. Base64
    // =========================

    String encoded = Base64.getEncoder()
            .encodeToString("Hello".getBytes());

    System.out.println("Encoded: " + encoded);

    String decoded = new String(
            Base64.getDecoder().decode(encoded)
    );

    System.out.println("Decoded: " + decoded);
}


}

// =========================
// Interface + Implementation
// =========================

interface Vehicle {
default void start() {
System.out.println("Vehicle started");
}

static void info() {
    System.out.println("Vehicle info");
}


}

class Car implements Vehicle {
}
