package io2.puertolego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io2.puertolego.models.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
	
	@Query(value="select (case when exists (select id_client, authKey from dbo.Client where id_client = ?1 and authKey = ?2 )then 'true' else 'false' end) as authorized",nativeQuery=true)
	boolean requestAuthorization(int id_client,String authKey);
	
	@Query(value="Select [id_trans],[price],[payment_method],[city],[street],[country],[postcode],[date],[status] FROM [dbo].[Transaction] where id_client = ?1",nativeQuery=true)
	List<Transaction> getTransactions(int id_client);
		
	@Transactional
	@Modifying
	@Query(value="insert into dbo.[transaction] (id_client,price,payment_method,city,street,country,postcode,date,status) values(?1,?2,?3,?4,?5,?6,?7,getDate(),?8)",nativeQuery=true)
	void addTransaction(int id_client,float price, String paymant_method, String city, String street, String country, String postcode, String status);
	
	@Transactional
	@Modifying
	@Query(value="insert into dbo.[transaction_item] (id_pro,id_trans,quantity) values(?1,?2,?3)",nativeQuery=true)
	void addTransactionItem(int id_pro,int id_trans,int quantity);
	
	@Transactional
	@Modifying
	@Query(value="update dbo.[product] set quantity = quantity - ?2 where id_pro = ?1",nativeQuery=true)
	void changeProductQuantity(int id_pro,int quantity);
	
	@Query(value="select (case when exists (select id_pro,quantity from dbo.product where id_pro = ?1 and quantity >= ?2 )then 'true' else 'false' end) as available",nativeQuery=true)
	boolean checkProductQuantity(int id_pro,int quantity);
	
	@Query(value="select top 1 id_trans from dbo.[transaction] order by id_trans desc",nativeQuery=true)
	int getLatestTransID();
}

