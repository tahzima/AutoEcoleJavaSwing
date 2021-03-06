package com.autoecole.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private static Database instance = new Database();
	private java.lang.String url = "jdbc:mysql://localhost:3306/autoecole?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private java.lang.String user = "root";
	private java.lang.String passwd = "";
	private Connection conexion;
	
	public static Database getInstance() {
		return instance;
	}
	
	private Database() {
		if (conexion == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion = DriverManager.getConnection(url, user, passwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Connection getConexion() {
		return conexion;
	}
}
