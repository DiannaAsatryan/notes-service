**Notes service**

Notes service application is a basic Spring boot REST service.

It has support containerized build and run( in addition to standard run )
For this purpose there are two start.sh and docker-compose.yml scripts included in it.

start.sh - will use docker image for DB and run already built jar

docker-compose.yml (need to run with docker-compose up command) - it will create application's docker container and start also DB container

In order to run app in as container in /resources/application.yml line 3 should be disabled and 4 enabled, which contents db host in docker to connect

Employee Notes.postman_collection.json postman collection provided for test note CRUD operation