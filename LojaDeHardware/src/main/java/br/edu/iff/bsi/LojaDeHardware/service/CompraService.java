package br.edu.iff.bsi.LojaDeHardware.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.bsi.LojaDeHardware.entities.Compra;
import br.edu.iff.bsi.LojaDeHardware.repository.CompraRepository;

@Service
public class CompraService {

	CompraRepository compraRep;
	
	public List<Compra> findByClienteId(@RequestParam Long clienteId){
		try {
	        return compraRep.findByClienteId(clienteId);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList();
	    }
	}
	
}
