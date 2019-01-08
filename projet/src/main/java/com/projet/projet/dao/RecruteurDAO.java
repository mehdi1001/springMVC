package com.projet.projet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.projet.entities.Recruteur;

@Service
public class RecruteurDAO {

	 @Autowired
	 RecruteurRepository recruteurRepository;
	 
	 public List<Recruteur> findAll(){
		 
		 return recruteurRepository.findAll();
		 
		 
	 }
}
