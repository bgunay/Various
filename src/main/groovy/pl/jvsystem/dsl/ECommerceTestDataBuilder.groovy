package pl.jvsystem.dsl
class ECommerceTestDataBuilder {

	ShoppingCart shoppingCart
	def books = []

	ShoppingCart build(closure) {
		shoppingCart = new ShoppingCart()
		closure.delegate = this
		closure()
		shoppingCart.items = books
		shoppingCart
	}

	void items (int quantity, closure) {
		closure.delegate = this
		quantity.times {
			books << new Book()
			closure()
		}
	}

	def methodMissing(String name, args) {
		Book book = books.last()
		if (book.hasProperty(name)) {
			// here eventually can add data strategy generator
			book.@"$name" = args[0]
		} else {
			throw new MissingMethodException(name,ECommerceTestDataBuilder,args)
		}
	}


}
