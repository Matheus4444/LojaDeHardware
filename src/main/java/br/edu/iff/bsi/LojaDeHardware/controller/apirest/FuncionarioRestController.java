package br.edu.iff.bsi.LojaDeHardware.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.bsi.LojaDeHardware.entities.Funcionario;
import br.edu.iff.bsi.LojaDeHardware.service.FuncionarioService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/v1/funcionario")
@Tag(name = "Funcionários", description = "")
public class FuncionarioRestController {
	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioService.addFuncionario(funcionario);
		return funcionario;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
	    Funcionario func = funcionarioService.findById(id);

	    if (func == null) {	        
	        return null;
	    }	    
	    func.setNome(funcionario.getNome());
	    func.setEmail(funcionario.getEmail());
	    func.setPassword(funcionario.getPassword());
	    func.setCpf(funcionario.getCpf());	    
	    func = funcionarioService.updateFuncionario(func);

	    return func;
	}


	@DeleteMapping("/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String deletarFuncionarioPor(@PathVariable Long id) {
		Funcionario fBusca = funcionarioService.findById(id);
		if (fBusca == null) {
			return "Funcionario não encontrado";
		} else {
			funcionarioService.deleteFuncionario(fBusca.getCpf());
			return "funcionário excluído";
		}
	}

	@GetMapping("")
	public List<Funcionario> listarFuncionarios() throws Exception {
		return funcionarioService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Funcionario buscarFuncionarioId(@PathVariable("id") Long id) throws Exception {
		return funcionarioService.findById(id);
	}
}
