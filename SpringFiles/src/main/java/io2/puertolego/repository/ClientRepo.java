package io2.puertolego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io2.puertolego.models.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer>{
	
	@Query(value="select (case when exists (select id_client, authKey from dbo.Client where id_client = ?1 and authKey = ?2 )then 'true' else 'false' end) as authorized",nativeQuery=true)
	boolean requestAuthorization(int id_client,String authKey);
	
	@Query(value="select (case when exists (select id_client, authKey from dbo.Client where username = ?1 )then 'true' else 'false' end) as exist",nativeQuery=true)
	boolean usernameExist(String username);
		
	@Query(value="SELECT [id_client], [username], [name], [surname] FROM [dbo].[Client] where id_client = ?1",nativeQuery=true)
	Client getClientInfo(int id_client);
	
	@Query(value="select (case when exists (select username from dbo.Client where username = ?1)then 'false' else 'true' end) as available",nativeQuery=true)
	boolean usernameAvailability(String username);
		
	@Transactional
	@Modifying
	@Query(value="update dbo.client set name = ?2, surname = ?3 where id_client = ?1",nativeQuery=true)
	void updateClientInfo(int id_client,String name,String surname);
	
	@Transactional
	@Modifying
	@Query(value="update dbo.client set password = ?2 where id_client = ?1",nativeQuery=true)
	void updateClientPassword(int id_client,String password);
	
	@Transactional
	@Modifying
	@Query(value="insert into dbo.client (username,name,surname,password) values (?1,?2,?3,?4)",nativeQuery=true)
	void registerClient(String username,String name,String surname,String password);
	
	@Transactional
	@Modifying
	@Query(value="update dbo.client set authKey = ?2 where id_client = ?1",nativeQuery=true)
	void changeAuthKey(int id_client,String authKey);
	
	@Query(value="Select authKey from dbo.Client where username = ?1 and password = ?2",nativeQuery=true)
	String loginClient(int username,String password);
		
	@Query(value="Select password from dbo.Client where id_client = ?1",nativeQuery=true)
	String getClientPassword(int id_client);
	
	@Query(value="Select id_client from dbo.Client where username = ?1",nativeQuery=true)
	int getClientId(String username);
}
