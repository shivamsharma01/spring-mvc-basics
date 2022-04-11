package com.priso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		System.out.println("This is home url");
		return "index";
	}

	@RequestMapping("/new-home")
	public String homeWithModel(Model model) {
		System.out.println("This is new-home url");
		List<String> friends = new ArrayList<>();
		friends.add("Kunal");
		friends.add("Kapil");
		friends.add("Aniket");
		friends.add("Shambhu");
		friends.add("Madhur");
		model.addAttribute("name", "Shivam Sharma");
		model.addAttribute("age", 29);
		model.addAttribute("friends", friends);
		return "index-with-model";
	}

	@RequestMapping("/technologies")
	public ModelAndView tech() {
		System.out.println("Tech page");
		List<String> technologies = new ArrayList<>();
		technologies.add("Angular");
		technologies.add("Spring Boot");
		technologies.add("Devops");
		technologies.add("MongoDB");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Trending Technologies");
		modelAndView.addObject("techs", technologies);
		modelAndView.setViewName("tech-page");
		return modelAndView;
	}
}
