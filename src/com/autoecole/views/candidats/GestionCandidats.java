package com.autoecole.views.candidats;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.autoecole.beans.Candidats;
import com.autoecole.beans.SearchCandidat;
import com.autoecole.controller.CandidatController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JSeparator;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseListener;

public class GestionCandidats extends JPanel implements DocumentListener,MouseListener {
	
	/*COMPONENTS*/
	private JLabel prenomLbl;
	private JLabel cinLbl;
	private JLabel rechercheLbl;
	private JLabel listPersonnelsLbl;
	private JLabel ajouterLbl;
	private JLabel modifierLbl;
	private JLabel actualiserLbl;
	private JLabel supprimerLbl;
	private JLabel gestionPersonnelsLbl;
	private JLabel nomLbl;
	private JLabel rehercheLbl;
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JTextField cinTxt;
	private JPanel separateur1Pnl;
	private JPanel separateur2Pnl;
	private JTable candidatsTable;
	private JScrollPane scroll;

	/*VARIABLES*/
	private Image iconRecherche;
	private Image iconAjouter;
	private Image iconModifier;
	private Image iconSupprimer;
	private Image iconActualiser;
	private DefaultTableModel candidatsTableModel;
	private String[] columns = {"Nom","Pr�nom","CIN","Date de naissance","T�l�phone","Adresse"};
	private Object[][] rows;
	private ArrayList<Candidats> listCandidats;
	private ArrayList<Candidats> listTempCandidats;
	private CandidatController candidatCtrl;
	private int rowIndex;
	private int idCandidat;
	private int check;
	private Candidats candidat;
	
	
	/*LOAD JTABLE*/
	public void refresh(List<Candidats> list) {
		
		int k = list.size();
		rows = new Object[k][7];
		
		for(int i=0;i<k;i++) {
			
			rows[i][0] = list.get(i).getNom();	
			rows[i][1] = list.get(i).getPrenom();
			rows[i][2] = list.get(i).getCin();
			rows[i][3] = list.get(i).getDateNaissance();
			rows[i][4] = list.get(i).getNumTel();
			rows[i][5] = list.get(i).getAdresse();
			rows[i][6] = list.get(i).getId();

		}
		DefaultTableModel model  = new DefaultTableModel(rows,columns);
		candidatsTable.setModel(model);	
	}
	

	/**
	 * Create the panel.
	 */
	public GestionCandidats() {
		
		setBackground(Color.decode("#34495e"));
		setBounds(0, 0, 661, 488);
		setLayout(null);
		

		/*JTABLE*/
		//REMPLISSAGE DU TABLE MODEL
		candidatCtrl = new CandidatController();
		listCandidats = candidatCtrl.getAll();
		int k = listCandidats.size();
		rows = new Object[k][7];

		for(int i=0;i<k;i++) {
						
			rows[i][0] = listCandidats.get(i).getNom();	
			rows[i][1] = listCandidats.get(i).getPrenom();
			rows[i][2] = listCandidats.get(i).getCin();
			rows[i][3] = listCandidats.get(i).getDateNaissance();
			rows[i][4] = listCandidats.get(i).getNumTel();
			rows[i][5] = listCandidats.get(i).getAdresse();
			rows[i][6] = listCandidats.get(i).getId();

		}
		candidatsTableModel = new DefaultTableModel(rows,columns);

		//Cr�ation du JTable
		candidatsTable = new JTable(candidatsTableModel);
		scroll = new JScrollPane(candidatsTable);
		scroll.setBounds(10, 219, 641,199);
		add(scroll);
		
		
		
		/*CREATION DES COMPOSANTS*/
		separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(Color.decode("#7ed6df"));
		separateur1Pnl.setBounds(0, 57, 648, 10);
		add(separateur1Pnl);
		
		separateur2Pnl = new JPanel();
		separateur2Pnl.setBackground(Color.decode("#7ed6df"));
		separateur2Pnl.setBounds(0, 153, 648, 10);
		add(separateur2Pnl);
		
		gestionPersonnelsLbl = new JLabel("Gestion Candidats");
		gestionPersonnelsLbl.setForeground(new Color(143, 188, 143));
		gestionPersonnelsLbl.setFont(new Font("Oswald", Font.PLAIN, 18));
		gestionPersonnelsLbl.setBounds(255, 11, 161, 48);
		add(gestionPersonnelsLbl);
		
		nomLbl = new JLabel("Nom :");
		nomLbl.setForeground(new Color(143, 188, 143));
		nomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		nomLbl.setBounds(38, 122, 36, 20);
		add(nomLbl);
		
		rehercheLbl = new JLabel("Recherche :");
		rehercheLbl.setForeground(new Color(143, 188, 143));
		rehercheLbl.setFont(new Font("Oswald", Font.PLAIN, 18));
		rehercheLbl.setBounds(283, 78, 106, 28);
		add(rehercheLbl);
		
		nomTxt = new JTextField();
		nomTxt.setBounds(77, 124, 86, 20);
		nomTxt.setColumns(10);
		add(nomTxt);

		prenomLbl = new JLabel("Prenom :");
		prenomLbl.setForeground(new Color(143, 188, 143));
		prenomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		prenomLbl.setBounds(213, 122, 50, 20);
		add(prenomLbl);
		
		prenomTxt = new JTextField();
		prenomTxt.setColumns(10);
		prenomTxt.setBounds(273, 124, 86, 20);
		add(prenomTxt);
		
		cinTxt = new JTextField();
		cinTxt.setColumns(10);
		cinTxt.setBounds(454, 124, 86, 20);
		add(cinTxt);
		
		cinLbl = new JLabel("CIN :");
		cinLbl.setForeground(new Color(143, 188, 143));
		cinLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		cinLbl.setBounds(409, 120, 35, 20);
		add(cinLbl);
		
		iconRecherche =  new ImageIcon(this.getClass().getResource("/searche.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		rechercheLbl = new JLabel();
		rechercheLbl.setIcon(new ImageIcon(iconRecherche));
		rechercheLbl.setBounds(602, 114, 36, 40);
		add(rechercheLbl);
		
		listPersonnelsLbl = new JLabel("Liste des candidats:");
		listPersonnelsLbl.setForeground(new Color(143, 188, 143));
		listPersonnelsLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		listPersonnelsLbl.setBounds(23, 183, 125, 31);
		add(listPersonnelsLbl);
		
		iconAjouter =  new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ajouterLbl = new JLabel("");
		ajouterLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterLbl.setBounds(587, 174, 40, 40);
		add(ajouterLbl);
		
		iconModifier =  new ImageIcon(this.getClass().getResource("/modifier.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		modifierLbl = new JLabel();
		modifierLbl.setIcon(new ImageIcon(iconModifier));
		modifierLbl.setBounds(23, 429, 51, 40);
		add(modifierLbl);
		
		supprimerLbl = new JLabel("");
		iconSupprimer =  new ImageIcon(this.getClass().getResource("/delete.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		supprimerLbl.setIcon(new ImageIcon(iconSupprimer));
		supprimerLbl.setBounds(84, 429, 51, 40);
		add(supprimerLbl);
		
		iconActualiser =  new ImageIcon(this.getClass().getResource("/actualiser.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		actualiserLbl = new JLabel();
		actualiserLbl.setIcon(new ImageIcon(iconActualiser));
		actualiserLbl.setBounds(591, 429, 36, 40);
		add(actualiserLbl);
		
		/*ACTION LISTENERS*/
		nomTxt.getDocument().addDocumentListener(this);		
		prenomTxt.getDocument().addDocumentListener(this);
		cinTxt.getDocument().addDocumentListener(this);
		rechercheLbl.addMouseListener(this);
		modifierLbl.addMouseListener(this);
		ajouterLbl.addMouseListener(this);
		supprimerLbl.addMouseListener(this);
		actualiserLbl.addMouseListener(this);	
		
	}
	
	
	
	/*Search TextFields Edited*/
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		if(e.getDocument()==nomTxt.getDocument() || e.getDocument()==prenomTxt.getDocument()){
			cinTxt.setEditable(false);
		}
		if(e.getDocument()==cinTxt.getDocument()){
				nomTxt.setEditable(false);
				prenomTxt.setEditable(false);
		}

	}
	
	@Override
	public void removeUpdate(DocumentEvent e) {
		if(e.getDocument()==nomTxt.getDocument()|| e.getDocument()==prenomTxt.getDocument()){
			if(nomTxt.getText().isEmpty() && prenomTxt.getText().isEmpty()) {
				cinTxt.setEditable(true);
			}
		}
		if(e.getDocument()==cinTxt.getDocument()){
			if(cinTxt.getText().isEmpty())
			{
				nomTxt.setEditable(true);
				prenomTxt.setEditable(true);
			}
		}
	}

	/*Buttons Clicked*/
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//Ajouter clicked
		if(e.getComponent() == ajouterLbl) {
			AjouterCandidats ajouterCandidat = new AjouterCandidats(GestionCandidats.this);
			ajouterCandidat.setVisible(true);
		}
		//Modifier clicked
		else if(e.getComponent() == modifierLbl) {
			rowIndex = candidatsTable.getSelectedRow();
			
			if(rowIndex == -1)
				JOptionPane.showMessageDialog(null,"Vous devez selectionner un candidat!");
			else{
				candidat = new Candidats();
				candidat.setNom((String)rows[rowIndex][0]);
				candidat.setPrenom((String)rows[rowIndex][1]);
				candidat.setCin((String)rows[rowIndex][2]);
				candidat.setDateNaissance((Date)rows[rowIndex][3]);
				candidat.setNumTel((String)rows[rowIndex][4]);
				candidat.setAdresse((String)rows[rowIndex][5]);
				candidat.setId((int)rows[rowIndex][6]);
				
				ModifierCandidats modifierCandidat = new ModifierCandidats(candidat,GestionCandidats.this);
				modifierCandidat.setVisible(true);	
			}
		}
		//Supprimer clicked
		else if(e.getComponent() == supprimerLbl) {
			rowIndex = candidatsTable.getSelectedRow();
			
			if(rowIndex == -1)
				JOptionPane.showMessageDialog(null,"Vous devez selectionner un candidat!");
			else
			{
				int confirm = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer ce candidat?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if(confirm == JOptionPane.YES_OPTION){
					idCandidat = (int)rows[rowIndex][6];
					check = candidatCtrl.delete(idCandidat);
					
					if(check>0) {
						candidatCtrl = new CandidatController();
						listTempCandidats = candidatCtrl.getAll();
						refresh(listTempCandidats);
					}
					else
						JOptionPane.showMessageDialog(null,"Une erreur s'est produite!");  
					
				}
			}
		}
		//Recherche clicked
		else if(e.getComponent() == rechercheLbl) {
			SearchCandidat params = new SearchCandidat();

			params.setNom(nomTxt.getText().toString());
			params.setPrenom(prenomTxt.getText().toString());
			params.setCin(cinTxt.getText().toString());
			
			List<Candidats> listTempCandidats = candidatCtrl.search(params);
			refresh(listTempCandidats);
		}
		//Actualiser clicked
		else if(e.getComponent() == actualiserLbl) {
			candidatCtrl = new CandidatController();
			listTempCandidats = candidatCtrl.getAll();
			refresh(listTempCandidats);
		}
		
	}

	
	/*NOT USED*/
	@Override
	public void changedUpdate(DocumentEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}


