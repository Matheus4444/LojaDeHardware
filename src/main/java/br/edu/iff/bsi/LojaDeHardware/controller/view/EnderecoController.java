package br.edu.iff.bsi.LojaDeHardware.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.bsi.LojaDeHardware.entities.Endereco;
import br.edu.iff.bsi.LojaDeHardware.service.EnderecoService;

@Controller
public class EnderecoController {
	@Autowired
	EnderecoService enderecoServ;

	@PostMapping("/addEndereco")
	@ResponseBody
	public String addPessoa(Endereco endereco) throws Exception {
		Endereco e = enderecoServ.addEndereco(endereco);
		return "Endereco add --> " + e.enderecoFormatado();

	}

	@GetMapping("/getEndereco")
	@ResponseBody
	public List<Endereco> getEndereco() {
		return enderecoServ.getEndereco();
	}

}