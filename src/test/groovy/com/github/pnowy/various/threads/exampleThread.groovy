package com.github.pnowy.various.threads

println Thread.currentThread().getName()

Thread.start {
	println Thread.currentThread().getName()
}