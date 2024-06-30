# FROM postgres:14.1

# # Set the environment variables for the PostgreSQL database
# ENV POSTGRES_USER=postgres
# ENV POSTGRES_PASSWORD=786@admin
# ENV POSTGRES_DB=test
# EXPOSE 5431

FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime environment
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/spring-Testing-0.0.1-SNAPSHOT.jar test.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "test.jar"]
