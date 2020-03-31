package com.autoecole.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.autoecole.beans.Candidats;
import com.autoecole.beans.SearchCandidat;
import com.autoecole.beans.Users;
import com.autoecole.service.Database;

public class CandidatController {
	
	private Connection connexion;
	private Statement state;
	private PreparedStatement prepState;
	private ResultSet result;
	
	//Get All Candidats
	public ArrayList<Candidats> getAll () {
		
		ArrayList<Candidats> list = new ArrayList<Candidats>();
		connexion = Database.getInstance().getConexion();
		Candidats candidat;
		try {
			state = connexion != null ? connexion.createStatement() : null ;
			result = state.executeQuery("SELECT * FROM candidats");
			while (result.next()) {
				candidat = new Candidats();
				
				candidat.setId(result.getInt("id"));
				candidat.setNom(result.getString("nom"));
				candidat.setPrenom(result.getString("prenom"));
				candidat.setCin(result.getString("cin"));
				candidat.setDateNaissance(result.getDate("dateNaissance"));
				candidat.setNumTel(result.getString("numTel"));
				candidat.setAdresse(result.getString("adresse"));
				
				list.add(candidat);
			}
			state.close();
			result.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
	//Get Candidats by id
	public Candidats findById (int id) {
		
		connexion = Database.getInstance().getConexion();
		Candidats candidat = new Candidats();
		try {
			state = connexion != null ? connexion.createStatement() : null ;
			result = state.executeQuery("SELECT * FROM candidats where id="+id);
			while (result.next()) {				
				candidat.setId(result.getInt("id"));
				candidat.setNom(result.getString("nom"));
				candidat.setPrenom(result.getString("prenom"));
				candidat.setCin(result.getString("cin"));
				candidat.setDateNaissance(result.getDate("dateNaissance"));
				candidat.setNumTel(result.getString("numTel"));
				candidat.setAdresse(result.getString("adresse"));
			}
			state.close();
			result.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return candidat;
		
	}
	
	
	//Recherche candidat
	public ArrayList<Candidats> search(SearchCandidat params){

		ArrayList<Candidats> list = new ArrayList<Candidats>();
		connexion = Database.getInstance().getConexion();
		Candidats candidat;
		try {
			
			state = connexion != null ? connexion.createStatement() : null ;
			String sql;
			String where="";
			
			if(!params.getCin().isEmpty())
			{
				where += "and cin = '"+params.getCin()+"'";
			}
			
			if(!params.getNom().isEmpty())
			{
				where += " and nom like '%"+params.getNom()+"%'";
			}
			
			if(!params.getPrenom().isEmpty())
			{
				where += " and prenom like '%"+params.getPrenom()+"%'";
			}
			
			sql = "select * from candidats where 1=1  "+where;
			
			ResultSet result = state.executeQuery(sql);
			while (result.next()) {
				candidat = new Candidats();
				
				candidat.setId(result.getInt("id"));
				candidat.setNom(result.getString("nom"));
				candidat.setPrenom(result.getString("prenom"));
				candidat.setCin(result.getString("cin"));
				candidat.setDateNaissance(result.getDate("dateNaissance"));
				candidat.setNumTel(result.getString("numTel"));
				candidat.setAdresse(result.getString("adresse"));
				
				list.add(candidat);
			}
			state.close();
			result.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	
	//Ajouter Candidat
	public int add (Candidats candidat) {
			
		connexion = Database.getInstance().getConexion();
		int checkResult = 0;
		try {			
			
			prepState = connexion.prepareStatement("insert into candidats (nom,prenom,cin,dateNaissance,numTel,adresse) values (?,?,?,?,?,?)");
			prepState.setString(1,candidat.getNom());
			prepState.setString(2,candidat.getPrenom());
			prepState.setString(3,candidat.getCin());
			prepState.setDate(4,candidat.getDateNaissance());
			prepState.setString(5,candidat.getNumTel());
			prepState.setString(6,candidat.getAdresse());
			
			checkResult = prepState.executeUpdate();
			
			
			prepState.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return checkResult;
		
	}
	
	//Modifier Candidat
	public int edit (Candidats candidat) {
		
		connexion = Database.getInstance().getConexion();
		int checkResult = 0;
		try {
			prepState = connexion.prepareStatement("update candidats set nom=?,prenom=?,cin=?,dateNaissance=?,numTel=?,adresse=? where id=?");
			prepState.setString(1,candidat.getNom());
			prepState.setString(2,candidat.getPrenom());
			prepState.setString(3,candidat.getCin());
			prepState.setDate(4,candidat.getDateNaissance());
			prepState.setString(5,candidat.getNumTel());
			prepState.setString(6,candidat.getAdresse());
			prepState.setInt(7,candidat.getId());

			checkResult = prepState.executeUpdate();
			
			
			prepState.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return checkResult;
	}
	
	
	//Supprimer Candidat
		public int delete (int id) {
			
			connexion = Database.getInstance().getConexion();
			int checkResult = 0;
			try {
				state = connexion != null ? connexion.createStatement() : null ;
				
				checkResult =  state.executeUpdate("delete from candidats where id="+id);
				
				state.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return checkResult;
		}
	
}
