package com.priso.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.priso.model.Contact;
import com.priso.model.User;
import com.priso.service.UserService;

@Controller
public class ContactController {

	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy:H:mm");
	@Autowired
	private UserService service;

	@ModelAttribute
	private void commonData(Model model) {
		System.out.println("Adding common data to the model object");
		model.addAttribute("date", dateFormatter.format(new Date()));
	}

	@RequestMapping("/contact-requestparam")
	public String showForm() {
		System.out.println("Contact Page RequestParam");
		return "contact-view-to-controller-RequestParam";
	}

	@RequestMapping("/contact-modelattribute")
	public String showForm2() {
		System.out.println("Contact Page ModelAttribute");
		return "contact-view-to-controller-ModelAttribute";
	}

	@RequestMapping(path = "/processform-RequestParam", method = RequestMethod.POST)
	public String handleForm(@RequestParam("email") String email, @RequestParam("username") String username,
			@RequestParam("userpassword") String password, Model model) {
		/*
		 * or public String processForm(HttpServletRequest request) {
		 * request.getParameter("email") request.getParameter("username")
		 * request.getParameter("password")
		 */
		System.out.println("Form Process Handler RequestParam");
		System.out.println(String.format("%s %s %s", email, username, password));
		model.addAttribute("email", email);
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		return "success-RequestParam";
	}

	@RequestMapping(path = "/processform-ModelAttribute", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model) {
		System.out.println("Form Process Handler ModelAttribute");
		// because of using @ModelAttribute annotation and declaring the type
		// spring implicitly sets model.addAttribute("user", user);
		// in the jsp properties can be accessed even when they are private
		model.addAttribute("id", service.createUser(user));
		return "success-ModelAttribute";
	}

	@RequestMapping(path = "/contact-details")
	public String contactForm() {
		System.out.println("contact Form Handler BindingResult");
		return "form-to-check-binding-result";
	}

	@RequestMapping(path = "/process-form-binding-result", method = RequestMethod.POST)
	public String handleContactForm(@ModelAttribute("contact") Contact contact, BindingResult bindingResult) {
		System.out.println("handleContactForm Handler BindingResult");
		if (bindingResult.hasErrors())
			return "error-invalid-field-value";
		return "success-contact-form";
	}
}
