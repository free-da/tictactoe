package application.game;

public class Match {

	public void start() {
		
		System.out.println("Hello!");
		printEmptyGameboardToConsole();
	}
	
	private void printEmptyGameboardToConsole() {
		Gameboard gameboard = new Gameboard();
		gameboard.drawGameboard();
	}
}
