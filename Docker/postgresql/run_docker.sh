#!/bin/bash
exec_path="/home/brice/AppartManager/Docker/postgresql"
cd ${exec_path}
docker run --name database -p 5454:5432 -v etc:/etc/postgresql -v log:/var/log/postgresql -v lib:/var/lib/postgresql -d mypostgres
#docker run -p 5454:5432 --name database -v /home/brice/AppartManager/Docker/postgresql/etc:/etc/postgresql -v /home/brice/AppartManager/Docker/postgresql/log:/var/log/postgresql -v /home/brice/AppartManager/Docker/postgresql/lib:/var/lib/postgresql -it --rm -d postgres
