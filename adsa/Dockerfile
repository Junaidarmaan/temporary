# Use an official Maven image with a compatible JDK version
FROM maven:3.9.4-amazoncorretto-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src

# Build the application without running tests
RUN mvn clean package -DskipTests

# Use Amazon Corretto JDK for running the application
FROM amazoncorretto:17-alpine

# Set the working directory
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
