package pl.jvsystem.dynamicobjects

data = new File('car.dat').readLines()

props = data[0].split(", ")
println props

data -= data[0]

def averangeMilesDrivenPerYear = { miles.toLong() / (2008 - year.toLong()) }

cars = data.collect {
	car = new Expando()
	it.split(", ").eachWithIndex { String value, int index ->
		car[props[index]] = value
	}

	car.ampy = averangeMilesDrivenPerYear

	car
}

props.each {
	name -> print "$name "
}
println " Avg. MPY "

ampyMethod = 'ampy'
cars.each { car ->
	for (String property : props ) {
		print "${car[property]} "
	}
	println car."$ampyMethod"()
}