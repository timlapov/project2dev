# Project2Dev

Project2Dev is a simple Java application demonstrating basic CRUD operations and repository patterns using JPA (Hibernate) and an in-memory H2 database.

## Project Structure

```
project2dev/
├── src/
│   ├── main/
│   │   ├── java/art/lapov/project2dev/
│   │   │   ├── entity/             # JPA Entities (Application, Developer, Project, etc.)
│   │   │   ├── repository/         # Repository implementations and interfaces
│   │   │   │   ├── interfaces/     # Repository interfaces
│   │   │   │   └── ...             # Implementations (e.g., ApplicationRepositoryImpl)
│   │   │   ├── Main.java           # Main application entry point
│   │   │   └── ...
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml # JPA configuration
│   └── test/                     # Unit tests 
├── pom.xml                       # Maven project file
├── diagram.puml                  # PlantUML diagram
└── README.md                     # This file
```

## Technologies Used

*   **Java 21**
*   **Maven**
*   **JPA (Jakarta Persistence API)** with **Hibernate** as the provider

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) 21 or higher
*   Maven

### Building the Project

Navigate to the project root directory (where `pom.xml` is located) and run:

```bash
mvn clean install
```

This command will compile the project, run tests (if any), and package it into a JAR file.

### Running the Application

After building, you can run the application from the command line:

```bash
mvn exec:java -Dexec.mainClass="art.lapov.project2dev.Main"
```

Alternatively, you can run the `Main` class directly from your IDE (e.g., IntelliJ IDEA, Eclipse).

## Database

The project uses an in-memory H2 database, which means the data will be lost each time the application restarts. The `DataLoader` class is responsible for populating some mock data on startup.

## Contributing

Feel free to fork the repository and contribute. Pull requests are welcome.

## License
MIT
