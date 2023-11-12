FROM openjdk:17-jdk

WORKDIR /app

COPY target/DevsuServer-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
