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
	private String password;
	private int id_adr;
	
	public Client() {
		super();
	}
	
	public Client(int id_client, String username, String name, String surname, String password, int id_adr) {
		super();
		this.id_client = id_client;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.id_adr = id_adr;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId_adr() {
		return id_adr;
	}
	public void setId_adr(int id_adr) {
		this.id_adr = id_adr;
	}
}
