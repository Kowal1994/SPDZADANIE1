package com.mycompnany.app.store;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTest {
	private Card card;
	private Item item;
	private Item item2;

	@Before
	public void init() {
		card = new Card();
		item = new Item("Ball", 10);
		item2= new Item("Knife",10);
		Assert.assertTrue(item!=null);
		Assert.assertTrue(item2!=null);
		Assert.assertTrue(card!=null);
	}
	
	@After 
	public void clean() {
		card=null;
		item=null;
		item2=null;
	}
	
	@Test 
	public void testPositiv_checkAddTwoAgumentException() {
		try {
		card.add(item,0);
		card.add(item2,-2);
		Assert.assertTrue(false);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test 
	public void testPositiv_checkAddOneAgument() {
		card.add(item);
		Assert.assertTrue(Integer.valueOf(card.getOrder().size()).equals(1));
		Assert.assertTrue(card.getOrderValue().equals(new BigDecimal(10).setScale(2)));
	}
	
	@Test 
	public void testPositiv_checkAddTwoArguments() {
		card.add(item,2);	
		Assert.assertTrue(Integer.valueOf(card.getOrder().size()).equals(1));
		Assert.assertTrue(card.getOrderValue().equals(new BigDecimal(20).setScale(2)));
	}
	
	@Test
	public void testPositiv_checkRemoveOneArgument() {
		card.add(item);
		card.add(item2);
		card.remove(item);
		Assert.assertTrue(Integer.valueOf(card.getOrder().size()).equals(1));
		Assert.assertTrue(card.getOrderValue().equals(new BigDecimal(10).setScale(2)));
	}
	
	@Test
	public void testPositiv_checkRemoveTwoAgumentException() {
		try {
			card.remove(item,10);
			card.remove(item2,2);
			Assert.assertTrue(true);
		} catch (IllegalArgumentException e) {
			e.getMessage();
			Assert.assertTrue(false);
		}	
	}
	
	@Test
	public void testPositiv_checkRemoveTwoArgument() {
		card.add(item,15);
		card.add(item2,2);
		card.remove(item, 4);
		Assert.assertTrue(Integer.valueOf(card.getOrder().size()).equals(2));
		Assert.assertTrue(Integer.valueOf(card.getOrder().get(item).intValue()).equals(11));
		Assert.assertTrue(card.getOrderValue().equals(new BigDecimal(130).setScale(2)));
		
	}
	
	@Test
	public void testPositiv_checkGetOrderValue() {
		card.add(item,1);
		card.add(item2,10);
		card.add(item2);
		card.remove(item);
		card.remove(item2, 10);
		Assert.assertTrue(Integer.valueOf(card.getOrder().size()).equals(1));
		Assert.assertTrue(card.getOrderValue().equals(new BigDecimal(10).setScale(2))); 
	}
		
}
