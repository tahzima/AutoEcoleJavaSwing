package com.autoecole.beans;

import java.sql.Date;

public class Vehicules {
	private int id;
	private String type;
	private String marque;
	private String modele;
	private int nbPlace;
	private String typeCarburant;
	private String matricule;
	private int puissanceFiscale;
	private String assurance;
	private Date dateLimiteAssurance;
	private int kmVidange;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public String getTypeCarburant() {
		return typeCarburant;
	}
	public void setTypeCarburant(String typeCarburant) {
		this.typeCarburant = typeCarburant;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public int getPuissanceFiscale() {
		return puissanceFiscale;
	}
	public void setPuissanceFiscale(int puissanceFiscale) {
		this.puissanceFiscale = puissanceFiscale;
	}
	public String getAssurance() {
		return assurance;
	}
	public void setAssurance(String assurance) {
		this.assurance = assurance;
	}
	public Date getDateLimiteAssurance() {
		return dateLimiteAssurance;
	}
	public void setDateLimiteAssurance(Date dateLimiteAssurance) {
		this.dateLimiteAssurance = dateLimiteAssurance;
	}
	public int getKmVidange() {
		return kmVidange;
	}
	public void setKmVidange(int kmVidange) {
		this.kmVidange = kmVidange;
	}
	
	
}
