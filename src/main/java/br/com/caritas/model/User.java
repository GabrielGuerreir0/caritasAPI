package br.com.caritas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, length = 80)
	private String email;

	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private UserRoles role;

	public User() {}
	
	public User(String nome, String email, String senha, UserRoles role) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.role = role;
	}
	

	

	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	public UserRoles getRole() {
		return role;
	}




	public void setRole(UserRoles role) {
		this.role = role;
	}


	


	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome, role, senha);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(nome, other.nome)
				&& role == other.role && Objects.equals(senha, other.senha);
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UserRoles.ADMIN)  return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
				new SimpleGrantedAuthority("ROLE_GERENTE"), new SimpleGrantedAuthority("ROLE_USER" ));
		
		else if(this.role == UserRoles.GERENTE) return List.of(new SimpleGrantedAuthority("ROLE_GERENTE"), 
				new SimpleGrantedAuthority("ROLE_USER"));
		
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
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
