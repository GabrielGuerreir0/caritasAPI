package br.com.caritas.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.caritas.controllers.UserController;
import br.com.caritas.data.vo.v1.UserVo;
import br.com.caritas.exceptions.ResourceNotFoundExeption;
import br.com.caritas.mapper.DozerMapper;
import br.com.caritas.model.User;
import br.com.caritas.repositories.UserRepository;
import jakarta.persistence.Entity;

@Service
public class UserServices {

	private final AtomicLong conter = new AtomicLong();
	private final PasswordEncoder encoder;

	public UserServices(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	private Logger logger = Logger.getLogger(UserServices.class.getName());

	@Autowired
	UserRepository repositoriy;
	

	public UserVo findById(long id) {
		
		logger.info("Find one user!");

		var entity = repositoriy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));
		UserVo vo = DozerMapper.ParseObject(entity, UserVo.class);
		vo.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
		return vo;
		
	} 
	
	//UTILIZAÇÃO DE UM UNICO PERFIL POR EMAIL
	
	/*public User findByEmail(String email) {
		return repositoriy.findByEmail(email)
        .orElseThrow(() -> new ResourceNotFoundExeption("No user found for this email!"));
	}
	
	public UserVo findByEmailAndSenha(String email, String senha) {
	    logger.info("Find email and senha user!");

	    User entity = findByEmail(email);

	    if (entity != null && encoder.matches(senha, entity.getSenha())) {
	        UserVo vo = DozerMapper.ParseObject(entity, UserVo.class);
	        vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
	        return vo;
	    } else {
	        throw new ResourceNotFoundExeption("Incorrect email or password!");
	    }
	}*/
	public UserVo findByEmailAndSenha(String email, String senha) {
	    logger.info("Find email and senha user!");

	    List<User> users = repositoriy.findByEmail(email);

	    for (User user : users) {
	        if (encoder.matches(senha, user.getSenha())) {
	            UserVo vo = DozerMapper.ParseObject(user, UserVo.class);
	            vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
	            return vo;
	        }
	    }

	    throw new ResourceNotFoundExeption("Credenciais inválidas. Por favor, verifique seu email e senha.");
	}




	public List<UserVo> findAll() {
		logger.info("Find all people!!");

		var users = DozerMapper.ParseListObjects(repositoriy.findAll(), UserVo.class);
		users
			.stream()
			.forEach(p -> p.add(linkTo(methodOn(UserController.class).findById(p.getKey())).withSelfRel()));
			return users;
	}

	public UserVo create(UserVo user) {

		logger.info("create user!");
		user.setSenha(encoder.encode(user.getSenha()));
		var entity = DozerMapper.ParseObject(user, User.class);
		var vo = DozerMapper.ParseObject(repositoriy.save(entity), UserVo.class);
		vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public UserVo update(UserVo user) {

		logger.info("create user!");

		var entity = repositoriy.findById(user.getKey())
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));

		entity.setEmail(user.getEmail());
		entity.setNome(user.getNome());
		entity.setSenha(user.getSenha());

		var vo = DozerMapper.ParseObject(repositoriy.save(entity), UserVo.class);
		vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public void delete(long id) {

		logger.info("create user!");

		var entity = repositoriy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("No records found for this ID!"));
		repositoriy.delete(entity);

	}
}
