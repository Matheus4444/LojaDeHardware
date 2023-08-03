package br.edu.iff.bsi.LojaDeHardware.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.LojaDeHardware.entities.Cliente;
import br.edu.iff.bsi.LojaDeHardware.entities.ListaCompras;
import br.edu.iff.bsi.LojaDeHardware.entities.Parte;
import br.edu.iff.bsi.LojaDeHardware.repository.ListaComprasRepository;

@Service
public class ListaComprasService {

	@Autowired
	private ListaComprasRepository listaComprasRepository;

	public void adicionarParte(Cliente cliente, Parte parte) {
		ListaCompras listaCompras = listaComprasRepository.findByCliente(cliente);
		if (listaCompras == null) {
			listaCompras = new ListaCompras();
			listaCompras.setCliente(cliente);
			listaCompras.setPartes(new ArrayList<>()); // Inicializa a lista de partes
		}
		listaCompras.getPartes().add(parte);
		listaComprasRepository.save(listaCompras);
	}
}
