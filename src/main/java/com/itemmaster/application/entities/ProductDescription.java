package com.itemmaster.application.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProductDescription {

	public static enum EntryStatus {
		DRAFT, COMPLETE, APPROVED, REJECTED
	}

	public static enum ProductType {
		UPC, GTIN, ISBN, EAN
	}

	@Id
	private String productId;
	private String sku;
	private String productName;
	private String productIdType;
	private String shortDescription;
	private String keyFeatures;
	private Integer unitsPerConsumerUnit;
	private String brand;
	private String manufacturer;
	private String manufacturerPartNumber;
	private String modelNumber;
	private String status;
	private Integer createdBy;
	private Integer approvedBy;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", referencedColumnName = "id")
	private ImageUrls imageUrls;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", referencedColumnName = "id")
	private Logistics logistics;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", referencedColumnName = "id")
	private DiscoverabilityAttributes discoverabilityAttributes;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", referencedColumnName = "id")
	private ComplianceLRAttributes complianceLRAttributes;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", referencedColumnName = "id")
	private AdditionalCategoryAttributes additionalCategoryAttributes;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", referencedColumnName = "id")
	private NiceToHaveAttributes niceToHaveAttributes;

	public ProductDescription() {

	}

	public ProductDescription(String sku, String productName, String productIdType, String productId,
			String shortDescription) {
		this.sku = sku;
		this.productName = productName;
		this.productIdType = productIdType;
		this.productId = productId;
		this.shortDescription = shortDescription;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductIdType() {
		return productIdType;
	}

	public void setProductIdType(String productIdType) {
		this.productIdType = productIdType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getKeyFeatures() {
		return keyFeatures;
	}

	public void setKeyFeatures(String keyFeatures) {
		this.keyFeatures = keyFeatures;
	}

	public Integer getUnitsPerConsumerUnit() {
		return unitsPerConsumerUnit;
	}

	public void setUnitsPerConsumerUnit(Integer unitsPerConsumerUnit) {
		this.unitsPerConsumerUnit = unitsPerConsumerUnit;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturerPartNumber() {
		return manufacturerPartNumber;
	}

	public void setManufacturerPartNumber(String manufacturerPartNumber) {
		this.manufacturerPartNumber = manufacturerPartNumber;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public ImageUrls getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(ImageUrls imageUrls) {
		this.imageUrls = imageUrls;
	}

	public Logistics getLogistics() {
		return logistics;
	}

	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
	}

	public DiscoverabilityAttributes getDiscoverabilityAttributes() {
		return discoverabilityAttributes;
	}

	public void setDiscoverabilityAttributes(DiscoverabilityAttributes discoverabilityAttributes) {
		this.discoverabilityAttributes = discoverabilityAttributes;
	}

	public ComplianceLRAttributes getComplianceLRAttributes() {
		return complianceLRAttributes;
	}

	public void setComplianceLRAttributes(ComplianceLRAttributes complianceLRAttributes) {
		this.complianceLRAttributes = complianceLRAttributes;
	}

	public AdditionalCategoryAttributes getAdditionalCategoryAttributes() {
		return additionalCategoryAttributes;
	}

	public void setAdditionalCategoryAttributes(AdditionalCategoryAttributes additionalCategoryAttributes) {
		this.additionalCategoryAttributes = additionalCategoryAttributes;
	}

	public NiceToHaveAttributes getNiceToHaveAttributes() {
		return niceToHaveAttributes;
	}

	public void setNiceToHaveAttributes(NiceToHaveAttributes niceToHaveAttributes) {
		this.niceToHaveAttributes = niceToHaveAttributes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public int getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

}
