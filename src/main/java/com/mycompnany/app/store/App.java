package com.mycompnany.app.store;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
    	Card card = new Card();
    	Item item = new Item("Knife",10);
    	Item item2 = new Item("Ball",10);
    	card.add(item);
    	card.add(item2,2);
    	System.out.println(card);;
    }	
}
