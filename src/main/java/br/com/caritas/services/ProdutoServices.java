package br.com.caritas.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caritas.controllers.ProdutosController;
import br.com.caritas.data.vo.v1.ProdutoVo;
import br.com.caritas.exceptions.ResourceNotFoundExeption;
import br.com.caritas.mapper.DozerMapper;
import br.com.caritas.model.Produto;
import br.com.caritas.repositories.ProdutoRepository;

@Service
public class ProdutoServices {


	private Logger logger = Logger.getLogger(ProdutoServices.class.getName());

	@Autowired
	ProdutoRepository repositoriy;

	public ProdutoVo findById(long id) {

		logger.info("Find one produto!");

		var entity = repositoriy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));
		ProdutoVo vo = DozerMapper.ParseObject(entity, ProdutoVo.class);
		vo.add(linkTo(methodOn(ProdutosController.class).findById(id)).withSelfRel());
		return vo;

	}

	public List<ProdutoVo> findAll() {
		logger.info("Find all produtos!!");

		var produtos = DozerMapper.ParseListObjects(repositoriy.findAll(), ProdutoVo.class);
		produtos.stream()
				.forEach(p -> p.add(linkTo(methodOn(ProdutosController.class).findById(p.getId())).withSelfRel()));
		return produtos;
	}

	public ProdutoVo create(ProdutoVo produto) {

		logger.info("create produto!");
		var entity = DozerMapper.ParseObject(produto, Produto.class);
		var vo = DozerMapper.ParseObject(repositoriy.save(entity), ProdutoVo.class);
		vo.add(linkTo(methodOn(ProdutosController.class).findById(vo.getId())).withSelfRel());
		return vo;
	}

	public ProdutoVo update(ProdutoVo produto) {

		logger.info("create produto!");

		var entity = repositoriy.findById(produto.getId())
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));

		entity.setColhidos(produto.getColhidos());
		entity.setConsumidos(produto.getConsumidos());
		entity.setCultivados(produto.getCultivados());
		entity.setDescricao(produto.getDescricao());
		entity.setNome(produto.getNome());
		entity.setNomef(produto.getNomef());

		var vo = DozerMapper.ParseObject(repositoriy.save(entity), ProdutoVo.class);
		vo.add(linkTo(methodOn(ProdutosController.class).findById(vo.getId())).withSelfRel());
		return vo;
	}

	public void delete(long id) {

		logger.info("delete produto!");

		var entity = repositoriy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));
		repositoriy.delete(entity);

	}
}
