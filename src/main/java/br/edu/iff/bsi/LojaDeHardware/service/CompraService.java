package br.edu.iff.bsi.LojaDeHardware.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.bsi.LojaDeHardware.entities.Cliente;
import br.edu.iff.bsi.LojaDeHardware.entities.Compra;
import br.edu.iff.bsi.LojaDeHardware.entities.Parte;
import br.edu.iff.bsi.LojaDeHardware.repository.ClienteRepository;
import br.edu.iff.bsi.LojaDeHardware.repository.CompraRepository;
import br.edu.iff.bsi.LojaDeHardware.repository.ParteRepository;

@Service
public class CompraService {

	@Autowired
	private ClienteRepository clienteRep;

	@Autowired
	private CompraRepository compraRep;
	@Autowired
	private ParteRepository parteRep;

	public String addCompra(String cpf) {
		Cliente cl = clienteRep.buscarPeloCPF(cpf);
		if (cl == null) {
			return "Cliente não achado";
		} else {
			Compra compra = new Compra(cpf);
			cl.adicionarCompra(compra);
			Compra c = compraRep.save(compra);
			clienteRep.flush();
			return "Registrado no id " + c.getId();
		}
	}

	public String addCompraAPI(Long id, String cpf) {
		Cliente cl = clienteRep.buscarPeloCPF(cpf);
		if (cl == null) {
			return "Cliente não achado";
		} else {
			Compra compra = new Compra(cpf);
			cl.adicionarCompra(compra);
			Compra c = compraRep.save(compra);
			clienteRep.flush();
			return "Registrado no id " + c.getId();
		}
	}

	public String atualizarCompra(String idCompra, String cpf) {
		Compra c = compraRep.BuscarPeloId(Long.parseLong(idCompra));
		if (c == null) {
			return "Compra não achada";
		} else {
			if (c.isFinalizado()) {
				return "Compra já finalizada";
			} else {
				if (cpf != null) {
					Cliente cl = clienteRep.buscarPeloCPF(cpf);
					if (cl == null) {
						return "Cliente não achado";
					} else {
						c.setCpfCliente(cpf);
						cl.adicionarCompra(c);
						clienteRep.flush();
					}
				}
				compraRep.flush();
				return "Atualizado no id " + c.getId();
			}
		}
	}

	public String deletarCompra(Long idCompra) {
		Compra c = compraRep.BuscarPeloId(idCompra);
		if (c == null) {
			return "Compra não achada";
		} else {
			Long idCliente = compraRep.BuscarPeloIdCliente(idCompra);
			Cliente cl = clienteRep.BuscarPeloId(idCliente);
			if (cl == null) {
				return "Cliente não achado";
			} else {
				cl.removerCompra(c);
				clienteRep.flush();
			}

			compraRep.delete(c);
			return "Deletado no id " + c.getId();
		}
	}

	public List<Compra> listarCompras() {
		return compraRep.findAll();
	}

	public String addParte(String idCompra, String nome) {
		Compra c = compraRep.BuscarPeloId(Long.parseLong(idCompra));
		if (c == null) {
			return "Compra não encontrada";
		} else {
			if (c.isFinalizado()) {
				return "Compra já finalizada";
			} else {
				Parte a = parteRep.buscarPeloNome(nome);
				if (a == null) {
					return "Parte não encontrado";
				} else {
					if (compraRep.verificarParteCompra(a.getId(), c.getId()) != 0) {
						return "Parte já cadastrado";
					} else {
						c.adicionarParte(a);
						compraRep.flush();
						return "Parte adicionada";
					}
				}
			}
		}
	}

	public String removeParte(Long idCompra, String nome) {
		Compra c = compraRep.BuscarPeloId(idCompra);
		if (c == null) {
			return "Compra não encontrada";
		} else {
			Parte a = parteRep.buscarPeloNome(nome);
			if (a == null) {
				return "Parte não encontrado";
			} else {
				if (compraRep.verificarParteCompra(a.getId(), c.getId()) == 0) {
					return "Parte não consta na compra";
				} else {
					c.removerParte(a);
					compraRep.flush();
					return "Parte removido";
				}
			}
		}
	}

	public String finalizarCompraPeloId(Long idCompra) {
		Compra c = compraRep.BuscarPeloId(idCompra);
		if (c == null) {
			return "Compra não encontrada";
		} else {
			if (c.isFinalizado()) {
				return "Compra já finalizada";
			} else {
				if (c.getQtdPartes() == 0) {
					return "A compra precisa ter no mínimo 1 produto.";
				} else {
					Cliente cl = clienteRep.BuscarPeloIdCompra(c.getId());
					if (cl.verSaldo() < c.getPrecoFinal()) {
						return "Saldo do cliente não é o suficiente";
					} else {
						cl.removerSaldo(c.getPrecoFinal());
						c.finalizar();
						compraRep.flush();
						clienteRep.flush();
						return "Compra finalizada com sucesso";
					}
				}
			}
		}
	}
	

	public Compra getCompraById(Long id) {
		return compraRep.BuscarPeloId(id);
	}
	
	public List<Parte> ListarPartePeloIdCompra(Long id){
		return parteRep.ListarPartePeloIdCompra(id);
	}
	
}
