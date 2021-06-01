package io2.puertolego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io2.puertolego.models.Adress;

@Repository
public interface AdressRepo extends JpaRepository<Adress, Integer>{
	
	@Query(value="select (case when exists (select id_client, authKey from dbo.Client where id_client = ?1 and authKey = ?2 )then 'true' else 'false' end) as authorized",nativeQuery=true)
	boolean requestAuthorization(int id_client,String authKey);
	
	@Query(value="SELECT a.id_adr, a.city, a.country, a.street, a.postcode FROM dbo.Adress a join dbo.Client b on a.id_adr = b.id_adr where b.id_client = ?1",nativeQuery=true)
	Adress getClientAdress(int id_client);
	
	@Query(value="select top 1 id_adr from dbo.Adress order by id_adr desc",nativeQuery=true)
	int getNewestRow();
	
	@Transactional
	@Modifying
	@Query(value="insert into dbo.Adress(city,country,street,postcode) values (?1,?2,?3,?4)",nativeQuery=true)
	void addClientAdress(String city,String country,String street,String postcode);
	
	@Transactional
	@Modifying
	@Query(value="Update Client set id_adr = ?1 where id_client = ?2",nativeQuery=true)
	void addIdAdressToClient(int id_adr,int id_client);
	
	@Transactional
	@Modifying
	@Query(value="Update dbo.Adress set city = ?1, country = ?2, street = ?3, postcode = ?4 where id_adr = ?5",nativeQuery=true)
	void updateAdress(String city,String country,String street,String postcode,int id_adr);
}
