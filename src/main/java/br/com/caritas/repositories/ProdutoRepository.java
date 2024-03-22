package br.com.caritas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caritas.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
