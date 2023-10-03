package br.edu.iff.bsi.LojaDeHardware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.LojaDeHardware.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(value="SELECT * FROM CLIENTE WHERE CPF = ?1", nativeQuery = true)
	Cliente buscarPeloCPF(String CPF);

	@Query(value="SELECT TELEFONE FROM CLIENTE_TELEFONE JOIN CLIENTE WHERE CPF = ?1 AND TELEFONE = ?2 AND ID = CLIENTE_ID", nativeQuery = true)
	String buscarTelefonePeloCPF(String CPF, String telefone);
	
	@Query(value="SELECT TELEFONE FROM CLIENTE_TELEFONE JOIN CLIENTE WHERE CPF = ?1 AND ID = CLIENTE_ID", nativeQuery = true)
	List<String> ListarTelefonePeloCPF(String CPF);
	
	@Query(value="SELECT * FROM CLIENTE WHERE ID = ?1", nativeQuery = true)
	Cliente BuscarPeloId(Long id);
	
	@Query(value="SELECT CLIENTE.* FROM CLIENTE, COMPRA WHERE ID_CLIENTE=CLIENTE.ID AND COMPRA.ID = ?1", nativeQuery = true)
	Cliente BuscarPeloIdCompra(Long id);

}
