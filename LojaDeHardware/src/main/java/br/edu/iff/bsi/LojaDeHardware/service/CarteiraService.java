package br.edu.iff.bsi.LojaDeHardware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.LojaDeHardware.entities.Carteira;
import br.edu.iff.bsi.LojaDeHardware.repository.CarteiraRepository;

@Service
public class CarteiraService {
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	public Carteira addCarteira(Carteira carteira) {
		return carteiraRepository.save(carteira);
	}

}
