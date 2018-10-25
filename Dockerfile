FROM openjdk:8
ADD . /src
WORKDIR /src
COPY target/microservices-template-*.jar /usr/local/bin/microservices-template.jar
RUN chmod +x /usr/local/bin/microservices-template.jar
CMD ["java", "-jar", "/usr/local/bin/microservices-template.jar"]
