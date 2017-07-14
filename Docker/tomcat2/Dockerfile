# Pull base image.
FROM ubuntu:latest

MAINTAINER Brice MEDJO <bricetd@gmail.com>

# Install ubuntu libraries

RUN apt-get update
RUN apt-get dist-upgrade -y
RUN DEBIAN_FRONTEND=noninteractive apt-get -y dist-upgrade
RUN DEBIAN_FRONTEND=noninteractive apt-get -y install python-software-properties
RUN DEBIAN_FRONTEND=noninteractive apt-get -y install software-properties-common

# Install Java.
RUN \
echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
add-apt-repository -y ppa:webupd8team/java && \
apt-get update && \
apt-get install -y oracle-java8-installer && \
apt-get install -y tomcat8 && \
rm -rf /var/lib/apt/lists/* && \
rm -rf /var/cache/oracle-jdk8-installer
# Define working directory.
#WORKDIR /data
# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
ENV CATALINA_HOME=/usr/share/tomcat8
ENV CATALINA_BASE=/var/lib/tomcat8
ENV TOMCAT8_SECURITY=no

#Update tomcat configuration file
RUN sed -i 's@^#JAVA_HOME.*@JAVA_HOME=/usr/lib/jvm/java-8-oracle@g' /etc/default/tomcat8
WORKDIR /var/lib/tomcat8/logs
#RUN ./bin/startup.sh
ADD start.sh /start.sh
RUN chmod +x /start.sh
COPY logger.properties ${CATALINA_BASE}/conf/logging.properties
# Expose the tomcat default port
EXPOSE 8080
# Define default command.
#CMD ["./bin/startup.sh"]
CMD [ "/start.sh"]
COPY appartmanager.war ${CATALINA_BASE}/webapps/appartmanager.war
#ENTRYPOINT ["/start.sh"]
#ENTRYPOINT ["/bin/bash"]
