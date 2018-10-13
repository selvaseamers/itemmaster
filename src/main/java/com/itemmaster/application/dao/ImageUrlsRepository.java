package com.itemmaster.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itemmaster.application.entities.ImageUrls;
import com.itemmaster.application.entities.ProductDescription;

public interface ImageUrlsRepository extends JpaRepository<ImageUrls, Long>{

}
