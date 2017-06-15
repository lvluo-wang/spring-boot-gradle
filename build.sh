#!/usr/bin/env bash

if [[ "$1" == "clean" ]]; then
    rm -rf ./build/
    gradle clean cleanIdea
    exit
fi

gradle build -x test

