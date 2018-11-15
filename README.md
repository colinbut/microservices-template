# Microservices Template

This repo contains a skeleton template for creating new microservices. 

It is an opinionated template where certain technology/tool/framework have been chosen...

* [Programming Language](#programming-language)
* [Application Framework](#application-framework)
* [Build](#build)
* [Continuous Integration (CI)](#continuous-integration)
* [Continuous Delivery (CD)](#continuous-delivery)
* [Continuous Deployment (CI)](#continuous-deployment)
* [Infrastructure As Code](#infrastructure-as-code)
* [Deploymemt](#deploymemt)
    * [Docker](#docker)
    * [Kubernetes](#kubernetes)
* [API Documentation](#api-documentation)

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
See `Jenkinsfile` which is a config file for defining build settings on Jenkins 2.0+ (with the use of Pipelines).

Currently, only Travis CI and Jenkins 2.0+ are supported. 

In the future, I am looking to offer support for:

- Circle CI
- Semaphore

### <a name="continous-delivery"></a>Continuous Delivery (CD)

Every commit/merge is a RC (Release Candidate).

See `Jenkinsfile`'s section on Continous Delivery.

### <a name="continous-deployment"></a>Continuous Deployment (CD)

Mainly it is about the automated deployment from a testing environment (Staging) onto live Production.
Normally, or historically, this would be a manual process done by the Operations Team (Ops).

See `Jenkinsfile`'s section on Continous Deployment.

CD is facilitated by the shell script `deploy.sh` which you can use and edit to define the steps and behaviours for
doing the deployment. In Jenkins pipeline, we have a sanity check stage which governs or acts as a gate prior for the software
to be deloyed onto Production. (Artifact/Pipeline promotion).

### <a name="infrastructure-as-code"></a>Infrastructure As Code

A bunch of Terraform files.

For implementing IAC, we use Hashicorp's Terraform.

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

Use of Swagger to document our microservice's API REST endpoints.

Access Swagger on:

```
http://{microservices-template-service-url}:{port}/swagger-ui.html
```

