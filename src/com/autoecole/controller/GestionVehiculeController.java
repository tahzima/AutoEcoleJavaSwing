package com.autoecole.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.autoecole.beans.Vehicules;
import com.autoecole.service.Database;

public class GestionVehiculeController {

	//Recuperer tous les Vehicules
	
	public List<Vehicules> getAllVehicules(){
		Connection conexion = Database.getInstance().getConexion();
		List<Vehicules> listVehicule = new ArrayList<Vehicules>();
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			ResultSet resultVehicule = state.executeQuery("select * from vehicules");
			while (resultVehicule.next()) {
				Vehicules vehicule = new Vehicules();
				vehicule.setId(resultVehicule.getInt("id"));
				vehicule.setType(resultVehicule.getString("type"));
				vehicule.setMarque(resultVehicule.getString("marque"));
				vehicule.setModele(resultVehicule.getString("modele"));
				vehicule.setNbPlace(resultVehicule.getInt("nbPlace"));
				vehicule.setType(resultVehicule.getString("typeCarburant"));
				vehicule.setMatricule(resultVehicule.getString("matricule"));
				vehicule.setPuissanceFiscale(resultVehicule.getInt("puissanceFiscale"));
				vehicule.setAssurance(resultVehicule.getString("assurance"));
				vehicule.setDateLimiteAssurance(resultVehicule.getDate("dateLimiteAssurance"));
				vehicule.setKmVidange(resultVehicule.getInt("kmVidange"));
				listVehicule.add(vehicule);
			}
			state.close();
			resultVehicule.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return listVehicule;
	}
	
	//recuperer vehicule par ID
	
	public Vehicules getVehiculeById(int idV){
		Connection conexion = Database.getInstance().getConexion();
		Vehicules vehicule = new Vehicules();
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			ResultSet resultVehicule = state.executeQuery("select * from vehicules where id like "+idV+"");
			while (resultVehicule.next()) {
				vehicule.setId(resultVehicule.getInt("id"));
				vehicule.setType(resultVehicule.getString("type"));
				vehicule.setMarque(resultVehicule.getString("marque"));
				vehicule.setModele(resultVehicule.getString("modele"));
				vehicule.setNbPlace(resultVehicule.getInt("nbPlace"));
				vehicule.setType(resultVehicule.getString("typeCarburant"));
				vehicule.setMatricule(resultVehicule.getString("matricule"));
				vehicule.setPuissanceFiscale(resultVehicule.getInt("puissanceFiscale"));
				vehicule.setAssurance(resultVehicule.getString("assurance"));
				vehicule.setDateLimiteAssurance(resultVehicule.getDate("dateLimiteAssurance"));
				vehicule.setKmVidange(resultVehicule.getInt("kmVidange"));
			}
			state.close();
			resultVehicule.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return vehicule;
	}
	
	//Modifier vehicule 
	
	public boolean modifierVehicule(Vehicules vehicules) {
		
		Connection conexion = Database.getInstance().getConexion();
		boolean resultaQuery = false;
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			PreparedStatement stmt=conexion.prepareStatement("UPDATE vehicules SET type=?, marque=?, modele=?, nbPlace=?, typeCarburant=?, matricule=?, puissanceFiscale=?, assurance=?, dateLimiteAssurance=?, kmVidange=? WHERE id=?");
			stmt.setString(1, vehicules.getType());
			stmt.setString(2, vehicules.getMarque());
			stmt.setString(3, vehicules.getModele());
			stmt.setInt(4, vehicules.getNbPlace());
			stmt.setString(5, vehicules.getTypeCarburant());
			stmt.setString(6, vehicules.getMatricule());
			stmt.setInt(7, vehicules.getPuissanceFiscale());
			stmt.setString(8, vehicules.getAssurance());
			stmt.setDate(9, vehicules.getDateLimiteAssurance());
			stmt.setInt(10, vehicules.getKmVidange());
			stmt.setInt(10, vehicules.getId());
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
	
	//Rechercher vehicule by nom , prenom et cin
	
	public Vehicules getPersonnelsByTypeMarqueMatricule(String type, String marque, String matricule){
		Connection conexion = Database.getInstance().getConexion();
		Vehicules vehicule = new Vehicules();
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			String  req;
			if(!type.isEmpty()) {
				req="select * from vehicules where type like '"+type+"'";
			}else if(!marque.isEmpty()) {
				req="select * from vehicules where marque like '"+marque+"'";
			}else {
				req="select * from vehicules where matricule like '"+matricule+"'";
			}
			ResultSet resultVehicule = state.executeQuery(req);
			while (resultVehicule.next()) {
				vehicule.setId(resultVehicule.getInt("id"));
				vehicule.setType(resultVehicule.getString("type"));
				vehicule.setMarque(resultVehicule.getString("marque"));
				vehicule.setModele(resultVehicule.getString("modele"));
				vehicule.setNbPlace(resultVehicule.getInt("nbPlace"));
				vehicule.setType(resultVehicule.getString("typeCarburant"));
				vehicule.setMatricule(resultVehicule.getString("matricule"));
				vehicule.setPuissanceFiscale(resultVehicule.getInt("puissanceFiscale"));
				vehicule.setAssurance(resultVehicule.getString("assurance"));
				vehicule.setDateLimiteAssurance(resultVehicule.getDate("dateLimiteAssurance"));
				vehicule.setKmVidange(resultVehicule.getInt("kmVidange"));
			}
			state.close();
			resultVehicule.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return vehicule;
	}
	
	//ajouter personnel
	
	public boolean ajouterVehicule(Vehicules vehicules) {
		Connection conexion = Database.getInstance().getConexion();
		boolean resultat = false;
		try {
			Statement statement = conexion != null ? conexion.createStatement() : null ;
			PreparedStatement stmt=conexion.prepareStatement("insert into vehicules(type,marque,modele,nbPlace,typeCarburant,matricule,puissanceFiscale,assurance,dateLimiteAssurance,kmVidange) values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, vehicules.getType());
			stmt.setString(2, vehicules.getMarque());
			stmt.setString(3, vehicules.getModele());
			stmt.setInt(4, vehicules.getNbPlace());
			stmt.setString(5, vehicules.getTypeCarburant());
			stmt.setString(6, vehicules.getMatricule());
			stmt.setInt(7, vehicules.getPuissanceFiscale());
			stmt.setString(8, vehicules.getAssurance());
			stmt.setDate(9, vehicules.getDateLimiteAssurance());
			stmt.setInt(10, vehicules.getKmVidange());
			stmt.setInt(10, vehicules.getId());
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
	
	public boolean supprimerVehicules(int id) {
		Connection conexion = Database.getInstance().getConexion();
		boolean etat = false;
		try {
			Statement statement = conexion != null ? conexion.createStatement() : null ;
			int result= statement.executeUpdate("delete from vehicules where id="+id+"");
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
