# PF4J Spring Demo Application

This project demonstrates the integration of PF4J (Plugin Framework for Java) with Spring Boot, showcasing a plugin-based architecture for Java applications.

## Project Overview

The application is a Spring Boot-based service that uses PF4J to manage plugins. It includes a simple REST API that aggregates responses from multiple plugins implementing a common interface.

### Technology Stack

- Java 23
- Spring Boot 3.4.2
- PF4J 3.13.0
- PF4J-Spring 0.9.0
- Gradle 8.12.1

## Project Structure

The project consists of several modules:

- **Main Application**: Core Spring Boot application that loads and manages plugins
- **Commons**: Shared interfaces and classes used by both the main application and plugins
- **Extensions**:
    - `hello-plugin`: Plugin that returns "Hello!" message
    - `bye-plugin`: Plugin that returns "Bye!" message

## Building and Running

### Prerequisites

- JDK 23 or later
- Gradle 8.12.1 or later

### Build Instructions

1. Clone the repository
2. Build the project:
```bash
./gradlew build
```

This will:
- Build the main application
- Build all plugins
- Copy plugin JARs to the `plugins` directory

### Running the Application

Start the application using:
```bash
./gradlew bootRun
```

## API Endpoints

- `GET /phrase`: Returns concatenated phrases from all active plugins

## Plugin Development

### Creating New Plugins

1. Create a new module in the `extensions` directory
2. Implement the `PhraseExtensionPoint` interface
3. Add plugin metadata to the build configuration
4. Add the new module to `settings.gradle.kts`

### Plugin Structure

Each plugin requires:
- Implementation of `PhraseExtensionPoint`
- Plugin metadata in `build.gradle.kts`:
  ```kotlin
  manifest {
      attributes["Plugin-Id"] = "plugin-id"
      attributes["Plugin-Version"] = project.version
      attributes["Plugin-Provider"] = "provider-name"
  }
  ```

## Project Configuration

The project uses Gradle for build automation. Key configurations include:

- Java 23 toolchain
- Spring Boot dependencies
- PF4J integration
- Automatic plugin deployment
