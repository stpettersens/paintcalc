### paintcalc
> Utility to calculate the volume of paint needed to paint a room of supplied dimensions.

[ ![Codeship Status for stpettersens/paintcalc](https://app.codeship.com/projects/e0f9b940-3e5a-0135-c15c-5a70b28fe525/status?branch=master)](https://app.codeship.com/projects/229482)
[![Build status](https://ci.appveyor.com/api/projects/status/l1claxd9mrq3onaa?svg=true)](https://ci.appveyor.com/project/stpettersens/paintcalc)

#### Building from source

##### Requirements

The following tools are required to build the programs. Please note these versions are known to work, earlier versions might work too.

* [Java Development Kit](http://java.sun.com) 1.8+
* [Ant](https://ant.apache.org) 1.9+ with [Ivy](https://ant.apache.org/ivy) 2.4+
* [Ruby](https://www.ruby-lang.org/en) 2.2+ and [Rake](https://ruby.github.io/rake) 10+

Ruby is required to run the `:test` task in the top level
buildfile (i.e. `Rakefile`). It is not strictly necessary to compile and run the programs or run the unit test. 

[JRuby](http://jruby.org) and its Rake implementation will work for the default task to compile the programs, but will not work for the `:test` task.

##### Build

* First, install the dependencies (i.e. [JUnit 4](http://junit.org/junit4))
in top level directory:

> `rake dependencies`

[or run `ant resolve` in *cli* directory].

* To build programs (in top level directory):

> `rake`

[or run `ant` in *cli* and *gui* directories, respectively].

* To test run the command line program with sample inputs:

> `rake test`

* To run the unit tests:

> `rake unittest`

[or run `ant unittest` in *cli* and *gui*, respectively].
