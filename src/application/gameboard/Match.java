package application.gameboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Match {
	private FieldValueType player;
	private FieldValueType bot;
	private Gameboard gameboard;
	private boolean playersTurn = true;
	private boolean gameIsOver = false;
	private String winner;
	private int numberOfDraws = 0;
	
	public void start(){
		
		System.out.println("Hello!");
		askPlayerWhichCharacter();
		printInstructions();
		gameboard = new Gameboard();
		gameboard.drawGameboard();
		startGameLoop();
		endGame();
		announceWinner();
		askToRestartOrEnd();
	}

	private void startGameLoop() {
		while (!isGameOver()) {
			nextMove();
		}    
		return;
	}
	
	private void askToRestartOrEnd() {
		// TODO Auto-generated method stub
		
	}

	private void announceWinner() {
		if (winner.equals("player")) {
			System.out.println("You won.");
		} else if (winner.equals("bot")) {
			System.out.println("You lost. The machine is superior.");
		} else {
			System.out.println("Tied.");
		}

	}

	private void endGame() {
		System.out.println("Game is over.");
	}

	private boolean isGameOver() {
		if (someoneWon()) {
			gameIsOver = true;
		}
		if (numberOfDraws == (gameboard.NUMBEROFCOLUMNS * gameboard.NUMBEROFROWS)) {
			gameIsOver = true;
		}
		return gameIsOver;
	}

	private boolean someoneWon() {
		if (gameboard.checkIfEitherWon(player)) {
			winner = "player";
			return true;	
		}
		if (gameboard.checkIfEitherWon(bot)) {
			winner = "bot";
			return true;	
		}
		return false;
	}

	private void nextMove() {
		if (playersTurn) {
			playerMakesNextMove();
		} else {
			botMakesNextMove(); 
		}
		numberOfDraws ++;
		gameboard.drawGameboard();

	}

	private void botMakesNextMove() {
		for (int i=0; i<gameboard.NUMBEROFROWS; i++) {
			for (int j=0; j<gameboard.NUMBEROFCOLUMNS; j++) {
				if (gameboard.checkIfFieldIsEmpty(i, j)) {
					gameboard.setFieldValue(i,j, bot);
					playersTurn = true;
					return;
		        }
			}
		}
		gameIsOver = true;
	}

	private void playerMakesNextMove() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
        	System.out.print(">_");
			input = bufferedReader.readLine();
			if (checkForValidity(input)) {
				gameboard.setFieldValue(findRowIndex(input), findColumnIndex(input), player);
	        }
		} catch(IOException e) {
			System.out.println("Error. Try again.");
			playerMakesNextMove();
		}
        playersTurn = false;
        return;
	}
	
	private int findColumnIndex(String input) {
		char secondLetter = input.charAt(1);
		String coordinatesHelperColumns = "ABCDEFG";
		coordinatesHelperColumns = coordinatesHelperColumns.substring(0, gameboard.NUMBEROFCOLUMNS);
		int columnIndex = -1;
		if (coordinatesHelperColumns.contains(Character.toString(secondLetter).toUpperCase())) {
			columnIndex = coordinatesHelperColumns.indexOf(Character.toString(secondLetter).toUpperCase());
		}
		return columnIndex;
	}
	
	private int findRowIndex(String input) {
		char firstLetter = input.charAt(0);
		String coordinatesHelperRows = "123456";
		coordinatesHelperRows = coordinatesHelperRows.substring(0, gameboard.NUMBEROFROWS);
		int rowIndex = -1;
		if (coordinatesHelperRows.contains(Character.toString(firstLetter).toUpperCase())) {
			rowIndex = coordinatesHelperRows.indexOf(Character.toString(firstLetter).toUpperCase());
		}
		return rowIndex;
	}

	private boolean checkForValidity(String input) {
		if (input.length()==2) {
			int columnIndex = findColumnIndex(input);
			int rowIndex = findRowIndex(input);
			if (columnIndex < 0 || rowIndex < 0) {
				return false;
			} else if (!gameboard.checkIfFieldIsEmpty(rowIndex, columnIndex)) {
				return false;
			}
		}
		return true;
	}

	private void askPlayerWhichCharacter() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Are you X or O?: [X] [O]");
		try {
			String input = bufferedReader.readLine();
			checkForValidityAndSaveOrAskAgain(input);
		} catch(IOException e) {
			System.out.println("Error. Try again.");
			askPlayerWhichCharacter();
		}
	}
	
	private void checkForValidityAndSaveOrAskAgain(String input) {

		if ((input.equals("X")) || (input.equals("x"))) {
			player = FieldValueType.X;
			bot = FieldValueType.O;
		} else if ((input.equals("O")) || (input.equals("o"))) {
			player = FieldValueType.O;
			bot = FieldValueType.X;
		} else {
			System.out.println("Try again.");
			askPlayerWhichCharacter();
		}
		return;
	}
	
	private void printInstructions() {
		System.out.print("You are " + player + ". ");
		System.out.print("You start.\n");
		System.out.println("Enter your field coordinate.");
	}
}
