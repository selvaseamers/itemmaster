package com.itemmaster.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itemmaster.application.entities.ProductDescription;
import com.itemmaster.application.service.DataEntryService;
import com.itemmaster.application.util.CustomErrorType;

@RestController
@RequestMapping("data-entry")
public class DataEntryController {

	@Autowired
	DataEntryService dataEntryService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createDataEntry(@RequestBody ProductDescription description) {
		CustomErrorType mesage = dataEntryService.validate(description);
		if (!mesage.getErrorMessage().equals("noerror")) {
			return new ResponseEntity<CustomErrorType>(mesage, HttpStatus.CONFLICT);
		}

		description = dataEntryService.buildProductId(description);

		mesage = dataEntryService.validateProductId(description.getProductId());
		if (!mesage.getErrorMessage().equals("noerror")) {
			return new ResponseEntity<CustomErrorType>(mesage, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<ProductDescription>(dataEntryService.save(description), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<?> getDataEntry() {
		return new ResponseEntity<List<ProductDescription>>(dataEntryService.findAll(), HttpStatus.ACCEPTED);
	}

}
