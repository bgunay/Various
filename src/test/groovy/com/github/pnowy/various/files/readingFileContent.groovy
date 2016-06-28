package com.github.pnowy.various.files

def file = new File("c:/tmp/text_file.txt")
println file.text

file.withReader { Reader reader ->
	def firstLine = reader.readLine()
	println firstLine.toUpperCase()
}

def lines = file.readLines()
lines.each {
	println it.toLowerCase()
}

file.eachLine {
	def result = (it =~ /(?i)first/).replaceAll("ALA")
	println result
}