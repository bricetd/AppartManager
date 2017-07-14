package com.mby.appartmanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="Coordonnees")
public class Coordonnees extends AbstractModel{

	@Size(max = 255)
	@Column(name="adresse")
	@XmlElement(name="adresse")
	private String adresse;
	
	@Column(name="code_postal")
	@XmlElement(name="code_postal")
	private short code_postal;
	
	@Size(max = 20)
	@Column(name="fixe")
	@XmlElement(name="fixe")
	private String fixe;
	
	@Size(max = 100)
	@Column(name="email")	
	@XmlElement(name="email")
	private String email;
	
	@Column(name="fax")
	@Size(max = 20)
	@XmlElement(name="fax")
	private String fax;
	
	@Size(max = 20)
	@Column(name="mobile")
	@XmlElement(name="mobile")
	private String mobile;
	
	@Size(max = 50)
	@Column(name="autre")
	@XmlElement(name="autre")
	private String autre;
	
	@Size(max = 255)
	@Column(name="commentaire")
	@XmlElement(name="commentaire")
	private String commentaire;

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public short getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(short code_postal) {
		this.code_postal = code_postal;
	}

	public String getFixe() {
		return fixe;
	}

	public void setFixe(String fixe) {
		this.fixe = fixe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAutre() {
		return autre;
	}

	public void setAutre(String autre) {
		this.autre = autre;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
