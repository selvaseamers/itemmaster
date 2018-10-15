package com.itemmaster.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itemmaster.application.entities.ProductDescription;
import com.itemmaster.application.service.DataEntryService;
import com.itemmaster.application.util.CustomErrorType;

@RestController
@RequestMapping("api/data-entry/product")
public class DataEntryController {

	@Autowired
	DataEntryService dataEntryService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@RequestBody ProductDescription description) {
		CustomErrorType mesage = dataEntryService.validate(description);
		if (!mesage.getErrorMessage().equals("noerror")) {
			return new ResponseEntity<CustomErrorType>(mesage, HttpStatus.CONFLICT);
		}

		description = dataEntryService.buildProductId(description);

		mesage = dataEntryService.validateProductId(description.getProductId());
		if (!mesage.getErrorMessage().equals("noerror")) {
			return new ResponseEntity<CustomErrorType>(mesage, HttpStatus.CONFLICT);
		}

		if (!dataEntryService.isValidStatus(description.getStatus())) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Not a valid status"), HttpStatus.CONFLICT);
		}

		return new ResponseEntity<ProductDescription>(dataEntryService.save(description), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@PathVariable("productId") String productId,
			@RequestBody ProductDescription description) {
		System.out.println("======> Given id : " + productId);

		if (dataEntryService.find(productId) == null) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product not found"), HttpStatus.NOT_FOUND);
		}

		CustomErrorType mesage = dataEntryService.validate(description);

		if (!mesage.getErrorMessage().equals("noerror")) {
			return new ResponseEntity<CustomErrorType>(mesage, HttpStatus.CONFLICT);
		}

		if (!dataEntryService.isValidStatus(description.getStatus())) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Not a valid status"), HttpStatus.CONFLICT);
		}

		return new ResponseEntity<ProductDescription>(dataEntryService.update(description), HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable("productId") String productId) {
		System.out.println("======> Given id : " + productId);
		ProductDescription productDescription = dataEntryService.find(productId);

		if (productDescription != null) {
			return new ResponseEntity<ProductDescription>(productDescription, HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product not found"), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> getAllProducts() {
		return new ResponseEntity<List<ProductDescription>>(dataEntryService.findAll(), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity<?> getProductByStatus(@RequestParam("status") String status) {
		return new ResponseEntity<List<ProductDescription>>(dataEntryService.findByStatus(status),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{productId}/status", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAdminStatus(@PathVariable("productId") String productId,
			@RequestParam("status") String status) {
		if (!dataEntryService.isValidAdminStatus(status)) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Not a valid Admin status"),
					HttpStatus.CONFLICT);
		}
		ProductDescription description = dataEntryService.find(productId);
		description.setStatus(status);

		return new ResponseEntity<ProductDescription>(dataEntryService.update(description), HttpStatus.NO_CONTENT);
	}

//	@RequestMapping(value = "/gettemplate", method = RequestMethod.GET)
//	public Response<?> getExcel() {
//
//		// incomplete to-do
//		dataEntryService.getXlsx();
//
//		return null;
//
//	}
}