package com.projet.projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Candidat implements Serializable {

	@Id
	@GeneratedValue
	public Long id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String specialite;
	private char sexe;
	private String niveauEtude;
	private String categorie;
	
	
	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	


	public Candidat(Long id, String nom, String prenom, String email, String password, String specialite, char sexe,
			String niveauEtude, String categorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.specialite = specialite;
		this.sexe = sexe;
		this.niveauEtude = niveauEtude;
		this.categorie = categorie;
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



	public char getSexe() {
		return sexe;
	}



	public void setSexe(char sexe) {
		this.sexe = sexe;
	}



	public String getNiveauEtude() {
		return niveauEtude;
	}



	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}



	public String getCategorie() {
		return categorie;
	}



	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
}
