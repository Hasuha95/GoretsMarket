FROM openjdk:20

#EXPOSE 9065

# указываем, где в нашем приложении лежит джарник
ARG JAR_FILE=target/Gorets-0.0.1-SNAPSHOT.jar
COPY ./target/Gorets-0.0.1-SNAPSHOT.jar app.jar
#ADD ${JAR_FILE} backend.jar

ENTRYPOINT ["java","-jar","/app.jar"]