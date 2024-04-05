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
import org.springframework.web.bind.annotation.RestController;

import br.com.caritas.data.vo.v1.ItemVo;
import br.com.caritas.data.vo.v1.ProdutoVo;
import br.com.caritas.services.ItemServices;
import br.com.caritas.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Item", description = "Endpoints for Managiin Itens")
public class ItemController {

	@Autowired
	private ItemServices service;

	@GetMapping(value = "/produtos/{id}/item/{itemId}", produces = { MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	@Operation(summary = "Finds a Item", description = "Finds a Item", tags = { "Item" }, responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = ProdutoVo.class))),
			@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),

	})
	public ItemVo findById(@PathVariable(value = "itemId") long id) {
		return service.findById(id);
	}

	@GetMapping(value = "/produtos/{id}/item", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML })
	@Operation(summary = "Finds all Produto", description = "Finds all Produto", tags = { "Produtos" }, responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoVo.class))) }),
			@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })

	public List<ItemVo> findAll() {  
		
		return service.findAll();
	}

	@PostMapping(value = "/produtos/{id}/item", consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML })
	@Operation(summary = "Add a new Item", description = "Add a new Item by passing in a JSON, XML or YML", tags = {
			"Item" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = ItemVo.class))),
					@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })

	public ItemVo create(@RequestBody ItemVo item) {
		return service.create(item);
	}

	@PutMapping(value = "/produtos/{id}/item", consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML })
	@Operation(summary = "Updates a Item", description = "Updates a Item by passing in a JSON, XML or YML", tags = {
			"Item" }, responses = {
					@ApiResponse(description = "Updated", responseCode = "200", content = @Content(schema = @Schema(implementation = ItemVo.class))),
					@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })

	public ItemVo update(@RequestBody ItemVo item) {
		return service.update(item);
	}

	@DeleteMapping(value = "/produtos/{id}/item/{di}")
	@Operation(summary = "Delete a Produto", description = "Delete a Produto by passing in a JSON, XML or YML", tags = {
			"Produtos" }, responses = {
					@ApiResponse(description = "NO Content", responseCode = "204", content = @Content),
					@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })

	public ResponseEntity<?> delete(@PathVariable(value = "di") long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
