package br.edu.iff.bsi.LojaDeHardware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.LojaDeHardware.entities.Cliente;
import br.edu.iff.bsi.LojaDeHardware.entities.ListaCompras;

@Repository
public interface ListaComprasRepository extends JpaRepository<ListaCompras, Long> {
	ListaCompras findByCliente(Cliente cliente);
}
