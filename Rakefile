require 'os'
require 'fileutils'

ant = "ant"

if OS.windows? then
	Dir.chdir("cli")
	ant = "cmd /c ant.bat"
	Dir.chdir("..")
end

task :default => [:cli] do
	Dir.chdir("gui")
	puts "Building GUI implentation..."
	sh "#{ant}"
	Dir.chdir("..")
end

task :cli do
	Dir.chdir("cli")
	puts "Buidling CLI implementation..."
	sh "#{ant}"
	Dir.chdir("..")
end

task :clean do
	FileUtils.rm_r("cli/ant_build")
	File.delete("cli/paintcalc.jar")
	FileUtils.rm_r("gui/ant_build")
	File.delete("gui/paintcalc.jar")
end
