package br.com.caritas.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caritas.controllers.ItemController;
import br.com.caritas.data.vo.v1.ItemVo;
import br.com.caritas.exceptions.ResourceNotFoundExeption;
import br.com.caritas.mapper.DozerMapper;
import br.com.caritas.model.Item;
import br.com.caritas.repositories.ItemRepository;

@Service
public class ItemServices {


	private Logger logger = Logger.getLogger(ProdutoServices.class.getName());

	@Autowired
	ItemRepository repositoriy;

	public ItemVo findById(long id) {

		logger.info("Find one Item!");

		var entity = repositoriy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));
		ItemVo vo = DozerMapper.ParseObject(entity, ItemVo.class);
		vo.add(linkTo(methodOn(ItemController.class).findById(id)).withSelfRel());
		return vo;

	}

	public List<ItemVo> findAll() {
		logger.info("Find all Item!!");

		var produtos = DozerMapper.ParseListObjects(repositoriy.findAll(), ItemVo.class);
		produtos.stream().forEach(p -> p.add(linkTo(methodOn(ItemController.class).findById(p.getId())).withSelfRel()));
		return produtos;
	}

	public ItemVo create(ItemVo item) {

		logger.info("create Item!");
		var entity = DozerMapper.ParseObject(item, Item.class);
		var vo = DozerMapper.ParseObject(repositoriy.save(entity), ItemVo.class);
		vo.add(linkTo(methodOn(ItemController.class).findById(vo.getId())).withSelfRel());
		return vo;
	}

	public ItemVo update(ItemVo item) {

		logger.info("create Item!");

		var entity = repositoriy.findById(item.getId())
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));

		entity.setColhidos(item.getColhidos());
		entity.setConsumidos(item.getConsumidos());
		entity.setCultivados(item.getCultivados());
		entity.setDescricao(item.getDescricao());
		entity.setNome(item.getNome());
		entity.setNomef(item.getNomef());

		var vo = DozerMapper.ParseObject(repositoriy.save(entity), ItemVo.class);
		vo.add(linkTo(methodOn(ItemController.class).findById(vo.getId())).withSelfRel());
		return vo;
	}

	public void delete(long id) {

		logger.info("delete Item!");

		var entity = repositoriy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));
		repositoriy.delete(entity);

	}

}
