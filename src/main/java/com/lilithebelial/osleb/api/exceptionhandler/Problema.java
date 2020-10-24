package com.lilithebelial.osleb.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/*Anotação que diz para incluir apenas as propriedades não nulas.*/
@JsonInclude(Include.NON_NULL)
public class Problema {
 private int status;
 private String titulo;
 private LocalDateTime dataHora;
 
 /*Controla o nome do campo inválido, e uma mensagem sobre o erro*/
 public static class Campo{
	private String campo;
	private String mensagem;
	
	
	public Campo(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	 
 }
 
 
 List<Campo> campos;
 
 Problema(int status,String titulo,LocalDateTime dataHora){
	 this.status = status;
	 this.titulo = titulo;
	 this.dataHora = dataHora;
	 
 }


 public int getStatus() {
	return status;
}

 public void setStatus(int status) {
	this.status = status;
}

 public String getTituto() {
	return titulo;
}

 public void setTituto(String tituto) {
	this.titulo = tituto;
}

 public LocalDateTime getDataHora() {
	return dataHora;
}
 public void setDataHora(LocalDateTime dataHora) {
	this.dataHora = dataHora;
}
 public List<Campo> getCampos() {
	return campos;
}

 public void setCampos(List<Campo> campos) {
	this.campos = campos;
}
 
}
