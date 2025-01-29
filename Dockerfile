# Usar la imagen oficial de Amazon Corretto 21
FROM amazoncorretto:21 as build

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN ./mvnw clean package -DskipTests

FROM amazoncorretto:21

WORKDIR /app

COPY --from=build /app/target/msvc-agronomic-activities-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8004

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
