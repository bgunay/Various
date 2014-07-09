package pl.jvsystem.files

def file = new File ('c:/TMP/pg2264.txt')
int wordCount = 0
//file.eachLine { String line ->
//	line.tokenize().each { String word ->
//		wordCount++
//		println word
//	}
//}
//println wordCount

file.splitEachLine(/[\s\t]+/) { Collection words ->
	words.findAll { it.trim() }.each { String word ->
		wordCount++
	}
}
println wordCount