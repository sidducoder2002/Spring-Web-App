package com.taashee.SpringWebApp.entity;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.taashee.SpringWebApp.security.UserRole;

@Entity(name="Users")
public class Users implements UserDetails{
	@Id
	private int state_id;
	private String username;
	private String password;
	private String role;

	public Users(int state_id, String username, String password, String role) {
		this.state_id = state_id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	@Override
	public Set<SimpleGrantedAuthority> getAuthorities() {
		UserRole userRole=UserRole.STATE;
		if(role.equals(UserRole.ADMIN.name())){
			userRole=UserRole.ADMIN;
		}
		Set<SimpleGrantedAuthority> permissions = userRole.getPermission().stream()
		        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
		        .collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_" + role));
		//read Write Role_admin Role_State
		return permissions;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public Users() {
		
		
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
