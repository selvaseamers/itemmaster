package com.itemmaster.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itemmaster.application.entities.NiceToHaveAttributes;
import com.itemmaster.application.entities.ProductDescription;

public interface NiceToHaveAttributesRepository extends JpaRepository<NiceToHaveAttributes, Long> {

}
