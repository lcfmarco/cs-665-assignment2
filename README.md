
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Chin Fung Lam Marco        |
| Date         | 10/20/2026                 |
| Course       | Fall                       |
| Assignment # | 2                          |

# Assignment Overview
Given a collection of retailers in a busy city with collaboration with local drivers.
The objective of the assignment is to develop a notification system that inform drivers about delivery
requests made by shops. A shop can create a delivery request, and sent this request to all available drivers.

# GitHub Repository Link:
https://github.com/{YOUR_USERNAME}/cs-665-assignment-{ASSIGNMENT_NUMBER}

# Implementation Description 


For each assignment, please answer the following:

- Explain the level of flexibility in your implementation, including how new object types can
be easily added or removed in the future.

The implementation is designed to be flexible by separating the responsibilities of shops and drivers through the Observer
design pattern. With this pattern, the Shop class implements the PublisherBase interface, and the Driver
class implements the SubscriberBase interface. What this does is the shops can notify subscribers (the drivers)
without needing to directly utilise the methods in the Driver class. 

Additionally, with how the subscribers and publishers are set up, it is easy to add or remove Drivers from a shop's subscribers
list using the subscribe() and unsubscribe() method (required by the interface), without needing to change any of the existing
implementation in our code. 

Next, if we ever have new types of subscribers, these new subscribers can be created by implementing the
SubscriberBase interface without needing to make any modifications to the Shop class, thus added flexibility.

A driver can also quite easily subscribe to multiple shops to receive delivery requests from various publishers
without needing to implement new, and specific code each time. This adds to the flexibility of my implementation.

- Discuss the simplicity and understandability of your implementation, ensuring that it is
easy for others to read and maintain.

As mentioned earlier, the project is implemented with the intention of being simple. I try to make it easier
to understand by clearly separating the responsibilities of the different classes. This makes it easier to understand
because each class holds different purposes. The Shop class is responsible for creating and broadcasting the 
delivery requests, the Driver class is responsible for receiving the notifications from the Shops, and the 
DeliveryRequest class ensures that the delivery information is stored properly, and finally the interfaces provides the
rules that are needed for the Subscribers and Publishers to make it clear on what is needed for each role.

On top of that, the methods and variable names uses descriptive names to make it clear on what the variables represent
or what the methods are doing, plus I added comments to explain what each class does, and what each method 
does, with additional details of any parameters it takes and the things it should be returning.

- Describe how you have avoided duplicated code and why it is important.

Duplicated code is avoided through the Observer design pattern as well, more specifically 
it removes a lot of the duplication in the notification process between shops and drivers. 

Rather than needing to write methods or writing specific code to notify individual drivers, 
we just needed a single notifySubscribers() method in the Shop class to notify a new delivery request
to all the subscribed drivers. 

Additionally, I try to reuse existing methods whenever possible. For example, in the implementation of 
createDeliveryRequest(), the method calls setLatestDeliveryRequest() to handle the storing of the new request and
the notifying subscribers of new changes. I reuse this method to avoid needing to reimplement
something I have already previously implemented, which avoids duplicate code.

Avoiding duplicate code is important for many reasons. First, it makes the implementation easier to understand
as there is less clutter. But most importantly, it reduces the chances of inconsistencies due to needing to implement
the same thing multiple times, and it makes it much easier to manage the code when changes needs to be made. Rather than making
changes to multiple locations, chances are we would only need to make changes to one location.

- If applicable, mention any design patterns you have used and explain why they were
chosen.

As explained earlier, I applied the Observer pattern. The reason this pattern is used is demonstrated in the previous
questions, but in short it is because the problem involves the situation where we have a subscriber, and we have a publisher, 
such that the subscriber are the drivers and the publishers are the shops. Considering that multiple
drivers can subscribe to a store, there is a lot more simplicity when
a store decides to broadcast a delivery request. Using this pattern prevents the need from 
individually informing every driver involved, rather a single method to notify 
all subscribers does that task. 

# Assumptions Made

1. I assumed that a Driver can be subscribed to multiple stores, rather than only one store.
2. I assumed that an existing request can be updated after being made. And when an update is made, the new changes should be notified to the subscribers.
3. I assumed that when a delivery request is made, the shop associated to that delivery request cannot be changed. Thus I made the Shop field in the DeliveryRequest class FINAL.
4. I assumed that all subscribed drivers are considered available, and that there is no limit to how many requests they can receive.
5. I assumed a shop and Driver only needs to keep track of their latest deliveries. Such that a shop only keeps track of the latest delivery they sent out, and the driver only needs to keep track of the latest delivery request they received.
While I recognize that keeping track of all delivery requests is more useful in real life, for simplicity of the code I assumed that as it wasn't a requirement.

# Maven Commands

This project uses Java 25. Install a Java 25 JDK and Apache Maven (https://maven.apache.org/) before building. Maven must run with JDK 25 or newer; check the selected versions with:

```bash
java -version
mvn -version
```

The Maven compiler is configured with `maven.compiler.release` set to `25`, so the code can use Java 25 language features and APIs and produces bytecode requiring Java 25 or newer.

If compilation fails with `release version 25 not supported`, Maven is running with a JDK older than 25. Check `mvn -version` (not only `java -version`), then configure `JAVA_HOME` to point to JDK 25 and ensure its `bin` directory is first on `PATH`. On macOS, for example, run these commands in the terminal you use for Maven:

```bash
export JAVA_HOME="$(/usr/libexec/java_home -v 25)"
export PATH="$JAVA_HOME/bin:$PATH"
mvn -version
mvn clean verify
```

Confirm that `mvn -version` reports Java 25 or newer. Open a new terminal in your IDE after changing the JDK environment so it picks up the updated setting.

### Java 25 features to explore

Java 25 is an LTS release. In addition to the language and API improvements from intervening Java releases, these finalized Java 25 features can be useful in coursework:

- **Compact source files and instance `main` methods:** for a small program, Java 25 lets you omit the class declaration and the `public static` modifiers. The Java launcher can infer the entry point:

  ```java
  // Before: a named class and static main method were required.
  public class Hello {
      public static void main(String[] args) {
          System.out.println("Hello, Java!");
      }
  }
  ```

  ```java
  // Java 25: save as Hello.java and run with `java Hello.java`.
  void main() {
      System.out.println("Hello, Java 25!");
  }
  ```

- **Module import declarations:** instead of listing multiple packages from one module, Java 25 can import all packages that module exports. For example, `java.base` exports `java.util` and `java.io`:

  ```java
  // Before:
  import java.util.List;
  import java.util.Map;

  class CourseList {
      public static void main(String[] args) {
          Map<String, List<String>> courses = Map.of("CS", List.of("Java", "Design"));
          System.out.println(courses);
      }
  }
  ```

  ```java
  // Java 25:
  import module java.base;

  void main() {
      Map<String, List<String>> courses = Map.of("CS", List.of("Java", "Design"));
      System.out.println(courses);
  }
  ```

- **Flexible constructor bodies:** previously, validation that had to happen before a superclass constructor call was often hidden in a helper used as a `super(...)` argument. Java 25 allows a constructor to validate arguments directly before `super()`; this early code cannot access the object under construction:

  ```java
  // Before (assume BaseItem has a constructor that accepts a name):
  class BaseItem {
      BaseItem(String name) {}
  }

  class NamedItem extends BaseItem {
      private final String name;

      NamedItem(String name) {
          super(validate(name));
          this.name = name;
      }

      private static String validate(String name) {
          if (name == null || name.isBlank()) {
              throw new IllegalArgumentException("name must not be blank");
          }
          return name;
      }
  }
  ```

  ```java
  // Java 25:
  class BaseItem {
      BaseItem(String name) {}
  }

  class NamedItem extends BaseItem {
      private final String name;

      NamedItem(String name) {
          if (name == null || name.isBlank()) {
              throw new IllegalArgumentException("name must not be blank");
          }
          super(name);
          this.name = name;
      }
  }
  ```

- **Scoped values:** before scoped values, `ThreadLocal` was a common way to make per-thread context available to deeper calls, but required mutable set/cleanup discipline. A scoped value is immutable once bound and is available only during the bounded operation:

  ```java
  // Before:
  class RequestExample {
      private static final ThreadLocal<String> REQUEST_ID = new ThreadLocal<>();

      static void main(String[] args) {
          handleRequest();
      }

      private static void handleRequest() {
          REQUEST_ID.set("request-123");
          try {
              processRequest();
          } finally {
              REQUEST_ID.remove();
          }
      }

      private static void processRequest() {
          System.out.println("Handling " + REQUEST_ID.get());
      }
  }
  ```

  ```java
  // Java 25:
  class RequestExample {
      private static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();

      static void main(String[] args) {
          ScopedValue.where(REQUEST_ID, "request-123").run(RequestExample::handleRequest);
      }

      private static void handleRequest() {
          processRequest();
      }

      private static void processRequest() {
          System.out.println("Handling " + REQUEST_ID.get());
      }
  }
  ```

Some Java 25 features are still in preview or incubator status. They require explicit opt-in and may change in later releases; this template uses standard Java 25 features without preview flags.

## Log4j example

The template includes Log4j 2 and a working example in `Main.java`. A class gets a logger with `LogManager.getLogger`; choose a level that matches the message:

```java
// Declare once as a class field.
private static final Logger LOGGER = LogManager.getLogger(Main.class);

// Call from a method.
LOGGER.debug("Details useful during development.");
LOGGER.info("The operation completed.");
LOGGER.warn("The input is unusual, but processing can continue.");

// In a catch block, pass the caught exception to include its stack trace.
LOGGER.error("The operation failed.", exception);
```

Log levels help filter output: `TRACE` and `DEBUG` are useful for detailed diagnostics, `INFO` for normal events, `WARN` for unexpected conditions, and `ERROR` for failures. The sample configuration in `src/main/resources/log4j2.xml` writes messages at `DEBUG` level and above to the console. Change the root logger's `level` to `info` to hide debug messages, or adjust the appender and layout to customize where and how messages are displayed.

Run the example with:

```bash
mvn exec:java
```

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```

## Test coverage

JaCoCo records which parts of the application are exercised by the tests and creates an HTML coverage report. Run the tests and generate the report with:

```bash
mvn clean verify
```

Open `target/site/jacoco/index.html` in a browser to see coverage by package, class, and method. The report includes instruction, branch, and line coverage. Click a class name to see which lines were executed; red lines are not covered, and yellow lines were only partly covered.

For example, add tests for different age-calculation paths in `Person` and run `mvn clean verify` again. The report will show whether the new tests exercised those paths. Coverage is a guide to which code your tests execute, not proof that the code is correct: review the assertions and edge cases as well.


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

In this template, Checkstyle is informational: violations are reported, but they do not fail the Maven build. This behavior is controlled by the `failOnViolation` setting in the `maven-checkstyle-plugin` configuration in `pom.xml`, which is currently set to `false`. Review and fix the reported issues as part of your work; a successful build does not necessarily mean that the Checkstyle checks passed.

To make Checkstyle violations fail the build, change that setting to `true`:

```xml
<configuration>
    <configLocation>config/google_checks.xml</configLocation>
    <failOnViolation>true</failOnViolation>
    <consoleOutput>true</consoleOutput>
</configuration>
```

Then run the Checkstyle check explicitly:

```bash
mvn checkstyle:check
```

With this configuration, the check goal fails when it finds violations. The report-generation command below remains useful for reviewing the detailed results.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`
