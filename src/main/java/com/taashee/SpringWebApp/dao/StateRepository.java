package com.taashee.SpringWebApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.taashee.SpringWebApp.entity.States;
import com.taashee.SpringWebApp.entity.Users;

@Repository
public interface StateRepository extends JpaRepository<States, Integer> {
	
	
}
