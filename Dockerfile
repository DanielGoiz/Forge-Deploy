FROM maven:3.9.6-amazoncorretto-17 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN apt-get install maven -y
RUN mvn clean install -DskipTests

FROM amazoncorretto:17
WORKDIR /app
COPY --from=build /app/target/Forgek-0.0.1-SNAPSHOT.jar /app/Forgek-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/Forgek-0.0.1-SNAPSHOT.jar"]
