FROM eclipse-temurin:17-jre-alpine
MAINTAINER waynemorphic
VOLUME /tmp
COPY target/employee-demo-0.0.1-SNAPSHOT.jar employee-demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/employee-demo-0.0.1-SNAPSHOT.jar"]