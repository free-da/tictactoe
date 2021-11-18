package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MatchController {
	private Match match;
	private Random randomizerForBotMoves = new Random();

	public MatchController(Match match) {
		this.match = match;
	}
	
	public void startMatch() {
		startGameLoop();
		announceEndOfGame();
		announceWinner();
	}

	private void startGameLoop() {
		while (!isGameOver()) {
			nextMove();
		}    
		return;
	}

	private boolean isGameOver() {
		if (someoneWon()) {
			match.gameIsOver = true;
		}
		if (match.numberOfMoves == (match.grid.numberOfColumns * match.grid.numberOfRows)) {
			match.gameIsOver = true;
			someoneWon();
		}
		return match.gameIsOver;
	}
	
	private boolean someoneWon() {
		if (WinChecker.checkIfEitherWon(match.playerSymbol, match.grid)) {
			match.winner = "player";
			return true;	
		}
		if (WinChecker.checkIfEitherWon(match.botSymbol, match.grid)) {
			match.winner = "bot";
			return true;	
		}
		return false;
	}

	private void nextMove() {
		if (match.playersTurn) {
			playerMakesNextMove();
		} else {
			botMakesNextMove(); 
		}
		match.numberOfMoves ++;
		GameboardDrawer.drawGameboard(match.grid);
	}

	private void botMakesNextMove() {
		int rowIndex = randomizerForBotMoves.nextInt(match.grid.numberOfRows);
		int columnIndex = randomizerForBotMoves.nextInt(match.grid.numberOfColumns);
		if (match.grid.checkIfFieldIsEmpty(rowIndex, columnIndex)) {
			match.grid.setFieldValue(rowIndex,columnIndex, match.botSymbol);
			match.playersTurn = true;
			return;
        } else {
        	botMakesNextMove();
        }
	}

	private void playerMakesNextMove() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
        	System.out.print(">_");
			input = bufferedReader.readLine();
			if (coordinateInputIsValid(input)) {
				match.grid.setFieldValue(findRowIndex(input), findColumnIndex(input), match.playerSymbol);
	        } else {
	        	System.out.println("Please, play by the rules. Try again.");
				playerMakesNextMove();
	        }
		} catch(IOException e) {
			System.out.println("Error. Try again.");
			playerMakesNextMove();
		}
        match.playersTurn = false;
        return;
	}

	private void announceWinner() {
		if (match.gameIsOver && someoneWon()) {
			if (match.winner.equals("player")) {
				System.out.println("You won.");
			} else if (match.winner.equals("bot")) {
				System.out.println("You lost. The machine is superior.");
			} 
		} else {
			System.out.println("Tied. Everybody loses.");
		}

	}

	private void announceEndOfGame() {
		System.out.println("Game is over.");
	}
	
	private int findColumnIndex(String input) {
		char secondLetter = input.charAt(1);
		String coordinatesHelperColumns = "ABCDEFG";
		coordinatesHelperColumns = coordinatesHelperColumns.substring(0, match.grid.numberOfColumns);
		int columnIndex = coordinatesHelperColumns.indexOf(Character.toString(secondLetter).toUpperCase());
		return columnIndex;
	}
	
	private int findRowIndex(String input) {
		char firstLetter = input.charAt(0);
		String coordinatesHelperRows = "123456";
		coordinatesHelperRows = coordinatesHelperRows.substring(0, match.grid.numberOfRows);
		int rowIndex = coordinatesHelperRows.indexOf(Character.toString(firstLetter).toUpperCase());
		return rowIndex;
	}

	private boolean coordinateInputIsValid(String input) {
		if (input.length()==2) {
			int columnIndex = findColumnIndex(input);
			int rowIndex = findRowIndex(input);
			if (columnIndex < 0 || rowIndex < 0) {
				return false;
			} else if (!match.grid.checkIfFieldIsEmpty(rowIndex, columnIndex)) {
				return false;
			}
			return true;
		}
		return false;
	}
}

