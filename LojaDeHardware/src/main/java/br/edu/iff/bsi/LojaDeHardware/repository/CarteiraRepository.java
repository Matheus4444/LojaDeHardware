package br.edu.iff.bsi.LojaDeHardware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.LojaDeHardware.entities.Carteira;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long>{

}
