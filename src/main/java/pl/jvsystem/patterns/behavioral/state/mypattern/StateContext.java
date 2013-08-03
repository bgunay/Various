package pl.jvsystem.patterns.behavioral.state.mypattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 02.06.13 13:12
 */
public class StateContext
{
	private State myState;

	/**
	 * Standard constructor
	 */
	public StateContext()
	{
		setState(new StateA());
	}

	/**
	 * Setter method for the state.
	 * Normally only called by classes implementing the State interface.
	 *
	 * @param NEW_STATE
	 */
	public void setState(final State NEW_STATE)
	{
		myState = NEW_STATE;
	}

	/**
	 * Writer method
	 *
	 * @param NAME
	 */
	public void writeName(final String NAME)
	{
		myState.writeName(this, NAME);
	}
}