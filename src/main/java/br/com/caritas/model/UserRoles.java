package br.com.caritas.model;

public enum UserRoles {

	ADMIN("admin"),
	GERENTE("gerent"),
	USER("user");
	
	private String role;
	
		
	
	 UserRoles(String role) {
		this.role = role;
	}


	public String getRole() {
		return role;

	}
}
