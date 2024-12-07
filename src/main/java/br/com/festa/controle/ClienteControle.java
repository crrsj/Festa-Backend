package br.com.festa.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.festa.DTO.ClienteDTO;
import br.com.festa.servico.ClienteServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/festa")
@CrossOrigin(origins = "*")
public class ClienteControle {
	
	@Autowired
	private ClienteServico clienteServico;
	
	
	@PostMapping
	@Operation(summary = "Endpoint responsável por cadastrar clientes.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ClienteDTO>cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO ){
	  var cadastrar = clienteServico.cadastrarCliente(clienteDTO);
	  var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
	  buildAndExpand(cadastrar.getId()).toUri();
	  return ResponseEntity.created(uri).body(new ClienteDTO(cadastrar));
		
	}
	
	@GetMapping
	@Operation(summary = "Endpoint responsável por buscar Todos os clientes.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<ClienteDTO>>buscsrClientes(){
		var lista = clienteServico.listarClientes();
		return ResponseEntity.ok().body(lista.stream().map(ClienteDTO::new).toList());
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável por buscar cliente pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ClienteDTO>buscarPórId(@PathVariable Long id){
		var busca = clienteServico.buscarPorId(id);
		return ResponseEntity.ok().body(new ClienteDTO(busca));
		
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por deletar cliente.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		clienteServico.excluir(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("buscarNome")
	@Operation(summary = "Endpoint responsável por  buscar cliente pelo nome.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<ClienteDTO>>buscarPorNome(@RequestParam("nome") String nome){
		var busca = clienteServico.buscarPorNome(nome);
		return ResponseEntity.ok().body(busca.stream().map(ClienteDTO::new).toList());
		
	}
	
	@PutMapping
	@Operation(summary = "Endpoint responsável por atualizar cliente.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ClienteDTO>atualizarCliente(@RequestBody @Valid ClienteDTO clienteDTO){
		var atualizar = clienteServico.atualizarCliente(clienteDTO);
		return ResponseEntity.ok().body(new ClienteDTO(atualizar));
	}
}
