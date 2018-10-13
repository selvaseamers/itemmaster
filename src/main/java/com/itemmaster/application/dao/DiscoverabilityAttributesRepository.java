package com.itemmaster.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itemmaster.application.entities.DiscoverabilityAttributes;
import com.itemmaster.application.entities.ProductDescription;

public interface DiscoverabilityAttributesRepository extends JpaRepository<DiscoverabilityAttributes, Long>{

}
