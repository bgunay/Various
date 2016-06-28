package com.github.pnowy.various.dsl

import groovy.transform.Canonical

@Canonical
class ShoppingCart {
	List<Book> items = []
	Address shippingData
}
