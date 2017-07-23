package com.mby.appartmanager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="ContratGestion")
public class ContratGestion extends AbstractModelWithDocuments {
	
	@Column(name="date_debut", nullable=false)
	@XmlElement(name="date_debut")
	private Date date_debut;
	
	@Column(name="date_fin", nullable=false)
	@XmlElement(name="date_fin")
	private Date date_fin;
	
	@Column(name="duree", nullable=false)
	@XmlElement(name="duree")
	private short duree;
	
	@Column(name="tariff", nullable=false)
	@XmlElement(name="tariff")
	private short tariff;
	
	@OneToOne
//	@Cascade({CascadeType.ALL})
	private Options options;

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

	public short getDuree() {
		return duree;
	}

	public void setDuree(short duree) {
		this.duree = duree;
	}

	public short getTariff() {
		return tariff;
	}

	public void setTariff(short tariff) {
		this.tariff = tariff;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}
	
}
