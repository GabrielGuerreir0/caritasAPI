package br.com.caritas.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.caritas.controllers.FamiliaController;
import br.com.caritas.data.vo.v1.FamiliaVo;
import br.com.caritas.exceptions.ResourceNotFoundExeption;
import br.com.caritas.mapper.DozerMapper;
import br.com.caritas.model.Familia;
import br.com.caritas.repositories.FamiliaRepository;

@Service
public class FamiliaServices {

	private final AtomicLong conter = new AtomicLong();

	private Logger logger = Logger.getLogger(FamiliaServices.class.getName());

	@Autowired
	FamiliaRepository repositoriy;

	public FamiliaVo findById(long id) {
		
		logger.info("Find one produto!");

		var entity = repositoriy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));
		FamiliaVo vo = DozerMapper.ParseObject(entity, FamiliaVo.class);
		vo.add(linkTo(methodOn(FamiliaController.class).findById(id)).withSelfRel());
		return vo;
		
	} 

	public List<FamiliaVo> findAll() {
		logger.info("Find all produtos!!");

		var produtos = DozerMapper.ParseListObjects(repositoriy.findAll(), FamiliaVo.class);
		produtos
			.stream()
			.forEach(p -> p.add(linkTo(methodOn(FamiliaController.class).findById(p.getId())).withSelfRel()));
			return produtos;
	}

	public FamiliaVo create(FamiliaVo familia) {

		logger.info("create familia!");
		var entity = DozerMapper.ParseObject(familia, Familia.class);
		var vo = DozerMapper.ParseObject(repositoriy.save(entity), FamiliaVo.class);
		vo.add(linkTo(methodOn(FamiliaController.class).findById(vo.getId())).withSelfRel());
		return vo;
	}

	public FamiliaVo update(FamiliaVo familia) {

		logger.info("create user!");

		var entity = repositoriy.findById(familia.getId())
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));
		
		entity.setNome(familia.getNome());
		entity.setTelefone(familia.getTelefone());
		entity.setTec(familia.getTec());
		entity.setData(familia.getData());
		entity.setGp(familia.getGp());
		entity.setCnpj(familia.getCnpj());
		entity.setDap(familia.getDap());
		entity.setCpf(familia.getCpf());
		entity.setNit(familia.getNit());
		entity.setEnde(familia.getEnde());
		entity.setLat(familia.getLat());
		entity.setLon(familia.getLon());
		entity.setProj(familia.getProj());
		entity.setInte(familia.getInte());
		entity.setOutro(familia.getOutro());
		entity.setArea1(familia.getArea1());
		entity.setArea2(familia.getArea2());
		entity.setArea3(familia.getArea3());
		entity.setEquip(familia.getEquip());
		entity.setQuantidadeEquipamentos(familia.getQuantidadeEquipamentos());
		entity.setEstadoEquipamento(familia.getEstadoEquipamento());
		entity.setSelecao(familia.getSelecao());
		entity.setSelecao2(familia.getSelecao2());
		entity.setSelecao3(familia.getSelecao3());
		entity.setSelecao4(familia.getSelecao4());
		entity.setSelecao5(familia.getSelecao5());
		entity.setSelecao6(familia.getSelecao6());
		entity.setSelecao7(familia.getSelecao7());
		entity.setSelecao8(familia.getSelecao8());
		entity.setSelecao9(familia.getSelecao9());
		entity.setSelecao11(familia.getSelecao11());
		entity.setSelecao12(familia.getSelecao12());

		
		
		
		var vo = DozerMapper.ParseObject(repositoriy.save(entity), FamiliaVo.class);
		vo.add(linkTo(methodOn(FamiliaController.class).findById(vo.getId())).withSelfRel());
		return vo;
	}

	public void delete(long id) {

		logger.info("delete produto!");

		var entity = repositoriy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));
		repositoriy.delete(entity);

	}
}
