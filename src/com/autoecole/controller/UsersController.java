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
import com.autoecole.beans.Examens;
import com.autoecole.beans.SearchCandidat;
import com.autoecole.beans.SearchUser;
import com.autoecole.beans.Users;
import com.autoecole.service.Database;

public class UsersController {
	
	private Connection connexion;
	private Statement state;
	private PreparedStatement prepState;
	private ResultSet result;
	
	private void remplirUser(ResultSet resultSet, Users user) {
		try {
			user.setId(resultSet.getInt("id"));
			user.setLogin(resultSet.getString("login"));
			user.setPassword(resultSet.getString("password"));
			user.setNom(resultSet.getString("nom"));
			user.setPrenom(resultSet.getString("prenom"));
			user.setPoste(resultSet.getString("poste"));
			user.setCin(resultSet.getString("cin"));
			user.setId_Personnels(resultSet.getInt("id_Personnels"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Get All users
	public ArrayList<Users> getAll () {
		
		ArrayList<Users> list = new ArrayList<Users>();
		connexion = Database.getInstance().getConexion();
		Users user;
		try {
			state = connexion != null ? connexion.createStatement() : null ;
			result = state.executeQuery("Select * from usersview");
			while (result.next()) {
				user = new Users();
				remplirUser(result, user);				
				list.add(user);
			}
			state.close();
			result.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	//Get user by id
	public Users findById (int id) {
		
		connexion = Database.getInstance().getConexion();
		Users user = new Users();
		try {
			state = connexion != null ? connexion.createStatement() : null ;
			result = state.executeQuery("SELECT * FROM usersview where id="+id);
			while (result.next()) {				
				remplirUser(result, user);	
			}
			state.close();
			result.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	
	//Recherche users
	public ArrayList<Users> search(SearchUser params){

		ArrayList<Users> list = new ArrayList<Users>();
		connexion = Database.getInstance().getConexion();
		Users user;
		try {
			
			state = connexion != null ? connexion.createStatement() : null ;
			String sql;
			String where="";
			
			if(!params.getLogin().isEmpty())
			{
				where += "and login = '"+params.getLogin()+"'";
			}
			
			if(!params.getNom().isEmpty())
			{
				where += " and nom like '%"+params.getNom()+"%'";
			}
			
			if(!params.getPrenom().isEmpty())
			{
				where += " and prenom like '%"+params.getPrenom()+"%'";
			}
			
			sql = "select * from usersview where 1=1  "+where;
			
			ResultSet result = state.executeQuery(sql);
			while (result.next()) {
				user = new Users();
				remplirUser(result, user);	
				list.add(user);
			}
			state.close();
			result.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//Ajouter user
	public int add (Users user) {
			
		connexion = Database.getInstance().getConexion();
		int checkResult = 0;
		try {
			prepState = connexion.prepareStatement("insert into users (login,password,id_Personnels) values (?,?,?)");
			prepState.setString(1,user.getLogin());
			prepState.setString(2,user.getPassword());
			prepState.setInt(3,user.getId_Personnels());
			
			checkResult = prepState.executeUpdate();
			
			prepState.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return checkResult;
		
	}
	
	//Modifier user
	public int edit (Users user) {
		
		connexion = Database.getInstance().getConexion();
		int checkResult = 0;
		try {
			prepState = connexion.prepareStatement("update users set login=?,password=? where id=?");
			prepState.setString(1,user.getLogin());
			prepState.setString(2,user.getPassword());
			prepState.setInt(3,user.getId());

			checkResult = prepState.executeUpdate();
			
			prepState.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return checkResult;
	}
	
	
	//Supprimer user
		public int delete (int id) {
			
			connexion = Database.getInstance().getConexion();
			int checkResult = 0;
			try {
				state = connexion != null ? connexion.createStatement() : null ;
				
				checkResult =  state.executeUpdate("delete from users where id="+id);
				
				state.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return checkResult;
		}
	
		
		public int checkUserExist(int idPersonnel) {
			
			connexion = Database.getInstance().getConexion();
			int count = 0;
			try {
				state = connexion != null ? connexion.createStatement() : null ;
				result = state.executeQuery("select count(*) from users where id_Personnels="+idPersonnel);
				while (result.next()) {				
					count = result.getInt(1);	
				}
				state.close();
				result.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return count;	
		}
		
		
}
