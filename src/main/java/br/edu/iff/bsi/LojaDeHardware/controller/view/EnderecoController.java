package br.edu.iff.bsi.LojaDeHardware.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.bsi.LojaDeHardware.entities.Endereco;
import br.edu.iff.bsi.LojaDeHardware.service.EnderecoService;

@Controller
public class EnderecoController {
	@Autowired
	EnderecoService enderecoServ;

	@PostMapping("/addEndereco")
	@ResponseBody
	public String addPessoa(Endereco endereco) throws Exception {
		Endereco e = enderecoServ.addEndereco(endereco);
		return "Endereco add --> " + e.enderecoFormatado();

	}

	@PutMapping("/editarEndereco/{id}")
	@ResponseBody
	public String editarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
		Endereco enderecoExistente = enderecoServ.getEnderecoPorId(id);
		if (enderecoExistente == null) {
			return "Endereco não encontrado.";
		}
		enderecoExistente.setRua(endereco.getRua());
		enderecoExistente.setNumero(endereco.getNumero());
		enderecoExistente.setBairro(endereco.getBairro());
		enderecoExistente.setCidade(endereco.getCidade());
		enderecoExistente.setEstado(endereco.getEstado());
		enderecoExistente.setCep(endereco.getCep());
		enderecoServ.addEndereco(enderecoExistente);
		return "Endereco editado.";
	}

	@DeleteMapping("/excluirEndereco/{id}")
	@ResponseBody
	public String excluirEndereco(@PathVariable Long id) {
		enderecoServ.removerEndereco(id);
		return "Endereco excluído.";
	}

	@GetMapping("/getEndereco")
	@ResponseBody
	public List<Endereco> getEndereco() {
		return enderecoServ.getEndereco();
	}

}