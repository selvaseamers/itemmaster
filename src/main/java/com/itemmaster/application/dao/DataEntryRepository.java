package com.itemmaster.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itemmaster.application.entities.ProductDescription;

@Repository
public interface DataEntryRepository extends JpaRepository<ProductDescription, String> {

	@Query("SELECT pd FROM ProductDescription pd WHERE pd.status = :status") 
	public List<ProductDescription> findByStatus(@Param("status")String status);

}
