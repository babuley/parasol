FROM openjdk:8-alpine

RUN apk --update add curl

RUN mkdir /usr/local/parasol

ADD target/parasol-1.0-SNAPSHOT.jar /usr/local/parasol

RUN chmod +x /usr/local/parasol/parasol-1.0-SNAPSHOT.jar

CMD ["java","-jar","/usr/local/parasol/parasol-1.0-SNAPSHOT.jar"]

EXPOSE 8888
