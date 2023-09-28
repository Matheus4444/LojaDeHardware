package br.edu.iff.bsi.LojaDeHardware.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.bsi.LojaDeHardware.entities.Parte;
import br.edu.iff.bsi.LojaDeHardware.entities.Cliente;
import br.edu.iff.bsi.LojaDeHardware.entities.Compra;
import br.edu.iff.bsi.LojaDeHardware.repository.CompraRepository;
import br.edu.iff.bsi.LojaDeHardware.service.ParteService;
import br.edu.iff.bsi.LojaDeHardware.service.ClienteService;
import br.edu.iff.bsi.LojaDeHardware.service.CompraService;

@Controller
@RequestMapping("/compra")
public class CompraController {
	@Autowired
	private CompraService compraService;
	@Autowired
	private ParteService parteService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private CompraRepository compraRep;

	@GetMapping()
	public String listarCompras(Model model) {
		model.addAttribute("compras", compraService.listarCompras());
		return "listarCompras";
	}

	@GetMapping("/{id}")
	public String visualizarCompra(@PathVariable Long id, @RequestParam(required = false) String tipo, Model model) {
		Compra compra = compraService.getCompraById(id);
		List<Parte> partes = parteService.listarPartes();
		if (compra == null) {
			return "redirect:/compra";
		}

		if (tipo != null && !tipo.isEmpty()) {
			partes = parteService.listarPartesPorTipo(tipo);
		} else {
			partes = parteService.listarPartes();
		}

		Cliente cliente = compraService.getClienteDaCompra(id);
		if (cliente != null) {
			model.addAttribute("saldoCliente", cliente.verSaldo());
		}
		model.addAttribute("hardwares", partes);
		model.addAttribute("compra", compra);
		return "comprar";
	}

	@GetMapping("/criar")
	public String exibirFormularioCriacaoCompra(Model model) {
		model.addAttribute("compra", new Compra());
		return "formularioCriacaoCompra";
	}

	@PostMapping("/criar")
	public String criarCompra(Compra compra) {
		String cpfCliente = compra.getCpfCliente();
		String resultado = compraService.addCompra(cpfCliente);
		return "redirect:/compra";
	}

	@PostMapping("atualizar/{id}")
	public String atualizarCompra(@PathVariable("id") String id, String cpf) throws Exception {
		return compraService.atualizarCompra(id, cpf);
	}

	@GetMapping("/{id}/adicionarParte")
	public String exibirFormularioAdicaoParte(@PathVariable Long id, Model model) {
		model.addAttribute("compraId", id);
		return "formularioAdicaoHardware";
	}

	@PostMapping("/{id}/adicionarParte")
	public String adicionarParteACompra(@PathVariable Long id, String nomeParte) {
		Compra compra = compraService.getCompraById(id);
		if (compra != null) {
			Parte parte = parteService.getParteByNome(nomeParte);
			if (parte != null) {
				compra.adicionarParte(parte);
				compraRep.save(compra);
			}
		}
		return "redirect:/compra/" + id;
	}

	@PostMapping("/deletarHardware")
	public String deletarHardwareDaCompra(@RequestParam Long idCompra, @RequestParam String nomeHardware)
			throws Exception {
		compraService.removeParte(idCompra, nomeHardware);
		return "redirect:/compra/" + idCompra;
	}

	@PostMapping("/{id}/finalizar")
	public String finalizarCompra(@PathVariable Long id) {
		String resultado = compraService.finalizarCompraPeloId(id);
		return "redirect:/compra/" + id;
	}

	@GetMapping("/carrinho/{id}")
	public String verCarrinho(@PathVariable("id") Long id, Model model) {
		Cliente cliente = compraService.getClienteDaCompra(id);
		if (cliente != null) {
			model.addAttribute("saldoCliente", cliente.verSaldo());
		}
		Compra compra = compraService.getCompraById(id);
		List<Parte> partes = compraService.ListarPartePeloIdCompra(id);
		model.addAttribute("hardwares", partes);
		model.addAttribute("compra", compra);
		return "carrinho";

	}

}