FROM openjdk:11

CMD gradle build

COPY build/libs/*.jar app.jar

COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh
