package com.itemmaster.application.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class NiceToHaveAttributes {

	@Id
	private String id;
	private boolean skuUpdate;
	private String safeHandlingInstructions;
	private String cuisine;
	private String foodPreparationTips;
	private String foodStorageTips;
	private String fancyCharacter;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isSkuUpdate() {
		return skuUpdate;
	}

	public void setSkuUpdate(boolean skuUpdate) {
		this.skuUpdate = skuUpdate;
	}

	public String getSafeHandlingInstructions() {
		return safeHandlingInstructions;
	}

	public void setSafeHandlingInstructions(String safeHandlingInstructions) {
		this.safeHandlingInstructions = safeHandlingInstructions;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getFoodPreparationTips() {
		return foodPreparationTips;
	}

	public void setFoodPreparationTips(String foodPreparationTips) {
		this.foodPreparationTips = foodPreparationTips;
	}

	public String getFoodStorageTips() {
		return foodStorageTips;
	}

	public void setFoodStorageTips(String foodStorageTips) {
		this.foodStorageTips = foodStorageTips;
	}

	public String getFancyCharacter() {
		return fancyCharacter;
	}

	public void setFancyCharacter(String fancyCharacter) {
		this.fancyCharacter = fancyCharacter;
	}

}
