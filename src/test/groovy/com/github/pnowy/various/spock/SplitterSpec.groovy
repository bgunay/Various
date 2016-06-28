package com.github.pnowy.various.spock

import com.google.common.base.Splitter
import groovy.util.logging.Slf4j
import spock.lang.Specification


/**
 * SplitterSpec
 */
@Slf4j
class SplitterSpec extends Specification {

	def "should split provided string"() {
		given:
		String profile = "12|13";
		when:
		List<String> profilesAsString = Splitter.on("|").omitEmptyStrings().
				trimResults().splitToList(profile);
		then:
		log.info("profilesAsString: {}", profilesAsString)
		assert profilesAsString.size() == 2
	}

}