package pl.jvsystem.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 09.04.13 19:10
 */
public class Main {

	public static void main(String...args)
	{
//		String a = "/89989";
//		System.out.println(a.split("/")[0]);
		String fileName = null;
		Pattern regex = Pattern.compile("(?<=filename=\"?).+(?=\"?)");
		Matcher regexMatcher = regex.matcher("attachment; filename=Reference_STR_Profiles.xlsx");
		if (regexMatcher.find()) {
			fileName = regexMatcher.group();
		}
		System.out.println("filename:"+fileName);

	}

	private String getFileNameFromContentDispositionHeader(String headerValue) {
		String fileName = "REPORT.xlsx";
		Pattern regex = Pattern.compile("(?<=filename=\"?).+(?=\"?)");
		Matcher regexMatcher = regex.matcher(headerValue);
		if (regexMatcher.find()) {
			fileName = regexMatcher.group();
		}
		System.out.println("filename:"+fileName);
		return fileName;
	}

}
