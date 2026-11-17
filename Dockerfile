# Build the Spring Boot application
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests clean package

# Run the application
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/app-service.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
