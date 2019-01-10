package com.projet.projet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.projet.dao.CandidatRepository;
import com.projet.projet.dao.RecruteurRepository;
import com.projet.projet.entities.Candidat;



@Controller
public class HomeController {

	@Autowired 
	CandidatRepository candidatRepository;
	@Autowired
	RecruteurRepository Recruteurepository;
	@GetMapping(value="/")
	public String home() {
		
		return "index_page";
	}
	@RequestMapping(value="/login")
	public String log(Model model) {
		model.addAttribute("candidat",new Candidat());
		return "login_rec";
	}
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public String login(Candidat st) {
		List<Candidat> liste = candidatRepository.searchname(st.getEmail(), st.getPassword());
		System.out.println(liste);
      if(liste.isEmpty())
      {return "login_rec";}
      else return "redirect:candidat/this";
	}
	
}
