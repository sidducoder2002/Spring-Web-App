package com.taashee.SpringWebApp.security;

public enum UserPermission {
	READ("read"),WRITE("write");

	private final String permission;

	public String getPermission() {
		return permission;
	}

	private UserPermission(String permission) {
		this.permission = permission;
	}
	
}
