require 'open3'

Dir.chdir("cli")
puts "Invoking java -jar paintcalc.jar"
puts
Open3.pipeline_rw("java -jar paintcalc.jar") {|i,o,ts|
  puts o.gets
  puts o.gets
  i.puts 5
  puts 5
  puts o.gets
  i.puts 5
  puts 5
  puts o.gets
  i.puts 2
  puts 2
  puts o.gets
  puts o.gets
  i.close
}
