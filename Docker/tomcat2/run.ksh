#!/bin/bash

DOCKER_ID=$(docker ps | grep -i 'appartmgr' | awk '{print $1}')

if [ -n "${DOCKER_ID}" ]
then
	echo "Stopping running container id='${DOCKER_ID}'"
	echo "docker stop ${DOCKER_ID}"
	docker stop ${DOCKER_ID}
	docker rm appartmgr
else
	echo "No container to stop"
fi

#docker run -d -p 8082:8080 --name tomcat --link mysql:tomcattomysqllink bricetd/java
docker run -d -p 8082:8080 --name appartmgr --link database:appartmgrtodatabaselink appartmgr
