package com.example.app;
import java.net.URI;
import java.net.http.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Java11Examples {

    public static void main(String[] args) throws Exception {

        // =========================
        // 1. var in Lambda
        // =========================
        BiFunction<Integer, Integer, Integer> add =
                (var a, var b) -> a + b;

        System.out.println("Lambda with var: " + add.apply(2, 3));

        // =========================
        // 2. String Enhancements
        // =========================

        String blank = "   ";
        System.out.println("isBlank: " + blank.isBlank());

        String text = "Java\n11\nRocks";
        text.lines().forEach(line -> System.out.println("Line: " + line));

        String spaced = "  hello  ";
        System.out.println("strip: '" + spaced.strip() + "'");
        System.out.println("repeat: " + "Hi ".repeat(3));

        // =========================
        // 3. File API
        // =========================

        Path path = Path.of("sample.txt");

        Files.writeString(path, "Hello Java 11");
        String content = Files.readString(path);

        System.out.println("File content: " + content);

        // =========================
        // 4. Optional Enhancements
        // =========================

        Optional<String> opt = Optional.empty();

        System.out.println("isEmpty: " + opt.isEmpty());

        opt.ifPresentOrElse(
                val -> System.out.println("Value: " + val),
                () -> System.out.println("No value present")
        );

        Optional<String> fallback =
                opt.or(() -> Optional.of("Default Value"));

        System.out.println("Fallback: " + fallback.get());

        // =========================
        // 5. HTTP Client (Sync)
        // =========================

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/get"))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("HTTP Response (sync): " + response.statusCode());

        // =========================
        // 6. HTTP Client (Async)
        // =========================

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(body -> System.out.println("Async Response received"));

        // Give async some time (demo purpose only)
        Thread.sleep(1000);

        // =========================
        // 7. Collection toArray
        // =========================

        List<String> list = List.of("A", "B", "C");
        String[] arr = list.toArray(String[]::new);

        System.out.println("Array: " + Arrays.toString(arr));

        // =========================
        // 8. Stream + Java 11 style usage
        // =========================

        List<String> result = list.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        System.out.println("Stream result: " + result);
    }
}
