package com.javatechnology.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javatechnology.model.Login;
import com.javatechnology.model.Registration;

@Controller
public class SpringMVCController {
	@RequestMapping("/")
	public String getHOme() {
		return "home";
	}
	@RequestMapping("/login")
	public ModelAndView getLogin() {
		ModelAndView view =new ModelAndView("login");
		view.addObject("login", new Login());
		return view;
	}
	@RequestMapping("/loginProcess")
	public ModelAndView loginProcess(Login login) {
		ModelAndView view =new ModelAndView("welcome");
		System.out.println(login.getUsername());
		view.addObject("login", login);//
		return view;
		
		// Query Parameter
		// Form parameter
		// path variableG
	}
	@RequestMapping("/queryParameter")
	public ModelAndView queryParameter(@RequestParam("id") long id, @RequestParam("name") String name) {
		ModelAndView view =new ModelAndView("home");
		System.out.println(" id value :"+id);
		System.out.println(" name value :"+name);
		return view;
	}
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute(new Registration());
		return "register";
	}
	@RequestMapping("/registerProcess")
	public String registerProcess(@Valid Registration registration,Errors errors) {
		if(errors.hasErrors())
			return "register";
		else {
		/*ModelAndView view =new ModelAndView("home");*/
		System.out.println(" firstname :"+registration.getFirstname());
		System.out.println(" lastname  :"+registration.getLastname());
		return "home";
		}
	}
		
}
