package pl.jvsystem.concurrency.gpars

import com.google.common.base.Stopwatch
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

import java.util.concurrent.TimeUnit

/**
 * FileDownloaderTest
 */
class FileDownloaderTest {
	static final DOWNLOAD_BASE_DIR = "c:/tmp"
	static final TEST_SERVICE = "https://androidnetworktester.googlecode.com"
	static final TEST_URL = "${TEST_SERVICE}/files/1mb.txt?cache="

	def downloader = new FileDownloader()
	Map files

	@Before
	void before() {
		files = [:]
		(1..5).each {
			files.put(
					"${TEST_URL}1.${it}",
					"${DOWNLOAD_BASE_DIR}/${it}MyFile.txt"
			)
		}
	}

	@Test
	@Ignore
	void testSerialDownload() {
		Stopwatch s = Stopwatch.createStarted()
		files.each { k, v ->
			println k
			new File(v) << k.toURL().text
		}
		println "TIME NOPAR: ${s.elapsed(TimeUnit.SECONDS)}"
	}

	@Test
	@Ignore
	void testParallelDownload() {
		Stopwatch s = Stopwatch.createStarted()
		downloader.download(files, 5)
		println "TIME NOPAR: ${s.elapsed(TimeUnit.SECONDS)}"
	}

}
