package com.lilithebelial.osleb.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lilithebelial.osleb.domain.exception.ClienteDomainException;
import com.lilithebelial.osleb.domain.model.Cliente;
import com.lilithebelial.osleb.domain.repository.ClienteRepository;

@Service
public class CrudClienteService {
	
	@Autowired
	private ClienteRepository cRepo;
	
	/*Salva ou atualiza um cliente no BD*/
	public Cliente salvar(Cliente cliente) {
		verificaEmail(cliente);
		
		
		return cRepo.save(cliente);
	}
	/*Verifica se o email existe no banco de dados, e se existir,
	 *  verifica se não é uma atualização de um cliente já existente.*/
	private void verificaEmail(Cliente cliente) {
		var clienteDB = cRepo.findByEmail(cliente.getEmail());	
		if(clienteDB!=null && !clienteDB.equals(cliente)) {
			throw new ClienteDomainException("Este email já esta sendo usado.");
		}
	}
	/*private void verificaTelefone(Cliente cliente) {
		
	}*/
	
	public void excluir(Long id) {
		cRepo.deleteById(id);
	}
	
	
}
