package com.bham.pij.assignments.pontoon;
// Munir Suleman

import java.util.*;

public abstract class CardGame {
	private int nplayers;
	private Deck deck;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	
	public CardGame (int nplayers) {
		// constructor creates the deck and sets the number of players for the game
		this.nplayers = nplayers;
		this.deck = new Deck();
		
		String[] playerNames = new String[10];
		playerNames[0] = "Player1";
		playerNames[1] = "Player2";
		playerNames[2] = "Player3";
		playerNames[3] = "Player4";
		playerNames[4] = "Player5";
		playerNames[5] = "Player6";
		playerNames[6] = "Player7";
		playerNames[7] = "Player8";
		playerNames[8] = "Player9";
		playerNames[9] = "Player10";
		
		for(int i = 0; i < nplayers; i++) {
			players.add(new Player(playerNames[i]));
		}
	}
	
	// deals the number of initial cards to each player in the game
	public abstract void dealInitialCards();
	
	// compares the hands of two players. if hand1 > hand2 = -1. if hand1 < hand2 = 1. if hand1 = hand2 = 0
	public abstract int compareHands(Player hand1, Player hand2);
	
	public Deck getDeck() {
		// returns the deck
		return this.deck;
	}
	
	public Player getPlayer(int i) {
		// returns the player at i
		return players.get(i);
	}
	
	public int getNumPlayers() {
		// return the number of players 
		return nplayers;
	}
	
}
