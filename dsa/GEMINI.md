# Project Overview

This project is a Java-based repository focused on Data Structures and Algorithms (DSA). It serves as a practice ground and collection for various algorithms and data structures implementations. The project is organized into logical packages such as `algorithms` (further broken down into `arrays`, `miscellaneous`, `searching`, `sorting`, `stacks`, `strings`) and `datastructures` (e.g., `Array`, `DoublyLinkedList`, `Queue`, `SinglyLinkedList`, `Stack`). It utilizes Maven for dependency management and build automation.

## Building and Running

This project uses Apache Maven for its build lifecycle.

### Prerequisites

*   Java Development Kit (JDK) 21 or newer
*   Apache Maven

### Build the Project

To compile the Java source code and package it into a JAR file, run the following command from the project root:

```bash
mvn clean install
```

This will compile all classes and create a `dsa-1.0-SNAPSHOT.jar` in the `target/` directory.

### Run a Specific Class

You can run individual Java classes with a `main` method using the `exec-maven-plugin`. For example, to run the `FindEvenNums` class:

```bash
mvn exec:java -Dexec.mainClass="com.dsa.algorithms.arrays.FindEvenNums"
```

Replace `"com.dsa.algorithms.arrays.FindEvenNums"` with the fully qualified name of the class you wish to execute.

## Development Conventions

*   **Language:** Java 21.
*   **Build Tool:** Maven.
*   **Package Structure:** Code is organized under `com.dsa` with sub-packages reflecting the type of algorithm or data structure (e.g., `com.dsa.algorithms.arrays`, `com.dsa.datastructures`).
*   **Code Style:** Standard Java conventions are followed, including Javadoc comments for classes and methods, clear variable naming, and consistent formatting. Additionally, ensure Javadoc comments are regularly added to newly implemented algorithms and data structures, explicitly mentioning relevant DSA topics.
*   **IDE:** The presence of `.project`, `.classpath`, and `.settings/` suggests it might be developed using Eclipse, but it's a standard Maven project and should be compatible with any Java IDE.
