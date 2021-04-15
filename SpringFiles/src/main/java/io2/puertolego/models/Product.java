package io2.puertolego.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="Product")
public class Product {

	
	
	@Id
	private int id_pro;
	private double price;
	private String name;
	private String collection;
	private int quantity;
	private int elements;
	private String age;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getElements() {
		return elements;
	}
	public void setElements(int elements) {
		this.elements = elements;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Product(double price, String name, String collection, int quantity, int elements, String age) {
		super();
		this.price = price;
		this.name = name;
		this.collection = collection;
		this.quantity = quantity;
		this.elements = elements;
		this.age = age;
	}
	public Product() {
		super();
	}
	
	
	
	
	
}