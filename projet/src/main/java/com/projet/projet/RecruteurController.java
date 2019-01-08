package com.projet.projet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projet.projet.dao.RecruteurDAO;
import com.projet.projet.dao.RecruteurRepository;
import com.projet.projet.entities.Recruteur;

@Controller
@RequestMapping(value="/recruteur")
public class RecruteurController {
	
	@Autowired
	private RecruteurRepository recruteurRepository;
	
	@RequestMapping(value="/this")
	public String index4(Model model){
		 List<Recruteur> list=recruteurRepository.findAll();
		 
		///////////////////////////// list.forEach(e->System.out.println(e.getNom()));
		 model.addAttribute("recruteur", list);
	
		return "recruteurtable";
		
		
	}
	
	
	
	@RequestMapping(value="/index")
	public String index(Model model){
		 List<Recruteur> list=recruteurRepository.findAll();
		 
		///////////////////////////// list.forEach(e->System.out.println(e.getNom()));
		 model.addAttribute("recruteur", list);
	
		return "index_recruteur";
		
		
	}
	
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(Model model,Model m) {
		model.addAttribute("recruteur",new Recruteur());
		List<Recruteur> list=recruteurRepository.findAll();
		m.addAttribute("ops",list);
		return "forms_recruteur";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Recruteur st) {
		recruteurRepository.save(st);
		
		return "redirect:this";
	}
	@RequestMapping(value="supprimer")
	public String supprimer(long id) {
		
		recruteurRepository.delete(id);
		return "redirect:this";
	} 
	@RequestMapping(value="modifierform")
	public String modifier(long id,Model model) {
		
		Recruteur recruteur = recruteurRepository.findOne(id);
		model.addAttribute("recruteur",recruteur);
		return "modifier_recruteur";
	} 
	@RequestMapping(value="/modifier",method=RequestMethod.POST)
	public String modifier(Recruteur st) {
		recruteurRepository.save(st);
		
		return "redirect:this";
	}
	
/*	@RequestMapping(value="/index")
   public ModelAndView getAll(){
	   
	   List<Stagiaire> list=stagiaireDAO.findAll();
	  list.forEach(e->System.out.println(e.getNom()));
	   return new ModelAndView("Stagiaire","stage",list);
	   
   }*/
}
