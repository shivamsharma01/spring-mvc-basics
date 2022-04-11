package com.priso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {

	@RequestMapping("/initial-null")
	public String initialPage() {
		String x = null;
		x.length(); // generating a null pointer exception and it will be handled by
					// expectionHandlerNull method
		return "index";
	}

	@RequestMapping("/initial-index")
	public String initialPage2() {
		String[] arr = new String[] {};
		arr[2] = "";
		return "index";
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ NullPointerException.class, NumberFormatException.class })
	public String exceptionHandlerNull(Model model) {
		model.addAttribute("errMsg", "Null Pointer Exception");
		return "null_page";
	}

}
