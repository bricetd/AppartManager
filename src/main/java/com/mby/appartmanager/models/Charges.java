package com.mby.appartmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.mby.appartmanager.models.interfaces.PaiementInterface;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="Charges")
public class Charges extends AbstractModelWithDocuments implements PaiementInterface{

	@Column(name="nom", nullable=false)
	@XmlElement(name="nom")
	private String nom;
	
	@Column(name="montant", nullable=false)
	@XmlElement(name="montant")
	private short montant;
	
	@Column(name="frequence", nullable=false)
	@XmlElement(name="frequence")
	private Frequence frequence;
	
	@Column(name="date_echeance", nullable=false)
	@XmlElement(name="date_echeance")
	private Date date_echeance;
	
	@OneToMany
	@Cascade({CascadeType.ALL})
	private List<Paiement> paiements;
	
	public List<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}

	public boolean addPaiement(Paiement paiement) {
		boolean result = false;
		if(null!=paiements){
			paiements.add(paiement);
		}
		return result;
	}

	public boolean removePaiement(Paiement paiement) {
		boolean result = false;
		if(null!=paiements&&null!=paiement){
			result = paiements.remove(paiement);
		}
		return result;// TODO Auto-generated method stub
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public short getMontant() {
		return montant;
	}

	public void setMontant(short montant) {
		this.montant = montant;
	}

	public Frequence getFrequence() {
		return frequence;
	}

	public void setFrequence(Frequence frequence) {
		this.frequence = frequence;
	}

	public Date getDate_echeance() {
		return date_echeance;
	}

	public void setDate_echeance(Date date_echeance) {
		this.date_echeance = date_echeance;
	}



	public enum Frequence {
	    ANNUEL("annuel"),
	    TRIMESTRIEL("trimestriel"),
	    UNIQUE("unique"),
	    MENSUEL("mensuel");
	    
		private final String value;
		
		Frequence(String value){
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
