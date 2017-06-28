require 'os'

ant = "ant"
simpletestrb = "test/simple.rb"
advancedtestrb = "test/advanced.rb"

if OS.windows? then
    if !ENV['CI'] then
        ant = "cmd /c ant.bat"
        simpletestrb = "test\\simple.rb"
        advancedtestrb = "test\\advanced.rb"
    end
end

task :default => [:cli] do
    puts ""
    Dir.chdir("gui")
    sh "#{ant}"
    puts ""
end

task :cli do
    Dir.chdir("cli")
    sh "#{ant}"
    Dir.chdir("..")
end

task :dependencies do
    Dir.chdir("cli")
    sh "#{ant} resolve"
end

task :clean do
    Dir.chdir("cli")
    sh "#{ant} clean"
    Dir.chdir("..")
    Dir.chdir("gui")
    sh "#{ant} clean"
end

task :test do
    ruby "#{simpletestrb}" # <> {simpletestio}
    puts ""
    ruby "#{advancedtestrb}" # <> {advancedtestio}
end

task :unittest do
    Dir.chdir("cli")
    sh "#{ant} unittest"
    puts ""
    if OS.windows? then
        sh "type result.txt"
    else
        sh "cat result.txt"
    end
end
