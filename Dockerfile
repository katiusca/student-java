# Dockerfile
FROM java:8

MAINTAINER  Author Name <katiusca.catari@email.com>

ENV MAVEN_VERSION 3.3.9

ENV MAVEN_HOME /usr/share/maven

VOLUME /root/.m2

CMD ["mvn"]