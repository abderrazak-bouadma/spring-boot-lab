FROM java:openjdk-8-jdk

ENV MAVEN_VERSION 3.3.1
ENV JAVA_VERSION

RUN curl -sSL http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar xzf - -C /usr/share \
  && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven

MAINTAINER Abderrazak BOUADMA <bouadma.abderrazak@gmail.com>

# Environments
ENV APP_FOLDER /APP

# Copy Project & Maven to Container
ADD . $APP_FOLDER

# Start Building Project
WORKDIR $APP_FOLDER
RUN mvn clean install

#
EXPOSE 8080
CMD ["./run.sh"]