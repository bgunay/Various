package pl.jvsystem.concurrency.gpars

import edu.stanford.nlp.process.CoreLabelTokenFactory
import edu.stanford.nlp.process.PTBTokenizer
import groovyx.gpars.GParsPool
import org.junit.BeforeClass
import org.junit.Test

import java.util.concurrent.atomic.AtomicInteger

/**
 * ParrarelizerSpec
 */
class ParrarelizerTest {

	static words = []

	@BeforeClass
	static void setup() {
		def libraryUrl = 'http://www.gutenberg.org/cache/epub/'
		def bookFile = '17405/pg17405.txt'
		def bigText = "${libraryUrl}${bookFile}".toURL()
		words = tokenize(bigText.text)
	}


	static tokenize(String txt) {
		List<String> words = []
		PTBTokenizer ptbt = new PTBTokenizer(
				new StringReader(txt),
				new CoreLabelTokenFactory(),
				''
		)
		ptbt.each { entry ->
			words << entry.value()
		}
		words
	}

	@Test
	void testParallelEach() {
		GParsPool.withPool {
			words.eachParallel { token ->
				if (token.length() > 10 && !token.startsWith('http')) {
					println token
				}
			}

		}
	}

	@Test
	void testEveryParallel() {
		GParsPool.withPool {
			assert !(words.everyParallel { token ->
				token.length() > 20
			})
		}
	}

	@Test
	void combinedParallel() {
		GParsPool.withPool {
			words.findAllParallel { it.length() > 10 && !it.startsWith('http')}
			.groupByParallel { it.length() }
			.collectParallel {
				println "WORD LENGHT ${it.key}: " + it.value*.toLowerCase().unique()
			}

		}
	}

	@Test
	void simpleParallel() {
		GParsPool.withPool(3) {
			final AtomicInteger result = new AtomicInteger(0)
			[1, 2, 3, 4, 5].eachParallel {
				println Thread.currentThread().name
				result.addAndGet(it)
			}
			assert 15 == result
		}
	}

}