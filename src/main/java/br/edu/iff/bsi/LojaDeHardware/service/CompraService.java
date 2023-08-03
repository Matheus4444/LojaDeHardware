package br.edu.iff.bsi.LojaDeHardware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.LojaDeHardware.entities.Compra;
import br.edu.iff.bsi.LojaDeHardware.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	CompraRepository CompraRep;

	public Compra salvarCompra(Compra compra) {
		return CompraRep.save(compra);
	}

	public Compra atualizarCompra(Compra compra) {
		if (compra.getId() != null) {
			return CompraRep.save(compra);
		} else {
			throw new RuntimeException("Compra inexistente. Primeiro adicione a compra.");
		}
	}

	public void removerCompra(Long compraId) {
		CompraRep.deleteById(compraId);
	}

	public List<Compra> listarCompras() throws Exception {
		return CompraRep.findAll();
	}

	public Compra buscarPeloID(Long id) {
		return CompraRep.BuscarPeloId(id);
	}

	public void flush() {
		CompraRep.flush();
	}

	public void deletarCompra(Compra compra) {
		CompraRep.delete(compra);
	}

	public Long buscarPeloIDCliente(Long id) {
		return CompraRep.BuscarPeloIdCliente(id);
	}
	
}
