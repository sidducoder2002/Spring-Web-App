package com.taashee.SpringWebApp.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;


public enum UserRole {
	STATE(new HashSet<>(Arrays.asList(UserPermission.READ))),
	ADMIN(new HashSet<>(Arrays.asList(UserPermission.READ,UserPermission.WRITE)));
	
	private final Set<UserPermission> permission;

	private UserRole(Set<UserPermission> permission) {
		this.permission = permission;
	}
	public Set<UserPermission> getPermission() {
		return permission;
	}
	public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
		Set<SimpleGrantedAuthority> permissions = getPermission().stream()
		        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
		        .collect(Collectors.toSet());

		return permissions;
		
	}
	
}
