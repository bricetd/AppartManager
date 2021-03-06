package com.mby.appartmanager.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mby.appartmanager.models.interfaces.EquipementInterface;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="Piece")
public class Piece extends AbstractModelWithDocuments implements EquipementInterface {
	
	@Column(name="nom", nullable=false)
	@XmlElement(name="nom")
	private String nom;
	
	@Column(name="surface")
	@XmlElement(name="surface")
	private int surface;
	
	@OneToMany(fetch = FetchType.EAGER)
//	@Cascade({CascadeType.ALL})
	private Set<Equipement> equipements;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public Set<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(Set<Equipement> equipements) {
		this.equipements = equipements;
	}

	public boolean addEquipement(Equipement equipement) {
		boolean result = false;
		if(null!=equipements){
			equipements.add(equipement);
		}
		return result;
	}

	public boolean removeEquipement(Equipement equipement) {
		boolean result = false;
		if(null!=equipements&&null!=equipement){
			result = equipements.remove(equipement);
		}
		return result;
	}

	
}
