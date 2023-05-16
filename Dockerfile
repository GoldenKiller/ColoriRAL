
# Usando java 17 fa il clean package e crea i .jar necessari
FROM maven:3.9.0-amazoncorretto-17 AS build
COPY src /home/app/src   
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


# Usando i jar creati prima lancia il il programma in un container lasciando aperto la porta 8080
FROM amazoncorretto:17
MAINTAINER test
COPY --from=build /home/app/target/ColoriRAL-0.0.1-SNAPSHOT.jar ColoriRAL-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=database,test","/ColoriRAL-0.0.1-SNAPSHOT.jar"]

