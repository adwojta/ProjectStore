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
	private int id_pro;
	private int id_client;
	
	
	public WishList() {
		super();
	}
	public WishList(int id_wish, int id_pro, int id_client) {
		super();
		this.id_wish = id_wish;
		this.id_pro = id_pro;
		this.id_client = id_client;
	}
	public int getId_wish() {
		return id_wish;
	}
	public void setId_wish(int id_wish) {
		this.id_wish = id_wish;
	}
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	
	
}
