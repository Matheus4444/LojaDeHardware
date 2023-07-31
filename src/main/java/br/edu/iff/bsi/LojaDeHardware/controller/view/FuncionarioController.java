package br.edu.iff.bsi.LojaDeHardware.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "funcionario"; // nome do arquivo HTML que você criou para adicionar funcionários
	}

	@PostMapping("/addFuncionario")
	public String addFuncionario(@ModelAttribute Funcionario funcionario) {
		funcionarioServ.addFuncionario(funcionario);
		return "sucesso"; // redireciona para a página principal após adicionar o funcionário
	}

	@GetMapping("/editar/{id}")
	public String showEditFuncionarioForm(@PathVariable("id") Long id, Model model) {
		Funcionario funcionario = funcionarioServ.findById(id);
		model.addAttribute("funcionario", funcionario);
		return "editarFuncionario"; // nome do arquivo HTML que você criou para editar funcionários
	}

	@PostMapping("/updateFuncionario")
	public String updateFuncionario(@ModelAttribute Funcionario funcionario) {
		funcionarioServ.updateFuncionario(funcionario);
		return "redirect:/funcionario"; // redireciona para a página principal após atualizar o funcionário
	}

	@PostMapping("/deleteFuncionario")
	public String deleteFuncionario(@RequestParam("id") Long id) {
	    funcionarioServ.deleteFuncionario(id);
	    return "redirect:/funcionario"; // redireciona para a página principal após excluir o funcionário
	}

	@GetMapping()
	public String getFuncionarios(Model model) {
		List<Funcionario> funcionarios = funcionarioServ.findAll();
		model.addAttribute("funcionarios", funcionarios);
		return "listarFuncionarios";
	}
}
