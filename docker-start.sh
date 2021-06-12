#!/bin/zsh
docker start postgre-staff || docker run --name  postgre-notes -p 5432:5432 -e POSTGRES_PASSWORD=root -d postgres
docker build --build-arg JAR_FILE=build/libs/\*.jar -t notes-management-docker .
docker run -p 8089:8089 notes-management-docker