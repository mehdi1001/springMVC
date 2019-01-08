package com.projet.projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Categorie implements Serializable {
    @Id
    @GeneratedValue
	public Long id;
    private String type;
    
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categorie(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
