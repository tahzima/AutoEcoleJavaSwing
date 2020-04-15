package com.autoecole.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.autoecole.beans.SearcheVehicule;
import com.autoecole.beans.Vehicules;
import com.autoecole.service.Database;

public class VehiculeController {
	
	//Recuperer tous les Vehicules
	
		public List<Vehicules> getAll(){
			Connection conexion = Database.getInstance().getConexion();
			List<Vehicules> listPersonnel = new ArrayList<Vehicules>();
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
					vehicule.setTypeCarburant(resultVehicule.getString("typeCarburant"));
					vehicule.setMatricule(resultVehicule.getString("matricule"));
					vehicule.setPuissanceFiscale(resultVehicule.getInt("puissanceFiscale"));
					vehicule.setAssurance(resultVehicule.getString("assurance"));
					vehicule.setDateLimiteAssurance(resultVehicule.getDate("dateLimiteAssurance"));
					vehicule.setKmVidange(resultVehicule.getInt("kmVidange"));
					listPersonnel.add(vehicule);
				}
				state.close();
				resultVehicule.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return listPersonnel;
		}
		
	//Recherche par ids
		
		public Vehicules findById(int idVehicule){
			Connection conexion = Database.getInstance().getConexion();
			Vehicules vehicule = new Vehicules();
			try {
				Statement state = conexion != null ? conexion.createStatement() : null;
				ResultSet resultatVehicule = state.executeQuery("select * from vehicules where id like "+idVehicule+"");
				while (resultatVehicule.next()) {
					vehicule.setId(resultatVehicule.getInt("id"));
					vehicule.setType(resultatVehicule.getString("type"));
					vehicule.setMarque(resultatVehicule.getString("marque"));
					vehicule.setModele(resultatVehicule.getString("modele"));
					vehicule.setNbPlace(resultatVehicule.getInt("nbPlace"));
					vehicule.setTypeCarburant(resultatVehicule.getString("typeCarburant"));
					vehicule.setMatricule(resultatVehicule.getString("matricule"));
					vehicule.setPuissanceFiscale(resultatVehicule.getInt("puissanceFiscale"));
					vehicule.setAssurance(resultatVehicule.getString("assurance"));
					vehicule.setDateLimiteAssurance(resultatVehicule.getDate("dateLimiteAssurance"));
					vehicule.setKmVidange(resultatVehicule.getInt("kmVidange"));
				}
				state.close();
				resultatVehicule.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return vehicule;
		}
		
	//Modifier Vehicule
		
		public boolean update(Vehicules vehicule) {
			
			Connection conexion = Database.getInstance().getConexion();
			boolean resultaQuery = false;
			try {
				Statement state = conexion != null ? conexion.createStatement() : null;
				PreparedStatement stmt=conexion.prepareStatement("UPDATE vehicules SET type=?, marque=?, modele=?, nbPlace=?, typeCarburant=?, matricule=?, puissanceFiscale=?, assurance=?, dateLimiteAssurance=?, kmVidange=? WHERE id like ?");
				stmt.setString(1, vehicule.getType());
				stmt.setString(2, vehicule.getMarque());
				stmt.setString(3, vehicule.getModele());
				stmt.setInt(4, vehicule.getNbPlace());
				stmt.setString(5, vehicule.getTypeCarburant());
				stmt.setString(6, vehicule.getMatricule());
				stmt.setInt(7, vehicule.getPuissanceFiscale());
				stmt.setString(8, vehicule.getAssurance());
				stmt.setDate(9, vehicule.getDateLimiteAssurance());
				stmt.setFloat(10, vehicule.getKmVidange());
				stmt.setInt(11, vehicule.getId());
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
		
	//Recherche Vehicule
		
		public List<Vehicules> search(SearcheVehicule params){
			Connection conexion = Database.getInstance().getConexion();
			Vehicules vehicule;
			List<Vehicules> listeVehicule = new ArrayList<Vehicules>();
			try {
				Statement state = conexion != null ? conexion.createStatement() : null;
				String sql;
				String where="";
				
				if(!params.getType().isEmpty())
				{
					where += "and type = '"+params.getType()+"'";
				}
				
				if(!params.getMarque().isEmpty())
				{
					where += " and marque like '%"+params.getMarque()+"%'";
				}
				
				if(!params.getMatricule().isEmpty())
				{
					where += " and matricule like '%"+params.getMatricule()+"%'";
				}
				
				sql = "select * from vehicules where 1=1  "+where;
				
				ResultSet resultatVehicule = state.executeQuery(sql);
					while (resultatVehicule.next()) {
						vehicule= new Vehicules();
						vehicule.setId(resultatVehicule.getInt("id"));
						vehicule.setType(resultatVehicule.getString("type"));
						vehicule.setMarque(resultatVehicule.getString("marque"));
						vehicule.setModele(resultatVehicule.getString("modele"));
						vehicule.setNbPlace(resultatVehicule.getInt("nbPlace"));
						vehicule.setTypeCarburant(resultatVehicule.getString("typeCarburant"));
						vehicule.setMatricule(resultatVehicule.getString("matricule"));
						vehicule.setPuissanceFiscale(resultatVehicule.getInt("puissanceFiscale"));
						vehicule.setAssurance(resultatVehicule.getString("assurance"));
						vehicule.setDateLimiteAssurance(resultatVehicule.getDate("dateLimiteAssurance"));
						vehicule.setKmVidange(resultatVehicule.getInt("kmVidange"));
						listeVehicule.add(vehicule);
					}
				state.close();
				resultatVehicule.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} 
			return listeVehicule;
		}
		
	//Ajouter vehicule
		
		public boolean add(Vehicules vehicule) {
			Connection conexion = Database.getInstance().getConexion();
			boolean resultat = false;
			try {
				Statement statement = conexion != null ? conexion.createStatement() : null ;
				PreparedStatement stmt=conexion.prepareStatement("insert into vehicules(type,marque,modele,nbPlace,typeCarburant,matricule,puissanceFiscale,assurance,dateLimiteAssurance,kmVidange) values(?,?,?,?,?,?,?,?,?,?)");  
				stmt.setString(1, vehicule.getType());
				stmt.setString(2, vehicule.getMarque());
				stmt.setString(3, vehicule.getModele());
				stmt.setInt(4, vehicule.getNbPlace());
				stmt.setString(5, vehicule.getTypeCarburant());
				stmt.setString(6, vehicule.getMatricule());
				stmt.setInt(7, vehicule.getPuissanceFiscale());
				stmt.setString(8, vehicule.getAssurance());
				stmt.setDate(9, vehicule.getDateLimiteAssurance());
				stmt.setFloat(10, vehicule.getKmVidange());
				
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
		
	//Supprimer vehicule
		
		public boolean delete(int id) {
			Connection conexion = Database.getInstance().getConexion();
			boolean etat = false;
			try {
				Statement statement = conexion != null ? conexion.createStatement() : null ;
				int result= statement.executeUpdate("delete from vehicules where id like "+id+"");
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
