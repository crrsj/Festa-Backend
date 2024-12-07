package br.com.festa.entidade;

import java.time.LocalDate;

import br.com.festa.DTO.ClienteDTO;
import br.com.festa.enums.Pagamento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name ="tb_clientes")
@Data
@NoArgsConstructor
public class Cliente {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String fone;
	private String email;
	private String endereco;
	private LocalDate dataEvento;
	private Double total;
	private Pagamento pagamento;
	
	public Cliente(ClienteDTO clienteDTO) {
		this.id = clienteDTO.id();
		this.nome = clienteDTO.nome();
		this.fone = clienteDTO.fone();
		this.email = clienteDTO.email();
		this.endereco = clienteDTO.endereco();
		this.dataEvento = clienteDTO.dataEvento();
		this.total = clienteDTO.total();
		this.pagamento = clienteDTO.pagamento();
	}
}
