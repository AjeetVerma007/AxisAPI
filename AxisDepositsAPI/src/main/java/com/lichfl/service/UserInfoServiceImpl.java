package com.lichfl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichfl.entity.CustomUserDetails;
import com.lichfl.repository.UserRepository;

@Service
public class UserInfoServiceImpl implements  UserInfoService
{
	@Autowired
	private UserRepository  userRepository;

	@Override
	public CustomUserDetails saveUser(CustomUserDetails customUserDetails) {
		// TODO Auto-generated method stub
		return userRepository.save(customUserDetails);
	}

}
