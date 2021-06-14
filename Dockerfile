FROM amazoncorretto:11

ADD note/target/note-0.0.1-SNAPSHOT.jar notes.jar
EXPOSE 8088

ENTRYPOINT ["java","-jar","notes.jar"]

