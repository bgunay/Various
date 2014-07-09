package pl.jvsystem.dsl

import groovy.transform.Canonical

/**
 * ShoppingCart
 */
@Canonical
class ShoppingCart {
	List<Book> items = []
	User user
	Address shippingData


}
