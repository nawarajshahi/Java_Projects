/*
 * Created by Nawaraj Shahi
 */

package com.week6;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	//define hand which is list of Card
	private List<Card> hand = new ArrayList<Card>();
	private int score;
	private String name;
	
	//constructor to initialize the values
	public Player() {
		this.score = 0;
		this.name = "";
	}
	
	//Getters
	public int getScore() {
		return score;
	}

	
	public String getName() {
		return name;
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}

	
	/*implement describe method that prints out the information about the layer
	 * and calls the describe method for each card in the list of hand
	*/
	public void describe() {
		System.out.println("Name of the player: " + name);
		System.out.println("Score of the player: " + score);
		for (Card card: hand) {
			card.describe();
		}
	}
	
	/* implement the flip method that removes and returns the top card of the hand
	 */
	public Card flip() {
		return hand.remove(0);
	}
	
	
	/*implement the draw method that takes a Deck as an argument and calls the 
	 * Draw method on the deck, adding the returned Card to the hand field
	 */
	public void draw(Deck deck) {
		hand.add(deck.draw());
	}
	
	//implement incrementScore method to add 1 to the Player's score field
	public void incrementScore() {
		score++;
	}

}
