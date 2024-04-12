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

import br.com.caritas.data.vo.v1.UserVo;
import br.com.caritas.services.UserServices;
import br.com.caritas.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Endpoints for Managing User")
public class UserController {

	@Autowired
	private UserServices service;

	

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML })
	@Operation(summary = "Finds a User", description = "Finds a User", tags = { "User" }, responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = UserVo.class))),
			@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
	public UserVo findById(@PathVariable(value = "id") long id) {
		return service.findById(id);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	@Operation(summary = "Finds all User", description = "Finds all User", tags = { "User" }, responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserVo.class))) }),
			@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
	public List<UserVo> findAll() {
		return service.findAll();
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML })
	@Operation(summary = "Add a new User", description = "Add a new User by passing in a JSON, XML or YML", tags = {
			"User" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = UserVo.class))),
					@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
	public UserVo create(@RequestBody UserVo user) {
		return service.create(user);
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML })
	@Operation(summary = "Updates a User", description = "Updates a User by passing in a JSON, XML or YML", tags = {
			"User" }, responses = {
					@ApiResponse(description = "Updated", responseCode = "200", content = @Content(schema = @Schema(implementation = UserVo.class))),
					@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
	public UserVo update(@RequestBody UserVo user) {
		return service.update(user);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete a User", description = "Delete a User by passing in a JSON, XML or YML", tags = {
			"User" }, responses = { @ApiResponse(description = "NO Content", responseCode = "204", content = @Content),
					@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
	public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
