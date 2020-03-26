package com.autoecole.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.autoecole.beans.Personnels;
import com.autoecole.service.Database;

public class GestionPersonnelsController {
	
	//Recuperer tous les personnels
	
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
	
	//recuperer personnel par ID
	
	public Personnels getPersonnelById(int idP){
		Connection conexion = Database.getInstance().getConexion();
		List<Personnels> listPersonnel = new ArrayList<Personnels>();
		Personnels personnel = new Personnels();
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			ResultSet resultPersonnel = state.executeQuery("select * from personnels where id like "+idP+"");
			while (resultPersonnel.next()) {
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
			}
			state.close();
			resultPersonnel.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return personnel;
	}
	
	//Modifier personnel 
	
	public boolean modifierPersonnel(Personnels personnels) {
		
		Connection conexion = Database.getInstance().getConexion();
		boolean resultaQuery = false;
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			PreparedStatement stmt=conexion.prepareStatement("UPDATE personnels SET nom=?, prenom=?, cin=?, dateNaissance=?, numTel=?, adresse=?, poste=?, dateEmbauche=?, salaire=? WHERE id=?");
			stmt.setString(1, personnels.getNom());
			stmt.setString(2, personnels.getPrenom());
			stmt.setString(3, personnels.getCin());
			stmt.setDate(4, personnels.getDateNaissance());
			stmt.setString(5, personnels.getNumTele());
			stmt.setString(6, personnels.getAdresse());
			stmt.setString(7, personnels.getPoste());
			stmt.setDate(8, personnels.getDateEmbauche());
			stmt.setFloat(9, personnels.getSalaire());
			stmt.setInt(10, personnels.getId());
			int res=stmt.executeUpdate();
			if(res>0) {
				resultaQuery=true;
			}
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return resultaQuery;
	}
	
	//Rechercher personnel by nom , prenom et cin
	
	public Personnels getPersonnelsByNomPrenomCin(String nom, String prenom, String cin){
		Connection conexion = Database.getInstance().getConexion();
		Personnels personnel = new Personnels();
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			String  req;
			if(!cin.isEmpty()) {
				req="select * from personnels where cin like '"+cin+"'";
			}else {
				if(!prenom.isEmpty() && !nom.isEmpty()) {
					req="select * from personnels where prenom like '"+prenom+"' and nom like '"+nom+"'";
				}else {
					req="select * from personnels where prenom like '"+prenom+"' or nom like '"+nom+"'";
				}
			}
			ResultSet resultPersonnel = state.executeQuery(req);
			while (resultPersonnel.next()) {
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
			}
			state.close();
			resultPersonnel.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return personnel;
	}
	
	//ajouter personnel
	
	public boolean ajouterPersonnel(Personnels personnels) {
		Connection conexion = Database.getInstance().getConexion();
		boolean resultat = false;
		try {
			Statement statement = conexion != null ? conexion.createStatement() : null ;
			PreparedStatement stmt=conexion.prepareStatement("insert into personnels(nom,prenom,cin,dateNaissance,numTel,adresse,poste,dateEmbauche,salaire) values(?,?,?,?,?,?,?,?,?)");  
			stmt.setString(1, personnels.getNom());
			stmt.setString(2, personnels.getPrenom());
			stmt.setString(3, personnels.getCin());
			stmt.setDate(4, personnels.getDateNaissance());
			stmt.setString(5, personnels.getNumTele());
			stmt.setString(6, personnels.getAdresse());
			stmt.setString(7, personnels.getPoste());
			stmt.setDate(8, personnels.getDateEmbauche());
			stmt.setFloat(9, personnels.getSalaire());
			
			int res=stmt.executeUpdate();
			
			if(res>0) {
				resultat=true;
			}
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return resultat;
	}
	
	//supprimer personnel
	
	public boolean supprimerPersonnels(int id) {
		Connection conexion = Database.getInstance().getConexion();
		boolean etat = false;
		try {
			Statement statement = conexion != null ? conexion.createStatement() : null ;
			int result= statement.executeUpdate("delete from personnels where id="+id+"");
			if(result>0) {
				etat=true;
			}
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return etat;
	}
}
