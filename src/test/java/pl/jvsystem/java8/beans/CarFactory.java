package pl.jvsystem.java8.beans;

/**
 * Date: 2014-05-03 14:47
 */
public interface CarFactory<C extends Car> {
	C create(String model, String brand);
}
