package com.projet.projet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projet.projet.dao.StagiaireRepository;
import com.projet.projet.entities.Stagiaire;

@Controller
@RequestMapping(value="/stagiaire")
public class StagiaireController {
	
	@Autowired
	private StagiaireRepository stagiaireRepository;
	
	@RequestMapping(value="/this")
	public String index4(Model model){
		 List<Stagiaire> list=stagiaireRepository.findAll();
		 
		///////////////////////////// list.forEach(e->System.out.println(e.getNom()));
		 model.addAttribute("stagiaire", list);
	
		return "stagiairetable";	
	}
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(Model model,Model m) {
		model.addAttribute("stagiaire",new Stagiaire());
		List<Stagiaire> list=stagiaireRepository.findAll();
		m.addAttribute("ops",list);
		return "index";
	}
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(Model model,Model m) {
		model.addAttribute("stagiaire",new Stagiaire());
		List<Stagiaire> list=stagiaireRepository.findAll();
		m.addAttribute("ops",list);
		return "forms";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Stagiaire st) {
		stagiaireRepository.save(st);
		
		return "redirect:index";
	}
	@RequestMapping(value="supprimer")
	public String supprimer(long id) {
		
		stagiaireRepository.delete(id);
		return "redirect:index";
	} 
	@RequestMapping(value="modifierform")
	public String modifier(long id,Model model) {
		
		Stagiaire stagiaire = stagiaireRepository.findOne(id);
		model.addAttribute("stagiaire", stagiaire);
		return "modifier";
	} 
	@RequestMapping(value="/modifier",method=RequestMethod.POST)
	public String modifier(Stagiaire st) {
		stagiaireRepository.save(st);
		
		return "redirect:index";
	}
	
/*	@RequestMapping(value="/index")
   public ModelAndView getAll(){
	   
	   List<Stagiaire> list=stagiaireDAO.findAll();
	  list.forEach(e->System.out.println(e.getNom()));
	   return new ModelAndView("Stagiaire","stage",list);
	   
   }*/
}
