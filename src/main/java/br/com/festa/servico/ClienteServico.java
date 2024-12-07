package br.com.festa.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.festa.DTO.ClienteDTO;
import br.com.festa.entidade.Cliente;
import br.com.festa.repositorio.Clienterepositorio;

@Service
public class ClienteServico {
	
	@Autowired
	private Clienterepositorio clienterepositorio;

	public Cliente cadastrarCliente(ClienteDTO clienteDTO) {		
		var cadastro = new Cliente(clienteDTO);
		return clienterepositorio.save(cadastro);
		
	}
	
	public List<Cliente>listarClientes(){
		return clienterepositorio.findAll();
	}
	
	public Cliente buscarPorId(Long id) {
		Optional<Cliente>buscar = clienterepositorio.findById(id);
		return buscar.get();
	}
	
	public Cliente atualizarCliente(ClienteDTO clienteDTO) {
		var atualizar = new Cliente(clienteDTO);
		return clienterepositorio.save(atualizar);
	}
	
	public void excluir(Long id) {
		clienterepositorio.deleteById(id);
	}
	
	public List<Cliente>buscarPorNome(String nome){
		return clienterepositorio.findByNome(nome.trim().toUpperCase());
	}
}
