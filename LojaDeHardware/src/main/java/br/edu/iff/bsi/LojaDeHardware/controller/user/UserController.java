package br.edu.iff.bsi.LojaDeHardware.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.edu.iff.bsi.LojaDeHardware.entities.User;

@Controller
public class UserController {
	@PostMapping("/saveUser")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@ModelAttribute User user){
		System.out.println("nome de usuário: " + user.getUserName());
		System.out.println("senha: " + user.getPassword());
	}

}
