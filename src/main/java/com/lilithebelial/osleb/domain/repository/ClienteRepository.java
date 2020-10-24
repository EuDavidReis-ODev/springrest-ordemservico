package com.lilithebelial.osleb.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lilithebelial.osleb.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
	
	/*findByNome uma ocorrencia que seja exatamento igual o nome passado*/
	List<Cliente> findByNome(String nome);
	
	/*findByNomeContaining procura por alguma ocorrencia que contenha o nome passado*/
	List<Cliente> findByNomeContaining(String nome);
	
	
}
