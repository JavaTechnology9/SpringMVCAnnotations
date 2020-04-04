package com.javatechnology.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/me")
	public String getPersonInfo() {
		return "login";
	}
	@RequestMapping("/admin")
	public String getAdminPage() {
		return "home";
	}

}
