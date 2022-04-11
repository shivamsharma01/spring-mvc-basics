package com.priso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InterceptorController {

	@RequestMapping("/home-for-interceptor")
	public String handleHome() {
		return "home-for-interceptor";
	}

	@RequestMapping("/welcome")
	public String handleWelcome(@RequestParam("user") String username, Model model) {
		model.addAttribute("name", username);
		return "welcome";
	}
}
