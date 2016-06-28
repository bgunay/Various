package pl.jvsystem.dsl

import groovy.transform.Canonical

@Canonical
class Book {
	Long id
	String title
	BigDecimal price
}
