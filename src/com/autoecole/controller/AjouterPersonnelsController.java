package com.autoecole.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.autoecole.beans.Personnels;
import com.autoecole.service.Database;

public class AjouterPersonnelsController {
	
	public List<Personnels> getAllPersonnels(){
		Connection conexion = Database.getInstance().getConexion();
		List<Personnels> listPersonnel = new ArrayList<Personnels>();
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			ResultSet resultPersonnel = state.executeQuery("select * from personnels");
			while (resultPersonnel.next()) {
				Personnels personnel = new Personnels();
				personnel.setId(resultPersonnel.getInt("id"));
				personnel.setNom(resultPersonnel.getString("nom"));
				personnel.setPrenom(resultPersonnel.getString("prenom"));
				personnel.setCin(resultPersonnel.getString("cin"));
				personnel.setDateNaissance(resultPersonnel.getDate("dateNaissance"));
				personnel.setNumTele(resultPersonnel.getString("numTel"));
				personnel.setAdresse(resultPersonnel.getString("adresse"));
				personnel.setPoste(resultPersonnel.getString("poste"));
				personnel.setDateEmbauche(resultPersonnel.getDate("dateEmbauche"));
				personnel.setSalaire(resultPersonnel.getFloat("salaire"));
				listPersonnel.add(personnel);
			}
			state.close();
			resultPersonnel.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return listPersonnel;
	}
	
}
