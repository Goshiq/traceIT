#!/bin/sh

docker pull postgres
#rm ./*.jar
cp ../target/lets*.jar ./
docker-compose up
