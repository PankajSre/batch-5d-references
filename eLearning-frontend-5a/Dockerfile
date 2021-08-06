FROM tomcat:8-jre8-alpine
LABEL maintainer = "pankaj.saini85@gmail.com"
ADD ./target/elearning.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]