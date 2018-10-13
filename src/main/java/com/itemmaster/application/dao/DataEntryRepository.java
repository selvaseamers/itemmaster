package com.itemmaster.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itemmaster.application.entities.ProductDescription;

@Repository
public interface DataEntryRepository extends JpaRepository<ProductDescription, String> {

	//@Query("Select pd from productDescription pd where pd.productId like %:productId%")
	//public DataEntryRepository findByProductId(@Param("productId")String productId);

}
