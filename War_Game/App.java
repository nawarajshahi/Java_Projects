package com.week6;

public class App {

	public static void main(String[] args) {
		// Instantiating a Deck and two players
		Deck deck = new Deck();
		deck.shuffle();
		
		Player playerOne = new Player();
		playerOne.setName("Nawaraj");
		
		//Player two
		Player playerTwo = new Player();
		playerTwo.setName("Olivia");
		
		
		//Deal the card from the deck
		dealCards(playerOne, playerTwo, deck);
		
	
		//flip cards from the dealt hand
		flipCards(playerOne, playerTwo);
		
		//declare the winner
		declareWinner(playerOne, playerTwo);
		
	}
	

	//implementation for flipping the card from the dealt hand
	public static void flipCards(Player playerOne, Player playerTwo){
		for (int index = 0; index <26; index ++) {
			int p1Value = playerOne.flip().getValue();
			int p2Value = playerTwo.flip().getValue();
			
			if(p1Value > p2Value) {
				playerOne.incrementScore();
			}
			else if(p2Value > p1Value) {
				playerTwo.incrementScore();
			} 
			//Game development is in progress
			//ignores if both players have the cards of same rank for now
		}
		
	}

	//compare the score and declare the victor!
	public static void declareWinner(Player playerOne, Player playerTwo) {
		System.out.println("__Final Score__");
		System.out.println(playerOne.getName() + " : " + playerOne.getScore());
		System.out.println(playerTwo.getName() + " : " + playerTwo.getScore());
		System.out.println("-----------------");
		
		//comparing the score 
		if (playerOne.getScore() > playerTwo.getScore()) {
			System.out.println(playerOne.getName() + " won the war!");
		}else if (playerOne.getScore() < playerTwo.getScore()) {
			System.out.println(playerTwo.getName() + " won the war!");
		} else {
			System.out.println("Draw! Game tied!");
		}
		
	}

	//deal the cards from a deck of 52 cards between two player
	public static void dealCards(Player playerOne, Player playerTwo, Deck deck) {
		for (int index = 0; index <52; index++) {
			if (index % 2 ==0) {
				playerOne.draw(deck);
			}else {
				playerTwo.draw(deck);
			}
		}
	}
}
