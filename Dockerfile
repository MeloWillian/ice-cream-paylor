FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=build /app/target/ice-cream-parlor-1.0-SNAPSHOT-jar-with-dependencies.jar ./app.jar

CMD ["java", "-jar", "app.jar"]
