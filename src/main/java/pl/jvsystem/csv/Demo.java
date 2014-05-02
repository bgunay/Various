package pl.jvsystem.csv;

import java.io.FileReader;
import java.util.Arrays;

import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

/**
 * Date: 11.12.13 10:53
 */
public class Demo {

	public static void main(String[] args) throws Exception {

		try(ICsvBeanReader inFile = new CsvBeanReader(new FileReader("C:\\test1a.txt"), CsvPreference.EXCEL_PREFERENCE)) {
			final String[] header = inFile.getHeader(true);
			System.out.println("header: " + Arrays.toString(header));
			System.out.println("header: " + header.length);
		}
	}
}
