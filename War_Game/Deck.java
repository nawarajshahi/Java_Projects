package com.week6;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	//List of cards using Card class
	private static List<Card> cards = new ArrayList<Card>();
	
	String[] suits = {"club", "Spade", "diamond", "heart"};

	//constructor to initialize all 52 cards when new deck is instantiated
	public Deck() {
		//create a Deck
		for (int rank = 2; rank <=14; rank++) {
			for (int suit = 0; suit <suits.length; suit ++) {
				cards.add(new Card(rank, suits[suit])); 
				//instantiating a card on each iteration and adding it to the lsit of cards
				
			}
		}
		
	}
	
	
	//shuffle the card method
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	// draw the card method
	public Card draw() {
		return cards.remove(0);
	}
	
	//additional method to to print out all cards in a deck
	public void printDeck() {
		for (Card card:cards) {
			card.describe();
		}
	}
	
}
