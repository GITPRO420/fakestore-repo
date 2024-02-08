FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/product-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} product-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/product-service-0.0.1.jar"]