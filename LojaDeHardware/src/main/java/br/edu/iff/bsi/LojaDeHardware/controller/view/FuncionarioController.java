package br.edu.iff.bsi.LojaDeHardware.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.bsi.LojaDeHardware.entities.Funcionario;
import br.edu.iff.bsi.LojaDeHardware.repository.FuncionarioRepository;

@Controller
@RequestMapping(path = "/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository res;
	
	@GetMapping()
	public String page() {
		return "funcionario";
	}

	@PostMapping("/addFuncionario")
	@ResponseBody
	public String addPessoa(Funcionario funcionario) throws Exception {
		Funcionario f = res.save(funcionario);
		return "Funcionario adiciconado -->" + f.getId();
	}

	@GetMapping("/getFuncionario")
	@ResponseBody
	public List<Funcionario> getFuncionarios() {
		return res.findAll();
	}

}
