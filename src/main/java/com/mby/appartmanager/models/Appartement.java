package com.mby.appartmanager.models;

import java.util.HashSet;
import java.util.Set;

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

import com.mby.appartmanager.models.interfaces.ChargesInterface;
import com.mby.appartmanager.models.interfaces.GestionnaireInterface;
import com.mby.appartmanager.models.interfaces.LocationInterface;
import com.mby.appartmanager.models.interfaces.PieceInterface;
import com.mby.appartmanager.models.interfaces.TransactionInterface;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="Appartement")
public class Appartement extends AbstractModelWithDocuments implements GestionnaireInterface, TransactionInterface, PieceInterface, LocationInterface, ChargesInterface {

	@Column(name="nom", unique=true, nullable=false)
	@XmlElement(name="nom")
	private String nom;
	
	@Column(name="surface",nullable=false)
	@XmlElement(name="surface")
	private short surface;
	
	@Column(name="etage",nullable=false)
	@XmlElement(name="etage")
	private short etage;
	
	@Column(name="hasParking", nullable=false)
	@XmlElement(name="hasParking")
	private boolean hasParking;
	
	@Column(name="hasCave", nullable=false)
	@XmlElement(name="hasCave")
	private boolean hasCave;
	
	@OneToMany
	@Cascade({CascadeType.ALL})
	private Set<Transaction> transactions;
	
	@OneToMany
	@Cascade({CascadeType.ALL})
	private Set<Location> locations;
	
	@OneToMany
	@Cascade({CascadeType.ALL})
	private Set<Piece> pieces;
	
	@OneToMany
	@Cascade({CascadeType.ALL})
	private Set<Charges> charges;
	
	@OneToMany
	@Cascade({CascadeType.ALL})
	private Set<Gestionnaire> gestionnaires;
	
	@OneToOne
	@Cascade({CascadeType.ALL})
	private Coordonnees coordonnees;
	
	public Appartement(){
	}
	
	public Appartement(String nom, short surface, short etage, boolean hasParking,
			boolean hasCave){
		super();
		this.nom = nom;
		this.surface = surface;
		this.etage = etage;
		this.hasParking = hasParking;
		this.hasCave = hasCave;
		gestionnaires = new HashSet<Gestionnaire>();
		charges = new HashSet<Charges>();
		transactions = new HashSet<Transaction>();
		locations = new HashSet<Location>();
		pieces = new HashSet<Piece>();
	}
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public short getSurface() {
		return surface;
	}

	public void setSurface(short surface) {
		this.surface = surface;
	}

	public short getEtage() {
		return etage;
	}

	public void setEtage(short etage) {
		this.etage = etage;
	}

	public boolean isHasParking() {
		return hasParking;
	}

	public void setHasParking(boolean hasParking) {
		this.hasParking = hasParking;
	}

	public boolean isHasCave() {
		return hasCave;
	}

	public void setHasCave(boolean hasCave) {
		this.hasCave = hasCave;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Set<Charges> getCharges() {
		return charges;
	}

	public void setCharges(Set<Charges> charges) {
		this.charges = charges;
	}

	public boolean addCharge(Charges charge) {
		boolean result = false;
		if(null!=charges){
			charges.add(charge);
		}
		return result;
	}

	public boolean removeCharge(Charges charge) {
		boolean result = false;
		if(null!=charges&&null!=charge){
			result = charges.remove(charge);
		}
		return result;
	}

	public Set<Location> getLocations() {
		return locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

	public boolean addLocation(Location location) {
		boolean result = false;
		if(null!=locations){
			locations.add(location);
		}
		return result;
	}

	public boolean removeLocation(Location location) {
		boolean result = false;
		if(null!=locations&&null!=location){
			result = locations.remove(location);
		}
		return result;
	}

	public Set<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(Set<Piece> pieces) {
		this.pieces = pieces;
	}

	public boolean addPiece(Piece piece) {
		boolean result = false;
		if(null!=pieces){
			pieces.add(piece);
		}
		return result;
	}

	public boolean removePiece(Piece piece) {
		boolean result = false;
		if(null!=pieces&&null!=piece){
			result = pieces.remove(piece);
		}
		return result;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public boolean addTransaction(Transaction Transaction) {
		boolean result = false;
		if(null!=transactions){
			transactions.add(Transaction);
		}
		return result;
	}

	public boolean removeTransaction(Transaction Transaction) {
		boolean result = false;
		if(null!=transactions&&null!=Transaction){
			result = transactions.remove(Transaction);
		}
		return result;
	}

	public Set<Gestionnaire> getGestionnaires() {
		return gestionnaires;
	}

	public void setGestionnaires(Set<Gestionnaire> gestionnaires) {
		this.gestionnaires = gestionnaires;
	}

	public boolean addGestionnaire(Gestionnaire gestionnaire) {
		boolean result = false;
		if(null!=gestionnaires){
			gestionnaires.add(gestionnaire);
		}
		return result;
	}

	public boolean removeGestionnaire(Gestionnaire gestionnaire) {
		boolean result = false;
		if(null!=gestionnaires&&null!=gestionnaire){
			result = gestionnaires.remove(gestionnaire);
		}
		return result;
	}

}
