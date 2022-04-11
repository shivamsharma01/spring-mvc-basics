package com.priso.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReController {

	@RequestMapping("/invalid-servletresponse")
	public void invalidUsingHttpServletResponse(HttpServletRequest req, HttpServletResponse response) {
		// this approach is not recommended
		System.out.println("invalidUsingHttpServletResponse route handler");
		try {
			response.sendRedirect("home");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/invalid-prefix")
	public String invalidUsingPrefix() {
		System.out.println("invalidUsingPrefix route handler");
		return "redirect:/home";
	}

	@RequestMapping("/invalid-redirectview")
	public RedirectView invalidUsingRedirectView() {
		System.out.println("invalidUsingRedirectView route handler");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("home"); // or any external link wwww.google.com
		return redirectView;
	}

}
