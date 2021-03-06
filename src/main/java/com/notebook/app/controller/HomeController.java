package com.notebook.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/","home"})
public class HomeController
{


	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model)
	{
		model.addAttribute("message", "Hello world!");
		return "index";
	}

	@RequestMapping(value = "form", method = RequestMethod.GET )
	public String formPage(ModelMap model)
	{
		model.addAttribute("message", "Form page");
		return "user-form";
	}
}