package com.priso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ ArrayIndexOutOfBoundsException.class })
	public String exceptionHandlerIndex(Model model) {
		model.addAttribute("errMsg", "Array Index Out Of Bound Exception");
		return "null_page";
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ Exception.class })
	public String exceptionHandlerGeneric(Model model) {
		model.addAttribute("errMsg", "An Exception occurred");
		return "null_page";
	}
}
