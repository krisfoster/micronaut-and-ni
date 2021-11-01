# Tutorial to Demo GraalVM Enterprise Edition Native Image with Micronaut

## Pre-requisites

* Access to a linux machine
* Access to the Internet
* Some spare time, but not too much :)

## Overview

There will be a number of steps, each demonstrating a feature. The steps are:

0. Build a `HelloWorld` Java application and turn it into a Native Image
1. Build a simple Java microservice (using micronaut)
   Add a Junit test – after all, we are professionals
   Run it & “benchmark” start-up (framework will print out how long it took to get ready)
   Stress test with hey (or wrk2) and show the throughput
2. Convert to Native Image – we want instant start-up
   Show the maven plugin for NI – add a native profile (use G1GC as well?)
   Build & run – still works fine
   Let’s benchmark using same methodology – time to first useful request (look at output from framework)
   Look at the throughput (use hey / wrk2)
3. Want to improve the throughput – let’s introduce PGO
   Profile the Native Image, whilst stress testing
   Show how we feed the profile info into the build process
   Run our new app
   Then repeat the stress test – we should see better throughput
4. Unit test the Native Image - show the new functionality available here

## Installation of GraalVM Enterprise Edition

### Oracle Linux

GraalVM Enterprise Edition is available as a package on Oracle linux:

```sh
$ sudo yum install graalvm21-ee-17-devel-21.3.0-1.el7.x86_64
$ java -version
```

### Other Linuxs

The binaries for GraalVM Enterprise Edition areavailable for download [here](https://www.oracle.com/downloads/graalvm-downloads.html?selected_tab=1).

The instllation guides are available from the same page. You will need to install the following componenets:

1. Oracle GraalVM Enterprise Edition Core, 21.3.0 (at least), Java Version 17
2. Oracle GraalVM Enterprise Edition Native Image, same version as above, Java Version 17

## Installation of Micronaut

Micronaut can be installed using `sdkman`, instructions are [here](https://micronaut.io/download/). To install:

```sh
$ curl -s https://get.sdkman.io | bash
$ source "$HOME/.sdkman/bin/sdkman-init.sh"
$ sdk install micronaut
$ mn --version
```