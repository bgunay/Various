package pl.jvsystem.files

File file = new File('../../')
println file.absolutePath
file.eachDirRecurse { File f ->
	println f.name
}