package br.edu.iff.bsi.LojaDeHardware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.LojaDeHardware.entities.Funcionario;
import br.edu.iff.bsi.LojaDeHardware.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	FuncionarioRepository funcionarioRep;

	public void addFuncionario(Funcionario funcionario) {
		funcionarioRep.save(funcionario);
	}

	public Funcionario findById(Long id) {
		return funcionarioRep.findById(id).orElse(null);
	}
	
	public Funcionario findByCpf(String cpf) {
		return funcionarioRep.buscarPeloCPF(cpf);
	}

	public List<Funcionario> findAll() {
		return funcionarioRep.findAll();
	}

	public Funcionario updateFuncionario(Funcionario funcionario) {
        if (funcionario.getId() != null) {
            return funcionarioRep.save(funcionario);
        } else {
            throw new RuntimeException("Funcionário inexistente. Primeiro adicione o funcionário.");
        }
    }

    public String deleteFuncionario(String cpf) {
    	Funcionario f = funcionarioRep.buscarPeloCPF(cpf);
		if(f!=null) {	
			funcionarioRep.delete(f);
			return "Funcionario deletado no id "+f.getId();
		}else {
			return "Funcionario não encontrado";
		}
    }
}
