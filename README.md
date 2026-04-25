# java-api-practice
Dedicated to the practice of  important Java APIs from version 8 onwards

# Java 8 Features – Complete Practical Guide

This repository demonstrates core Java 8 features with practical, runnable examples.

---

## 🚀 Features Covered

### 1. Functional Interfaces
- Predicate<T>
- Function<T, R>
- Consumer<T>
- Supplier<T>

### 2. Lambda Expressions

### 3. Stream API
- Intermediate operations:
  - filter
  - map
  - flatMap
  - distinct
  - sorted
  - limit
  - skip
- Terminal operations:
  - forEach
  - collect
  - reduce
  - count
  - anyMatch / allMatch / noneMatch
  - findFirst / findAny

### 4. Method References
- Static
- Instance
- Constructor

### 5. Default & Static Methods in Interfaces

### 6. Optional Class

### 7. New Date-Time API (`java.time`)

### 8. forEach Usage

### 9. Parallel Streams (with caveats)

### 10. Collectors
- groupingBy
- partitioningBy
- joining
- mapping
- counting

### 11. Base64 Encoding/Decoding

---

## 🧠 Key Concepts

### Functional Programming in Java
Java 8 introduced functional-style programming:
- Treat behavior as data
- Use lambdas instead of anonymous classes
- Write declarative code instead of imperative loops

---

### Stream Pipeline

---
## ▶️ How to Run

### Option 1: Direct execution (Java 8+)
```bash
java Java8Examples.java
```

# Java 11 Features – Practical Guide with Examples

This repository demonstrates key Java 11 features with clean, runnable examples.  
Designed for interview preparation and real-world backend development.

---

## 🚀 Features Covered

### 1. var in Lambda Parameters
- Improved readability
- Supports annotations

### 2. String Enhancements
- isBlank()
- lines()
- strip(), stripLeading(), stripTrailing()
- repeat()

### 3. File API Improvements
- Files.readString()
- Files.writeString()

### 4. Optional Enhancements
- isEmpty()
- ifPresentOrElse()
- or()

### 5. Modern HTTP Client (java.net.http)
- Synchronous calls
- Asynchronous calls

### 6. Collection Enhancements
- toArray(IntFunction)

### 7. Running Java Without Compilation
- Direct execution using `java File.java`

---

## 🧠 Key Concepts

### Cleaner APIs
Java 11 reduces boilerplate significantly:
- File handling is simpler
- String manipulation is richer
- Optional is more expressive

---

### HTTP Client Upgrade
Replaces legacy `HttpURLConnection` with:
- Fluent API
- Async support
- Better readability

---

### String Improvements
Removes common utility code like:
- `trim().isEmpty()`
- manual splitting

---
## ▶️ How to Run

### Option 1: Direct execution (Java 11+)
```bash
java Java11Examples.java
```

# Java 17 Features – Practical Guide with Examples

This repository demonstrates key Java 17 features with clean, runnable examples.  
Focused on modern Java design, readability, and interview preparation.

---

## 🚀 Features Covered

### 1. Records
- Immutable data carriers
- Less boilerplate than POJOs

### 2. Sealed Classes
- Controlled inheritance
- Better domain modeling

### 3. Pattern Matching for instanceof
- Cleaner type checks
- Reduced casting

### 4. Switch Expressions (Modern Switch)
- Arrow syntax
- Returns values

### 5. Text Blocks
- Multi-line strings
- Cleaner JSON/SQL handling

### 6. Enhanced Random API
- Better random generators

---

## 🧠 Key Concepts

### Records
Replace verbose POJOs:
- No getters/setters needed
- Immutable by default
- Auto-generated equals/hashCode/toString

---

### Sealed Classes
Restrict which classes can extend/implement:
- Improves maintainability
- Safer polymorphism

---

### Pattern Matching
Removes explicit casting after instanceof checks.

---

### Switch Expressions
- Eliminates fall-through bugs
- More readable and functional

---

### Text Blocks
Useful for:
- JSON
- SQL queries
- Multi-line messages

---

## ▶️ How to Run

### Java 17 Required

```bash
javac Java17Examples.java
java Java17Examples
```

# Java 21 Features – Modern Java (LTS) Guide

This repository demonstrates key Java 21 features with practical, runnable examples.  
Focus: concurrency, scalability, and modern language improvements.

---

## 🚀 Features Covered

### 1. Virtual Threads (Project Loom)
- Lightweight threads
- Massive concurrency with minimal overhead

### 2. Structured Concurrency (Preview)
- Manage multiple tasks as a single unit
- Simplifies error handling and cancellation

### 3. Record Patterns
- Deconstruct records easily

### 4. Pattern Matching for Switch (Final)
- Cleaner, safer switch logic

### 5. Sequenced Collections
- Unified API for ordered collections

---

## 🧠 Key Concepts

### Virtual Threads
Traditional threads are expensive (OS-level).  
Virtual threads are lightweight and managed by JVM.

👉 You can create **millions of threads** without killing your system.

---

### Structured Concurrency
Treat multiple threads like a single workflow:
- All succeed OR fail together
- Easier debugging
- Cleaner lifecycle management

---

### Pattern Matching (Switch + Records)
Removes boilerplate:
- No casting
- No manual extraction

---

### Sequenced Collections
Consistent way to access:
- First element
- Last element
- Reversed view

---

## ▶️ How to Run

### Java 21 Required

```bash
javac Java21Examples.java
java Java21Examples