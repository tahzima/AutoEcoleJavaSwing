package com.autoecole.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.autoecole.beans.Examens;
import com.autoecole.service.Database;

public class ExamenController {

	private Connection connexion;
	private Statement state;
	private PreparedStatement prepState;
	private ResultSet result;

	private void remplirExamen(ResultSet resultSet, Examens exam) {
		try {
			exam.setIdExamen(resultSet.getInt(1));
			exam.setDateExamen(resultSet.getDate(2));
			exam.setNbEchecTotal(resultSet.getInt(3));
			exam.setIdCandidat(resultSet.getInt(4));
			exam.setTypePermis(resultSet.getString(5));
			exam.setDecisionFinale(resultSet.getString(6));
			exam.setIdExamenTheorique(resultSet.getInt(7));
			exam.setNoteTheorique(resultSet.getInt(8));
			exam.setDecisionTheorique(resultSet.getString(9));
			exam.setDateExamenTheorique(resultSet.getDate(10));
			exam.setNbEchecTheorique(resultSet.getInt(11));
			exam.setIdExamenPratique(resultSet.getInt(12));
			exam.setDecisionPratique(resultSet.getString(13));
			exam.setDateExamenPratique(resultSet.getDate(14));
			exam.setNbEchecPratique(resultSet.getInt(15));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Get All Examens
	public ArrayList<Examens> getAll() {

		ArrayList<Examens> list = new ArrayList<Examens>();
		connexion = Database.getInstance().getConexion();
		Examens examen;
		try {
			state = connexion != null ? connexion.createStatement() : null;
			result = state.executeQuery("select * from examensview");
			while (result.next()) {
				examen = new Examens();
				remplirExamen(result, examen);
				list.add(examen);
			}
			state.close();
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	// Get Examen by id
	public Examens findById(int id) {

		connexion = Database.getInstance().getConexion();
		Examens examen = new Examens();
		try {
			state = connexion != null ? connexion.createStatement() : null;
			result = state.executeQuery("select * from examensview where id=" + id);
			while (result.next()) 
				remplirExamen(result, examen);
			
			state.close();
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examen;
	}

	// Recherche Examen
	public ArrayList<Examens> search(Date duDateExamen, Date auDateExamen) {

		ArrayList<Examens> list = new ArrayList<Examens>();
		connexion = Database.getInstance().getConexion();
		Examens examen = null;
		try {
			prepState = connexion.prepareStatement("select * from examensview where dateExamen between ? and ?");
			prepState.setDate(1, duDateExamen);
			prepState.setDate(2, auDateExamen);
			result = prepState.executeQuery();
			while (result.next()) {
				examen = new Examens();
				remplirExamen(result, examen);
				list.add(examen);
			}
			
			prepState.close();
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// Ajouter Examen
	public int add(Examens examen) {

		connexion = Database.getInstance().getConexion();
		int checkResult = 1;
		try {
			prepState = connexion.prepareStatement("insert into examens (dateExamen,id_Candidats,typePermis,decision) values (?,?,?,?)");
			prepState.setDate(1, examen.getDateExamen());
			prepState.setInt(2, examen.getIdCandidat());
			prepState.setString(3, examen.getTypePermis());
			prepState.setString(4, examen.getDecisionFinale());
			checkResult *= prepState.executeUpdate();
			
			prepState = connexion.prepareStatement("select id from examens where dateExamen=? and id_Candidats=?");
			prepState.setDate(1, examen.getDateExamen());
			prepState.setInt(2, examen.getIdCandidat());
			result = prepState.executeQuery();
			
			int idExamen = 0;
			while(result.next()) {
				if(result.isLast())
					idExamen = result.getInt(1);
				else {
					checkResult = -1;
					break;
				}
			}
				
			if(idExamen>0) {
				prepState = connexion.prepareStatement("insert into examenstheoriques (dateExamen,decision,id_examens) values (?,?,?)");
				prepState.setDate(1, examen.getDateExamen());
				prepState.setString(2, examen.getDecisionTheorique());
				prepState.setInt(3, idExamen);
				checkResult *= prepState.executeUpdate();

				prepState = connexion.prepareStatement("insert into examenspratiques (dateExamen,decision,id_examens) values (?,?,?)");
				prepState.setDate(1, examen.getDateExamen());
				prepState.setString(2, examen.getDecisionPratique());
				prepState.setInt(3, idExamen);
				checkResult *= prepState.executeUpdate();
			}
			
			prepState.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return checkResult;
	}

	// Modifier Examen
	public int edit(Examens examen, int choix) {

		connexion = Database.getInstance().getConexion();
		int checkResult = 1;
		try {
			if (choix == 1) {
				prepState = connexion.prepareStatement("update examens set dateExamen=? where id=?");
				prepState.setDate(1, examen.getDateExamen());
				prepState.setInt(2, examen.getIdExamen());
				checkResult *= prepState.executeUpdate();

				prepState = connexion.prepareStatement("update examenstheoriques set dateExamen=? where id_examens=?");
				prepState.setDate(1, examen.getDateExamen());
				prepState.setInt(2, examen.getIdExamen());
				checkResult *= prepState.executeUpdate();

				prepState = connexion.prepareStatement("update examenspratiques set dateExamen=? where id_examens=?");
				prepState.setDate(1, examen.getDateExamen());
				prepState.setInt(2, examen.getIdExamen());
				checkResult *= prepState.executeUpdate();
			} else if (choix == 2) {
				prepState = connexion.prepareStatement("update examenspratiques set dateExamen=? where id_examens=?");
				prepState.setDate(1, examen.getDateExamenPratique());
				prepState.setInt(2, examen.getIdExamen());
				checkResult *= prepState.executeUpdate();
			}

			prepState.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return checkResult;
	}

	// Supprimer Examen
	public int delete(int id) {

		connexion = Database.getInstance().getConexion();
		int checkResult = 0;
		try {
			state = connexion != null ? connexion.createStatement() : null;

			checkResult = state.executeUpdate("delete from examens where id=" + id);

			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return checkResult;
	}

	// Set Examen Results
	public int setResultats(Examens examen) {
		
		connexion = Database.getInstance().getConexion();
		int checkResult = 1;
		try {
			if(!examen.getDecisionFinale().equals(Examens.Decision.EN_ATTENTE.toString())) {
				prepState = connexion.prepareStatement("update examens set nbEchec=?,decision=? where id=?");
				prepState.setInt(1,examen.getNbEchecTotal());
				prepState.setString(2,examen.getDecisionFinale());
				prepState.setInt(3, examen.getIdExamen());
				checkResult *= prepState.executeUpdate();
	
				prepState = connexion.prepareStatement("update examenstheoriques set note=?,decision=?,nbEchec=? where id_examens=?");
				prepState.setInt(1, examen.getNoteTheorique());
				prepState.setString(2, examen.getDecisionTheorique());
				prepState.setInt(3, examen.getNbEchecTheorique());
				prepState.setInt(4, examen.getIdExamen());
				checkResult *= prepState.executeUpdate();
	
				prepState = connexion.prepareStatement("update examenspratiques set decision=?,nbEchec=? where id_examens=?");
				prepState.setString(1, examen.getDecisionPratique());
				prepState.setInt(2, examen.getNbEchecPratique());
				prepState.setInt(3, examen.getIdExamen());
				checkResult *= prepState.executeUpdate();
				
				prepState.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return checkResult;
	}
	
	// M‡J Examen selon la note theorique
	public Examens updateExamenTheoriqueFields(Examens examen) {
		
		if(examen.getNoteTheorique()<30) {
			if(examen.getDecisionTheorique().equals(Examens.Decision.EN_ATTENTE.toString())) {
				examen.setNbEchecTheorique(examen.getNbEchecTheorique()+1);
				examen.setDecisionTheorique(Examens.Decision.RATTRAPAGE.toString());
				examen.setDecisionFinale(Examens.Decision.RATTRAPAGE.toString());
				examen.setNbEchecTotal(examen.getNbEchecTheorique());
			}
			else if(examen.getDecisionTheorique().equals(Examens.Decision.RATTRAPAGE.toString())) {
				examen.setNbEchecTheorique(examen.getNbEchecTheorique()+1);
				examen.setDecisionTheorique(Examens.Decision.ECHOUE.toString());
				examen.setDecisionFinale(Examens.Decision.ECHOUE.toString());
			}
		}
		else {
			examen.setDecisionTheorique(Examens.Decision.REUSSI.toString());
			examen.setDecisionFinale(Examens.Decision.EN_PROGRESSION.toString());
		}
		return examen;
	}
		
	//M‡J Examen selon la decision pratique
	public Examens updateExamenPratiqueFields(Examens examen) {
		
		if(examen.getDecisionPratique().equals(Examens.Decision.RATTRAPAGE.toString())) {
			examen.setNbEchecPratique(examen.getNbEchecPratique()+1);
			examen.setDecisionFinale(Examens.Decision.RATTRAPAGE.toString());
			examen.setNbEchecTotal(examen.getNbEchecTheorique()+examen.getNbEchecPratique());
		}
		else if (examen.getDecisionPratique().equals(Examens.Decision.ECHOUE.toString())) {
			examen.setNbEchecPratique(examen.getNbEchecPratique()+1);
			examen.setDecisionFinale(Examens.Decision.ECHOUE.toString());
			examen.setNbEchecTotal(examen.getNbEchecTheorique()+examen.getNbEchecPratique());
		}
		else if (examen.getDecisionPratique().equals(Examens.Decision.REUSSI.toString())) {
			examen.setDecisionFinale(Examens.Decision.REUSSI.toString());
		}
		
		
		return examen;
	}
		
		
		
		
		
		
	
}
