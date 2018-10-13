package com.itemmaster.application.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComplianceLRAttributes {

	@Id
	private String id;
	private boolean isPrivateLabelOrUnbranded;
	private boolean exclusiveBrandsIndicator;
	private boolean isProp65WarningRequired;
	private String prop65WarningText;
	private boolean hasExpiration;
	private Integer shelfLife;
	private boolean hasPricePerUnit;
	private Integer pricePerUnitQuantity;
	private String pricePerUnitUom;
	private boolean hasGMOs;
	private boolean isTemperatureSensitive;
	private boolean hasStateRestrictions;
	private String states;
	private Long zipCodes;
	private boolean stateRestrictionsText;
	private String stateRestrictions;
	private boolean isIntendedForHumanConsumption;
	private boolean isNutritionFactsLabelRequired;
	private String nutritionFactsLabel;
	private String nutritionIngredientsImage;
	private boolean hasIngredientList;
	private String ingredientListImage;
	private boolean isPerishable;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isPrivateLabelOrUnbranded() {
		return isPrivateLabelOrUnbranded;
	}

	public void setPrivateLabelOrUnbranded(boolean isPrivateLabelOrUnbranded) {
		this.isPrivateLabelOrUnbranded = isPrivateLabelOrUnbranded;
	}

	public boolean isExclusiveBrandsIndicator() {
		return exclusiveBrandsIndicator;
	}

	public void setExclusiveBrandsIndicator(boolean exclusiveBrandsIndicator) {
		this.exclusiveBrandsIndicator = exclusiveBrandsIndicator;
	}

	public boolean isProp65WarningRequired() {
		return isProp65WarningRequired;
	}

	public void setProp65WarningRequired(boolean isProp65WarningRequired) {
		this.isProp65WarningRequired = isProp65WarningRequired;
	}

	public String getProp65WarningText() {
		return prop65WarningText;
	}

	public void setProp65WarningText(String prop65WarningText) {
		this.prop65WarningText = prop65WarningText;
	}

	public boolean isHasExpiration() {
		return hasExpiration;
	}

	public void setHasExpiration(boolean hasExpiration) {
		this.hasExpiration = hasExpiration;
	}

	public Integer getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}

	public boolean isHasPricePerUnit() {
		return hasPricePerUnit;
	}

	public void setHasPricePerUnit(boolean hasPricePerUnit) {
		this.hasPricePerUnit = hasPricePerUnit;
	}

	public Integer getPricePerUnitQuantity() {
		return pricePerUnitQuantity;
	}

	public void setPricePerUnitQuantity(Integer pricePerUnitQuantity) {
		this.pricePerUnitQuantity = pricePerUnitQuantity;
	}

	public String getPricePerUnitUom() {
		return pricePerUnitUom;
	}

	public void setPricePerUnitUom(String pricePerUnitUom) {
		this.pricePerUnitUom = pricePerUnitUom;
	}

	public boolean isHasGMOs() {
		return hasGMOs;
	}

	public void setHasGMOs(boolean hasGMOs) {
		this.hasGMOs = hasGMOs;
	}

	public boolean isTemperatureSensitive() {
		return isTemperatureSensitive;
	}

	public void setTemperatureSensitive(boolean isTemperatureSensitive) {
		this.isTemperatureSensitive = isTemperatureSensitive;
	}

	public boolean isHasStateRestrictions() {
		return hasStateRestrictions;
	}

	public void setHasStateRestrictions(boolean hasStateRestrictions) {
		this.hasStateRestrictions = hasStateRestrictions;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public Long getZipCodes() {
		return zipCodes;
	}

	public void setZipCodes(Long zipCodes) {
		this.zipCodes = zipCodes;
	}

	public boolean isStateRestrictionsText() {
		return stateRestrictionsText;
	}

	public void setStateRestrictionsText(boolean stateRestrictionsText) {
		this.stateRestrictionsText = stateRestrictionsText;
	}

	public String getStateRestrictions() {
		return stateRestrictions;
	}

	public void setStateRestrictions(String stateRestrictions) {
		this.stateRestrictions = stateRestrictions;
	}

	public boolean isIntendedForHumanConsumption() {
		return isIntendedForHumanConsumption;
	}

	public void setIntendedForHumanConsumption(boolean isIntendedForHumanConsumption) {
		this.isIntendedForHumanConsumption = isIntendedForHumanConsumption;
	}

	public boolean isNutritionFactsLabelRequired() {
		return isNutritionFactsLabelRequired;
	}

	public void setNutritionFactsLabelRequired(boolean isNutritionFactsLabelRequired) {
		this.isNutritionFactsLabelRequired = isNutritionFactsLabelRequired;
	}

	public String getNutritionFactsLabel() {
		return nutritionFactsLabel;
	}

	public void setNutritionFactsLabel(String nutritionFactsLabel) {
		this.nutritionFactsLabel = nutritionFactsLabel;
	}

	public String getNutritionIngredientsImage() {
		return nutritionIngredientsImage;
	}

	public void setNutritionIngredientsImage(String nutritionIngredientsImage) {
		this.nutritionIngredientsImage = nutritionIngredientsImage;
	}

	public boolean isHasIngredientList() {
		return hasIngredientList;
	}

	public void setHasIngredientList(boolean hasIngredientList) {
		this.hasIngredientList = hasIngredientList;
	}

	public String getIngredientListImage() {
		return ingredientListImage;
	}

	public void setIngredientListImage(String ingredientListImage) {
		this.ingredientListImage = ingredientListImage;
	}

	public boolean isPerishable() {
		return isPerishable;
	}

	public void setPerishable(boolean isPerishable) {
		this.isPerishable = isPerishable;
	}

}
