package com.github.pnowy.various.java8.domain;

@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);
}
