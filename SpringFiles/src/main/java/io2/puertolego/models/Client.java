package io2.puertolego.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_client;
	private String username;
	private String name;
	private String surname;
	
	public Client() {
		super();
	}
	
	public Client(int id_client, String username, String name, String surname) {
		super();
		this.id_client = id_client;
		this.username = username;
		this.name = name;
		this.surname = surname;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

}
