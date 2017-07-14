package com.mby.appartmanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="Options")
public class Options extends AbstractModel{

	@Column(name="assurance_loyer_impaye")
	@XmlElement(name="assurance_loyer_impaye")
	private boolean assurance_loyer_impaye;
	
	@Column(name="recherche_locataire")
	@XmlElement(name="recherche_locataire")
	private boolean recherche_locataire;
	
	@Column(name="etablissement_bail")
	@XmlElement(name="etablissement_bail")
	private boolean etablissement_bail;
	
	@Column(name="gerance")
	@XmlElement(name="gerance")
	private boolean gerance;

	public boolean isAssurance_loyer_impaye() {
		return assurance_loyer_impaye;
	}

	public void setAssurance_loyer_impaye(boolean assurance_loyer_impaye) {
		this.assurance_loyer_impaye = assurance_loyer_impaye;
	}

	public boolean isRecherche_locataire() {
		return recherche_locataire;
	}

	public void setRecherche_locataire(boolean recherche_locataire) {
		this.recherche_locataire = recherche_locataire;
	}

	public boolean isEtablissement_bail() {
		return etablissement_bail;
	}

	public void setEtablissement_bail(boolean etablissement_bail) {
		this.etablissement_bail = etablissement_bail;
	}

	public boolean isGerance() {
		return gerance;
	}

	public void setGerance(boolean gerance) {
		this.gerance = gerance;
	}
}
