# YearnMove Project

## Project Overview
YearnMove is a backend project developed with Spring Boot 3, designed to manage and process data through various services and controllers. It facilitates the **analysis and evaluation of physical activity programs**, computing health outcome ratios across cognitive, emotional, physical, social, and wellbeing domains.

## Technology Stack
- **Spring Boot 3**
- Java 17
- Maven
- MySQL
- MyBatis-Plus

## Environmental Requirements
- JDK 17 or higher
- Maven 3.6 or higher
- MySQL Database

## Installation and Execution
1. Clone the repository to your local machine:
   ```sh
   git clone
   ```
2. Navigate to the project directory:
   ```sh
   cd YearnMove
   ```
3. Build the project with Maven to resolve dependencies and compile the source code:
   ```sh
   mvn clean install
   ```
4. Run the application using Maven, which will start the embedded web server and initialize the application:
   ```sh
   mvn spring-boot:run
   ```


## Project Structure
```
yearnmove_project
│-- .idea/
│-- .mvn/
│-- src/
│   ├── main/java/com/comp5703/yearnmove/
│   │   ├── common/             # Common utilities
│   │   ├── config/             # Application configurations
│   │   ├── controller/         # API controllers (Article, Main Data, Outcomes)
│   │   ├── filter/             # CORS filter
│   │   ├── mapper/             # Database mappers (MyBatis-Plus)
│   │   ├── pojo/               # Data objects (DTOs, Entities)
│   │   │   ├── dto/            # Data Transfer Objects
│   │   │   ├── vo/             # View Objects (Requests, Responses)
│   │   ├── service/            # Business logic layer
│   │   │   ├── impl/           # Service implementations
│   │   ├── utils/              # Utility classes
│   │   ├── YearnMoveApplication.java # Main Spring Boot application
│-- resources/                  # Configuration and static resources
│-- test/                        # Unit and integration tests
│-- target/                      # Compiled output
│-- pom.xml                      # Maven dependencies
```

## Features
- **Health Outcome Analysis**: Computes cognitive, emotional, physical, social, and wellbeing-related health outcomes.
- **Flexible Querying**: Enables retrieval of research data through multiple filtering options.
- **Data Processing**: Automates calculations of various health outcome ratios.
- **RESTful API Services**: Provides structured endpoints for managing and querying health-related data.

## API Endpoints
- **Health Outcomes Services**: Supports multiple health outcome computations.
- **Filtering & Querying**: Allows retrieval of filtered research records.

## License
This project is licensed under the MIT License.

