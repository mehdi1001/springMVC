package com.projet.projet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.projet.entities.Candidat;

@Service
public class CandidatDAO {

	 @Autowired
	 CandidatRepository candidatRepository;
	 
	 public List<Candidat> findAll(){
		 
		 return candidatRepository.findAll();
		 
		 
	 }
}
