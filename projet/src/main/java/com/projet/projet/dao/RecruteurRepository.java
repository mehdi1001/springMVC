package com.projet.projet.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.projet.entities.Recruteur;
public interface RecruteurRepository extends JpaRepository<Recruteur, Long>{
  
	
	
	
	
  
  
  
  public List<Recruteur> findByNom(String nom);
  
  
  public Page<Recruteur> findByNom(String nom,Pageable pageable);
  
  @Query("select s from Recruteur s where s.nom like :x")
  public Page<Recruteur> searchname(@Param("x") String nm,Pageable pageable);
  
  
 }
