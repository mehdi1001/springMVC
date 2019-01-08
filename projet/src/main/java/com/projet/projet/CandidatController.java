package com.projet.projet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projet.projet.dao.CandidatDAO;
import com.projet.projet.dao.CandidatRepository;
import com.projet.projet.dao.CategorieRepository;
import com.projet.projet.entities.Candidat;
import com.projet.projet.entities.Categorie;
import com.projet.projet.entities.Stagiaire;

@Controller
@RequestMapping(value = "/candidat")
public class CandidatController {

	@Autowired
	private CandidatRepository candidatRepository;
	@Autowired 
	private CategorieRepository categorieRepository;
	
	

	@RequestMapping(value = "/this")
	public String index4(Model model) {
		List<Candidat> list = candidatRepository.findAll();

		///////////////////////////// list.forEach(e->System.out.println(e.getNom()));
		model.addAttribute("candidat", list);

		return "candidattable";

	}

	@RequestMapping(value = "/index")
	public String index(Model model) {
		List<Candidat> list = candidatRepository.findAll();

		///////////////////////////// list.forEach(e->System.out.println(e.getNom()));
		model.addAttribute("candidat", list);

		return "index_candidat";

	}

	@RequestMapping(value = "/test")
	public String index2(Model model) {

		return "index";

	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model, Model m) {
		model.addAttribute("candidat", new Candidat());
		List<Candidat> list = candidatRepository.findAll();
		m.addAttribute("ops", list);
		return "forms_candidat";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Candidat st) {
		st.setCategorie("recue");
		candidatRepository.save(st);

		return "redirect:this";
	}

	@RequestMapping(value = "supprimer")
	public String supprimer(long id) {

		candidatRepository.delete(id);
		return "redirect:this";
	}

	@RequestMapping(value = "modifierform")
	public String modifier(long id, Model model) {

		Candidat candidat = candidatRepository.findOne(id);
		model.addAttribute("candidat", candidat);
		return "modifier_candidat";
	}

	@RequestMapping(value = "/modifier", method = RequestMethod.POST)
	public String modifier(Candidat st) {
		candidatRepository.save(st);

		return "redirect:this";
	}
	
	@RequestMapping(value = "modifierCat")
	public String modifierCat(long id, Model model) {
		Candidat candidat = candidatRepository.findOne(id);
		model.addAttribute("candidat", candidat);
		List<Categorie> liste = categorieRepository.findAll();
		model.addAttribute("categorie", liste);
		return "modifier_categorie";
	}
	@RequestMapping(value ="modifiercategorie", method = RequestMethod.POST)
	public String cat(Candidat st) {
		String s = st.getCategorie();
		if(s == "validee")
		{st.setCategorie("validee");}
		candidatRepository.save(st);

		return "redirect:this";
	}
	@RequestMapping(value="sourcing")
	public String sourcing()
	{
		return "sourcing_google";
		
	}

	/*
	 * @RequestMapping(value="/index") public ModelAndView getAll(){
	 * 
	 * List<Stagiaire> list=stagiaireDAO.findAll();
	 * list.forEach(e->System.out.println(e.getNom())); return new
	 * ModelAndView("Stagiaire","stage",list);
	 * 
	 * }
	 */
}
