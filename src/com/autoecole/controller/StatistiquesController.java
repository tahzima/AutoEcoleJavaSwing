package com.autoecole.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.autoecole.service.Database;

public class StatistiquesController {
	public Float getAllCandidatEchouer(){
		Connection conexion = Database.getInstance().getConexion();
		float pourcentage=-1;
		float nbCandidatEchoue=0;
		float nbCandidat=0;
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			ResultSet resultSommeCandidatEchoue = state.executeQuery("SELECT COUNT(id) FROM examens where decision like 'Echoué'");
			while (resultSommeCandidatEchoue.next()) {
				nbCandidatEchoue=resultSommeCandidatEchoue.getInt(1);
			}
			resultSommeCandidatEchoue.close();
			
			ResultSet resultSommeCandidat = state.executeQuery("SELECT COUNT(id) FROM examens");
			while (resultSommeCandidat.next()) {
				nbCandidat=resultSommeCandidat.getInt(1);
			}
			resultSommeCandidat.close();
			state.close();
			pourcentage=(nbCandidatEchoue*100)/nbCandidat;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return pourcentage;
	}
	
	
	public Float getAllCandidatReussi(){
		Connection conexion = Database.getInstance().getConexion();
		float pourcentage=-1;
		float nbCandidatReussi=0;
		float nbCandidat=0;
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			ResultSet resultSommeCandidatEchoue = state.executeQuery("SELECT COUNT(id) FROM examens where decision like 'Réussi'");
			while (resultSommeCandidatEchoue.next()) {
				nbCandidatReussi=resultSommeCandidatEchoue.getInt(1);
			}
			resultSommeCandidatEchoue.close();
			
			ResultSet resultSommeCandidat = state.executeQuery("SELECT COUNT(id) FROM examens");
			while (resultSommeCandidat.next()) {
				nbCandidat=resultSommeCandidat.getInt(1);
			}
			resultSommeCandidat.close();
			state.close();
			pourcentage=(nbCandidatReussi*100)/nbCandidat;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return pourcentage;
	}
	
	
	public int getAllCandidat(){
		Connection conexion = Database.getInstance().getConexion();
		int nbCandidat=-1;
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			ResultSet resultSommeCandidat = state.executeQuery("SELECT COUNT(id) FROM candidats");
			while (resultSommeCandidat.next()) {
				nbCandidat=resultSommeCandidat.getInt(1);
			}
			resultSommeCandidat.close();
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return nbCandidat;
	}
	
	
	public float getNoteMoyenneTH(){
		Connection conexion = Database.getInstance().getConexion();
		float sommeNoteExamenTH=-1;
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			ResultSet resultNbExamenTH = state.executeQuery("SELECT AVG(note) FROM examenstheoriques");
			while (resultNbExamenTH.next()) {
				sommeNoteExamenTH=resultNbExamenTH.getInt(1);
			}
			resultNbExamenTH.close();
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return sommeNoteExamenTH;
	}
	
	
	public int getNbCandidatPratique(){
		Connection conexion = Database.getInstance().getConexion();
		int sommeNoteExamenTH=-1;
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			ResultSet resultNbExamenTH = state.executeQuery("SELECT COUNT(id) FROM examenspratiques where decision like 'Réussi'");
			while (resultNbExamenTH.next()) {
				sommeNoteExamenTH=resultNbExamenTH.getInt(1);
			}
			resultNbExamenTH.close();
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return sommeNoteExamenTH;
	}
	
	
	public int getNbCandidatTheorique(){
		Connection conexion = Database.getInstance().getConexion();
		int sommeNoteExamenTH=-1;
		try {
			Statement state = conexion != null ? conexion.createStatement() : null;
			ResultSet resultNbExamenTH = state.executeQuery("SELECT COUNT(id) FROM examenstheoriques where decision like 'Réussi'");
			while (resultNbExamenTH.next()) {
				sommeNoteExamenTH=resultNbExamenTH.getInt(1);
			}
			resultNbExamenTH.close();
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return sommeNoteExamenTH;
	}
}
