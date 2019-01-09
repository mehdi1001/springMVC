package com.projet.projet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.projet.projet.dao.StagiaireRepository;
import com.projet.projet.entities.Stagiaire;

@Controller
@RequestMapping(value="/stagiaire")
public class StagiaireController {
	
	@Autowired
	private StagiaireRepository stagiaireRepository;
	@Value("${place.cv}")
	private String cv_candidat;
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
	public String save(Stagiaire st,@RequestParam(name="cv") MultipartFile file) throws IllegalStateException, IOException  {
		
		System.out.println(file.getOriginalFilename());
		st.setCv(st.getNom()+" "+st.getPrenom()+"CV.pdf");
		file.transferTo(new File(cv_candidat+st.getNom()+" "+st.getPrenom()+".pdf"));
		stagiaireRepository.save(st);
		
		return "redirect:form";
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
