package com.lichfl.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.lichfl.entity.CustomUserDetails;
import com.lichfl.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository  userRepository;
	
	@Autowired
	private CustomUserDetails customUserDetails;

	@Override
	public UserDetails loadUserByUsername(String username)  {
		// TODO Auto-generated method stub
		
	
			customUserDetails=userRepository.findUserByUsername(username, "A");
	
		 
		// System.out.println("User Details from DB "+customUserDetails);
		// System.out.println("customUserDetails.getUserName() : "+customUserDetails.getUserName());
					
		
		if ( null!=customUserDetails && customUserDetails.getUserName().equals(username) )
			 
		 {
			 System.out.println("Entered User details Matched");
			 return new User(customUserDetails.getUserName(), customUserDetails.getPassword(), new ArrayList<>());
			 
		 }
		else 
		 {
			throw new RuntimeException("User does not exists");
			//throw  new Exception("User does not exists");
		 }
	
		
		 
	 }
	

}
