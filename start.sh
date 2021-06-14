#!/bin/zsh
docker start dbpostgresql || docker run --name  dbpostgresql -p 5432:5432 -e POSTGRES_PASSWORD=root -d postgres
java -jar ./note/target/note-0.0.1-SNAPSHOT.jar