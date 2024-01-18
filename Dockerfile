FROM openjdk:19-jdk

WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests
#COPY  /build/libs/autopilot-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]