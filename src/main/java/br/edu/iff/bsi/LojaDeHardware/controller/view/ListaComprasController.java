package br.edu.iff.bsi.LojaDeHardware.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.bsi.LojaDeHardware.entities.Cliente;
import br.edu.iff.bsi.LojaDeHardware.entities.Parte;
import br.edu.iff.bsi.LojaDeHardware.repository.ClienteRepository;
import br.edu.iff.bsi.LojaDeHardware.repository.ParteRepository;
import br.edu.iff.bsi.LojaDeHardware.service.ListaComprasService;
import br.edu.iff.bsi.LojaDeHardware.service.ParteService;

@Controller
@RequestMapping("/listaCompras")
public class ListaComprasController {

	@Autowired
	private ListaComprasService listaComprasService;
	@Autowired
	ParteService parteServ;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ParteRepository ParteRepository;

	@PostMapping("/adicionarAlimento")
	@ResponseBody
	public String adicionarAlimento(@RequestParam Long clienteId, @RequestParam Long parteId) {
		Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
		Parte parte = ParteRepository.findById(parteId).orElse(null);

		if (cliente == null || parte == null) {
			return "Cliente ou alimento não encontrado.";
		}

		listaComprasService.adicionarParte(cliente, parte);
		return "Parte adicionado à lista de compras do cliente.";
	}
}
