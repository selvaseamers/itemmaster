package com.itemmaster.application.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdditionalCategoryAttributes {

	@Id
	private String id;
	private String alcoholContentByVolume;
	private String alcoholProof;
	private String alcoholClassAndType;
	private String neutralSpiritsColoringAndFlavoring;
	private String wineAppellation;
	private String wineVarietal;
	private int vintage;
	private boolean isNonGrape;
	private boolean isEstateBottled;
	private boolean containsSulfites;
	private String timeAged;
	private String ingredients;
	private String containerType;
	private boolean isGmoFree;
	private String servingSize;
	private Integer servingsPerContainer;
	private Integer calories;
	private Integer caloriesFromFat;
	private String totalFat;
	private Float totalFatPercentageDailyValue;
	private Integer fatCaloriesPerGram;
	private String totalCarbohydrate;
	private Float totalCarbohydratePercentageDailyValue;
	private Integer carbohydrateCaloriesPerGram;
	private String nutrientName;
	private String nutrientAmount;
	private String nutrientPercentageDailyValue;
	private String nutrientFootnote;
	private String nutrients;
	private Integer proteinCaloriesPerGram;
	private Float totalProteinPercentageDailyValue;
	private String totalProtein;
	private String foodForm;
	private boolean isImitation;
	private boolean usdaInspected;
	private boolean hasHighFructoseCornSyrup;
	private String foodAllergenStatements;
	private String instructions;
	private String caffeineDesignation;
	private String spiceLevel;
	private boolean isMadeInHomeKitchen;
	private String beefCut;
	private String poultryCut;
	private String releaseDate;
	private boolean isHealthyIncentive;
	private boolean isSnapEligible;
	private boolean isWICEligible;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlcoholContentByVolume() {
		return alcoholContentByVolume;
	}

	public void setAlcoholContentByVolume(String alcoholContentByVolume) {
		this.alcoholContentByVolume = alcoholContentByVolume;
	}

	public String getAlcoholProof() {
		return alcoholProof;
	}

	public void setAlcoholProof(String alcoholProof) {
		this.alcoholProof = alcoholProof;
	}

	public String getAlcoholClassAndType() {
		return alcoholClassAndType;
	}

	public void setAlcoholClassAndType(String alcoholClassAndType) {
		this.alcoholClassAndType = alcoholClassAndType;
	}

	public String getNeutralSpiritsColoringAndFlavoring() {
		return neutralSpiritsColoringAndFlavoring;
	}

	public void setNeutralSpiritsColoringAndFlavoring(String neutralSpiritsColoringAndFlavoring) {
		this.neutralSpiritsColoringAndFlavoring = neutralSpiritsColoringAndFlavoring;
	}

	public String getWineAppellation() {
		return wineAppellation;
	}

	public void setWineAppellation(String wineAppellation) {
		this.wineAppellation = wineAppellation;
	}

	public String getWineVarietal() {
		return wineVarietal;
	}

	public void setWineVarietal(String wineVarietal) {
		this.wineVarietal = wineVarietal;
	}

	public Integer getVintage() {
		return vintage;
	}

	public void setVintage(Integer vintage) {
		this.vintage = vintage;
	}

	public boolean isNonGrape() {
		return isNonGrape;
	}

	public void setNonGrape(boolean isNonGrape) {
		this.isNonGrape = isNonGrape;
	}

	public boolean isEstateBottled() {
		return isEstateBottled;
	}

	public void setEstateBottled(boolean isEstateBottled) {
		this.isEstateBottled = isEstateBottled;
	}

	public boolean isContainsSulfites() {
		return containsSulfites;
	}

	public void setContainsSulfites(boolean containsSulfites) {
		this.containsSulfites = containsSulfites;
	}

	public String getTimeAged() {
		return timeAged;
	}

	public void setTimeAged(String timeAged) {
		this.timeAged = timeAged;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public boolean isGmoFree() {
		return isGmoFree;
	}

	public void setGmoFree(boolean isGmoFree) {
		this.isGmoFree = isGmoFree;
	}

	public String getServingSize() {
		return servingSize;
	}

	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}

	public Integer getServingsPerContainer() {
		return servingsPerContainer;
	}

	public void setServingsPerContainer(Integer servingsPerContainer) {
		this.servingsPerContainer = servingsPerContainer;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Integer getCaloriesFromFat() {
		return caloriesFromFat;
	}

	public void setCaloriesFromFat(Integer caloriesFromFat) {
		this.caloriesFromFat = caloriesFromFat;
	}

	public String getTotalFat() {
		return totalFat;
	}

	public void setTotalFat(String totalFat) {
		this.totalFat = totalFat;
	}

	public Float getTotalFatPercentageDailyValue() {
		return totalFatPercentageDailyValue;
	}

	public void setTotalFatPercentageDailyValue(Float totalFatPercentageDailyValue) {
		this.totalFatPercentageDailyValue = totalFatPercentageDailyValue;
	}

	public Integer getFatCaloriesPerGram() {
		return fatCaloriesPerGram;
	}

	public void setFatCaloriesPerGram(Integer fatCaloriesPerGram) {
		this.fatCaloriesPerGram = fatCaloriesPerGram;
	}

	public String getTotalCarbohydrate() {
		return totalCarbohydrate;
	}

	public void setTotalCarbohydrate(String totalCarbohydrate) {
		this.totalCarbohydrate = totalCarbohydrate;
	}

	public Float getTotalCarbohydratePercentageDailyValue() {
		return totalCarbohydratePercentageDailyValue;
	}

	public void setTotalCarbohydratePercentageDailyValue(Float totalCarbohydratePercentageDailyValue) {
		this.totalCarbohydratePercentageDailyValue = totalCarbohydratePercentageDailyValue;
	}

	public Integer getCarbohydrateCaloriesPerGram() {
		return carbohydrateCaloriesPerGram;
	}

	public void setCarbohydrateCaloriesPerGram(Integer carbohydrateCaloriesPerGram) {
		this.carbohydrateCaloriesPerGram = carbohydrateCaloriesPerGram;
	}

	public String getNutrientName() {
		return nutrientName;
	}

	public void setNutrientName(String nutrientName) {
		this.nutrientName = nutrientName;
	}

	public String getNutrientAmount() {
		return nutrientAmount;
	}

	public void setNutrientAmount(String nutrientAmount) {
		this.nutrientAmount = nutrientAmount;
	}

	public String getNutrientPercentageDailyValue() {
		return nutrientPercentageDailyValue;
	}

	public void setNutrientPercentageDailyValue(String nutrientPercentageDailyValue) {
		this.nutrientPercentageDailyValue = nutrientPercentageDailyValue;
	}

	public String getNutrientFootnote() {
		return nutrientFootnote;
	}

	public void setNutrientFootnote(String nutrientFootnote) {
		this.nutrientFootnote = nutrientFootnote;
	}

	public String getNutrients() {
		return nutrients;
	}

	public void setNutrients(String nutrients) {
		this.nutrients = nutrients;
	}

	public Integer getProteinCaloriesPerGram() {
		return proteinCaloriesPerGram;
	}

	public void setProteinCaloriesPerGram(Integer proteinCaloriesPerGram) {
		this.proteinCaloriesPerGram = proteinCaloriesPerGram;
	}

	public Float getTotalProteinPercentageDailyValue() {
		return totalProteinPercentageDailyValue;
	}

	public void setTotalProteinPercentageDailyValue(Float totalProteinPercentageDailyValue) {
		this.totalProteinPercentageDailyValue = totalProteinPercentageDailyValue;
	}

	public String getTotalProtein() {
		return totalProtein;
	}

	public void setTotalProtein(String totalProtein) {
		this.totalProtein = totalProtein;
	}

	public String getFoodForm() {
		return foodForm;
	}

	public void setFoodForm(String foodForm) {
		this.foodForm = foodForm;
	}

	public boolean isImitation() {
		return isImitation;
	}

	public void setImitation(boolean isImitation) {
		this.isImitation = isImitation;
	}

	public boolean isUsdaInspected() {
		return usdaInspected;
	}

	public void setUsdaInspected(boolean usdaInspected) {
		this.usdaInspected = usdaInspected;
	}

	public boolean isHasHighFructoseCornSyrup() {
		return hasHighFructoseCornSyrup;
	}

	public void setHasHighFructoseCornSyrup(boolean hasHighFructoseCornSyrup) {
		this.hasHighFructoseCornSyrup = hasHighFructoseCornSyrup;
	}

	public String getFoodAllergenStatements() {
		return foodAllergenStatements;
	}

	public void setFoodAllergenStatements(String foodAllergenStatements) {
		this.foodAllergenStatements = foodAllergenStatements;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getCaffeineDesignation() {
		return caffeineDesignation;
	}

	public void setCaffeineDesignation(String caffeineDesignation) {
		this.caffeineDesignation = caffeineDesignation;
	}

	public String getSpiceLevel() {
		return spiceLevel;
	}

	public void setSpiceLevel(String spiceLevel) {
		this.spiceLevel = spiceLevel;
	}

	public boolean isMadeInHomeKitchen() {
		return isMadeInHomeKitchen;
	}

	public void setMadeInHomeKitchen(boolean isMadeInHomeKitchen) {
		this.isMadeInHomeKitchen = isMadeInHomeKitchen;
	}

	public String getBeefCut() {
		return beefCut;
	}

	public void setBeefCut(String beefCut) {
		this.beefCut = beefCut;
	}

	public String getPoultryCut() {
		return poultryCut;
	}

	public void setPoultryCut(String poultryCut) {
		this.poultryCut = poultryCut;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isHealthyIncentive() {
		return isHealthyIncentive;
	}

	public void setHealthyIncentive(boolean isHealthyIncentive) {
		this.isHealthyIncentive = isHealthyIncentive;
	}

	public boolean isSnapEligible() {
		return isSnapEligible;
	}

	public void setSnapEligible(boolean isSnapEligible) {
		this.isSnapEligible = isSnapEligible;
	}

	public boolean isWICEligible() {
		return isWICEligible;
	}

	public void setWICEligible(boolean isWICEligible) {
		this.isWICEligible = isWICEligible;
	}

}
