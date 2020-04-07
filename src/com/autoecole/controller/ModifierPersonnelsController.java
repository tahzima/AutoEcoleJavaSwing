package com.autoecole.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import com.autoecole.service.Database;

public class ModifierPersonnelsController {
	
	public boolean modifierPersonnel(int id, String nom, String prenom, String cin, Date dateNaissance, String numTele, String adresse, String poste, Date dateEmbauche, float salaire) {
		
		Connection conexion = Database.getInstance().getConexion();
		boolean resultaQuery = false;
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			int res = state.executeUpdate("UPDATE personnels SET nom='"+nom+"', prenom='"+prenom+"', cin='"+cin+"', dateNaissance='"+dateNaissance+"', numTel='"+numTele+"', adresse='"+adresse+"', poste='"+poste+"', dateEmbauche='"+dateNaissance+"', salaire='"+salaire+"' WHERE id="+id+"");
			if(res>0) {
				resultaQuery=true;
			}
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return resultaQuery;
	}
	
}
