# I3A Operators Service

| | **Status** |
|---|:----|
| **circleCI** |[![CircleCI](https://circleci.com/gh/asw-i3a/operators-service/tree/master.svg?style=svg)](https://circleci.com/gh/asw-i3a/operators-service/tree/master)
| **code coverage** |[![codecov](https://codecov.io/gh/asw-i3a/operators-service/branch/master/graph/badge.svg)](https://codecov.io/gh/asw-i3a/operators-service)
| **code quality** |[![Codacy Badge](https://api.codacy.com/project/badge/Grade/76aa0b37d6d04efbb066b869e474e273)](https://www.codacy.com/app/colunga91/operators-service?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=asw-i3a/operators-service&amp;utm_campaign=Badge_Grade)
| **latest build** |[![Docker Badge](https://img.shields.io/badge/docker%20image-latest-blue.svg)](https://hub.docker.com/r/incisystem/operators_service/)

This micro-servide forms part of platform called GestUsers, if you don't know about it, we encourage you to see this other [repo](https://github.com/asw-i3a/project-documentation) first.

It manages the input / output from the database of operators to the clients that requets its services.

**API Documentation:** https://github.com/asw-i3a/project-documentation/tree/master/inci_api_doc

### Package
|Group|Artifact|
|-----|--------|
|io.github.asw.i3a|operators.service|

### Authors
- [Elena Allegue González](https://github.com/EleAllegue)
- [Guillermo Facundo Colunga](https://github.com/thewilly)

## System requirements
As the project is developed in java macOS, Windows and Linux distributions are natively supported. Of course you will need the **latest JDK available**. Also, depending on where are you going to run the database, you will need **internet connection or MongoDB** installed and running on your machine.

### Java Development Kit (JDK)
A Java Development Kit (JDK) is a program development environment for writing Java applets and applications. It consists of a runtime environment that "sits on top" of the operating system layer as well as the tools and programming that developers need to compile, debug, and run applets and applications written in the Java programming language.

If you do not has the latest stable version download you can download it [here](http://www.oracle.com/technetwork/java/javase/downloads).

### MongoDB
This project uses MongoDB as the database. You can check how to use it on [MongoDB install](https://github.com/Arquisoft/participants_i2b/wiki/MongoDB). By defatult a dummy server is up and running, it´s configured at the file `applications.properties`. Change this configuration as needed, should not interfeer with the module itself.

### Jasypt
This project uses Jasypt to encrypt the passwords. You don't need to download it as far as its dependency its imported from maven central, but you can check it [here](http://www.jasypt.org/).

## Building the project
It is as simple as running `mvn install`. Or if you want to run it you can use `mvn mvn spring-boot:run`.
