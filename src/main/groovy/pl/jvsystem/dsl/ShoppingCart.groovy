package pl.jvsystem.dsl

import groovy.transform.Canonical

@Canonical
class ShoppingCart {
	List<Book> items = []
	Address shippingData
}
