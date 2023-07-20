package br.edu.iff.bsi.LojaDeHardware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.LojaDeHardware.entities.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	  @Query(value = "SELECT * FROM Compra WHERE cliente_id = :clienteId", nativeQuery = true)
	    List<Compra> findByClienteId(Long clienteId);
	
}
