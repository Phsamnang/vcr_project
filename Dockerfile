FROM openjdk:21-jdk

WORKDIR /app

COPY  /build/libs/demo-0.0.1-SNAPSHOT.jar .

#COPY  /build/libs/autopilot-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "autopilot-0.0.1-SNAPSHOT.jar"]