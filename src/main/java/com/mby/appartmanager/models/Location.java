package com.mby.appartmanager.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mby.appartmanager.models.interfaces.LocataireInterface;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="Location")
public class Location extends AbstractModelWithDocuments implements LocataireInterface{

	@Column(name="date_debut", nullable=false)
	@XmlElement(name="date_debut")
	private Date date_debut;
	
	@Column(name="date_fin")
	@XmlElement(name="date_fin")
	private Date date_fin;
	
	@Column(name="isCollocation", nullable=false)
	@XmlElement(name="isCollocation")
	private boolean isCollocation;
	
	@Column(name="isMeuble", nullable=false)
	@XmlElement(name="isMeuble")
	private boolean isMeuble;
	
	@OneToMany(fetch = FetchType.EAGER)
//	@Cascade({CascadeType.ALL})
	private Set<Locataire> locataires;
	
	public Set<Locataire> getLocataires() {
		return locataires;
	}

	public void setLocataires(Set<Locataire> locataires) {
		this.locataires = locataires;
	}

	public boolean addLocataire(Locataire locataire) {
		boolean result = false;
		if(null!=locataires){
			locataires.add(locataire);
		}
		return result;
	}

	public boolean removeLocataire(Locataire locataire) {
		boolean result = false;
		if(null!=locataires&&null!=locataire){
			result = locataires.remove(locataire);
		}
		return result;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public boolean isCollocation() {
		return isCollocation;
	}

	public void setCollocation(boolean isCollocation) {
		this.isCollocation = isCollocation;
	}

	public boolean isMeuble() {
		return isMeuble;
	}

	public void setMeuble(boolean isMeuble) {
		this.isMeuble = isMeuble;
	}
	
	

}
