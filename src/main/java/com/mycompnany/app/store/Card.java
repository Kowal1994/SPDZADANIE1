package com.mycompnany.app.store;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Card {
	private final Map<Item,Integer> order = new TreeMap<Item, Integer>();
	
	public void add(Item item) {
		if(order.containsKey(item)) {
			Integer quantity = order.get(item)+1;
			order.put(item,quantity);
		} else {
			order.put(item,1);
		}	
	}
	
	public void add(Item item,Integer quantity) throws IllegalArgumentException  {
		if(quantity<=0) {
			throw new IllegalArgumentException(String.format("Illegal quantity ", quantity));
		}
		if(order.containsKey(item)) {
			quantity = order.get(item)+quantity;
		}
		order.put(item, quantity);
	}
	
	public void remove(Item item) {
		if(order.containsKey(item)) {
			if(order.get(item)==1) {
				order.remove(item);
			} else {
				Integer quantity = order.get(item)-1;
				order.put(item, quantity);
			}
		}
	}
	
	public void remove(Item item,Integer quantity) throws IllegalArgumentException {
		if(order.containsKey(item)) {
			Integer itemQuantity = order.get(item);
			if(itemQuantity.equals(quantity)) {
				order.remove(item);
			} else if(itemQuantity>quantity) {
				order.put(item, itemQuantity-quantity);
			} else {
				throw new IllegalArgumentException(String.format("Illegal quantity ", quantity));
			}			
		}
	}
	
	public BigDecimal getOrderValue() {
		BigDecimal orderValue=BigDecimal.ZERO.setScale(2);
		for (Entry<Item, Integer> item : order.entrySet()) {
			orderValue=orderValue.add(item.getKey().getPrice().multiply(new BigDecimal(item.getValue().intValue())));
		}
		return orderValue.setScale(2);
	}
	
	public Map<Item, Integer> getOrder() {
		return order;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Order: \n");
		order.forEach((k,v)-> result.append(("Item " + k.getName() + " Prize " + k.getPrice() + " Quantity " + v.intValue() + "\n")));
		result.append("Total price " + getOrderValue());
		return result.toString();
	}
	
}
