FROM openjdk:19-jdk

WORKDIR /app

COPY pom.xml .
COPY src ./src

#COPY  /build/libs/autopilot-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]