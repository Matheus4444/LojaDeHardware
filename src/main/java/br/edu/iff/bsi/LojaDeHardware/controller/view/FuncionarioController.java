package br.edu.iff.bsi.LojaDeHardware.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.bsi.LojaDeHardware.entities.Funcionario;
import br.edu.iff.bsi.LojaDeHardware.service.FuncionarioService;

@Controller
@RequestMapping(path = "/funcionario")
public class FuncionarioController {
	@Autowired
	private FuncionarioService funcionarioServ;

	@GetMapping("/adicionar")
	public String showCadastroFuncionarioForm(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		return "funcionario";
	}

	@PostMapping("/addFuncionario")
	public String addFuncionario(@ModelAttribute Funcionario funcionario) {
		funcionarioServ.addFuncionario(funcionario);
		return "sucesso";
	}

	@GetMapping("/editar")
	public String showEditFuncionarioForm(@RequestParam Long id, Model model) {
		Funcionario funcionario = funcionarioServ.findById(id);
		if(funcionario != null) {
		model.addAttribute("funcionario", funcionario);
		return "editarFuncionario";
		} 			
		return "Funcionario nao encontrado";
	}

	@PostMapping("/updateFuncionario")
	public String updateFuncionario(@ModelAttribute Funcionario funcionario) {
		funcionarioServ.updateFuncionario(funcionario);
		return "redirect:/funcionario";
	}

	@PostMapping("/deleteFuncionario")
	public String deleteFuncionario(@RequestParam("cpf") String cpf) {
	    funcionarioServ.deleteFuncionario(cpf);
	    return "redirect:/funcionario";
	}

	@GetMapping()
	public String getFuncionarios(Model model) {
		List<Funcionario> funcionarios = funcionarioServ.findAll();
		model.addAttribute("funcionarios", funcionarios);
		return "listarFuncionarios";
	}
}
