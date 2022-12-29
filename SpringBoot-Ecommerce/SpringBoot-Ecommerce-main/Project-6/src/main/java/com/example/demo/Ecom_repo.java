package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface Ecom_repo extends JpaRepository<Ecommerce,Integer> {
	
	 @Query(value = "SELECT * FROM ecommerce e where e.product_id = ?1", nativeQuery = true)
	 List<Ecommerce> findById(int id);
	    
	 @Query(value="SELECT * FROM ecommerce e where e.type=?1",nativeQuery=true)
	 List<Ecommerce> findByType(String name);
	 
	 @Modifying
	 @Transactional 
	 @Query(value = "DELETE FROM ecommerce WHERE e.product_id = ?1 ", nativeQuery = true)
	 void deleteAllByIdInBatch(int id);

}
