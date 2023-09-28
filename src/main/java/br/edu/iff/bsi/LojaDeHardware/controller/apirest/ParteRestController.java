package br.edu.iff.bsi.LojaDeHardware.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.bsi.LojaDeHardware.entities.Parte;
import br.edu.iff.bsi.LojaDeHardware.service.ParteService;

@RestController
@RequestMapping("/api/v1/parte")
public class ParteRestController {
	@Autowired
	private ParteService parteService;

	@GetMapping
	public List<Parte> listarPartes() {
		return parteService.listarPartes();
	}

	@GetMapping("/{id}")
	public Parte buscarPartePorId(@PathVariable Long id) {
		return parteService.buscarPartePorId(id);
	}

	@PostMapping
	public String salvarParte(double preco, String nome, String tipoParte) {

		return parteService.salvarParte(new Parte(preco, nome, tipoParte));

	}

	@PutMapping("/{id}")
	public String atualizarParte(@PathVariable("id") Long id, double preco, String tipoParte) throws Exception {
		Parte ParteBusca = parteService.buscarPartePorId(id);
		if (ParteBusca == null) {
			return "Parte não achado";
		} else {
			return parteService.atualizarParte(id, ParteBusca.getNome(), preco, tipoParte);
		}
	}

	@DeleteMapping("/{id}")
	public String removerParte(@PathVariable Long id) {
		Parte ParteBusca = parteService.buscarPartePorId(id);
		if (ParteBusca == null) {
			return "Parte não achado";
		} else {
			return parteService.removerParte(id);
		}
	}
}
