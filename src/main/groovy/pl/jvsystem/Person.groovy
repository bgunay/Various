package pl.jvsystem

import groovy.transform.Canonical

@Canonical
class Person {

	String name;
	Integer age;

	@Override
	String toString() {
		return "($name, $age)"
	}
}
