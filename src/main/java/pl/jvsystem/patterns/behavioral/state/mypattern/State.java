package pl.jvsystem.patterns.behavioral.state.mypattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 02.06.13 13:11
 */
public interface State {
	void writeName(final StateContext stateContext, final String name);
}
