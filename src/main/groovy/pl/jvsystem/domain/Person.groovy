package pl.jvsystem.domain

import groovy.transform.Canonical

@Canonical
class Person {

	String firstName;
	String lastName;
	Integer age;

	@Override
	String toString() {
		return "($firstName, $lastName, $age)"
	}
}
