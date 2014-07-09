package pl.jvsystem.dsl

import groovy.transform.Canonical

/**
 * Book
 */
@Canonical
class Book {
	Long id
	String title
	BigDecimal price
}
