package br.com.caritas.data.vo.v1;

import br.com.caritas.model.UserRoles;

public record RegisterVo (String nome,String email, String senha, UserRoles role){

}
