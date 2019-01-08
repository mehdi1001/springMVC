package com.projet.projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Recruteur implements Serializable {

	@Id
	@GeneratedValue
	public Long id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String codeRecruteur;
	
	
	public Recruteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	



	public Recruteur(Long id, String nom, String prenom, String email, String password, String codeRecruteur) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.codeRecruteur = codeRecruteur;
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

	



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public String getCodeRecruteur() {
		return codeRecruteur;
	}


	public void setCodeRecruteur(String codeRecruteur) {
		this.codeRecruteur = codeRecruteur;
	}



	



	
	
}
