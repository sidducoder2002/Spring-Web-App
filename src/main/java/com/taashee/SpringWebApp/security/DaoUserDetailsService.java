package com.taashee.SpringWebApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taashee.SpringWebApp.dao.UserRepository;

@Service
public class DaoUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user =userRepository.findByUsername(username);
		return user;
	}

}
