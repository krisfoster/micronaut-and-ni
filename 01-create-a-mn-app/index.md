# Creating a Micronaut Application

## Overview

In this step we are going to create a Micronaut application with a `HTTP` based front end - a test micro-service. We will see how we can easily build a micro-service application based upon Micronaut. In the following steps we will see just how easy it is to create a binary executable from a Micronaut based application using Native Image, allowing us to benefit from super fast start-up times.

## Learning More About Micronaut

Micronaut is a modern Java application framework that speifically targets Native Image as a deployment platform. You can learn more about it from the [Micronaut Documentation](https://docs.micronaut.io/latest/guide/#introduction).

One of the main features of Micronaut that allows it to be such a good fit for Native Image is the use of annotation processors within its [dependency injection framework](https://docs.micronaut.io/latest/guide/#how). Dependency injection is done at compile time rather than at runtime.

## Our Use Case

Suppose we have been asked to supply pyramids, in ASCII form. It's all the rage and we have cornered the market. A user wants to be able to call our `HTTP` end-point and they expect to receive a beautiful ASCII pyramid. We have chosen to build our pyramids out of Sierpinski Triangles, we just like the look of them, because the kind of pyramid being returned here isn't important.

## Create the Application

Micronaut comes with a command line tool for creating and updating your applications, `mn`. We are going to use this to create out application:

```sh
$ mn create-app --features=graalvm org.example.graal --build=maven --lang=java
```

This creates a new directory containing our empty Micronaut application:

```sh
# If you don't have the `tree` command install, please install with your package manager
# On Oracle Linux : `sudo yum install tree`
$ tree graal
graal/
├── micronaut-cli.yml
├── mvnw
├── mvnw.bat
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── org
    │   │       └── example
    │   │           └── Application.java
    │   └── resources
    │       ├── application.yml
    │       └── logback.xml
    └── test
        └── java
            └── org
                └── example
                    └── GraalTest.java

10 directories, 9 files
```

What did we just do? Let's take a quick look at the command line we ran:

* `mn create-app` : the command to the `mn` command line application to create an empty application
* `--features=graalvm` : This let's Micronaut that we will be wating to make use of the Natice Image integration
* `--build=maven` : We are going to use Maven as our build tool
* `--lang=java` : Java will be the progrmming language. This is the default, but we could also specify that we want to use Groovy or Kotlin

## Adding a Web End-Point