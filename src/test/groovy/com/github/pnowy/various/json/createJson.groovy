package com.github.pnowy.various.json

import groovy.json.JsonBuilder

def builder = new JsonBuilder()
builder.customer {
	name 'John'
	lastName 'Appleseed'
	address {
		streetName 'Gordon street'
		city 'Philadelphia'
		houseNumber 20
	}
}
println builder.toPrettyString()

def chart = [
		items: [
				type: 'chart',
				height: 200,
				width: 300,
				axes: [
						{
							type 'Time'
							fields ([ 'x' ])
							position 'left'
							title 'Time'
						},
						{
							type 'Numeric'
							fields ( [ 'y' ] )
							position 'bottom'
							title 'Profit in EUR'
						}
				]
		]
]
def builder2 = new JsonBuilder(chart)
println builder2.toPrettyString()