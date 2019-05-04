package com.assignment.security;

public enum Roles {
	TECHLEAD("USER_TECHLEAD"), ADMIN("SYSTEM_ADMIN");

	private String description;

    private Roles(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
