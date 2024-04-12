package br.com.caritas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caritas.data.vo.v1.AutenticationVo;
import br.com.caritas.data.vo.v1.LoginResponseVo;
import br.com.caritas.data.vo.v1.RegisterVo;
import br.com.caritas.model.User;
import br.com.caritas.repositories.UserRepository;
import br.com.caritas.security.TokenService;
import br.com.caritas.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;



@RestController
@RequestMapping("auth")
public class AutenticationController {
	
	@Autowired
	private  AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private TokenService tokenService;
	
	

	@PostMapping(value = "/login", consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML })
	@Operation(summary = "Login as User", description = "Login as User by passing in a JSON, XML or YML", tags = {
			"Login" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = AutenticationVo.class))),
					@ApiResponse(description = "Bad Rquest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorizedt", responseCode = "401", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
	public ResponseEntity login(@RequestBody @Valid AutenticationVo aut) {
            var EmailPassword = new UsernamePasswordAuthenticationToken(aut.email(), aut.senha());
            var auth = this.authenticationManager.authenticate(EmailPassword);
            
            var token = tokenService.generateToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseVo(token));     
    }
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterVo data) {
		if (this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();
		
		String encryptPassword = new BCryptPasswordEncoder().encode(data.senha());
		User User = new User(data.nome(), data.email(), encryptPassword, data.role());
		
		this.repository.save(User);
		
		return ResponseEntity.ok().build();
	}
	
}
