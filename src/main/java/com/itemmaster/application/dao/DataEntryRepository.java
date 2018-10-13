package com.itemmaster.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itemmaster.application.entities.ProductDescription;

@Repository
public interface DataEntryRepository extends JpaRepository<ProductDescription, Long> {

	//public DataEntryRepository findByName(String name);

}
