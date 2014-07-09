package pl.jvsystem.files

import pl.jvsystem.domain.Person

File file = new File('c:/TMP/output.txt')
//file.text = "Ala ma kota"
//file.bytes = [65, 66, 76, 68] as byte[]
file << "Append New line"

file.withWriter { Writer writer ->

}