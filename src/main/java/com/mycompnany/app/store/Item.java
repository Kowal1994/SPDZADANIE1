package com.mycompnany.app.store;

import java.math.BigDecimal;

public class Item implements Comparable<Item> {
	private String name;
	private BigDecimal price;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = new BigDecimal(price).setScale(2);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrize(BigDecimal prize) {
		this.price = prize;
	}

	@Override
	public int hashCode() {

		return name.hashCode();
	}

	@Override
	public int compareTo(Item item) {
		if(item==null) { 
			return 1;
		}else {
			return this.getName().compareTo(item.getName());
		}
	}

}
