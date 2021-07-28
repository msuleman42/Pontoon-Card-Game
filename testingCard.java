// Munir Suleman
public class testingCard {
	
	public static void main(String[] args) {
		// Starts game with 2 players (can be up to 9). Deals the cards to the players and then compares the hands
		// to see who wins.
		Pontoon game2 = new Pontoon(2);
		System.out.println("Player 1's cards: ");
		game2.getPlayer(0).display();
		System.out.println("Player 2's cards: ");
		game2.getPlayer(1).display();
		int p1 = game2.compareHands(game2.getPlayer(0), game2.getPlayer(1));
		
		// Prints who won
		if(p1 < 0)
			System.out.println("Player 1 wins");
		else if(p1 > 0)
			System.out.println("Player 2 wins");
		else
			System.out.println("DRAW");
	
	}
}
