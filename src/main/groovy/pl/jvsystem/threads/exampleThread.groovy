package pl.jvsystem.threads

println Thread.currentThread().getName()

Thread.start {
	println Thread.currentThread().getName()
}