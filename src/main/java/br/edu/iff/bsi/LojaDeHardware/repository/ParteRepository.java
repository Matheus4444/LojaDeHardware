package br.edu.iff.bsi.LojaDeHardware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.LojaDeHardware.entities.Parte;

@Repository
public interface ParteRepository extends JpaRepository<Parte, Long> {
		@Query(value="SELECT * FROM PARTE WHERE NOME = ?1", nativeQuery = true)
	Parte buscarPeloNome(String nome);
	
	@Query(value="SELECT * FROM PARTE WHERE ID = ?1", nativeQuery = true)
	Parte BuscarPeloId(Long id);
	
	@Query(value="SELECT E.* FROM PARTE E, ASSOCIACAO_COMPRA_PRODUTO CP WHERE E.ID = CP.FK_PRODUTO AND CP.FK_COMPRA = ?1", nativeQuery = true)
	List<Parte> ListarPartePeloIdCompra(Long id);
	
	List<Parte> findByTipoParte(String tipo);
}
