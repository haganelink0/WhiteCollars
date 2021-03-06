package com.itacademy.botigaCuadres.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) 
public class ResourceNotFound extends Exception {


	private static final long serialVersionUID = 1L;
	
	public ResourceNotFound(Integer id){
        super("the shop with id:" + id + "is not found");
    }

}
