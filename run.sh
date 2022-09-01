#!/usr/bin/env bash

sudo mvn clean
mvn install
docker-compose up -d --build
docker logs --follow letsbid


