package com.itemmaster.application.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itemmaster.application.dao.AdditionalCategoryAttributesRepository;
import com.itemmaster.application.dao.ComplianceLRAttributesRepository;
import com.itemmaster.application.dao.DataEntryRepository;
import com.itemmaster.application.dao.DiscoverabilityAttributesRepository;
import com.itemmaster.application.dao.ImageUrlsRepository;
import com.itemmaster.application.dao.LogisticsRepository;
import com.itemmaster.application.dao.NiceToHaveAttributesRepository;
import com.itemmaster.application.entities.ProductDescription;
import com.itemmaster.application.util.CustomErrorType;

@Service
public class DataEntryService {

	@Autowired
	DataEntryRepository dataEntryRepository;

	@Autowired
	AdditionalCategoryAttributesRepository acAttributesRepository;

	@Autowired
	ComplianceLRAttributesRepository crlAttributesRepository;

	@Autowired
	DiscoverabilityAttributesRepository dArributesRepository;

	@Autowired
	ImageUrlsRepository imageUrlsRepository;

	@Autowired
	LogisticsRepository logisticsRepository;

	@Autowired
	NiceToHaveAttributesRepository niceToHaveAttributesRepository;

	public ProductDescription save(ProductDescription productDescription) {
		String productId = productDescription.getProductId();

		if (productDescription.getAdditionalCategoryAttributes() != null) {
			productDescription.getAdditionalCategoryAttributes().setId(productId);
			acAttributesRepository.saveAndFlush(productDescription.getAdditionalCategoryAttributes());
		}

		if (productDescription.getComplianceLRAttributes() != null) {
			productDescription.getComplianceLRAttributes().setId(productId);
			crlAttributesRepository.saveAndFlush(productDescription.getComplianceLRAttributes());
		}

		if (productDescription.getDiscoverabilityAttributes() != null) {
			productDescription.getDiscoverabilityAttributes().setId(productId);
			dArributesRepository.saveAndFlush(productDescription.getDiscoverabilityAttributes());
		}

		if (productDescription.getImageUrls() != null) {
			productDescription.getImageUrls().setId(productId);
			imageUrlsRepository.saveAndFlush(productDescription.getImageUrls());
		}

		if (productDescription.getLogistics() != null) {
			productDescription.getLogistics().setId(productId);
			logisticsRepository.saveAndFlush(productDescription.getLogistics());
		}

		if (productDescription.getNiceToHaveAttributes() != null) {
			productDescription.getNiceToHaveAttributes().setId(productId);
			niceToHaveAttributesRepository.saveAndFlush(productDescription.getNiceToHaveAttributes());
		}
		productDescription = dataEntryRepository.saveAndFlush(productDescription);

		return productDescription;
	}

	public ProductDescription update(ProductDescription productDescription) {

		String productId = productDescription.getProductId();

		if (productDescription.getAdditionalCategoryAttributes() != null) {
			productDescription.getAdditionalCategoryAttributes().setId(productId);
			acAttributesRepository.save(productDescription.getAdditionalCategoryAttributes());
		}

		if (productDescription.getComplianceLRAttributes() != null) {
			productDescription.getComplianceLRAttributes().setId(productId);
			crlAttributesRepository.save(productDescription.getComplianceLRAttributes());
		}

		if (productDescription.getDiscoverabilityAttributes() != null) {
			productDescription.getDiscoverabilityAttributes().setId(productId);
			dArributesRepository.save(productDescription.getDiscoverabilityAttributes());
		}

		if (productDescription.getImageUrls() != null) {
			productDescription.getImageUrls().setId(productId);
			imageUrlsRepository.save(productDescription.getImageUrls());
		}

		if (productDescription.getLogistics() != null) {
			productDescription.getLogistics().setId(productId);
			logisticsRepository.save(productDescription.getLogistics());
		}

		if (productDescription.getNiceToHaveAttributes() != null) {
			productDescription.getNiceToHaveAttributes().setId(productId);
			niceToHaveAttributesRepository.save(productDescription.getNiceToHaveAttributes());
		}
		productDescription = dataEntryRepository.save(productDescription);

		return productDescription;

	}

	public ProductDescription find(String id) {
		return dataEntryRepository.findOne(id);
	}

	public List<ProductDescription> findByStatus(String status) {
		return dataEntryRepository.findByStatus(status);
	}

	public List<ProductDescription> findAll() {
		return dataEntryRepository.findAll();
	}

	public ProductDescription buildProductId(ProductDescription description) {

		String productId = description.getProductId();
		int length = description.getProductId().length();
		if (description.getProductIdType().equals(ProductDescription.ProductType.UPC.toString())) {
			if (length != 12) {
				description.setProductId(String.format("%0" + (12 - length) + "d%s", 0, productId));
			}
		} else if (description.getProductIdType().equals(ProductDescription.ProductType.GTIN.toString())) {
			if (length != 14) {
				description.setProductId(String.format("%0" + (14 - length) + "d%s", 0, productId));
			}
		} else if (description.getProductIdType().equals(ProductDescription.ProductType.ISBN.toString())) {
			if (length != 13) {
				description.setProductId(String.format("%0" + (13 - length) + "d%s", 0, productId));
			}
		} else if (description.getProductIdType().equals(ProductDescription.ProductType.EAN.toString())) {
			if (length != 13) {
				description.setProductId(String.format("%0" + (13 - length) + "d%s", 0, productId));
			}
		}

		System.out.println(" ====> Generated : " + description.getProductId());
		return description;
	}

	public boolean isValidStatus(String status) {
		return (status.equals(ProductDescription.EntryStatus.DRAFT.toString())
				|| status.equals(ProductDescription.EntryStatus.COMPLETE.toString())
				|| status.equals(ProductDescription.EntryStatus.APPROVED.toString())
				|| status.equals(ProductDescription.EntryStatus.REJECTED.toString()));
	}

	public boolean isValidAdminStatus(String status) {
		return (status.equals(ProductDescription.EntryStatus.APPROVED.toString())
				|| status.equals(ProductDescription.EntryStatus.REJECTED.toString()));
	}

	public CustomErrorType validateProductId(String productId) {

		if (find(productId) != null) {
			return new CustomErrorType("ProductId : " + productId + " Already Exists");
		}

		return new CustomErrorType("noerror");
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

		if (description.getProductIdType() == null || description.getProductIdType().isEmpty()) {
			return new CustomErrorType("ProductIdType cannot be empty");
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

	public Workbook getXlsx() {

		List<ProductDescription> description = findByStatus(ProductDescription.EntryStatus.APPROVED.toString());
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("ExcelFormat.xlsx").getFile());

		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);

			Sheet sheet = workbook.getSheet("walmart");
			int rowNum = 6;

			for (ProductDescription r : description) {
				Row row = sheet.createRow(rowNum++);
				int i = 0;
				// basic
				row.createCell(i++).setCellValue(r.getSku());
				row.createCell(i++).setCellValue(r.getProductName());
				row.createCell(i++).setCellValue(r.getProductIdType());
				row.createCell(i++).setCellValue(r.getProductId());
				row.createCell(i++).setCellValue(r.getShortDescription());
				row.createCell(i++).setCellValue(r.getKeyFeatures());
				row.createCell(i++).setCellValue(r.getUnitsPerConsumerUnit());
				row.createCell(i++).setCellValue(r.getBrand());
				row.createCell(i++).setCellValue(r.getManufacturer());
				row.createCell(i++).setCellValue(r.getManufacturerPartNumber());
				row.createCell(i++).setCellValue(r.getModelNumber());
				// images
				if (r.getImageUrls() != null) {
					row.createCell(i++).setCellValue(r.getImageUrls().getMainImageUrl());
					row.createCell(i++).setCellValue(r.getImageUrls().getProductSecondaryImageURL());
				} else {
					i += 2;
				}
				// offer
				if (r.getLogistics() != null) {
					row.createCell(i++).setCellValue(r.getLogistics().getMsrp());
				} else {
					i++;
				}
				// Discoverability r.getDiscoverabilityAttributes().getFlavor()
				if (r.getDiscoverabilityAttributes() != null) {
					row.createCell(i++).setCellValue(r.getDiscoverabilityAttributes().getFlavor());
					row.createCell(i++).setCellValue(r.getDiscoverabilityAttributes().isReadyToEat());
					row.createCell(i++).setCellValue(r.getDiscoverabilityAttributes().getCount());
					row.createCell(i++).setCellValue(r.getDiscoverabilityAttributes().getSize());
				} else {
					i += 4;
				}
				// Complaince
				if (r.getComplianceLRAttributes() != null) {
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isPrivateLabelOrUnbranded());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isExclusiveBrandsIndicator());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isProp65WarningRequired());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().getProp65WarningText());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isIntendedForHumanConsumption());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isNutritionFactsLabelRequired());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().getNutritionFactsLabel());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().getNutritionIngredientsImage());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isHasIngredientList());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().getIngredientListImage());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isHasExpiration());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().getShelfLife());
					row.createCell(i++).setCellValue("days");
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isHasPricePerUnit());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().getPricePerUnitUom());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().getPricePerUnitQuantity());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isHasGMOs());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isPerishable());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isTemperatureSensitive());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().isHasStateRestrictions());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().getStates());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().getZipCodes());
					row.createCell(i++).setCellValue(r.getComplianceLRAttributes().getStateRestrictions());
				} else {
					i += 23;
				}
				// Additional category Attributes
				if (r.getAdditionalCategoryAttributes() != null) {
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().isGmoFree());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getServingSize());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getServingsPerContainer());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getCalories());
					row.createCell(i++).setCellValue("Calories");
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getCaloriesFromFat());
					row.createCell(i++).setCellValue("Calories");
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getTotalFat());
					row.createCell(i++).setCellValue("Gram");
					row.createCell(i++)
							.setCellValue(r.getAdditionalCategoryAttributes().getTotalFatPercentageDailyValue());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getFatCaloriesPerGram());
					row.createCell(i++).setCellValue("Gram");
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getTotalCarbohydrate());
					row.createCell(i++).setCellValue("Gram");
					row.createCell(i++).setCellValue(
							r.getAdditionalCategoryAttributes().getTotalCarbohydratePercentageDailyValue());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getCarbohydrateCaloriesPerGram());
					row.createCell(i++).setCellValue("Gram");
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getNutrientName());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getNutrientAmount());
					row.createCell(i++)
							.setCellValue(r.getAdditionalCategoryAttributes().getNutrientPercentageDailyValue());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getNutrientFootnote());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getProteinCaloriesPerGram());
					row.createCell(i++).setCellValue("Gram");
					row.createCell(i++)
							.setCellValue(r.getAdditionalCategoryAttributes().getTotalProteinPercentageDailyValue());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getTotalProtein());
					row.createCell(i++).setCellValue("Gram");
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getFoodForm());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getContainerType());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getTimeAged());
					row.createCell(i++).setCellValue("months; years");
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().isImitation());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getIngredients());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().isUsdaInspected());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().isHasHighFructoseCornSyrup());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getFoodAllergenStatements());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getInstructions());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getCaffeineDesignation());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getSpiceLevel());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().isMadeInHomeKitchen());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getBeefCut());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getPoultryCut());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().getReleaseDate());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().isHealthyIncentive());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().isSnapEligible());
					row.createCell(i++).setCellValue(r.getAdditionalCategoryAttributes().isWICEligible());
				} else {
					i += 44;
				}
				// Nice to have attributes
				if (r.getNiceToHaveAttributes() != null) {
					row.createCell(i++).setCellValue(r.getNiceToHaveAttributes().isSkuUpdate());
					row.createCell(i++).setCellValue(r.getNiceToHaveAttributes().getSafeHandlingInstructions());
					row.createCell(i++).setCellValue(r.getNiceToHaveAttributes().getCuisine());
					row.createCell(i++).setCellValue(r.getNiceToHaveAttributes().getFoodPreparationTips());
					row.createCell(i++).setCellValue(r.getNiceToHaveAttributes().getFoodStorageTips());
					row.createCell(i++).setCellValue(r.getNiceToHaveAttributes().getAcharacter());
				}
			}

		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return workbook;
	}

}
