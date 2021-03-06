package com.github.pnowy.various.java8.domain;

/**
 * Date: 2014-05-03 13:59
 */
public interface Formula {
	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}

	static double max(double a, double b) {
		return a > b ? a : b;
	}

}
