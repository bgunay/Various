package pl.jvsystem.java8;

/**
 * Date: 2014-05-03 14:01
 */
public class MagicFormula implements Formula {
	@Override
	public double calculate(int a) {
		return sqrt(a * 100);
	}
}
