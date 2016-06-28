package com.github.pnowy.various.dsl

import groovy.transform.Canonical

@Canonical
class Address {
	String street
	String city
	String country
}
