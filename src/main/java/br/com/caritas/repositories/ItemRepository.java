package br.com.caritas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caritas.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
