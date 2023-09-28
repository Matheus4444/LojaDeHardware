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
		return "parteForm";
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
		return "listarPartes";
	}

	@GetMapping("/editar")
	public String editarParte(@RequestParam Long id, Model model) {
		Parte parte = parteService.buscarPartePorId(id);
		model.addAttribute("parte", parte);
		return "editarPartes";
	}

	@PostMapping("/atualizar")
	public String atualizarParte(@RequestParam Long id, String nome, double preco, String tipoALimento) {
		parteService.atualizarParte(id, nome, preco, tipoALimento);
		return "redirect:/parte/listar";
	}

	@GetMapping("/excluir")
	public String excluirParte(@RequestParam Long id) {
		parteService.removerParte(id);
		return "redirect:/parte/listar";
	}
}
