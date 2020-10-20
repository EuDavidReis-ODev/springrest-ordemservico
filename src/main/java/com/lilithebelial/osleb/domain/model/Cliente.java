package com.lilithebelial.osleb.domain.model;

public class Cliente {
	long id;
	String nome, email, telefone;
		
	public Cliente(long id,String nome,String email,String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.id = id;
	}
	
 	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
