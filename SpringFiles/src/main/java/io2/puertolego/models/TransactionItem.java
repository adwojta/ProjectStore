package io2.puertolego.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactionItem")
public class TransactionItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_trans_item")
	private int id_trans_item;
	private int id_pro;
	private int id_trans;
	private int quantity;

	public TransactionItem(int id_trans_item, int id_pro, int id_trans, int quantity) {
		super();
		this.id_trans_item = id_trans_item;
		this.id_pro = id_pro;
		this.id_trans = id_trans;
		this.quantity = quantity;
	}
	public TransactionItem() {
		super();
	}
	public int getId_trans_item() {
		return id_trans_item;
	}
	public void setId_trans_item(int id_trans_item) {
		this.id_trans_item = id_trans_item;
	}
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}
	public int getId_trans() {
		return id_trans;
	}
	public void setId_trans(int id_trans) {
		this.id_trans = id_trans;
	}	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
