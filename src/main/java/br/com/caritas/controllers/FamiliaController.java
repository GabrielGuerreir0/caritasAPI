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

import br.com.caritas.data.vo.v1.FamiliaVo;
import br.com.caritas.services.FamiliaServices;
import br.com.caritas.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/familia")
@Tag(name="Familia", description="Endpoints for Managiin Familia")
public class FamiliaController {
 
	
	@Autowired
	private FamiliaServices service;
	
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
			@Operation(summary = "Finds a Familia", description = "Finds a Familia",
			tags = {"Familia"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200", 
							content = @Content (schema = @Schema(implementation = FamiliaVo.class))
											),
					@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			
			})
	public FamiliaVo findById(@PathVariable(value="id")long id) {
		return service.findById(id);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all Familia", description = "Finds all Familia",
	tags = {"Familia"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
					content = {
							@Content(
									mediaType = "application/json",
									array = @ArraySchema(schema = @Schema(implementation = FamiliaVo.class))
									)
					}),
			@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
)
	
	public List<FamiliaVo> findAll() {
		return service.findAll();
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, 
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Add a new Familia", description = "Add a new Familia by passing in a JSON, XML or YML",
	tags = {"Familia"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
					content = @Content (schema = @Schema(implementation = FamiliaVo.class))
									),
			@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
)
	
	public FamiliaVo create(@RequestBody FamiliaVo familia) {
		return service.create(familia);
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, 
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Updates a Familia", description = "Updates a Familia by passing in a JSON, XML or YML",
	tags = {"Familia"},
	responses = {
			@ApiResponse(description = "Updated", responseCode = "200", 
					content = @Content (schema = @Schema(implementation = FamiliaVo.class))
									),
			@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
)
	
	public FamiliaVo update(@RequestBody FamiliaVo familia) {
		return service.update(familia);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete a Familia", description = "Delete a Familia by passing in a JSON, XML or YML",
	tags = {"Familia"},
	responses = {
			@ApiResponse(description = "NO Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
)
	
	public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
