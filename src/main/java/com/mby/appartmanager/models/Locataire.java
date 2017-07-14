package com.mby.appartmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.mby.appartmanager.models.interfaces.IncidentInterface;
import com.mby.appartmanager.models.interfaces.PaiementInterface;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="Locataire")
public class Locataire extends AbstractModelWithDocuments implements PaiementInterface, IncidentInterface{

	@Column(name="nom", nullable=false)
	@XmlElement(name="nom")
	private String nom;
	
	@Column(name="prenom", nullable=false)
	@XmlElement(name="prenom")
	private String prenom;
	
	@Column(name="date_naissance", nullable=false)
	@XmlElement(name="date_naissance")
	private Date date_naissance;
	
	@Column(name="statusMarital", nullable=false)
	@XmlElement(name="statusMarital")
	private StatusMarital statusMarital;
	
	@Column(name="revenusMensuel")
	@XmlElement(name="revenusMensuel")
	private short revenusMensuel;
	
	@Column(name="employeur")
	@XmlElement(name="employeur")
	private String employeur;
	
	@Column(name="anciennete")
	@XmlElement(name="anciennete")
	private Short anciennete;
	
	@Column(name="cautionnaire")
	@XmlElement(name="cautionnaire")
	private String cautionnaire;
	
	@OneToOne
	@Cascade({CascadeType.ALL})
	private Coordonnees coordonnees;
	
	@OneToMany
	@Cascade({CascadeType.ALL})
	private List<Incident> incidents;
	
	@OneToMany
	@Cascade({CascadeType.ALL})
	private List<Paiement> paiements;
	
	
	public List<Incident> getIncidents() {
		return incidents;
	}

	public void setIncidents(List<Incident> incidents) {
		this.incidents = incidents;
	}

	public boolean addIncident(Incident incident) {
		boolean result = false;
		if(null!=incidents){
			incidents.add(incident);
		}
		return result;
	}

	public boolean removeIncident(Incident incident) {
		boolean result = false;
		if(null!=incidents&&null!=incident){
			result = incidents.remove(incident);
		}
		return result;
	}

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
		return result;
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

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public StatusMarital getStatusMarital() {
		return statusMarital;
	}

	public void setStatusMarital(StatusMarital statusMarital) {
		this.statusMarital = statusMarital;
	}

	public short getRevenusMensuel() {
		return revenusMensuel;
	}

	public void setRevenusMensuel(short revenusMensuel) {
		this.revenusMensuel = revenusMensuel;
	}

	public String getEmployeur() {
		return employeur;
	}

	public void setEmployeur(String employeur) {
		this.employeur = employeur;
	}

	public Short getAnciennete() {
		return anciennete;
	}

	public void setAnciennete(Short anciennete) {
		this.anciennete = anciennete;
	}

	public String getCautionnaire() {
		return cautionnaire;
	}

	public void setCautionnaire(String cautionnaire) {
		this.cautionnaire = cautionnaire;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}



	public enum StatusMarital {
	    CELIBATAIRE("celibataire"),
	    DIVORCE("divorce"),
	    PACSE("pacse"),
	    CONCUBINAGE("concubinage"),
	    MARIE("marie");
	    
		private final String value;
		
		StatusMarital(String value){
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
