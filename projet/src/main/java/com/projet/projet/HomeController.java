package com.projet.projet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {

	
	@GetMapping(value="/")
	public String home() {
		
		return "index_page";
	}
	@GetMapping(value="/login")
	public String log() {
		
		return "login";
	}
	
}
