package com.mby.appartmanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="DispositifFiscal")
public class DispositifFiscal extends AbstractModel{

	@Column(name="nom", nullable=false)
	@XmlElement(name="nom")
	private String nom;
	
	@Column(name="duree")
	@XmlElement(name="duree")
	private short duree;
	
	@Column(name="conditions")
	@XmlElement(name="conditions")
	private String conditions;
	
	@Column(name="articles_loi")
	@XmlElement(name="articles_loi")
	private String articles_loi;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public short getDuree() {
		return duree;
	}

	public void setDuree(short duree) {
		this.duree = duree;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getArticles_loi() {
		return articles_loi;
	}

	public void setArticles_loi(String articles_loi) {
		this.articles_loi = articles_loi;
	}
}
