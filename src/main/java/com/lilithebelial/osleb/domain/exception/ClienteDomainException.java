package com.lilithebelial.osleb.domain.exception;

public class ClienteDomainException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Exception que trata erros do CRUD clientes.*/
	public ClienteDomainException(String msg) {
		super(msg);
	}

}
