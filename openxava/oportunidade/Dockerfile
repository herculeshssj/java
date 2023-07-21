FROM tomcat:9

RUN apt update && apt install -y maven

RUN mkdir /app

COPY ./ /app

RUN mvn package -f /app/pom.xml

RUN mv /app/target/oportunidade.war /usr/local/tomcat/webapps && rm -rf /app

EXPOSE 8080

CMD ["catalina.sh", "run"]