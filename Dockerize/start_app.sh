#!/bin/sh

export POSTGRES_HOST=db
docker pull postgres
rm ./*.jar
cp ../target/lets*.jar ./
docker-compose up
