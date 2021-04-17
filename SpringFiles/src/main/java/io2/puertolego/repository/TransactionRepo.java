package io2.puertolego.repository;

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
	
	@Query(value="placeholder",nativeQuery=true)
	boolean getTransactions();
		
	@Transactional
	@Modifying
	@Query(value="placeholder",nativeQuery=true)
	void addTransaction();
}

