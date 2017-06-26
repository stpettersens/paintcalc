### paintcalc
> Utility to calculate the volume of paint needed to paint a room of supplied dimensions.

[![Build Status](https://travis-ci.org/stpettersens/paintcalc.svg?branch=master)](https://travis-ci.org/stpettersens/paintcalc)

#### Building from source

##### Requirements

The following tools are required to build the program. Please note these versions are known to work, earlier versions might work too.

* Java Development Kit 1.8+
* Ant 1.8+
* Ruby 2.2+ and Rake

Ruby is required to run the `:tests` task in the top level
buildfile (i.e. `Rakefile`). It is not strictly necessary to compile and run the programs or run the unit tests. JRuby and its Rake implementation will work for the default task to compile the programs, but will not work for the `:tests` task.

##### Build

To build programs (in top level directory):

`rake`

[or run `ant` in *cli* and *gui* directories, respectively].

To test run the command line program:

`rake test`

To run the unit tests:

`rake unittests`

[or run `ant unittest` in *cli* and *gui*, respectively].
