# Microservices Template

This repo contains a skeleton template for creating new microservices. 

It is an opinionated template where certain technology/tool/framework choice gears towards a certain direction.

### Programming Language

- Java 8

### Application Framework

- Spring Boot 2.0+

### Build

Using maven project management system as the build system/tool. 
Maven wrapper is used so that no need to install Maven on your machine beforehand. Lets maven wrapper take care of maven.

Currently gradle is not supported but maybe in the future. Watch this space.

### Continuous Integration (CI)

See `.travis.yml` which is a config file for defining build settings on Travis CI.

Currently, only Travis CI and Jenkins 2.0+ are supported. 

In the future, I am looking to offer support for:

- Circle CI
- Semaphore

### Infrastructure As Code

A bunch of Terraform files.

### Deploymemt

#### Docker

See `Dockerfile` in the root of the project directory.

Building a Docker container

```bash
./mvnw clean package
```

or execute Docker directly:

```bash
docker build -t microservices-template:1.0.0-SNAPSHOT .
```

#### Kubernetes

Using an container orchestration framework to manage the containers.

```bash
kubectl apply -f deployment/microservices-template.yml
```

### API Documentation

Access Swagger on:

```
http://{microservices-template-service-url}:{port}/swagger-ui.html
```

