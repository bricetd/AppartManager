#!/bin/bash
docker-compose down -v
#docker-compose rm -v -f
#docker volume prune -f
docker-compose up -d
