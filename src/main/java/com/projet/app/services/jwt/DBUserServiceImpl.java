package com.projet.app.services.jwt;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.projet.app.models.DBUser;
import com.projet.app.repository.DBUserRepository;

@Service
public class DBUserServiceImpl implements UserDetailsService{
	private final DBUserRepository dbUserRepository;
	
	 @Autowired
	    public DBUserServiceImpl(DBUserRepository dbUserRepository) {
	        this.dbUserRepository = dbUserRepository;
	    }
	
	
	 @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        // Write logic to fetch user from DB
	        DBUser user = dbUserRepository.findByEmail(email)
	                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + email));

	        return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
	    }
}
