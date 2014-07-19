package pl.jvsystem.java8;

/**
 * Date: 2014-05-03 14:21
 */
@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);
}