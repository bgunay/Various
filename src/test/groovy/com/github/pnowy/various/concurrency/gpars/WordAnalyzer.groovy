package com.github.pnowy.various.concurrency.gpars

import com.google.common.collect.Lists
import groovyx.gpars.GParsPool

/**
 * WordAnalyzer
 */
class WordAnalyzer {
	static final Integer THRESHOLD = 50000
	static final int MAX_THREAD = 8

	private Map calculateFrequency(List<String> words) {
		def frequences = [:]
		words.each {
			Integer num = frequences.get(it)
			frequences.put(it, num ? num + 1 : 1)
		}
		frequences
	}

	Map frequency(List<String> tokens) {
		def frequencyMap = [:]
		def maps
		GParsPool.withPool(MAX_THREAD) {
			maps = GParsPool.runForkJoin(tokens) { words ->
				if (words.size() <= THRESHOLD) {
					// no parallelism
					return calculateFrequency(words)
				} else {
					Lists.partition(words, THRESHOLD).each { sublist ->
						forkOffChild(sublist)
					}
					// collect all results
					return childrenResults
				}
			}
			maps.each {
				frequencyMap.putAll(it)
			}
			// reverse sort
			frequencyMap.sort { a, b -> b.value <=> a.value }
		}
	}

}
