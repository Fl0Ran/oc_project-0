package com.lambazon.domain;

public class Product {

	private Integer id;
	private String name, description, details;
	private int quantity;
	private double price;

	public Product(int id, int quantity, double price, String name, String description) {
		setId(id);
		setQuantity(quantity);
		setPrice(price);
		setName(name);
		setDescription(description);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * if total of quantity it's under 0 , quantity equal 0
	 * @return
	 */
	public int getQuantity() {
		if( quantity < 0)
		{
			quantity = 0;
		}
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * if total of price less than 0 price = 0 , same if the price is greater than 1000 , price = 1000
	 * @return
	 */
	public double getPrice() {
		if (price < 0 )
		{
			price = 0;
		}
		else if(price > 1000)
		{
			price = 1000;
		}
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return : total price of an article in inventory depending on the quantity
	 */
	public double getInventoryPrice() {
        return (price * quantity);
	}

}
