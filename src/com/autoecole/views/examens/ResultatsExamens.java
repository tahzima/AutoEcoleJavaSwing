package com.autoecole.views.examens;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.autoecole.beans.Candidats;
import com.autoecole.beans.Examens;
import com.autoecole.controller.CandidatController;
import com.autoecole.controller.ExamenController;
import com.toedter.calendar.JDateChooser;

import javafx.scene.control.ComboBox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class ResultatsExamens extends JFrame implements MouseListener,DocumentListener,ItemListener{

	/*COMPONENTS*/
	private JPanel contentPane;
	private JPanel contentPnl;
	private JPanel separateur1Pnl;
	private JPanel separateur2Pnl;
	private JLabel gestionExamensLbl ;
	private JLabel resultatsExamenLbl;
	private JLabel candidatLbl;
	private JLabel enregistrerImageLbl;
	private JLabel annulerImagreLbl;
	private JLabel retourImageLbl;
	private JLabel typePermisLbl;
	private JLabel lblEchecsThoriques;
	private JLabel lblEchecsPratiques;
	private JLabel lblDecisionTheorique;
	private JLabel lblDecisionPratique;
	private JLabel lblEchecsTotals;
	private JLabel lblNoteThorique;
	private JLabel lblDecisionFinale;
	private JTextField candidatTxt;
	private JTextField typePermisTxt;
	private JTextField noteTheoriqueTxt;
	private JTextField echecsTheoriquesTxt;
	private JTextField decisionFinaleTxt;
	private JTextField echecsTotalsTxt;
	private JTextField echecsPratiquesTxt;
	private JTextField decisionTheoriqueTxt;
	private JComboBox decisionPratiqueComboBox;
	private JSeparator separator1;
	private JSeparator separator2;
	/*VARIABLES*/
	private Image iconAjouter;
	private Image iconAnnuler;
	private CandidatController candidatCtrl;
	private ExamenController examenCtrl;
	private GestionExamens gestionExamen;
	private Examens originalExamen;
	private Examens updatedExamen;
	private Examens updatedExamen2;
	
	private void colorFields(Examens exam) {
		if(exam.getDecisionFinale().equals(Examens.Decision.EN_ATTENTE.toString()))
			decisionFinaleTxt.setBackground(Color.white);
		else if(exam.getDecisionFinale().equals(Examens.Decision.EN_PROGRESSION.toString()))
			decisionFinaleTxt.setBackground(Color.cyan);
		else if(exam.getDecisionFinale().equals(Examens.Decision.RATTRAPAGE.toString()))
			decisionFinaleTxt.setBackground(Color.yellow);
		else if(exam.getDecisionFinale().equals(Examens.Decision.REUSSI.toString()))
			decisionFinaleTxt.setBackground(Color.green);
		else if(exam.getDecisionFinale().equals(Examens.Decision.ECHOUE.toString()))
			decisionFinaleTxt.setBackground(Color.red);
		
		if(exam.getDecisionTheorique().equals(Examens.Decision.EN_ATTENTE.toString()))
			decisionTheoriqueTxt.setBackground(Color.white);
		else if(exam.getDecisionTheorique().equals(Examens.Decision.RATTRAPAGE.toString()))
			decisionTheoriqueTxt.setBackground(Color.yellow);
		else if(exam.getDecisionTheorique().equals(Examens.Decision.REUSSI.toString()))
			decisionTheoriqueTxt.setBackground(Color.green);
		else if(exam.getDecisionTheorique().equals(Examens.Decision.ECHOUE.toString()))
			decisionTheoriqueTxt.setBackground(Color.red);
		
		if(exam.getDecisionPratique().equals(Examens.Decision.EN_ATTENTE.toString()))
			decisionPratiqueComboBox.setBackground(Color.white);
		else if(exam.getDecisionPratique().equals(Examens.Decision.RATTRAPAGE.toString()))
			decisionPratiqueComboBox.setBackground(Color.yellow);
		else if(exam.getDecisionPratique().equals(Examens.Decision.REUSSI.toString()))
			decisionPratiqueComboBox.setBackground(Color.green);
		else if(exam.getDecisionPratique().equals(Examens.Decision.ECHOUE.toString()))
			decisionPratiqueComboBox.setBackground(Color.red);
		
	}
	
	private void fillFields(Examens exam) {
		candidatCtrl = new CandidatController();
		String nomCandidat = candidatCtrl.findById(exam.getIdCandidat()).getNom();
		String prenomCandidat = candidatCtrl.findById(exam.getIdCandidat()).getPrenom();
		candidatTxt.setText(nomCandidat+" "+prenomCandidat);
		typePermisTxt.setText(exam.getTypePermis());
		echecsTheoriquesTxt.setText(String.valueOf(exam.getNbEchecTheorique()));
		decisionFinaleTxt.setText(exam.getDecisionFinale());
		echecsTotalsTxt.setText(String.valueOf(exam.getNbEchecTotal()));
		echecsPratiquesTxt.setText(String.valueOf(exam.getNbEchecPratique()));
		decisionTheoriqueTxt.setText(exam.getDecisionTheorique());
	}

	
	/**
	 * Create the frame.
	 */
	public ResultatsExamens(final Examens examenArg,final  GestionExamens gestionExam) {
		setTitle("R\u00E9sultats Examen");
		
		setLocationRelativeTo(null);
		setBounds(100, 100, 451, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Local To Global*/
		gestionExamen = gestionExam;
		originalExamen = examenArg;
		
		/*Création des composants*/
		contentPnl = new JPanel();
		contentPnl.setLayout(null);
		contentPnl.setBackground(new Color(52, 73, 94));
		contentPnl.setBounds(0, 0, 435, 477);
		contentPane.add(contentPnl);
		
		separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(new Color(126, 214, 223));
		separateur1Pnl.setBounds(0, 57, 432, 10);
		contentPnl.add(separateur1Pnl);
		
		separateur2Pnl = new JPanel();
		separateur2Pnl.setBackground(new Color(126, 214, 223));
		separateur2Pnl.setBounds(0, 117, 432, 10);
		contentPnl.add(separateur2Pnl);
		
		gestionExamensLbl = new JLabel("Gestion Examens");
		gestionExamensLbl.setForeground(new Color(143, 188, 143));
		gestionExamensLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionExamensLbl.setBounds(169, 11, 161, 48);
		contentPnl.add(gestionExamensLbl);
		
		resultatsExamenLbl = new JLabel("R\u00E9sultats Examen");
		resultatsExamenLbl.setForeground(new Color(143, 188, 143));
		resultatsExamenLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		resultatsExamenLbl.setBounds(169, 78, 154, 28);
		contentPnl.add(resultatsExamenLbl);
		
		candidatLbl = new JLabel("Candidat :");
		candidatLbl.setHorizontalAlignment(SwingConstants.CENTER);
		candidatLbl.setForeground(new Color(143, 188, 143));
		candidatLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		candidatLbl.setBounds(28, 138, 63, 20);
		contentPnl.add(candidatLbl);
		
		typePermisLbl = new JLabel("Type Permis :");
		typePermisLbl.setHorizontalAlignment(SwingConstants.CENTER);
		typePermisLbl.setForeground(new Color(143, 188, 143));
		typePermisLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		typePermisLbl.setBounds(28, 171, 74, 20);
		contentPnl.add(typePermisLbl);
		
		iconAjouter = new ImageIcon(this.getClass().getResource("/accept.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		enregistrerImageLbl = new JLabel();
		enregistrerImageLbl.setIcon(new ImageIcon(iconAjouter));
		enregistrerImageLbl.setBounds(297, 410, 46, 42);
		contentPnl.add(enregistrerImageLbl);
		
		iconAnnuler = new ImageIcon(this.getClass().getResource("/annuler.png")).getImage();
		annulerImagreLbl = new JLabel();
		annulerImagreLbl.setIcon(new ImageIcon(iconAnnuler));
		annulerImagreLbl.setBounds(367, 410, 46, 42);
		contentPnl.add(annulerImagreLbl);
		
		retourImageLbl = new JLabel("");
		retourImageLbl.setBounds(494, 438, 46, 14);
		contentPnl.add(retourImageLbl);
		
		candidatTxt = new JTextField();
		candidatTxt.setEditable(false);
		candidatTxt.setBounds(169, 140, 227, 20);
		candidatTxt.setColumns(10);
		contentPnl.add(candidatTxt);
		
		typePermisTxt = new JTextField();
		typePermisTxt.setEditable(false);
		typePermisTxt.setBounds(169, 173, 120, 20);
		typePermisTxt.setColumns(10);
		contentPnl.add(typePermisTxt);
		
		lblEchecsThoriques = new JLabel("Echecs th\u00E9oriques :");
		lblEchecsThoriques.setHorizontalAlignment(SwingConstants.CENTER);
		lblEchecsThoriques.setForeground(new Color(143, 188, 143));
		lblEchecsThoriques.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblEchecsThoriques.setBounds(28, 305, 99, 20);
		contentPnl.add(lblEchecsThoriques);
		
		lblEchecsPratiques = new JLabel("Echecs pratiques :");
		lblEchecsPratiques.setHorizontalAlignment(SwingConstants.CENTER);
		lblEchecsPratiques.setForeground(new Color(143, 188, 143));
		lblEchecsPratiques.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblEchecsPratiques.setBounds(28, 377, 99, 20);
		contentPnl.add(lblEchecsPratiques);
		
		lblDecisionTheorique = new JLabel("Decision th\u00E9orique :");
		lblDecisionTheorique.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecisionTheorique.setForeground(new Color(143, 188, 143));
		lblDecisionTheorique.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblDecisionTheorique.setBounds(28, 336, 104, 20);
		contentPnl.add(lblDecisionTheorique);
		
		lblDecisionPratique = new JLabel("Decision pratique :");
		lblDecisionPratique.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecisionPratique.setForeground(new Color(143, 188, 143));
		lblDecisionPratique.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblDecisionPratique.setBounds(28, 410, 99, 20);
		contentPnl.add(lblDecisionPratique);
		
		lblEchecsTotals = new JLabel("Echecs totals :");
		lblEchecsTotals.setHorizontalAlignment(SwingConstants.CENTER);
		lblEchecsTotals.setForeground(new Color(143, 188, 143));
		lblEchecsTotals.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblEchecsTotals.setBounds(28, 202, 74, 20);
		contentPnl.add(lblEchecsTotals);
		
		lblNoteThorique = new JLabel("Note th\u00E9orique :");
		lblNoteThorique.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoteThorique.setForeground(new Color(143, 188, 143));
		lblNoteThorique.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblNoteThorique.setBounds(28, 274, 84, 20);
		contentPnl.add(lblNoteThorique);
		
		lblDecisionFinale = new JLabel("Decision finale :");
		lblDecisionFinale.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecisionFinale.setForeground(new Color(143, 188, 143));
		lblDecisionFinale.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblDecisionFinale.setBounds(28, 233, 84, 20);
		contentPnl.add(lblDecisionFinale);
		
		separator1 = new JSeparator();
		separator1.setBounds(28, 264, 385, 10);
		contentPnl.add(separator1);
		
		noteTheoriqueTxt = new JTextField();
		noteTheoriqueTxt.setBounds(169, 276, 86, 20);
		contentPnl.add(noteTheoriqueTxt);
		noteTheoriqueTxt.setColumns(10);
		
		echecsTheoriquesTxt = new JTextField();
		echecsTheoriquesTxt.setBounds(169, 307, 86, 20);
		echecsTheoriquesTxt.setEditable(false);
		echecsTheoriquesTxt.setColumns(10);
		contentPnl.add(echecsTheoriquesTxt);
		
		decisionFinaleTxt = new JTextField();
		decisionFinaleTxt.setColumns(10);
		decisionFinaleTxt.setBounds(169, 235, 86, 20);
		decisionFinaleTxt.setEditable(false);
		contentPnl.add(decisionFinaleTxt);
		
		echecsTotalsTxt = new JTextField();
		echecsTotalsTxt.setColumns(10);
		echecsTotalsTxt.setBounds(169, 204, 86, 20);
		echecsTotalsTxt.setEditable(false);
		contentPnl.add(echecsTotalsTxt);
		
		separator2 = new JSeparator();
		separator2.setBounds(28, 365, 385, 10);
		contentPnl.add(separator2);
		
		echecsPratiquesTxt = new JTextField();
		echecsPratiquesTxt.setColumns(10);
		echecsPratiquesTxt.setBounds(169, 379, 86, 20);
		echecsPratiquesTxt.setEditable(false);
		contentPnl.add(echecsPratiquesTxt);
		
		decisionTheoriqueTxt = new JTextField();
		decisionTheoriqueTxt.setColumns(10);
		decisionTheoriqueTxt.setBounds(169, 338, 86, 20);
		decisionTheoriqueTxt.setEditable(false);
		contentPnl.add(decisionTheoriqueTxt);
		
		String[] choixCombo = new String[4];
		
		if(originalExamen.getNbEchecTotal()==0) {
			choixCombo[0] = Examens.Decision.EN_ATTENTE.toString();
			choixCombo[1] = Examens.Decision.RATTRAPAGE.toString();
			choixCombo[2] = Examens.Decision.REUSSI.toString();
			choixCombo[3] = Examens.Decision.ECHOUE.toString();
		}
		else if(originalExamen.getNbEchecTotal()==1) {
			choixCombo[0] = Examens.Decision.EN_ATTENTE.toString();
			choixCombo[1] = Examens.Decision.REUSSI.toString();
			choixCombo[2] = Examens.Decision.ECHOUE.toString();
		}
		
		decisionPratiqueComboBox = new JComboBox(choixCombo);
		decisionPratiqueComboBox.setEditable(false);
		decisionPratiqueComboBox.setBounds(169, 410, 118, 20);
		contentPnl.add(decisionPratiqueComboBox);
		
		String decisionFinale = originalExamen.getDecisionFinale(); 
		String decisionReussi = Examens.Decision.REUSSI.toString();
		String decisionEchoue = Examens.Decision.ECHOUE.toString();
		
		if(decisionFinale.equals(decisionReussi) || decisionFinale.equals(decisionEchoue)) {
			noteTheoriqueTxt.setEditable(false);
			UIManager.put("ComboBox.disabledBackground", Color.green);
			decisionPratiqueComboBox.setEnabled(false);
		}
		else if(!originalExamen.getDecisionTheorique().equals(Examens.Decision.REUSSI.toString()))
			decisionPratiqueComboBox.setEnabled(false);
		
		fillFields(originalExamen);
		noteTheoriqueTxt.setText(String.valueOf(originalExamen.getNoteTheorique()));
		decisionPratiqueComboBox.setSelectedItem(originalExamen.getDecisionPratique());
		colorFields(originalExamen);
		
		/*Action Listeners*/
		enregistrerImageLbl.addMouseListener(this);
		annulerImagreLbl.addMouseListener(this);
		noteTheoriqueTxt.getDocument().addDocumentListener(this);
		decisionPratiqueComboBox.addItemListener(this);
		
		updatedExamen = new Examens(originalExamen);
		updatedExamen2 = new Examens(updatedExamen);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Enregistrer Clicked
		if(e.getComponent() == enregistrerImageLbl) {
			examenCtrl = new ExamenController();
			int check = examenCtrl.setResultats(updatedExamen2);	
			if(check==1) {
				examenCtrl = new ExamenController();
				gestionExamen.setListExamens(examenCtrl.getAll());
				gestionExamen.refresh(gestionExamen.getListExamens());
				dispose();
			}
			else if(check==0)
				JOptionPane.showMessageDialog(null,"Une erreur s'est produite!");
			
		}
		//Annuler Clicked
		else if(e.getComponent() == annulerImagreLbl)
			dispose();
	}

	/*NOT USED*/
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(e.getDocument()==noteTheoriqueTxt.getDocument()) {
			
			int noteTheorique = Integer.parseInt(noteTheoriqueTxt.getText());
			
			examenCtrl = new ExamenController();
			updatedExamen = new Examens(originalExamen);
			updatedExamen.setNoteTheorique(noteTheorique);
			updatedExamen = examenCtrl.updateExamenTheoriqueFields(updatedExamen);
			fillFields(updatedExamen);
			colorFields(updatedExamen);
			
			if(updatedExamen.getDecisionTheorique().equals(Examens.Decision.REUSSI.toString()))
				decisionPratiqueComboBox.setEnabled(true);
			else
				decisionPratiqueComboBox.setEnabled(false);
			
			updatedExamen2 = new Examens(updatedExamen);
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if(e.getDocument()==noteTheoriqueTxt.getDocument()) {
			if(noteTheoriqueTxt.getText().isEmpty()) {
				fillFields(originalExamen);
				decisionPratiqueComboBox.setSelectedItem(originalExamen.getDecisionPratique());
				colorFields(originalExamen);
				updatedExamen = new Examens(originalExamen);	
			}
			else {
				examenCtrl = new ExamenController();
				updatedExamen = new Examens(originalExamen);
				updatedExamen.setNoteTheorique(Integer.parseInt(noteTheoriqueTxt.getText()));
				updatedExamen = examenCtrl.updateExamenTheoriqueFields(updatedExamen);
				fillFields(updatedExamen);
				colorFields(updatedExamen);
				
				if(updatedExamen.getDecisionTheorique().equals(Examens.Decision.REUSSI.toString()))
					decisionPratiqueComboBox.setEnabled(true);
				else {
					decisionPratiqueComboBox.setEnabled(false);
					decisionPratiqueComboBox.setSelectedItem(Examens.Decision.EN_ATTENTE.toString());
					decisionPratiqueComboBox.setBackground(Color.white);
				}
			}
			updatedExamen2 = new Examens(updatedExamen);
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource()==decisionPratiqueComboBox) {
			if(decisionPratiqueComboBox.getSelectedItem().equals(Examens.Decision.EN_ATTENTE.toString())) {
				fillFields(updatedExamen);
			}
			else {
				updatedExamen2 = new Examens(updatedExamen);
				updatedExamen2.setDecisionPratique(decisionPratiqueComboBox.getSelectedItem().toString());
				updatedExamen2 = examenCtrl.updateExamenPratiqueFields(updatedExamen2);
				fillFields(updatedExamen2);
				colorFields(updatedExamen2);
			}
		}
	}
}
