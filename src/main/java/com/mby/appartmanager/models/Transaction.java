package com.mby.appartmanager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="Transaction")
public class Transaction extends AbstractModelWithDocuments {

	@Column(name="type", nullable=false)
	@XmlElement(name="type")
	private Type type;
	
	@Column(name="date", nullable=false)
	@XmlElement(name="date")
	private Date date;
	
	@Column(name="isNeuf", nullable=false)
	@XmlElement(name="isNeuf")
	private boolean isNeuf; //ancien = 0, neuf = 1
	
	@Column(name="montant", nullable=false)
	@XmlElement(name="montant")
	private short montant;
	
	@OneToOne
	@Cascade({CascadeType.ALL})
	private DispositifFiscal dispositifFiscal;
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isNeuf() {
		return isNeuf;
	}


	public void setNeuf(boolean isNeuf) {
		this.isNeuf = isNeuf;
	}

	public short getMontant() {
		return montant;
	}

	public void setMontant(short montant) {
		this.montant = montant;
	}

	public DispositifFiscal getDispositifFiscal() {
		return dispositifFiscal;
	}

	public void setDispositifFiscal(DispositifFiscal dispositifFiscal) {
		this.dispositifFiscal = dispositifFiscal;
	}

	public enum Type {
	    VENTE("vente"),
	    ACHAT("achat");
	    
		private final String value;
		
		Type(String value){
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
