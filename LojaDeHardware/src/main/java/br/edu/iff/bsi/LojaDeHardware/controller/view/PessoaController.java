package br.edu.iff.bsi.LojaDeHardware.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.bsi.LojaDeHardware.entities.Pessoa;
import br.edu.iff.bsi.LojaDeHardware.repository.PessoaRepository;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
	@Autowired
	private PessoaRepository res;
	
	@PostMapping("/")
	public String addPessoa(Pessoa pessoa) throws Exception {
		Pessoa p = res.save(pessoa);
		return "Pessoa added -->"+p.getId()+"-->";
	}

}
