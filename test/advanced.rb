require 'open3'

Dir.chdir("cli")
puts "Invoking java -jar paintcalc.jar -a"
puts
Open3.pipeline_rw("java -jar paintcalc.jar -a") {|i, o, ts|
    puts o.gets # => Calculating paint needed...
    puts o.gets # => Room width (m)?
    i.puts 10 # <= 10
    puts 10
    puts o.gets # => Room length (m)?
    i.puts 5 # <= 10
    puts 10
    puts o.gets # => Room height (m)?
    i.puts 5 # <= 5
    puts 5
    puts o.gets # => Paint coverage in square metres per litre?
    i.puts 20 # <= 20
    puts 20
    puts o.gets # => How many coats?
    i.puts 2 # <= 2
    puts 2
    puts o.gets # => Room floor area is 50.0 square metres (w10.0m x h5.0m) 
    puts o.gets # and requires 5.0 litres of paint.
    puts o.gets # => The volume of the room is 250.0 cubic metres (w10.0m x l5.0m x h5.0m).
    puts o.gets #  => Coverage is 20.0 square metres per litre and 2 coats are applied.
    i.close
}
