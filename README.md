# Link-station problem

This little program solves a problem I was given as part of an interview. There are link stations
and devices in 2d coordinates. Coordinates are in the program, you can't give them as arguments, yet.

This is a Clojure and Leiningen project. To compile and run the program, you must hava Java 8+, Clojure and Leiningen installed. 

## Installation

Most likely the easiest way to install everything you need is to use your package manager.

Clojure installation: https://clojure.org/guides/getting_started

Leiningen installation https://leiningen.org/

Java: https://www.java.com/en/download/

Just use the package manager...

## Usage

With Clojure and Leiningen working, you can run the project simply:

    lein run

in the project root.

To run unit tests:

    lein test

To make an uberjar that has all dependencies:

    lein uberjar

Then you can run the jar:

    $ java -jar target/uberjar/tech-problem-0.1.0-standalone.jar
