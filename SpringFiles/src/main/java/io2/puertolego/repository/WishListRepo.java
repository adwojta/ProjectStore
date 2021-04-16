package io2.puertolego.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io2.puertolego.models.WishList;

@Repository
public interface WishListRepo extends JpaRepository<WishList, Integer>{
	
	@Query(value="SELECT a.id_wish ,b.name ,b.price FROM [dbo].[WishList] a join [dbo].Product b on a.id_pro = b.id_pro where a.id_client = ?1",nativeQuery=true)
	List<WishList> getClientWishList(int id_client);
	
	@Transactional
	@Modifying
	@Query(value="insert into dbo.WishList (id_client,id_pro) values (?1,?2)",nativeQuery=true)
	void addNewItem(int id_client,int id_pro);
	
	
}
