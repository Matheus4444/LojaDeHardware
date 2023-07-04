package br.edu.iff.bsi.LojaDeHardware.controller.view;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.edu.iff.bsi.LojaDeHardware.entities.Pessoa;

@Controller
public class PessoaController {
	@PostMapping("/savePessoa")
	@ResponseStatus(HttpStatus.CREATED)
	public void savePessoa(@ModelAttribute Pessoa pessoa){
		System.out.println("nome de usuário: " + pessoa.getNome());
		System.out.println("senha: " + pessoa.getEmail());
		System.out.println("senha: " + pessoa.getCpf());
		System.out.println("senha: " + pessoa.getPassword());
	}

}
