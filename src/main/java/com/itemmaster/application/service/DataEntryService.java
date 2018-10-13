package com.itemmaster.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itemmaster.application.dao.AdditionalCategoryAttributesRepository;
import com.itemmaster.application.dao.ComplianceLRAttributesRepository;
import com.itemmaster.application.dao.DataEntryRepository;
import com.itemmaster.application.dao.DiscoverabilityAttributesRepository;
import com.itemmaster.application.dao.ImageUrlsRepository;
import com.itemmaster.application.dao.LogisticsRepository;
import com.itemmaster.application.dao.NiceToHaveAttributesRepository;
import com.itemmaster.application.entities.AdditionalCategoryAttributes;
import com.itemmaster.application.entities.ComplianceLRAttributes;
import com.itemmaster.application.entities.DiscoverabilityAttributes;
import com.itemmaster.application.entities.ImageUrls;
import com.itemmaster.application.entities.ProductDescription;
import com.itemmaster.application.util.CustomErrorType;

@Service
public class DataEntryService {

	@Autowired
	DataEntryRepository dataEntryRepository;

//	@Autowired
//	AdditionalCategoryAttributesRepository acAttributesRepository;
//
//	@Autowired
//	ComplianceLRAttributesRepository crlAttributesRepository;
//
//	@Autowired
//	DiscoverabilityAttributesRepository dArributesRepository;
//
//	@Autowired
//	ImageUrlsRepository imageUrlsRepository;
//
//	@Autowired
//	LogisticsRepository logisticsRepository;
//
//	@Autowired
//	NiceToHaveAttributesRepository niceToHaveAttributesRepository;

	public ProductDescription save(ProductDescription productDescription) {
		return dataEntryRepository.saveAndFlush(productDescription);

//		if (productDescription.getAdditionalCategoryAttributes() != null) {
//			acAttributesRepository.saveAndFlush(productDescription.getAdditionalCategoryAttributes());
//		}
//
//		if (productDescription.getComplianceLRAttributes() != null) {
//			crlAttributesRepository.saveAndFlush(productDescription.getComplianceLRAttributes());
//		}
//
//		if (productDescription.getDiscoverabilityAttributes() != null) {
//			dArributesRepository.saveAndFlush(productDescription.getDiscoverabilityAttributes());
//		}
//
//		if (productDescription.getImageUrls() != null) {
//			imageUrlsRepository.saveAndFlush(productDescription.getImageUrls());
//		}
//
//		if (productDescription.getLogistics() != null) {
//			logisticsRepository.saveAndFlush(productDescription.getLogistics());
//		}
//
//		if (productDescription.getNiceToHaveAttributes() != null) {
//			niceToHaveAttributesRepository.saveAndFlush(productDescription.getNiceToHaveAttributes());
//		}

		// return productDescription;
	}

	public ProductDescription update(ProductDescription productDescription) {
		return dataEntryRepository.save(productDescription);

	}

	public ProductDescription find(Long id) {
		return dataEntryRepository.findOne(id);
	}

	public List<ProductDescription> findAll() {
		return dataEntryRepository.findAll();
	}

	public CustomErrorType validate(ProductDescription description) {

		if (description.getSku() == null || description.getSku().isEmpty()) {
			return new CustomErrorType("SKU cannot be empty");
		}

		if (description.getProductName() == null || description.getProductName().isEmpty()) {
			return new CustomErrorType("ProductName cannot be empty");
		}

		if (description.getProductId() == null || description.getProductId().isEmpty()) {
			return new CustomErrorType("ProductId cannot be empty");
		}

//		if (dataEntryRepository.findByName(description.getProductId()) != null) {
//			return new CustomErrorType("ProductId : " + description.getProductId() + " Already Exists");
//		}

		if (description.getProductIdType() == null || description.getProductIdType().isEmpty()) {
			return new CustomErrorType("ProductIdType cannot be empty");
		}

		if (description.getProductIdType().equals(ProductDescription.ProductType.UPC.toString())) {
			if (description.getProductId().length() > 12) {
				return new CustomErrorType("UPC should not contain more than 12 length");
			}
		} else if (description.getProductIdType().equals(ProductDescription.ProductType.GTIN.toString())) {
			if (description.getProductId().length() > 14) {
				return new CustomErrorType("GTIN should not contain more than 14 length");
			}
		} else if (description.getProductIdType().equals(ProductDescription.ProductType.ISBN.toString())) {
			if (description.getProductId().length() > 13) {
				return new CustomErrorType("ISBN should not contain more than 13 length");
			}
		} else if (description.getProductIdType().equals(ProductDescription.ProductType.EAN.toString())) {
			if (description.getProductId().length() > 13) {
				return new CustomErrorType("EAN should not contain more than 13 length");
			}
		} else {
			return new CustomErrorType("Given ProductType : " + description.getProductIdType() + " dosen't match");
		}

		if (description.getShortDescription() == null || description.getShortDescription().isEmpty()) {
			return new CustomErrorType("ShortDescription cannot be empty");
		}

		if (description.getComplianceLRAttributes() != null) {

			if (description.getComplianceLRAttributes() != null
					|| description.getComplianceLRAttributes().isProp65WarningRequired()) {
				if (description.getComplianceLRAttributes().getProp65WarningText() == null
						|| description.getComplianceLRAttributes().getProp65WarningText().isEmpty()) {
					return new CustomErrorType("Prop65WarningText cannot be empty, when Prop65WarningRequired");
				}
			}

			if (description.getComplianceLRAttributes() != null
					|| description.getComplianceLRAttributes().isHasExpiration()) {
				if (description.getComplianceLRAttributes().getShelfLife() == null) {
					return new CustomErrorType("ShelfLife cannot be empty, when ComplianceLRAttributes");
				}
			}

			if (description.getComplianceLRAttributes().isHasPricePerUnit()) {
				if (description.getComplianceLRAttributes().getPricePerUnitQuantity() == null) {
					return new CustomErrorType("PricePerUnitQuantity cannot be empty, when HasPricePerUnit");
				}

				if (description.getComplianceLRAttributes().getPricePerUnitUom() == null) {
					return new CustomErrorType("PricePerUnitUom cannot be empty, when HasPricePerUnit");
				}
			}

			if (description.getComplianceLRAttributes().isHasStateRestrictions()) {
				if (description.getComplianceLRAttributes().getStateRestrictions() == null) {
					return new CustomErrorType("StateRestrictions cannot be empty, when HasStateRestrictions");
				}

				if (description.getComplianceLRAttributes().getStates() == null) {
					return new CustomErrorType("States cannot be empty, when HasStateRestrictions");
				}
			}

			if (description.getComplianceLRAttributes().isNutritionFactsLabelRequired()) {
				if (description.getComplianceLRAttributes().getNutritionFactsLabel() == null) {
					return new CustomErrorType("NutritionFactsLabel cannot be empty, when NutritionFactsLabelRequired");
				}
				if (description.getComplianceLRAttributes().getNutritionIngredientsImage() == null) {
					return new CustomErrorType(
							"NutritionIngredientsImage cannot be empty, when NutritionFactsLabelRequired");
				}
			}

			if (description.getComplianceLRAttributes().isHasIngredientList()) {
				if (description.getComplianceLRAttributes().getIngredientListImage() == null) {
					return new CustomErrorType("IngredientListImage cannot be empty, when HasIngredientList");
				}
			}
		}

		if (description.getAdditionalCategoryAttributes() != null) {
			if (description.getAdditionalCategoryAttributes().isGmoFree()) {
				if (description.getAdditionalCategoryAttributes().getNutrientName() == null) {
					return new CustomErrorType("NutrientName cannot be empty, when GmoFree");
				}

				if (description.getAdditionalCategoryAttributes().getNutrientAmount() == null) {
					return new CustomErrorType("NutrientAmount cannot be empty, when GmoFree");
				}

				if (description.getAdditionalCategoryAttributes().getNutrientPercentageDailyValue() == null) {
					return new CustomErrorType("NutrientPercentageDailyValue cannot be empty, when GmoFree");
				}
			}
		}

		return new CustomErrorType("noerror");

	}

}
