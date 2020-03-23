package com.autoecole.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.autoecole.beans.Users;
import com.autoecole.service.Database;

public class AuthentificationController {
	public Users authentification(String login, String password) {
		Connection conexion = Database.getInstance().getConexion();
		Users user = new Users();
		try {
			Statement state = conexion != null ? conexion.createStatement() : null ;
			ResultSet result = state.executeQuery("SELECT * FROM users where login like '"+login+"'");
			while (result.next()) {
				if(password.equals(result.getString("password"))){
					user.setId(result.getInt("id"));
					user.setLogin(result.getString("login"));
					user.setPassword(result.getString("password"));
					user.setId_Personnels(result.getInt("id_Personnels"));
				}
			}
			state.close();
			result.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
