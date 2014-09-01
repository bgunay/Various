package pl.jvsystem.methodsynthesis

class PersonCache {
	def work() { "working..." }

	def plays = ['Tennis', 'VolleyBall', 'BasketBall']

	def methodMissing(String name, args) {
		System.out.println "methodMissing called for $name"
		def methodInList = plays.find { it == name.split('play')[1]}
		if (methodInList) {
			def impl = { Object[] vargs ->
				"playing ${name.split('play')[1]}..."
			}
			PersonCache instance = this
			instance.metaClass."$name" = impl //future calls will use this
			impl(args)
		} else {
			throw new MissingMethodException(name, PersonCache.class, args)
		}
	}
}

jack = new PersonCache()
println jack.playTennis()
println jack.playTennis()