package application;

import java.io.IOException;

import application.gameboard.Match;

public class Application {

	public static void main(String[] args){
		Match gameboard = new Match();
		gameboard.start();
	}

}
