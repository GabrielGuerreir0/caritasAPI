package br.com.caritas.repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caritas.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByEmail(String email);
	//Optional<User> findByEmail(String email);
	Optional<User> findByEmailAndSenha(String email, String senha);
}
