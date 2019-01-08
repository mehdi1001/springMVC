package com.projet.projet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Offre implements Serializable {

	@Id
	@GeneratedValue
	public Long id;
	private String titre;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFinOffre;
	
	
	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offre(Long id, String description, Date dateFinOffre) {
		super();
		this.id = id;
		this.description = description;
		this.dateFinOffre = dateFinOffre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateFinOffre() {
		return dateFinOffre;
	}

	public void setDateFinOffre(Date dateFinOffre) {
		this.dateFinOffre = dateFinOffre;
	}

	
	
	
	
	
}
