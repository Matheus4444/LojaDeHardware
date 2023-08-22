package br.edu.iff.bsi.LojaDeHardware.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.bsi.LojaDeHardware.entities.Compra;
import br.edu.iff.bsi.LojaDeHardware.entities.Parte;
import br.edu.iff.bsi.LojaDeHardware.service.CompraService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api/v1/compra")
public class CompraRestController {
	@Autowired
	private CompraService compraServ;

	@PostMapping
	public String addCompra(Long id, String cpf) throws Exception {

		return compraServ.addCompraAPI(id, cpf);

	}

	@GetMapping
	public List<Compra> listarCompras() {
		return compraServ.listarCompras();
	}

	@GetMapping("/{id}")
	public Compra buscarCompraPorId(@PathVariable Long id) {
		return compraServ.getCompraById(id);
	}

	@PutMapping("/{id}")
	public String atualizarCompra(@PathVariable("id") String id, String cpf) throws Exception {
		return compraServ.atualizarCompra(id, cpf);
	}

	@DeleteMapping("/{id}")
	public String deletarCompra(@PathVariable("id") Long id, String nome) throws Exception {
		return compraServ.removeParte(id, nome);
	}

	@PatchMapping("/{id}")
	@ResponseBody
	public String finalizarCompra(@PathVariable("id") Long id) throws Exception {
		return compraServ.finalizarCompraPeloId(id);
	}

	@PostMapping("/{id}/parte")
	@ResponseBody
	@Operation(summary = "Adicionar uma parte em uma compra em expecifíco")
	public String addParte(@PathVariable("id") String id, String titulo) throws Exception {
		return compraServ.addParte(id, titulo);
	}

	@GetMapping("/{id}/parte")
	@ResponseBody
	@Operation(summary = "Listar as partes de uma compra em especifíco")
	public List<Parte> listarPartes(@PathVariable("id") Long id) throws Exception {
		return compraServ.ListarPartePeloIdCompra(id);
	}

	@DeleteMapping("/{id}/parte")
	@ResponseBody
	@Operation(summary = "Deletar um parte em uma compra em expecifíco")
	public String removePartek(@PathVariable("id") Long id, String nome) throws Exception {
		return compraServ.removeParte(id, nome);
	}
}
