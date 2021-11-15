package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {

	Symbol playerSymbol;
	boolean gameIsOver;
	
	public GameController () {
		gameIsOver = false;
	}
	
	public void runTicTacToe(){
		askPlayerWhichSymbol();
		do {
			Match match = new Match(playerSymbol);
			printInstructions();
			GameboardDrawer.drawGameboard(match.grid);
			MatchController matchController= new MatchController(match);
			matchController.startMatch();
		} while (userCantGetEnough());
		System.out.println("Bye.");
		System.exit(0);
	}
	
	private boolean userCantGetEnough() {
		System.out.println("Do you want to play again? [re][restart] [ex][exit]");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
        	System.out.print(">_");
			String input = bufferedReader.readLine();
			if (input.equals("restart") || input.equals("re")) {
				return true;
			} else if (input.equals("exit") || input.equals("ex")) {
				return false;
			} else {
				System.out.println("Please, play by the rules. Try again.");
			}
		} catch(IOException e) {
			System.out.println("Error. Try again.");
			userCantGetEnough();
		}		
		return false;
	}

	private void askPlayerWhichSymbol() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Hello!\nAre you X or O?: [X] [O]\n");
		try {
			System.out.print(">_");
			String input = bufferedReader.readLine();
			if(checkCharacterForValidity(input)) {
				saveChosenCharacter(input);
				return;
			} else {
				System.out.println("Try again.");
				askPlayerWhichSymbol();
			};
		} catch(IOException e) {
			System.out.println("Error. Try again.");
			askPlayerWhichSymbol();
		}
	}

	private void printInstructions() {
		System.out.print("You are " + playerSymbol + ". ");
		System.out.print("You start.\n");
		System.out.println("Enter your field coordinate.");
	}
	
	private void saveChosenCharacter(String input) {
		if ((input.equals("X")) || (input.equals("x"))) {
			playerSymbol = Symbol.X;
		} else if ((input.equals("O")) || (input.equals("o"))) {
			playerSymbol = Symbol.O;
		}
	}

	private boolean checkCharacterForValidity(String input) {
		if ((input.equals("X")) || (input.equals("x")) || (input.equals("O")) || (input.equals("o"))) {
			return true;
		}
		return false;
	}
}
