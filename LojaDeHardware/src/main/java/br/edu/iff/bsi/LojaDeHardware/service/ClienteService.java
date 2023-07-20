package br.edu.iff.bsi.LojaDeHardware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.LojaDeHardware.entities.Cliente;
import br.edu.iff.bsi.LojaDeHardware.repository.ClienteRepository;
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public void addCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public List<String> selectAllInfoCliente() {
		return clienteRepository.selectAllInfoCliente();
	}

}
