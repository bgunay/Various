package com.github.pnowy.various.dsl

import groovy.transform.Canonical

@Canonical
class Book {
	Long id
	String title
	BigDecimal price
}
