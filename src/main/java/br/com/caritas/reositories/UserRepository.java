package br.com.caritas.reositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caritas.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{}
