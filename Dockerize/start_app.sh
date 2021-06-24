#!/bin/sh

docker network create -d bridge my_net
docker pull postgres
docker run --net=my_net -p 5432:5432 -e POSTGRES_PASSWORD=jmogo -e POSTGRES_USER=jmogo -d postgres
#docker run -e POSTGRES_PASSWORD=jmogo -e POSTGRES_USER=jmogo -d postgres
rm ./core/*.jar
cp ../target/lets*.jar ./core/
docker build -t=my_app ./core/
docker run --net=my_net -p 8080:8080 -it my_app
