package io2.puertolego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io2.puertolego.models.Product;


@Repository
interface UserRepository extends JpaRepository<Product, Integer>{
	
}

public class ProductRepo {

}
