#!/bin/bash
DOCKER_PATH="/home/brice/Workspace/projects/AppartManager/Docker/tomcat"
PROJECT_PATH="/home/brice/Workspace/projects/AppartManager"

echo "cd ${PROJECT_PATH}"
cd ${PROJECT_PATH}

echo "mvn clean package -DskipTests"
mvn clean package -DskipTests
if [ $? -eq 0 ]
then
	echo "cp -rp target/appartmanager*.war ${DOCKER_PATH}/appartmanager.war"
	cp -rp target/appartmanager*.war ${DOCKER_PATH}/appartmanager.war
	echo "cd ${DOCKER_PATH}"
	cd ${DOCKER_PATH}
	echo "docker build -t appartmgr ."
	docker build -t appartmgr .
fi

