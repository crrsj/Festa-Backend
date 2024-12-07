package br.com.festa.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.festa.entidade.Cliente;
import br.com.festa.enums.Pagamento;

public record ClienteDTO(
		
		Long id,
		String nome,
		String fone,
		String email,
		String endereco,
		@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
		LocalDate dataEvento,
		Double total,
		Pagamento pagamento) {

	public ClienteDTO(Cliente cadastrar) {		
		this(
				cadastrar.getId(),
				cadastrar.getNome(),
				cadastrar.getFone(),
				cadastrar.getEmail(),
				cadastrar.getEndereco(),
				cadastrar.getDataEvento(),
				cadastrar.getTotal(),
				cadastrar.getPagamento());
	}

}
