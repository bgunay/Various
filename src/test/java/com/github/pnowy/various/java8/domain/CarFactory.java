package com.github.pnowy.various.java8.domain;

public interface CarFactory<C extends Car> {
	C create(String model, String brand);
}
