package br.edu.iff.bsi.LojaDeHardware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.LojaDeHardware.entities.Parte;
import br.edu.iff.bsi.LojaDeHardware.repository.ParteRepository;

@Service
public class ParteService {
	
	@Autowired
	ParteRepository parteRep;

	public Parte salvarParte(Parte parte) {
		return parteRep.save(parte);
	}

	public List<Parte> listarPartes() {
		return parteRep.findAll();
	}

	public Parte atualizarParte(Parte parte) {
		if (parte.getId() != null) {
			return parteRep.save(parte);
		} else {
			throw new RuntimeException("Parte inexistente. Primeiro adicione a parte.");
		}
	}

	public void removerParte(Long parteId) {
		parteRep.deleteById(parteId);
	}
	
	public Parte buscarPartePorId(Long id) {
        return parteRep.findById(id).orElse(null);
    }

}
