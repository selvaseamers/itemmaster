package com.itemmaster.application.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itemmaster.application.entities.User;

import com.itemmaster.application.util.CustomErrorType;

@RestController
@RequestMapping("account")
public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

//	@Autowired
//	UserService userService;
//
//	@CrossOrigin
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public ResponseEntity<?> createUser(@RequestBody User newUser) {
//		if (userService.find(newUser.getUsername()) != null) {
//			logger.error("username Already exist " + newUser.getUsername());
//			return new ResponseEntity<CustomErrorType>(
//					new CustomErrorType("user with username " + newUser.getUsername() + " already exist "),
//					HttpStatus.CONFLICT);
//		}
//		if (newUser.getRole() == null || newUser.getRole().isEmpty() || newUser.getRole() != "ADMIN"
//				|| newUser.getRole() != User.Role.USER.toString()) {
//			return new ResponseEntity<CustomErrorType>(new CustomErrorType("user role is not matching "),
//					HttpStatus.CONFLICT);
//		}
//
//		return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
//	}
//
//	// this is the login api/service
//	@CrossOrigin
//	@RequestMapping("/login")
//	public Principal user(Principal principal) {
//		logger.info("user logged " + principal);
//		return principal;
//	}

}
