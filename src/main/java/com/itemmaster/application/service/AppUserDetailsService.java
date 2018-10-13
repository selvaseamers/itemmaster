//package com.itemmaster.application.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.itemmaster.application.entities.User;
//
//
//
///**
// * This Service class for providing the user credentials from the database.
// * 
// * @author selva
// *
// */
//@Service
//public class AppUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	UserService userService;
//
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userService.find(username);
//		return  user;
//	}
//}
