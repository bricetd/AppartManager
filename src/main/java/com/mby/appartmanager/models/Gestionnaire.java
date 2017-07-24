package com.mby.appartmanager.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mby.appartmanager.models.interfaces.ContratGestionInterface;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="Gestionnaire")
public class Gestionnaire extends AbstractModel implements ContratGestionInterface{

	@Column(name="nom")
	@XmlElement(name="nom")
	private String nom;
	
	@Column(name="prenom")
	@XmlElement(name="prenom")
	private String prenom;
	
	@Column(name="raison_sociale")
	@XmlElement(name="raison_sociale")
	private String raison_sociale;
	
	@OneToOne
//	@Cascade({CascadeType.ALL})
	private Coordonnees coordonnees;
	
	@OneToMany(fetch = FetchType.EAGER)
//	@Cascade({CascadeType.ALL})
	protected Set<ContratGestion> contratsGestions;

	public Set<ContratGestion> getContratGestions() {
		return contratsGestions;
	}

	public void setContratGestions(Set<ContratGestion> contratsGestions) {
		this.contratsGestions = contratsGestions;
	}

	public boolean addContratGestion(ContratGestion contratGestion) {
		boolean result = false;
		if(null!=contratsGestions){
			contratsGestions.add(contratGestion);
		}
		return result;
	}

	public boolean removeContratGestion(ContratGestion contratGestion) {
		boolean result = false;
		if(null!=contratsGestions&&null!=contratGestion){
			result = contratsGestions.remove(contratGestion);
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

	public String getRaison_sociale() {
		return raison_sociale;
	}

	public void setRaison_sociale(String raison_sociale) {
		this.raison_sociale = raison_sociale;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Set<ContratGestion> getContratsGestions() {
		return contratsGestions;
	}

	public void setContratsGestions(Set<ContratGestion> contratsGestions) {
		this.contratsGestions = contratsGestions;
	}
}
