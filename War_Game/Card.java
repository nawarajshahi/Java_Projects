package com.week6;

public class Card {
	//Setting fields
	private int value;
	private String suit;
	
	//Getters
	public int getValue() {
		return value;
	}
	
	public String getSuit() {
		return suit;
	}
	
	//Setters
	public void setValue(int value) {
		this.value = value;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public Card() { };

	public Card(int value, String suit){
		this.value = value;
		this.suit = suit;
	}
	
	//Describe method to print out info about a card
	public void describe() {
		System.out.println(getCardValueToString(value) + " of " + suit);
	}
	
	
	//Method that takes integer card value and returns string 
	//value representation of that card
	public String getCardValueToString(int value) {
		switch(value) {
		
		case 2: return "Two";
		case 3: return "Three";
		case 4: return "Four";
		case 5: return "Five";
		case 6: return "Six";
		case 7: return "Seven";
		case 8: return "Eight";
		case 9: return "Nine";
		case 10: return "Ten";
		case 11: return "Jack";
		case 12: return "Queen";
		case 13: return "King";
		case 14: return "Ace";
		}
		return "Invalid card type";
	}
	

}
