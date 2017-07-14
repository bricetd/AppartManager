#!/bin/bash
ls -ltr ${CATALINA_BASE}/webapps/
exec ${CATALINA_HOME}/bin/catalina.sh run
