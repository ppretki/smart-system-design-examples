#!/bin/sh
./gradlew build -x test
docker build -t server:1.0.0 .