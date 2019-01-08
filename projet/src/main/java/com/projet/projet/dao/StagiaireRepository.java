package com.projet.projet.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.projet.entities.Stagiaire;
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long>{
  
	
	
	
	
  
  
  
  public List<Stagiaire> findByNom(String nom);
  
  
  public Page<Stagiaire> findByNom(String nom,Pageable pageable);
  
  @Query("select s from Stagiaire s where s.nom like :x")
  public Page<Stagiaire> searchname(@Param("x") String nm,Pageable pageable);
  
  
 }
