FROM openjdk:21-jdk

WORKDIR /app

COPY  /target/demo-0.0.1-SNAPSHOT.jar .

#COPY  /build/libs/autopilot-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]