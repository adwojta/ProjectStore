package io2.puertolego.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="Adress")
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_adr;
	private String city;
	private String country;
	private String postcode;
	private String street;
	
	public Adress() {
		super();
	}
	
	public Adress(int id_adr, String city, String country, String postcode, String street) {
		super();
		this.id_adr = id_adr;
		this.city = city;
		this.country = country;
		this.postcode = postcode;
		this.street = street;
	}
	public int getId_adr() {
		return id_adr;
	}
	public void setId_adr(int id_adr) {
		this.id_adr = id_adr;
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
	
	
	
}
