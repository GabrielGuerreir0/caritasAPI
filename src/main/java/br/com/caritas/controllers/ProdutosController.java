package br.com.caritas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.caritas.data.vo.v1.ProdutoVo;
import br.com.caritas.services.ProdutoServices;
import br.com.caritas.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/produtos")
@Tag(name = "Produtos", description = "Endpoints for Managiin Produto")
public class ProdutosController {

	@Autowired
	private ProdutoServices service;

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML })
	@Operation(summary = "Finds a Produto", description = "Finds a Produto", tags = { "Produtos" }, responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = ProdutoVo.class))),
			@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),

	})
	public ProdutoVo findById(@PathVariable(value = "id") long id) {
		return service.findById(id);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	@Operation(summary = "Finds all Produto", description = "Finds all Produto", tags = { "Produtos" }, responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoVo.class))) }),
			@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })

	public List<ProdutoVo> findAll() {
		return service.findAll();
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML })
	@Operation(summary = "Add a new Produto", description = "Add a new Produto by passing in a JSON, XML or YML", tags = {
			"Produtos" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = ProdutoVo.class))),
					@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })

	public ProdutoVo create(@RequestBody ProdutoVo produto) {
		return service.create(produto);
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML })
	@Operation(summary = "Updates a Produto", description = "Updates a Produto by passing in a JSON, XML or YML", tags = {
			"Produtos" }, responses = {
					@ApiResponse(description = "Updated", responseCode = "200", content = @Content(schema = @Schema(implementation = ProdutoVo.class))),
					@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })

	public ProdutoVo update(@RequestBody ProdutoVo produto) {
		return service.update(produto);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete a Produto", description = "Delete a Produto by passing in a JSON, XML or YML", tags = {
			"Produtos" }, responses = {
					@ApiResponse(description = "NO Content", responseCode = "204", content = @Content),
					@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })

	public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
