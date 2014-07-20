package pl.jvsystem.regex

import groovy.util.logging.Slf4j
import spock.lang.Specification

import java.util.regex.Matcher
import java.util.regex.Pattern


/**
 * RegexSpec
 */
@Slf4j
class RegexSpec2 extends Specification {

	def "should match the filename"() {
		given:
		String fileName = null;
		Pattern regex = Pattern.compile("(?<=filename=\"?).+(?=\"?)");

		expect:
		Matcher regexMatcher = regex.matcher("attachment; filename=Reference_STR_Profiles.xlsx");

		if (regexMatcher.find()) {
			fileName = regexMatcher.group();
		}
		log.info("filename:" + fileName);
		assert fileName == 'Reference_STR_Profiles.xlsx'

	}

}