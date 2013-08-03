package pl.jvsystem.patterns.behavioral.templateMethod.mypattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 02.06.13 13:48
 */
public class Monopoly extends Game
{
	/* Implementation of necessary concrete methods */
	void initializeGame()
	{
		// Initialize players
		// Initialize money
	}

	void makePlay(int player)
	{
		// Process one turn of player
	}

	boolean endOfGame()
	{
		// Return true if game is over
		// according to Monopoly rules
		return false;
	}

	void printWinner()
	{
		// Display who won
	}
}
