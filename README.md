# YearnMove Project

## Project Overview
YearnMove is a backend project developed with Spring Boot 3, designed to manage and process data through various services and controllers.

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
```
git clone 
```
2. Navigate to the project directory:
```
cd YearnMove
```
3. Build the project with Maven to resolve dependencies and compile the source code:
```
mvn clean install
```
4. Run the application using Maven, which will start the embedded web server and initialize the application:
```
mvn spring-boot:run
```
Alternatively, you can run the main class directly:
* Navigate to the src/main/java/com/comp5703/yearnmove directory.
* Open YearnMoveApplication.java.
* Run the YearnMoveApplication class from your IDE (e.g., IntelliJ IDEA, Eclipse) or using the command line:
```
java -cp target/classes com.comp5703.yearnmove.YearnMoveApplication
```
## Project Structure

The project is structured as follows:
- `src/main/java` - Contains all Java source files organized by packages for controllers, services, DTOs, and data mappers.
- `src/main/resources` - Includes configuration files like `application.properties` which configure the behavior of the application.
- `src/test` - Contains test cases for testing the business logic and integration layers.


