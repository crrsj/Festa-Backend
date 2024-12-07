package br.com.festa.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.festa.entidade.Cliente;
import br.com.festa.enums.Pagamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteDTO(
		
		Long id,
		@NotBlank(message = "não pode estar em branco !")
		String nome,
		@NotBlank(message = "não pode estar em branco !")
		String fone,
		@Email
		String email,
		@NotBlank(message = "não pode estar em branco !")
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
