require 'os'
require 'fileutils'

ant = "ant"
simpletest = "test/simple.rb"
advancedtest = "test/advanced.rb"

if OS.windows? then
    if !ENV['CI'] then
        ant = "cmd /c ant.bat"
        simpletest = "test\\simple.rb"
        advancedtest = "test\\advanced.rb"
    end
end

task :default => [:cli] do
    puts ""
    Dir.chdir("gui")
    puts "Building GUI implentation..."
    sh "#{ant}"
    Dir.chdir("..")
end

task :cli do
    Dir.chdir("cli")
    puts "Building CLI implementation..."
    sh "#{ant}"
    Dir.chdir("..")
end

task :clean do
    FileUtils.rm_r("cli/ant_build")
    File.delete("cli/paintcalc.jar")
    FileUtils.rm_r("gui/ant_build")
    File.delete("gui/paintcalc.jar")
end

task :test do
    ruby "#{simpletest}"
    puts ""
    ruby "#{advancedtest}"
end

task :unittests do
    puts "!TODO"
end
