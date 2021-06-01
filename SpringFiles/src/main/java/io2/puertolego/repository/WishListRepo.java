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
	
	@Query(value="SELECT a.id_wish,a.id_pro ,b.name ,b.price FROM [dbo].[WishList] a join [dbo].Product b on a.id_pro = b.id_pro join [dbo].Client c on a.id_client = c.id_client where a.id_client = ?1 and c.authKey = ?2",nativeQuery=true)
	List<WishList> getClientWishList(int id_client, String authKey);
	
	@Transactional
	@Modifying
	@Query(value="insert into dbo.WishList (id_client,id_pro) values (?1,?2)",nativeQuery=true)
	void addNewItem(int id_client,int id_pro);
	
	@Query(value="select (case when exists (select id_client, authKey from dbo.Client where id_client = ?1 and authKey = ?2 )then 'true' else 'false' end) as authorized",nativeQuery=true)
	boolean requestAuthorization(int id_client,String authKey);
	
	@Query(value="select (case when exists (select id_client from dbo.[WishList] where id_client = ?1 and id_pro = ?2 )then 'true' else 'false' end) as exist",nativeQuery=true)
	boolean existInList(int id_client,int id_pro);
	
	@Transactional
	@Modifying
	@Query(value="delete from [dbo].[WishList] where id_wish = ?1",nativeQuery=true)
	void deleteItemFromWishList(int id_wish);
}
