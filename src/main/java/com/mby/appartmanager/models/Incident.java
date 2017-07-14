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
@Entity(name="Incident")
public class Incident extends AbstractModelWithDocuments {

	@Column(name="date", nullable=false)
	@XmlElement(name="date")
	private Date date;
	
	@Column(name="date_fin", nullable=true)
	@XmlElement(name="date_fin")
	private Date date_fin;
	
	@Column(name="libelle", nullable=false)
	@XmlElement(name="libelle")
	private String libelle;
	
	@Column(name="description", nullable=false)
	@XmlElement(name="description")
	private String description;
	
	@Column(name="justification")
	@XmlElement(name="justification")
	private String justification;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
}
