package io2.puertolego.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="WishList")
public class WishList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_wish;
	private String name;
	private double price;
	
	public WishList(int id_wish, String name, double price) {
		super();
		this.id_wish = id_wish;
		this.name = name;
		this.price = price;
	}

	public WishList() {
		super();
	}

	public int getId_wish() {
		return id_wish;
	}
	public void setId_wish(int id_wish) {
		this.id_wish = id_wish;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	
}
