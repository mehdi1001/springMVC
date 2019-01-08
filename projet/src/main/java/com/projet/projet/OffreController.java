package com.projet.projet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projet.projet.dao.OffreDAO;
import com.projet.projet.dao.OffreRepository;
import com.projet.projet.entities.Offre;

@Controller
@RequestMapping(value="/offre")
public class OffreController {
	
	@Autowired
	private OffreRepository offreRepository;
	
	@RequestMapping(value="/this")
	public String index4(Model model){
		 List<Offre> list=offreRepository.findAll();
		 
		///////////////////////////// list.forEach(e->System.out.println(e.getNom()));
		 model.addAttribute("offre", list);
	
		return "offretable";
		
		
	}
	
	@RequestMapping(value="/test")
	public String index2(Model model){
		
		return "index";
		
		
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(Model model,Model m) {
		model.addAttribute("offre",new Offre());
		List<Offre> list=offreRepository.findAll();
		m.addAttribute("ops",list);
		return "forms_offre";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Offre st) {
		offreRepository.save(st);
		
		return "redirect:this";
	}
	@RequestMapping(value="supprimer")
	public String supprimer(long id) {
		
		offreRepository.delete(id);
		return "redirect:this";
	} 
	@RequestMapping(value="modifierform")
	public String modifier(long id,Model model) {
		
		Offre offre = offreRepository.findOne(id);
		model.addAttribute("offre", offre);
		return "modifier_offre";
	} 
	@RequestMapping(value="/modifier",method=RequestMethod.POST)
	public String modifier(Offre st) {
		offreRepository.save(st);
		
		return "redirect:this";
	}
	
/*	@RequestMapping(value="/index")
   public ModelAndView getAll(){
	   
	   List<Stagiaire> list=stagiaireDAO.findAll();
	  list.forEach(e->System.out.println(e.getNom()));
	   return new ModelAndView("Stagiaire","stage",list);
	   
   }*/
}
