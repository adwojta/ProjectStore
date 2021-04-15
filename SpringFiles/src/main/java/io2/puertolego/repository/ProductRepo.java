package io2.puertolego.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import io2.puertolego.models.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	
	@Query(value="SELECT [id_pro],[price],[name],[collection],[quantity],[elements],[age] FROM [dbo].[Product] where id_pro = ?1",nativeQuery=true)
	Product getProductById(int id_pro);
	
	@Query(value="SELECT distinct [collection] FROM [dbo].[Product]",nativeQuery=true)
	List<String> getAllCollection();
	
	@Query(value="SELECT [id_pro],[price],[name],[collection],[quantity],[elements],[age] FROM [dbo].[Product] where promoted=1",nativeQuery=true)
	List<Product> getPromoted();
	
	@Query(value="SELECT [id_pro],[price],[name],[collection],[quantity],[elements],[age] FROM [dbo].[Product] where collection = ?1",nativeQuery=true)
	List<Product> getCollectionProducts(String collection);
}
