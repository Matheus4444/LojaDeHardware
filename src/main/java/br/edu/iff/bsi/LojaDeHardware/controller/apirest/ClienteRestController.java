package br.edu.iff.bsi.LojaDeHardware.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.bsi.LojaDeHardware.entities.Carteira;
import br.edu.iff.bsi.LojaDeHardware.entities.Cliente;
import br.edu.iff.bsi.LojaDeHardware.entities.Endereco;
import br.edu.iff.bsi.LojaDeHardware.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(path = "/api/v1/cliente")
public class ClienteRestController {
	@Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public String addCliente(String nome, String email, String cpf, String password, Endereco endereco, Carteira carteira,
			String telefone) {
    	return clienteService.addCliente(new Cliente(nome, email, cpf, password, endereco, carteira, telefone));
    	
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente cli = clienteService.buscarPeloID(id);

        if (cli == null) {
            return null;
        }

        cli.setNome(cliente.getNome());
        cli.setEmail(cliente.getEmail());
        cli.setPassword(cliente.getPassword());
        cli.setCpf(cliente.getCpf());

        clienteService.addCliente(cli);

        return cli;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String deletarClientePor(@PathVariable Long id) {
        Cliente cBusca = clienteService.buscarPeloID(id);
        if (cBusca == null) {
            return "Cliente não encontrado";
        } else {
            clienteService.deletarCliente(cBusca.getCpf());
            return "cliente excluído";
        }
    }

    @GetMapping("")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> buscarClienteId(@PathVariable("id") Long id) {
        try {
            Cliente cliente = clienteService.buscarPeloID(id);
            return ResponseEntity.ok(cliente);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{id}/telefones")
	@ResponseBody
	@Operation(summary = "Listar os telefones de um cliente em expecifíco")
	public List<String> listarTelefones(@PathVariable("id") Long id) throws Exception {
		return clienteService.ListarTelefonePeloCPF(clienteService.buscarPeloID(id).getCpf());
	}
	
	@PostMapping("/{id}/telefones")
	@ResponseBody
	@Operation(summary = "Adicionar um telefone em um cliente em expecifíco")
	public String addTelefone(@PathVariable("id") Long id, String telefone) throws Exception {
		Cliente cBusca = clienteService.getClienteById(id);
		if(cBusca==null) {			
			return "Cliente não achado";
		}else {			
			return clienteService.addTelefone(cBusca.getCpf(), telefone);
		}
	}
	
	@DeleteMapping("/{id}/telefones")
	@ResponseBody
	@Operation(summary = "Deletar um telefone em um cliente em expecifíco")
	public String removeTelefone(@PathVariable("id") Long id, String telefone) throws Exception {
		Cliente cBusca = clienteService.getClienteById(id);
		if(cBusca==null) {			
			return "Cliente não achado";
		}else {			
			return clienteService.removeTelefone(cBusca.getCpf(), telefone);
		}
	}
    
    @PostMapping("/{id}/carteira")
	@ResponseBody
	@Operation(summary = "Adicionar saldo em um cliente em expecifíco")
	public String adicionarSaldo(@PathVariable("id") Long id, String saldo) throws Exception {
		return clienteService.adcionarSaldo(clienteService.buscarPeloID(id).getCpf(), saldo);
	}
	
	@GetMapping("/{id}/carteira")
	@ResponseBody
	@Operation(summary = "Retornar o saldo de um cliente em expecifíco")
	public double verSaldo(@PathVariable("id") Long id) throws Exception {
		return clienteService.getSaldo(clienteService.buscarPeloID(id).getCpf());
	}
}
