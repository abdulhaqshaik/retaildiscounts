package com.retail.discounts.model;

import java.io.Serializable;

public class Item implements Serializable

{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2518099474897578333L;
	
	public Item(int f_id, String f_name, Double f_price, boolean f_grocery)
	{
		this.id=f_id;
		this.name=f_name;
		this.price=f_price;
		this.grocery=f_grocery;
	}

	private int id;
	
	private String name;
	
	private Double price;
	
	private boolean grocery;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean getGrocery() {
		return grocery;
	}

	public void setGrocery(boolean grocery) {
		this.grocery = grocery;
	}
	
	
	
	
	
}
