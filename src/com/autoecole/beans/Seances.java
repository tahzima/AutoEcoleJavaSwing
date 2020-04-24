package com.autoecole.beans;

import java.sql.Date;

public class Seances {
	private int id;
	private Date date;
	private String typeSeance;
	public String getTypeSeance() {
		return typeSeance;
	}
	public void setTypeSeance(String typeSeance) {
		this.typeSeance = typeSeance;
	}
	private int id_Vehicules;
	private int id_Personnels;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId_Vehicules() {
		return id_Vehicules;
	}
	public void setId_Vehicules(int id_Vehicules) {
		this.id_Vehicules = id_Vehicules;
	}
	public int getId_Personnels() {
		return id_Personnels;
	}
	public void setId_Personnels(int id_Personnels) {
		this.id_Personnels = id_Personnels;
	}
}
