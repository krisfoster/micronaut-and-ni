# GraalVM Enterprise Edition Native Image, `HelloWorld`

## Overview

We are going to start out with the simplest thing we can do with GraalVM Enterprise Edition Native Image, here-after referred to simple as Native Image, create a native linux binary that does nothing more than print to `STDOUT`. 

What we would like to show is the most basic process of building a native binary from a Java application.

Let's get started.

## Check we Have Native Image Installed

We should, thanks to the installation instructions at the root of the repo, should have both GraalVM Enterprise Edition Java 17 and the corresponding Native Image installed.

Let's Check:

```sh
$ java -version
java version "17.0.1" 2021-10-19 LTS
Java(TM) SE Runtime Environment GraalVM EE 21.3.0 (build 17.0.1+12-LTS-jvmci-21.3-b05)
Java HotSpot(TM) 64-Bit Server VM GraalVM EE 21.3.0 (build 17.0.1+12-LTS-jvmci-21.3-b05, mixed mode, sharing)
```

You should see the above. The exact version numbers may change if you are using a slighly more recent version of GraalVM Enterprise Edition Java. Most importantly we can see that we are using, `java version "17.0.1"`, and GraalVM Enterprise Edition, `GraalVM EE`.

Now we need to check that Native Image is available.

```sh
$ native-image --version
GraalVM 21.3.0 Java 17 EE (Java Version 17.0.1+12-LTS-jvmci-21.3-b05)
```
Again the exact version may differ, but you should see that you are using Native Image Java Version 17 Enterprise Edition, `Java 17 EE`.

## Create a `HelloWorld` Application

Let's create a super simple Java application.

```sh
touch HelloWorld.java
cat <<EOF >> HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
EOF
```

Let's compile it and run it.

```sh
$ javac HelloWorld.java
$ java HelloWorld
Hello World!
```

It worked.

## Making a Native Image

In order to mke a fast starting, low footprint linux binary of our application we need to use the `native-image` tool.

To build the native image:

```sh
$ native-image -cp . HelloWorld
[helloworld:8635]    classlist:   1,092.53 ms,  0.96 GB
[helloworld:8635]        (cap):     670.11 ms,  0.96 GB
[helloworld:8635]        setup:   2,850.94 ms,  0.96 GB
[helloworld:8635]     (clinit):     137.53 ms,  2.35 GB
[helloworld:8635]   (typeflow):   2,865.02 ms,  2.35 GB
[helloworld:8635]    (objects):   5,656.84 ms,  2.35 GB
[helloworld:8635]   (features):   1,445.34 ms,  2.35 GB
[helloworld:8635]     analysis:  10,514.94 ms,  2.35 GB
[helloworld:8635]     universe:     707.86 ms,  2.35 GB
[helloworld:8635]      (parse):     877.21 ms,  2.35 GB
[helloworld:8635]     (inline):   1,172.94 ms,  2.36 GB
[helloworld:8635]    (compile):  19,620.25 ms,  5.22 GB
[helloworld:8635]      compile:  22,952.41 ms,  5.22 GB
[helloworld:8635]        image:   1,377.63 ms,  5.22 GB
[helloworld:8635]        write:     220.87 ms,  5.22 GB
[helloworld:8635]      [total]:  39,935.77 ms,  5.22 GB
# Printing build artifacts to: /home/opc/repos/micronaut-and-ni/00-hello-world/helloworld.build_artifacts.txt

$ ls -l
total 15908
-rwxrwxr-x. 1 opc opc 16270848 Nov  1 13:15 helloworld
-rw-rw-r--. 1 opc opc       25 Nov  1 13:15 helloworld.build_artifacts.txt
-rw-rw-r--. 1 opc opc      426 Nov  1 12:55 HelloWorld.class
-rw-rw-r--. 1 opc opc      123 Nov  1 12:55 HelloWorld.java
```

So our `native-image` tool just built, `helloworld`. This is a linux binary. Let's run it.

```sh
$ ./helloworld
Hello World!
```

Let's look at how long our Java application and our native binary take to run:

```sh
$ time java HelloWorld
Hello World!

real	0m0.058s
user	0m0.059s
sys	0m0.023s

$ time ./helloworld
Hello World!

real	0m0.002s
user	0m0.002s
sys	0m0.000s
```

The actual numbers you will see will depend on the machine that you are using. The stand-out thing to notice is just how fast the native binary, that we created with `native-image`, runs.

And we are done our first steps into using Native Image.