package pl.jvsystem.patterns.behavioral.state.mypattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 02.06.13 13:14
 */
public class StateB implements State {
	private int count = 0;

	@Override
	public void writeName(StateContext stateContext, String name) {
		System.out.println(name.toUpperCase());
		// Change state after StateB's writeName() gets invoked twice
		if (++count > 1) {
			stateContext.setState(new StateA());
		}
	}
}
