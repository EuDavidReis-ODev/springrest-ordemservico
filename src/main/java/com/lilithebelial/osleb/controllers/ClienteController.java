package com.lilithebelial.osleb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lilithebelial.osleb.domain.model.Cliente;
@RestController
public class ClienteController {
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente c1 = new Cliente(99999983,"Marcos Silva","marcos@silva.com","1236412278");
		Cliente c2 = new Cliente(93599983,"Alan Pereira","alan@pereira.com","1244236577");
		Cliente c3 = new Cliente(19934923,"Oswaldo Silva","marcos@silva.com","1536457851");

		
		return Arrays.asList(c1,c2,c3);
	}


}
