package br.edu.iff.bsi.LojaDeHardware.controller.view;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.bsi.LojaDeHardware.entities.Carteira;
import br.edu.iff.bsi.LojaDeHardware.entities.Cliente;
import br.edu.iff.bsi.LojaDeHardware.entities.Endereco;
import br.edu.iff.bsi.LojaDeHardware.service.CarteiraService;
import br.edu.iff.bsi.LojaDeHardware.service.ClienteService;
import br.edu.iff.bsi.LojaDeHardware.service.EnderecoService;

@Controller
@RequestMapping(path = "/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteServ;
	@Autowired
	EnderecoService enderecoServ;
	@Autowired
	CarteiraService carteiraServ;

	@GetMapping
	public String page() {
		return "cliente";
	}

	@PostMapping("/addCliente")
	@ResponseBody
	public String addPessoa(Cliente cliente, @RequestParam String telefones, @RequestParam String rua,
			@RequestParam int numero, @RequestParam String bairro, @RequestParam String cidade,
			@RequestParam String estado, @RequestParam String cep) throws Exception {

		Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);

		Endereco enderecoSalvo = enderecoServ.addEndereco(endereco);

		Carteira carteira = new Carteira(0);

		Carteira carteiraSalva = carteiraServ.addCarteira(carteira);

		cliente.setCarteira(carteiraSalva);

		cliente.setEndereco(enderecoSalvo);

		cliente.setTelefones(Arrays.asList(telefones.split(",")));

		clienteServ.addCliente(cliente);

		return "Cliente added --> " + cliente.getId();
	}

	@GetMapping("/getCliente")
	@ResponseBody
	public List<Cliente> getClientes() {
		return clienteServ.findAll();
	}

	@GetMapping("/getAllCliente")
	@ResponseBody
	public List<String> getAllClientes() {
		return clienteServ.selectAllInfoCliente();
	}

}