// Munir Suleman

import java.util.*;

public class Player {
	private String name;
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void dealToPlayer(Card card) {
		// deals a card to a player
		hand.add(card);
	}
	
	public void removeCard(Card card) {
		// removes a card from a player hand
		hand.remove(card);
	}
	
	public ArrayList<Integer> getNumericalHandValue() {
		// returns all the possible numerical values of the hand
		List<List<Integer>> cardsVal = new ArrayList<List<Integer>>();
		ArrayList<Integer> handVal = new ArrayList<Integer>();
		// gets the numerical values of each card in the hand into one arraylist
		for(int i = 0; i < hand.size(); i++) {
			cardsVal.add(hand.get(i).getNumericalValue());
		}
		
		handVal.add(0);
		for (int i = 0; i < cardsVal.size(); i++) {
			// if theres only one hand value then theres no ace so just add the value of the card to the handVal arraylist
			if(cardsVal.get(i).size() <= 1) {
				for(int j = 0; j < handVal.size(); j++) {
					handVal.set(j, handVal.get(j) + cardsVal.get(i).get(0));
				}
			}
			else {
				// there is more than one possible card value so ace is present. Adds another possible handVal to the arraylist
				// If ace is present it adds 1 to the current handVal, adds a new handVal to the arrayList that is 10 more than
				// the handVal before it
				for(int k = 0; k < handVal.size(); k++) {
					handVal.set(k, handVal.get(k) + cardsVal.get(i).get(0));
				}
				handVal.add(handVal.get(handVal.size() - 1) + 10);
			}
		}
		return handVal;
	}
	
	public int getBestNumericalHandValue() {
		// returns the max value of the hand
		ArrayList<Integer> handVal = new ArrayList<Integer>();
		handVal = getNumericalHandValue();
		int bestHand = handVal.get(handVal.size() - 1);
		return bestHand;
	}
	
	public ArrayList<Card> getCards() {
		// returns the cards in the player's hand
		return hand;
	}
	
	public int getHandSize() {
		// returns the number of cards in the players hand
		return hand.size();
	}
	
	public void display() {
		for(int p = 0; p < hand.size(); p++) {
			System.out.println(hand.get(p).getValue() + " of " + hand.get(p).getSuit());
		}
	}
}
