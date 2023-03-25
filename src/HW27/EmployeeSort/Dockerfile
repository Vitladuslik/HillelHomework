FROM openjdk:17
MAINTAINER oStepurko

EXPOSE 8080/tcp
EXPOSE 8080/udp

COPY target/restServer-spring-boot.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
