package com.itemmaster.application.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImageUrls {

	@Id
	private String id;
	private String mainImageUrl;
	private String productSecondaryImageURL;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMainImageUrl() {
		return mainImageUrl;
	}

	public void setMainImageUrl(String mainImageUrl) {
		this.mainImageUrl = mainImageUrl;
	}

	public String getProductSecondaryImageURL() {
		return productSecondaryImageURL;
	}

	public void setProductSecondaryImageURL(String productSecondaryImageURL) {
		this.productSecondaryImageURL = productSecondaryImageURL;
	}

}
