package br.edu.iff.bsi.LojaDeHardware.controller.view;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.bsi.LojaDeHardware.entities.Compra;
import br.edu.iff.bsi.LojaDeHardware.service.CompraService;

@Controller
@RequestMapping(path = "/compra")

public class CompraController {

	@Autowired
	CompraService compraServ;

	@GetMapping("/getCompras")
	@ResponseBody
	public List<Compra> getCompras(@RequestParam Long clienteId) {
		try {
			return compraServ.findByClienteId(clienteId);
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}