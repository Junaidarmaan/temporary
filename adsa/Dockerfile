# Use Maven with Amazon Corretto JDK 21 for the build stage
FROM maven:3.9.4-amazoncorretto-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and pre-fetch dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY src ./src

# Build the application without running tests
RUN mvn clean package -DskipTests

# Use Amazon Corretto JDK 21 for the runtime
FROM amazoncorretto:21-alpine

# Set the working directory
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
