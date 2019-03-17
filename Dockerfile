FROM openjdk:8
ADD . /src
WORKDIR /src

# uncomment below for maven
COPY target/microservices-template-*.jar /usr/local/bin/microservices-template.jar

# uncomment below for gradle
# COPY build/libs/microservices-template-*.jar /usr/local/bin/microservices-template.jar

RUN chmod +x /usr/local/bin/microservices-template.jar
CMD ["java", "-jar", "/usr/local/bin/microservices-template.jar"]
