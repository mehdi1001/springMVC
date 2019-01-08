package com.projet.projet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.projet.entities.Offre;

@Service
public class OffreDAO {

	 @Autowired
	 OffreRepository offreRepository;
	 
	 public List<Offre> findAll(){
		 
		 return offreRepository.findAll();
		 
		 
	 }
}
