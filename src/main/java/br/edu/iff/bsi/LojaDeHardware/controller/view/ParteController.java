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

import br.edu.iff.bsi.LojaDeHardware.entities.Parte;
import br.edu.iff.bsi.LojaDeHardware.service.ParteService;

@Controller
@RequestMapping("/parte")
public class ParteController {

	@Autowired
	private ParteService parteService;

	@GetMapping("/cadastro")
	public String showCadastroParteForm(Model model) {
		model.addAttribute("parte", new Parte());
		return "parte"; // nome do arquivo HTML que você criou
	}

	@PostMapping("/saveParte")
	public String registerParte(@ModelAttribute Parte parte) {
		parteService.salvarParte(parte);
		return "redirect:/parte/listar";
	}

	@GetMapping("/listar")
	public String listarPartes(Model model) {
		List<Parte> partes = parteService.listarPartes();
		model.addAttribute("partes", partes);
		return "listarPartes"; // Nome do arquivo HTML que exibirá a lista de partes
	}

	@GetMapping("/editar")
	public String editarParte(@RequestParam Long id, Model model) {
		Parte parte = parteService.buscarPartePorId(id);
		model.addAttribute("parte", parte);
		return "editarPartes"; // Nome do arquivo HTML com o formulário de edição do parte
	}

	@PostMapping("/atualizar")
	public String atualizarParte(@ModelAttribute Parte parte) {
		parteService.atualizarParte(parte);
		return "redirect:/parte/listar"; // Redireciona para a página que lista os partes após atualizar
	}

	@GetMapping("/excluir")
	public String excluirParte(@RequestParam Long id) {
		parteService.removerParte(id);
		return "redirect:/parte/listar"; // Redireciona para a página que lista os partes após excluir
	}
}
