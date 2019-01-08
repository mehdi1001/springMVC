package com.projet.projet.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.projet.entities.Offre;
public interface OffreRepository extends JpaRepository<Offre, Long>{

  public List<Offre> findById(Long id);
  
  
  public Page<Offre> findById(Long id,Pageable pageable);
  
  @Query("select s from Offre s where s.id like :x")
  public Page<Offre> searchname(@Param("x") Long nm,Pageable pageable);
  
  
 }
