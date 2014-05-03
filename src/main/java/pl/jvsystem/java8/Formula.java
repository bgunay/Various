package pl.jvsystem.java8;

/**
 * Date: 2014-05-03 13:59
 */
public interface Formula {
	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}

}
