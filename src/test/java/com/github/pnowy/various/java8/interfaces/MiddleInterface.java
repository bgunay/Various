package com.github.pnowy.various.java8.interfaces;

/**
 * MiddleInterface
 */
public interface MiddleInterface extends SuperInterface {

	@Override
	default void printName() {
		System.out.println("MIDDLE_INTERFACE");
	}

}
