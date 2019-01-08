package com.projet.projet;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;

import com.projet.projet.dao.StagiaireRepository;
import com.projet.projet.entities.Stagiaire;



@SpringBootApplication
public class ProjetApplication {

	public static void main(String[] args) {
		ApplicationContext  ctx =SpringApplication.run(ProjetApplication.class, args);
		
      StagiaireRepository stagiaireRepository = 
    		  ctx.getBean(StagiaireRepository.class);
    /*  stagiaireRepository.save(new Stagiaire("test1", "mi", "informatique"));
      stagiaireRepository.save(new Stagiaire("brahim", "mei", "informatique"));
      stagiaireRepository.save(new Stagiaire("alaoui", "mdi", "informatique"));*/
      
      List<Stagiaire> etds=stagiaireRepository.findAll();
     
	}

}

