package com.github.pnowy.various.patterns.behavioral.state.mypattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 02.06.13 13:13
 */
public class StateA implements State {

	@Override
	public void writeName(StateContext stateContext, String name) {
		System.out.println(name.toLowerCase());
		stateContext.setState(new StateB());
	}
}
