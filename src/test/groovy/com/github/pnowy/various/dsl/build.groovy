package com.github.pnowy.various.dsl

def shoppingCart = new ECommerceTestDataBuilder().build {
	items(2) {
		title 'Pan Tadeusz'
		id 123
		price 100
	}
//	user {
//		id RANDOM_ID, 1,500
//		firstName RANDOM_STRING
//		lastName RANDOM_STRING
//		address RANDOM_US_ADDRESS
//	}
}

print shoppingCart