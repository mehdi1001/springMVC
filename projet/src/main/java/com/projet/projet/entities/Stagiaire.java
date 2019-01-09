package com.projet.projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Stagiaire implements Serializable {

	@Id
	@GeneratedValue
	public Long id;
	private String nom;
	private String prenom;
	private String specialite;
	private String cv;
	
	
	
	
	public Stagiaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stagiaire(String nom, String prenom, String specialite, String cv) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
		this.cv = cv;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	
}
