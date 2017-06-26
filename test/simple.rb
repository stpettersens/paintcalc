require 'open3'

Dir.chdir("cli")
puts "Invoking java -jar paintcalc.jar"
puts
Open3.pipeline_rw("java -jar paintcalc.jar") {|i, o, ts|
    puts o.gets # => Calculating paint needed...
    puts o.gets # => Room width (m)?
    i.puts 5 # <= 5
    puts 5
    puts o.gets # => Room length (m)?
    i.puts 5 # <= 5
    puts 5
    puts o.gets # => Room height (m)?
    i.puts 2 # <= 2
    puts 2
    puts o.gets # => Room floor area is 10.0 square metres (w5.0m x h2.0m) 
    puts o.gets # and requires 1.0 litre of paint.
    puts o.gets # => The volume of the room is 50.0 cubic metres (w5.0m x l5.0m x h2.0m).
    puts o.gets #  => Coverage is 10.0 square metres per litre and 1 coat is applied.
    i.close
}
