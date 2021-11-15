package application;

public class Match {
	public Grid grid;
	public boolean playersTurn;
	public boolean gameIsOver;
	public String winner;
	public int numberOfMoves;
	public Symbol playerSymbol;
	public Symbol botSymbol;
	
	public Match(Symbol playerSymbol) {
		grid = new Grid();
		this.playerSymbol = playerSymbol;
		botSymbol = (playerSymbol == Symbol.X) ? Symbol.O : Symbol.X; 
		playersTurn = true;
		gameIsOver = false;
		numberOfMoves = 0;
		winner = "";
	}
	
}
