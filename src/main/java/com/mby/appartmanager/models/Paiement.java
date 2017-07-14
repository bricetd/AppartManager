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
@Entity(name="Paiement")
public class Paiement extends AbstractModelWithDocuments {

	@Column(name="montant", nullable=false)
	@XmlElement(name="montant")
	private short montant;
	
	@Column(name="date", nullable=false)
	@XmlElement(name="date")
	private Date date;
	
	@Column(name="categorie", nullable=false)
	@XmlElement(name="categorie")
	private Categorie categorie;
	
	@Column(name="modepaiement", nullable=false)
	@XmlElement(name="modepaiement")
	private ModePaiement modepaiement;
	
	@Column(name="commentaire")
	@XmlElement(name="commentaire")
	private String commentaire;
	
	
	
	public short getMontant() {
		return montant;
	}

	public void setMontant(short montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public ModePaiement getModepaiement() {
		return modepaiement;
	}

	public void setModepaiement(ModePaiement modepaiement) {
		this.modepaiement = modepaiement;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public enum Categorie {
	    CAUTION("caution"),
	    CHARGE("charge"),
	    LOYER("loyer");
	    
		private final String value;
		
		Categorie(String value){
			this.value = value;
		}
		
		public String getValue(){
			return value;
		}
		
		@Override
		public String toString(){
			return value;
		}
	}
	
	public enum ModePaiement {
	    ESPECE("espece"),
	    VIREMENT("virement"),
	    CARTEBLEUE("cartebleue"),
	    AUTRE("autre");
	    
		private final String value;
		
		ModePaiement(String value){
			this.value = value;
		}
		
		public String getValue(){
			return value;
		}
		
		@Override
		public String toString(){
			return value;
		}
	}
}
