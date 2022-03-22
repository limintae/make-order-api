#!/bin/bash
mkdir /tmp/project
cp -a ./ /tmp/project
gradlew clean test -f /tmp/project/pom.xml
