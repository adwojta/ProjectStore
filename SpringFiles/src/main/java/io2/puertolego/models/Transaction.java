package io2.puertolego.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_pro;
	private double price;
	private String paymentMethod;
	private String city;
	private String country;
	private String postcode;
	private String street;
	private String date;
	private String status;
	
	@ElementCollection(targetClass=Product.class)
	private List<Product> itemList;
		
	public Transaction() {
		super();
	}
	
	public Transaction(int id_pro, double price, String paymentMethod, String city, String country, String postcode,
			String street, String date, String status, List<Product> itemList) {
		super();
		this.id_pro = id_pro;
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


	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
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

	public List<Product> getItemList() {
		return itemList;
	}

	public void setItemList(List<Product> itemList) {
		this.itemList = itemList;
	}
	
	
}
