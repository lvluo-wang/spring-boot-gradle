#!/usr/bin/env bash


sh build.sh


if [[ "$?" != "0" ]];then
    echo "Build error"
    eixt
fi

echo "start java -jar"

java -jar build/libs/spring-boot-gradle.war | tee "$(basename "spring-boot-gradle").log" &

if [[ "$?" != "0" ]]; then
   echo "start failed"
   exit
fi