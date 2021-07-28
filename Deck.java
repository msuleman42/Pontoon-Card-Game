// Munir Suleman

import java.util.*;

public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		// create deck of cards
		for(Card.Suit suit : Card.Suit.values()) {
			for(Card.Value value : Card.Value.values()) {
				Card card = new Card(suit, value);
				deck.add(card);
			}
		}
	}
	
	public void reset() {
		// recreates full deck of cards
		deck.clear();
		for(Card.Suit suit : Card.Suit.values()) {
			for(Card.Value value : Card.Value.values()) {
				Card card = new Card(suit, value);
				deck.add(card);
			}
		}
	}
	
	public void shuffle() {
		// shuffles the deck
		Random random = new Random();
		for(int i = 0; i < deck.size(); i++) {
			Card someCard = deck.get(i);
			int randomI = i + random.nextInt(deck.size() - i);
			deck.set(i, deck.get(randomI));
			deck.set(randomI, someCard);
		}
	}
	
	public Card getCard(int i) {
		// returns card at a i
		Card c = deck.get(i);
		return c;
	}
	
	public Card dealRandomCard() {
		// deals a random card from the deck (or whats left of the deck). Selected card needs to be removed from deck
		shuffle();
		Card randCard = deck.get(0);
		deck.remove(0);
		return randCard;
	}
	
	public int size() {
		// returns the number of cards currently in deck
		return deck.size();
	}
	
	

}
