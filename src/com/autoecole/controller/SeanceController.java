package com.autoecole.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.autoecole.beans.Candidats;
import com.autoecole.beans.Personnels;
import com.autoecole.beans.Seances;
import com.autoecole.beans.SearchPersonnel;
import com.autoecole.beans.SearchSeance;
import com.autoecole.service.Database;

public class SeanceController {
	
	private Connection connexion;
	private Statement state;
	private PreparedStatement prepState;
	private ResultSet result;
	
	//ajouter une seance
	
	public int add (Seances seance) {
		
		connexion = Database.getInstance().getConexion();
		int checkResult = 0;
		try {			
			if(seance.getId_Personnels()>0 && seance.getId_Vehicules()>0){

				prepState = connexion.prepareStatement("insert into seances (date,typeSeance,id_Vehicules,id_Personnels) values (?,?,?,?)");
				prepState.setDate(1,seance.getDate());
				prepState.setString(2,seance.getTypeSeance());
				prepState.setInt(3, seance.getId_Vehicules());
				prepState.setInt(4, seance.getId_Personnels());
			}else if(seance.getId_Personnels()>0 && seance.getId_Vehicules()<0) {
				prepState = connexion.prepareStatement("insert into seances (date,typeSeance,id_Personnels) values (?,?,?)");
				prepState.setDate(1,seance.getDate());
				prepState.setString(2,seance.getTypeSeance());
				prepState.setInt(3, seance.getId_Personnels());
			}
			
			checkResult = prepState.executeUpdate();
			
			prepState.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return checkResult;
		
	}
	
	//modifier une seance
	
	public int edit (Seances seance) {
		
		connexion = Database.getInstance().getConexion();
		int checkResult = 0;
		try {
			prepState = connexion.prepareStatement("update seances set date=?,typeSeance=?,id_Vehicules=?,id_Personnels=? where id=?");
			prepState.setDate(1,seance.getDate());
			prepState.setString(2,seance.getTypeSeance());
			prepState.setInt(3, seance.getId_Vehicules());
			prepState.setInt(4, seance.getId_Personnels());
			prepState.setInt(5,seance.getId());

			checkResult = prepState.executeUpdate();
			
			
			prepState.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return checkResult;
	}
	
	//supprimer une seance
	
	public int delete (int id) {
		
		connexion = Database.getInstance().getConexion();
		int checkResult = 0;
		try {
			state = connexion != null ? connexion.createStatement() : null ;
			
			checkResult =  state.executeUpdate("delete from seances where id="+id);
			
			state.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return checkResult;
	}
	
	//get all seances
	
	public ArrayList<Seances> getAll () {
		
		ArrayList<Seances> list = new ArrayList<Seances>();
		connexion = Database.getInstance().getConexion();
		Seances seance;
		try {
			state = connexion != null ? connexion.createStatement() : null ;
			result = state.executeQuery("SELECT * FROM seances");
			while (result.next()) {
				seance = new Seances();
				
				seance.setId(result.getInt("id"));
				seance.setDate(result.getDate("date"));
				seance.setTypeSeance(result.getString("typeSeance"));
				seance.setId_Vehicules(result.getInt("id_Vehicules"));
				seance.setId_Personnels(result.getInt("id_Personnels"));
				
				list.add(seance);
			}
			state.close();
			result.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	// recherche par Type et date
	
	public List<Seances> search(SearchSeance params){
		Connection conexion = Database.getInstance().getConexion();
		Seances seance;
		List<Seances> listSeance = new ArrayList<Seances>();
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			String sql;
			String where="";
			
			if(!params.getTypeSeance().isEmpty())
			{
				where += "and typeSeance like '"+params.getTypeSeance()+"'";
			}
			
			if(params.getDateSeance().toString()!="")
			{
				where += " and date like '%"+params.getDateSeance()+"%'";
			}
			
			sql = "select * from Seances where 1=1  "+where;
			
			ResultSet resultSeance = state.executeQuery(sql);
				while (resultSeance.next()) {
					seance = new Seances();
					seance.setId(resultSeance.getInt("id"));
					seance.setDate(resultSeance.getDate("date"));
					seance.setTypeSeance(resultSeance.getString("typeSeance"));
					seance.setId_Personnels(resultSeance.getInt("id_Personnels"));
					seance.setId_Vehicules(resultSeance.getInt("id_Vehicules"));
					listSeance.add(seance);
				}
			state.close();
			resultSeance.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} 
		return listSeance;
	}
}
