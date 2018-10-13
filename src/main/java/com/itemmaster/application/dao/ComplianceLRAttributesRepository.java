package com.itemmaster.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itemmaster.application.entities.ComplianceLRAttributes;
import com.itemmaster.application.entities.ProductDescription;

public interface ComplianceLRAttributesRepository extends JpaRepository<ComplianceLRAttributes, Long>{

}
