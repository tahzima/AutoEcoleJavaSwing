package com.autoecole.beans;

import java.sql.Date;

public class Examens {
	
	//Examen
	private int idExamen;
	private Date dateExamen;//NOT NULL
	private int nbEchecTotal;
	private int idCandidat;//NOT NULL
	private String typePermis;//NOT NULL
	private String decisionFinale;
	//Theorique
	private int idExamenTheorique;
	private int noteTheorique;
	private String decisionTheorique;
	private Date dateExamenTheorique;//NOT NULL
	private int nbEchecTheorique;
	//Pratique
	private int idExamenPratique;
	private String decisionPratique;
	private Date dateExamenPratique;//NOT NULL
	private int nbEchecPratique;
	// Constants
	public enum Decision{
		EN_ATTENTE("En attente"),
		EN_PROGRESSION("En progression"),
		RATTRAPAGE("Rattrapage"),
		REUSSI("Réussi"),
		ECHOUE("Echoué");
		
		private String value;

		Decision(String arg){
			this.value = arg;
		}
		
		@Override
		public String toString() {
			return value;
		}
	}
	
	public Examens() {}
	public Examens(Examens examen) {
		this.setIdExamen(examen.getIdExamen());
		this.setDateExamen(examen.getDateExamen());
		this.setNbEchecTotal(examen.getNbEchecTotal());
		this.setIdCandidat(examen.getIdCandidat());
		this.setTypePermis(examen.getTypePermis());
		this.setIdExamenTheorique(examen.getIdExamenTheorique());
		this.setNoteTheorique(examen.getNoteTheorique());
		this.setDecisionTheorique(examen.getDecisionTheorique());
		this.setDateExamenTheorique(examen.getDateExamenTheorique());
		this.setNbEchecTheorique(examen.getNbEchecTheorique());
		this.setIdExamenPratique(examen.getIdExamenTheorique());
		this.setDecisionPratique(examen.getDecisionPratique());
		this.setDateExamenPratique(examen.getDateExamenPratique());
		this.setNbEchecPratique(examen.getNbEchecPratique());
		this.setDecisionFinale(examen.getDecisionFinale());
	}
	
	public int getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}
	public Date getDateExamen() {
		return dateExamen;
	}
	public void setDateExamen(Date dateExamen) {
		this.dateExamen = dateExamen;
	}
	public int getNbEchecTotal() {
		return nbEchecTotal;
	}
	public void setNbEchecTotal(int nbEchecTotal) {
		this.nbEchecTotal = nbEchecTotal;
	}
	public int getIdCandidat() {
		return idCandidat;
	}
	public void setIdCandidat(int idCandidat) {
		this.idCandidat = idCandidat;
	}
	public String getTypePermis() {
		return typePermis;
	}
	public void setTypePermis(String typePermis) {
		this.typePermis = typePermis;
	}
	public int getIdExamenTheorique() {
		return idExamenTheorique;
	}
	public void setIdExamenTheorique(int idExamenTheorique) {
		this.idExamenTheorique = idExamenTheorique;
	}
	public int getNoteTheorique() {
		return noteTheorique;
	}
	public void setNoteTheorique(int noteTheorique) {
		this.noteTheorique = noteTheorique;
	}
	public String getDecisionTheorique() {
		return decisionTheorique;
	}
	public void setDecisionTheorique(String decisionTheorique) {
		this.decisionTheorique = decisionTheorique;
	}
	public Date getDateExamenTheorique() {
		return dateExamenTheorique;
	}
	public void setDateExamenTheorique(Date dateExamenTheorique) {
		this.dateExamenTheorique = dateExamenTheorique;
	}
	public int getNbEchecTheorique() {
		return nbEchecTheorique;
	}
	public void setNbEchecTheorique(int nbEchecTheorique) {
		this.nbEchecTheorique = nbEchecTheorique;
	}
	public int getIdExamenPratique() {
		return idExamenPratique;
	}
	public void setIdExamenPratique(int idExamenPratique) {
		this.idExamenPratique = idExamenPratique;
	}
	public String getDecisionPratique() {
		return decisionPratique;
	}
	public void setDecisionPratique(String decisionPratique) {
		this.decisionPratique = decisionPratique;
	}
	public Date getDateExamenPratique() {
		return dateExamenPratique;
	}
	public void setDateExamenPratique(Date dateExamenPratique) {
		this.dateExamenPratique = dateExamenPratique;
	}
	public int getNbEchecPratique() {
		return nbEchecPratique;
	}
	public void setNbEchecPratique(int nbEchecPratique) {
		this.nbEchecPratique = nbEchecPratique;
	}
	public String getDecisionFinale() {
		return decisionFinale;
	}
	public void setDecisionFinale(String decisionFinale) {
		this.decisionFinale = decisionFinale;
	}
	
	
}
