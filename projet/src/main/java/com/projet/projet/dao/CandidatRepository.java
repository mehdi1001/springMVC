package com.projet.projet.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.projet.entities.Candidat;
public interface CandidatRepository extends JpaRepository<Candidat, Long>{
  
	
	
	
	
  
  
  
  public List<Candidat> findByNom(String nom);
  
  
  public Page<Candidat> findByNom(String nom,Pageable pageable);
  
  @Query("select s from Candidat s where s.nom like :x")
  public Page<Candidat> searchname(@Param("x") String nm,Pageable pageable);
  
  
 }
