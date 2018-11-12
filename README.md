# Microservices Template

This repo contains a skeleton template for creating new microservices. 

It is an opinionated template where certain technology/tool/framework choice gears towards a certain direction.

- [Microservices Template](#microservices-template)
        - [<a name="programming-language"></a>Programming Language](#a-name%22programming-language%22aprogramming-language)
        - [<a name="application-framework"></a>Application Framework](#a-name%22application-framework%22aapplication-framework)
        - [<a name="build"></a>Build](#a-name%22build%22abuild)
        - [<a name="continous-integration"></a>Continuous Integration (CI)](#a-name%22continous-integration%22acontinuous-integration-ci)
        - [<a name="infrastructure-as-code"></a>Infrastructure As Code](#a-name%22infrastructure-as-code%22ainfrastructure-as-code)
        - [<a name="deploymemt"></a>Deploymemt](#a-name%22deploymemt%22adeploymemt)
            - [<a name="docker"></a>Docker](#a-name%22docker%22adocker)
            - [<a name="kubernetes"></a>Kubernetes](#a-name%22kubernetes%22akubernetes)
        - [<a name="api-documentation"></a>API Documentation](#a-name%22api-documentation%22aapi-documentation)

### <a name="programming-language"></a>Programming Language

- Java 8

### <a name="application-framework"></a>Application Framework

- Spring Boot 2.0+

### <a name="build"></a>Build

Using maven project management system as the build system/tool. 
Maven wrapper is used so that no need to install Maven on your machine beforehand. Lets maven wrapper take care of maven.

Currently gradle is not supported but maybe in the future. Watch this space.

### <a name="continous-integration"></a>Continuous Integration (CI)

See `.travis.yml` which is a config file for defining build settings on Travis CI.

Currently, only Travis CI and Jenkins 2.0+ are supported. 

In the future, I am looking to offer support for:

- Circle CI
- Semaphore

### <a name="infrastructure-as-code"></a>Infrastructure As Code

A bunch of Terraform files.

### <a name="deploymemt"></a>Deploymemt

#### <a name="docker"></a>Docker

See `Dockerfile` in the root of the project directory.

Building a Docker container

```bash
./mvnw clean package
```

or execute Docker directly:

```bash
docker build -t microservices-template:1.0.0-SNAPSHOT .
```

#### <a name="kubernetes"></a>Kubernetes

Using an container orchestration framework to manage the containers.

```bash
kubectl apply -f deployment/microservices-template.yml
```

### <a name="api-documentation"></a>API Documentation

Access Swagger on:

```
http://{microservices-template-service-url}:{port}/swagger-ui.html
```

