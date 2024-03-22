package br.com.caritas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caritas.model.Familia;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long>{}
