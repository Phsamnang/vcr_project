FROM openjdk:19-jdk

COPY target/VCR-0.0.1-SNAPSHOT.jar .

#COPY  /build/libs/autopilot-0.0.1-SNAPSHOT.jar .
EXPOSE 8080

CMD ["java", "-jar", "VCR-0.0.1-SNAPSHOT.jar"]