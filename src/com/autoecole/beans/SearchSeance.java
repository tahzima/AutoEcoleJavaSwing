package com.autoecole.beans;

import java.sql.Date;

public class SearchSeance {
	private Date dateDebut;
	private Date dateFin;
	private String typeSeance;
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getTypeSeance() {
		return typeSeance;
	}
	public void setTypeSeance(String typeSeance) {
		this.typeSeance = typeSeance;
	}
	
}
