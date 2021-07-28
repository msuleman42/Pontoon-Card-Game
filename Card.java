package com.bham.pij.assignments.pontoon;
// Munir Suleman

import java.util.*;

public class Card {
	// defining enums of Suit and Values
	public static enum Suit {CLUBS, HEARTS, DIAMONDS, SPADES};
	public static enum Value {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
	
	private Suit suit;
	private Value value;
	
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	public ArrayList<Integer> getNumericalValue() {
		// return an ArrayList of the numerical value of the card
		ArrayList<Integer> numVal = new ArrayList<Integer>();
		if(value == Value.ACE) {
			numVal.add(1);
			numVal.add(11);
		}
		else if(value == Value.TWO)
			numVal.add(2);
		else if(value == Value.THREE)
			numVal.add(3);
		else if(value == Value.FOUR)
			numVal.add(4);
		else if(value == Value.FIVE)
			numVal.add(5);
		else if(value == Value.SIX)
			numVal.add(6);
		else if(value == Value.SEVEN)
			numVal.add(7);
		else if(value == Value.EIGHT)
			numVal.add(8);
		else if(value == Value.NINE)
			numVal.add(9);
		else if(value == Value.TEN || value == Value.JACK || value == Value.QUEEN || value == Value.KING)
			numVal.add(10);
		
		return numVal;
	}

	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	
}
