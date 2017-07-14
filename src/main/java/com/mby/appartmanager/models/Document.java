package com.mby.appartmanager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "Document")
public class Document extends AbstractModel {

	@Column(name = "nom", nullable = false)
	@XmlElement(name = "nom")
	private String nom;

	@Column(name = "fichier", nullable = false)
	@XmlElement(name = "fichier")
	private String fichier;

//	@GeneratedValue(strategy = GenerationType.AUTO)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_ajout")
	@XmlElement(name = "date_ajout")
	private Date date_ajout;

	
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modification")
	@XmlElement(name = "date_modification")
	private Date date_modification;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}

	public Date getDate_ajout() {
		return date_ajout;
	}

	public void setDate_ajout(Date date_ajout) {
		this.date_ajout = date_ajout;
	}

	public Date getDate_modification() {
		return date_modification;
	}

	public void setDate_modification(Date date_modification) {
		this.date_modification = date_modification;
	}

/*	@PrePersist
	private void onCreate() {
		date_ajout = date_modification = new Date();
	}

	@PreUpdate
	private void onUpdate() {
		date_modification = new Date();
	}*/

}
