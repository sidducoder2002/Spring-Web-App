package com.taashee.SpringWebApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.taashee.SpringWebApp.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	UserDetails findByUsername(String username);
}
