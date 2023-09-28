	package br.edu.iff.bsi.LojaDeHardware.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.bsi.LojaDeHardware.entities.Cliente;
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
	public String page(Model model) {
		Cliente cliente = new Cliente();
	    model.addAttribute("cliente", cliente);
		return "cliente";
	}

	@GetMapping("/crud")
	public String page2(Model model) {
		List<Cliente> clientes = clienteServ.listarClientes();
		model.addAttribute("clientes", clientes);
		return "listarClientes";
	}

	@PostMapping("/addCliente")
	@ResponseBody
	public String addPessoa(Cliente cliente) {

		return clienteServ.addCliente(cliente);
	}

	@GetMapping("/getCliente")
	@ResponseBody
	public List<Cliente> getClientes() {
		return clienteServ.listarClientes();
	}

	@PostMapping("/buscaCPF")
	@ResponseBody
	public String buscarClienteCPF(String cpf) throws Exception {
		return clienteServ.buscarClienteCPF(cpf);
	}

	@GetMapping("/alterar")
	public String showAlterarClienteForm(@RequestParam Long id, Model model) {
		Cliente cliente = clienteServ.buscarPeloID(id);
		if (cliente != null) {
			model.addAttribute("cliente", cliente);
			return "alterarCliente";
		} else {
			return "clienteNaoEncontrado";
		}
	}

	@PostMapping("/updateCliente")
	public String updateCliente(@RequestParam String cpf, String nome, String email, String password, String telefone, double novoSaldo) {
		clienteServ.atualizarCliente(cpf, nome, email, password, telefone, novoSaldo);
		return "sucesso";
		
	}

	@PostMapping("/deleteCliente")
	@ResponseBody
	public String deleteCliente(@RequestParam Long id) {
		return clienteServ.deletarCliente(id);

	}

	@PostMapping("/listarTelefones")
	@ResponseBody
	public List<String> listarTelefones(String cpf) throws Exception {
		return clienteServ.ListarTelefonePeloCPF(cpf);
	}

	@PostMapping("/addTelefone")
	@ResponseBody
	public String addTelefone(String cpf, String telefone) throws Exception {
		return clienteServ.addTelefone(cpf, telefone);
	}

	@PostMapping("/removeTelefone")
	@ResponseBody
	public String removeTelefone(String cpf, String telefone) throws Exception {
		return clienteServ.removeTelefone(cpf, telefone);
	}

	@PostMapping("/getSaldo")
	@ResponseBody
	public String verSaldo(String cpf) throws Exception {
		double saldo = clienteServ.getSaldo(cpf);
		if (saldo == -1) {
			return "Cliente não encontrado";
		} else {
			return "Saldo: R$" + saldo;
		}
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}