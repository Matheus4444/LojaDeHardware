package br.edu.iff.bsi.LojaDeHardware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.LojaDeHardware.entities.Parte;
import br.edu.iff.bsi.LojaDeHardware.repository.ParteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ParteService {
	@Autowired
	ParteRepository parteRep;

	public String salvarParte(Parte parte) {
		if(parteRep.buscarPeloNome(parte.getNome())!=null) {
			return "Parte já cadastrado";
		}else{
			Parte a = parteRep.save(parte);
			return "Registrado no id "+a.getId();
		}
	}

	public List<Parte> listarPartes() {
		return parteRep.findAll();
	}

	public String atualizarParte(Long id, String nome, double preco, String tipoParte) {
		Parte a = parteRep.BuscarPeloId(id);
		if(a==null) {
			return "Parte não achada";
		}else {		
			if(preco > 0) {
				a.setPreco(preco);
			}
			if(tipoParte !=null) {				
				a.setTipoParte(tipoParte);
			}
			if(nome !=null) {				
				a.setNome(nome);
			}
			parteRep.flush();
			return "Atualizado no id "+a.getId();
		}
	}

	public String removerParte(Long id) {
		Parte a = parteRep.BuscarPeloId(id);
		if(a !=null) {	
			parteRep.delete(a);
			return "Parte deletado no id "+a.getId();
		}else {
			return "Parte não encontrado";
		}
	}
	
	public Parte buscarPartePorId(Long id) {
        return parteRep.findById(id).orElseThrow(() -> new EntityNotFoundException("Parte não encontrado"));
    }

	public List<Parte> listarPartesPorIds(List<Long> ids) {
		return parteRep.findAllById(ids);
	}
	
	public List<Parte> listarPartesPorTipo(String tipo) {
		return parteRep.findByTipoParte(tipo);
	}

	public Parte getParteByNome(String nome) {
		return parteRep.buscarPeloNome(nome);
	}
}
