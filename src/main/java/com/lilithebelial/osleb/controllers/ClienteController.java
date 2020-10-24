package com.lilithebelial.osleb.controllers;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.lilithebelial.osleb.domain.model.Cliente;
import com.lilithebelial.osleb.domain.repository.ClienteRepository;
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	/*Retorna lista com todos os clientes*/
	@GetMapping
	public List<Cliente> listar() {
		
		return clienteRepository.findAll();
		
		//return clienteRepository.findByNomeContaining("rcos");
	}

	/*Retorna cliente especifico, usando como referencia o Id*/
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	/*Adiciona um cliente,convertendo o body do request em um objeto Cliente*/
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente addCliente(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	/*Atualiza um cliente, identificando pelo ID que vem no path da requisição, e o responseBody=>Cliente*/
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id,@Valid @RequestBody Cliente cliente) {
	
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id);
		clienteRepository.save(cliente);
		
		return ResponseEntity.ok(cliente);
	}

	/*Exclui o cliente com base no ID passado na requisição*/
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> deletaCliente(@PathVariable Long clienteId) {
		
		
		if(!clienteRepository.existsById(clienteId)){
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(clienteId);
		return ResponseEntity.noContent().build();
	}
}
