package com.github.pnowy.various.java8.domain;

public class MagicFormula implements Formula {
	@Override
	public double calculate(int a) {
		return sqrt(a * 100);
	}
}
