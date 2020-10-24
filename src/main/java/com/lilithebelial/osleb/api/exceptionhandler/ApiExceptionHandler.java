package com.lilithebelial.osleb.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lilithebelial.osleb.domain.exception.ClienteDomainException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	/*Trata Exception de dados repetidos do cliente, por enquanto apenas email.*/
	@ExceptionHandler(ClienteDomainException.class)
	public ResponseEntity<Object> handlerCliException(ClienteDomainException ex,WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;

		var problema = geraProblema(ex);
		
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	
	/*Cria e seta o problema.*/
	private Problema geraProblema(ClienteDomainException ex) {
		var status = HttpStatus.BAD_REQUEST;

		var problema = new Problema(status.value(), ex.getMessage(), LocalDateTime.now());
		var campos = new ArrayList<Problema.Campo>();
		
		
		return problema;
	}
	
	/*Metodo que trata Exception quando os argumentos do request são inválidos.*/
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		/*Cria e seta os Campos inválidos*/
		var campos = new ArrayList<Problema.Campo>();
		for(ObjectError e : ex.getBindingResult().getAllErrors()){
			String campo = ((FieldError)e).getField();
			String message = e.getDefaultMessage();
			campos.add(new Problema.Campo(campo,message));
		}
		
		/*Cria e seta Problema*/
		var problema = new Problema(status.value(),
									"Um ou mais campos comtém valores inválidos.",
									LocalDateTime.now());
		problema.setCampos(campos);
	
		
		return super.handleExceptionInternal(ex, problema, headers, status, request);
		}
	
}
