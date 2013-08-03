package pl.jvsystem.patterns.behavioral.templateMethod.mypattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 02.06.13 13:49
 */
public class Chess extends Game
{
	/* Implementation of necessary concrete methods */
	void initializeGame()
	{
		// Initialize players
		// Put the pieces on the board
	}

	void makePlay(int player)
	{
		// Process a turn for the player
	}

	boolean endOfGame()
	{
		// Return true if in Checkmate or
		// Stalemate has been reached
		return false;
	}

	void printWinner()
	{
		// Display the winning player
	}
}
