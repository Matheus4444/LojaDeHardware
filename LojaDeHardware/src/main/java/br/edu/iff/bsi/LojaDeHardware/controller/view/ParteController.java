package br.edu.iff.bsi.LojaDeHardware.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.bsi.LojaDeHardware.entities.Parte;

@Controller
@RequestMapping(path = "/parte")
public class ParteController {
	
	@GetMapping("/cadastro")
    public String showCadastroParteForm() {
        return "parte";
    }
	
	@PostMapping("/saveParte")
	public String registerParte(@ModelAttribute Parte parte) {
		System.out.println("ID da parte: " + parte.getId());
		System.out.println("Nome da parte: " + parte.getNome());
		System.out.println("Preco da parte: " + parte.getPreco());
		System.out.println("Tipo da parte: " + parte.getTipoPeca());
		return "sucesso";
	}

}
