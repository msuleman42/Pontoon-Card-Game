package com.bham.pij.assignments.pontoon;
//Munir Suleman

import java.util.*;

public class Pontoon extends CardGame {
	
	public Pontoon(int nplayers) {
		super(nplayers);
		super.getDeck().shuffle();
		dealInitialCards();
	}
	
	public void dealInitialCards() {
		// deal 2 cards to each player
		for(int i = 0; i < super.getNumPlayers(); i++) {
			super.getPlayer(i).dealToPlayer(super.getDeck().dealRandomCard());
			super.getPlayer(i).dealToPlayer(super.getDeck().dealRandomCard());
		}
	}
	
	public int compareHands(Player hand1, Player hand2) {
		// compares the hands of two players. if hand1 > hand2 = -1. if hand1 < hand2 = 1. if hand1 = hand2 = 0
		boolean pCheck1 = pontoonCheck(hand1);
		boolean pCheck2 = pontoonCheck(hand2);
		
		boolean fCheck1 = fiveCardTrickCheck(hand1);
		boolean fCheck2 = fiveCardTrickCheck(hand2);
		
		boolean bCheck1 = bustCheck(hand1);
		boolean bCheck2 = bustCheck(hand2);
		
		int bestHandVal1 = getBestHandVal(hand1);
		int bestHandVal2 = getBestHandVal(hand2);
		
		if(pCheck1 == true || pCheck2 == true) {
			if(pCheck1 == true && pCheck2 == false) {
				// hand1 has a pontoon
				return -1;
			}
			else if(pCheck1 == false && pCheck2 == true) {
				// hand2 has a pontoon
				return 1;
			}
			else {
				//both have pontoons
				return 0;
			}
		}
		else if(fCheck1 == true || fCheck2 == true) {
			if(fCheck1 == true && fCheck2 == false) {
				// hand1 has a five card trick
				return -1;
			}
			else if(fCheck1 == false && fCheck2 == true) {
				// hand2 has a five card trick
				return 1;
			}
			else {
				//both have five card tricks
				return 0;
			}
		}
		else if(bCheck1 == true || bCheck2 == true) {
			if(bCheck1 == true && bCheck2 == false) {
				// hand1 is bust and hand2 is not so hand2 is better
				return 1;
			}
			else if(bCheck1 == false && bCheck2 == true) {
				// hand2 is bust and hand1 isnt so hand1 is better
				return -1;
			}
			else {
				// both are bust
				return 0;
			}
		}
		else {
			if(bestHandVal1 > bestHandVal2) {
				// hand1 is better than hand2
				return -1;
			}
			else if(bestHandVal1 < bestHandVal2) {
				// hand2 is better than hand1
				return 1;
			}
			else {
				// hands are equal
				return 0;
			}
		}
	}

	
	public boolean pontoonCheck(Player hand) {
		// check if hand is a pontoon
		boolean pCheck = false;
		int bHandVal = getBestHandVal(hand);
		if(hand.getHandSize() == 2 && bHandVal == 21) {
			pCheck = true;
		}
		
		return pCheck;
	}
	
	public boolean fiveCardTrickCheck (Player hand) {
		// check if hand is a five card trick
		boolean fCheck = false;
		int bHandVal = getBestHandVal(hand);
		if(hand.getHandSize() == 5 && bHandVal < 22) {
			fCheck = true;
		}
		
		return fCheck;
	}
	
	public boolean bustCheck(Player hand) {
		// check if hand is bust
		boolean bCheck = false;
		int bHandVal = getBestHandVal(hand);
		if(bHandVal > 21) {
			bCheck = true;
		}
		
		return bCheck;
	}
	
	public int getBestHandVal(Player hand) {
		// method returns the best value of the hand. if bust returns the highest value
		ArrayList<Integer> hVal = hand.getNumericalHandValue();
		int bestHandVal = 0;
		
		if(hVal.size() < 2) {
			// no aces so just return the one value as the best value
			bestHandVal = hVal.get(0);
		}
		else {
			// aces present so need to find the value closest to 21 that isnt bust
			for(int i = 0; i < hVal.size(); i++) {
				if(hVal.get(i) > 21) {
					
				}
				else {
					if(hVal.get(i) > bestHandVal) {
						bestHandVal = hVal.get(i);
					}
				}
			}
		}
		// if hand has aces and still all possibilities result in a value over 21 return the highest value
		if(bestHandVal == 0) {
			bestHandVal = hand.getBestNumericalHandValue();
		}
		
		return bestHandVal;
	}

}
