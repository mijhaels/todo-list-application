FROM maven:3.9.6-amazoncorretto-17 AS compiler
WORKDIR /build
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17-alpine
WORKDIR /app

COPY --from=compiler /build/target/todo-list-application-MAIN.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
