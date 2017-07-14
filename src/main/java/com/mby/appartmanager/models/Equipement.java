package com.mby.appartmanager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="Equipement")
public class Equipement extends AbstractModelWithDocuments{

	@Column(name="nom", nullable=false)
	@XmlElement(name="nom")
	private String nom;
	
	@Column(name="valeur")
	@XmlElement(name="valeur")
	private short valeur;
	
	@Column(name="date_achat")
	@XmlElement(name="date_achat")
	private Date date_achat;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public short getValeur() {
		return valeur;
	}

	public void setValeur(short valeur) {
		this.valeur = valeur;
	}

	public Date getDate_achat() {
		return date_achat;
	}

	public void setDate_achat(Date date_achat) {
		this.date_achat = date_achat;
	}
}
