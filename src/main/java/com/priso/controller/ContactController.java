package com.priso.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

	@RequestMapping("/contact")
	public String showForm() {
		System.out.println("Contact Page");
		return "contact";
	}

	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@RequestParam("email") String email, @RequestParam("username") String username,
			@RequestParam("userpassword") String password, Model model) {
		/*
		 * or public String processForm(HttpServletRequest request) {
		 * request.getParameter("email") request.getParameter("username")
		 * request.getParameter("password")
		 */
		System.out.println("Form Process Handler");
		System.out.println(String.format("%s %s %s", email, username, password));
		model.addAttribute("email", email);
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		return "success";
	}
}
