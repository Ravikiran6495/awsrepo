FROM eclipse-temurin:17-jdk-alpine
RUN apk add curl
VOLUME /tmp
EXPOSE 8080
ADD target/springboot-book.jar springboot-book.jar
ENTRYPOINT ["java","-jar","/springboot-book.jar"]