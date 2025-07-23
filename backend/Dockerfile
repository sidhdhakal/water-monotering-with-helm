# =================
# Stage 1: Build the application using Maven
# =================
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw package -DskipTests

# =================
# Stage 2: Create the final, lightweight runtime image
# =================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=builder /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# --- MODIFIED: Document that the application now uses port 8000 ---
EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]