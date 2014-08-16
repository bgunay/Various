package pl.jvsystem.concurrency.gpars

import groovyx.gpars.GParsPool

import java.util.concurrent.ForkJoinPool

/**
 * DownloadingFilesConcurrently
 */
class FileDownloader {

	static final int POOL_SIZE = 25
	static pool

	FileDownloader() {
		pool = new ForkJoinPool(POOL_SIZE)
	}

	private void downloadFile(String remoteUrl, String localUrl) {
		println "Started downloadin file ${remoteUrl}"
		new File("$localUrl").withOutputStream { out ->
			new URL(remoteUrl).withInputStream { from ->
				out << from
			}
		}
	}

	private void parallelDownload(Map fromTo) {
		GParsPool.withPool {
			fromTo.eachParallel { from, to ->
				downloadFile(from, to)
			}
		}
	}

	void download(Map fromTo, int maxConcurrent) {
		if (maxConcurrent > 0 ) {
			use(MapPartition) {
				List maps = fromTo.partition(maxConcurrent)
				maps.each { downloadMap ->
					parallelDownload(downloadMap)
				}
			}
		} else {
			parallelDownload(fromTo)
		}
	}

	class MapPartition {
		static List partition(Map delegate, int size) {
			def rslt = delegate.inject([[:]]) { ret, elem ->
				(ret.last() << elem).size() >= size ? ret << [:] : ret
			}
			rslt.last() ? rslt : rslt[0..-2]
		}
	}

}
