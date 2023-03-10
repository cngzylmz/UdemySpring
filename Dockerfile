FROM centos
RUN mkdir /opt/tomcat/

WORKDIR /opt/tomcat

RUN curl -0 https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.73/bin/apache-tomcat-9.0.73.tar.gz
RUN tar xvfz apache-tomcat-9.0.73.tar
RUN su mv -v apache-tomcat-9.0.73/* /opt/tomcat/.

