package io2.puertolego.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import javax.persistence.JoinColumn;

@Entity
@Table(name ="Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_trans;
	private double price;
	private String paymentMethod;
	private String city;
	private String country;
	private String postcode;
	private String street;
	private String date;
	private String status;
	
	@ManyToMany
	@JoinTable(name = "transaction_item",
	joinColumns = @JoinColumn(name = "id_trans"),
	inverseJoinColumns = @JoinColumn(name = "id_pro"))
	private Set<Product> itemList;
		
	public Transaction() {
		super();
	}
	
	public Transaction(int id_trans, double price, String paymentMethod, String city, String country, String postcode,
			String street, String date, String status, Set<Product> itemList) {
		super();
		this.id_trans = id_trans;
		this.price = price;
		this.paymentMethod = paymentMethod;
		this.city = city;
		this.country = country;
		this.postcode = postcode;
		this.street = street;
		this.date = date;
		this.status = status;
		this.itemList = itemList;
	}


	public int getId_trans() {
		return id_trans;
	}
	public void setId_trans(int id_trans) {
		this.id_trans = id_trans;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<Product> getItemList() {
		return itemList;
	}
	public void setItemList(Set<Product> itemList) {
		this.itemList = itemList;
	}
	
	
}
