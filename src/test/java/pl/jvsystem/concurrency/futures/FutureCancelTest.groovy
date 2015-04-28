package pl.jvsystem.concurrency.futures

import groovy.util.logging.Slf4j
import spock.lang.Shared
import spock.lang.Specification

import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.function.Supplier

@Slf4j
class FutureCancelTest extends Specification {

	@Shared ExecutorService threadPool

	def setupSpec() {
		threadPool = Executors.newFixedThreadPool(10)
	}

	def "future is cancelled without exception"() {
		given:
			def task = new InterruptibleTask()
			def future = threadPool.submit(task)
			task.blockUntilStarted()
		and:
			future.cancel(true)
		when:
			future.get()
		then:
			thrown(CancellationException)
	}

	def "CompletableFuture is cancelled via CancellationException"() {
		given:
			def task = new InterruptibleTask()
			def future = CompletableFuture.supplyAsync({task.run()} as Supplier, threadPool)
			task.blockUntilStarted()
		and:
			future.cancel(true)
		when:
			future.get()
		then:
			thrown(CancellationException)
	}

}