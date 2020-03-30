package com.autoecole.views;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.autoecole.beans.Candidats;
import com.autoecole.controller.CandidatController;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;

public class ModifierCandidats extends JFrame {

	/*COMPONENTS*/
	private JPanel contentPane;
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JTextField cinTxt;
	private JTextField numeroTelephoneTxt;
	private JTextField adresseTxt;
	private JPanel contentPnl;
	private JPanel separateur1Pnl;
	private JPanel separateur2Pnl;
	private JLabel gestionCandidatLbl ;
	private JLabel ajouterCandidatLbl;
	private JLabel nomLbl;
	private JLabel prenomLbl;
	private JLabel dateNaissanceLbl;
	private JLabel adresseLbl;
	private JLabel numeroTeleLbl;
	private JLabel modifierImageLbl;
	private JLabel annulerImagreLbl;
	private JLabel retourImageLbl;
	private JLabel cinLbl;
	private JDateChooser dateNaissanceDtc;
	
	
	/*VARIABLES*/
	private Image iconAjouter;
	private Image iconAnnuler;
	private Candidats candidat;
	private CandidatController candidatCtrl;
	private ArrayList<Candidats> listCandidats;
	
	/**
	 * Create the frame.
	 */
	public ModifierCandidats(Candidats candidatArg, GestionCandidats gestionCandidat) {
		
		setLocationRelativeTo(null);
		setBounds(100, 100, 664, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/*Création des composants*/
		contentPnl = new JPanel();
		contentPnl.setLayout(null);
		contentPnl.setBackground(new Color(52, 73, 94));
		contentPnl.setBounds(0, 0, 648, 480);
		contentPane.add(contentPnl);
		
		separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(new Color(126, 214, 223));
		separateur1Pnl.setBounds(0, 57, 648, 10);
		contentPnl.add(separateur1Pnl);
		
		separateur2Pnl = new JPanel();
		separateur2Pnl.setBackground(new Color(126, 214, 223));
		separateur2Pnl.setBounds(0, 117, 648, 10);
		contentPnl.add(separateur2Pnl);
		
		gestionCandidatLbl = new JLabel("Gestion Candidats");
		gestionCandidatLbl.setForeground(new Color(143, 188, 143));
		gestionCandidatLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionCandidatLbl.setBounds(255, 11, 161, 48);
		contentPnl.add(gestionCandidatLbl);
		
		ajouterCandidatLbl = new JLabel("Modifier Candidat");
		ajouterCandidatLbl.setForeground(new Color(143, 188, 143));
		ajouterCandidatLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		ajouterCandidatLbl.setBounds(255, 78, 154, 28);
		contentPnl.add(ajouterCandidatLbl);
		
		nomLbl = new JLabel("Nom :");
		nomLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nomLbl.setForeground(new Color(143, 188, 143));
		nomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		nomLbl.setBounds(63, 159, 154, 20);
		contentPnl.add(nomLbl);
		
		prenomLbl = new JLabel("Prenom :");
		prenomLbl.setHorizontalAlignment(SwingConstants.CENTER);
		prenomLbl.setForeground(new Color(143, 188, 143));
		prenomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		prenomLbl.setBounds(63, 190, 154, 20);
		contentPnl.add(prenomLbl);
		
		dateNaissanceLbl = new JLabel("Date de Naissance :");
		dateNaissanceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateNaissanceLbl.setForeground(new Color(143, 188, 143));
		dateNaissanceLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateNaissanceLbl.setBounds(63, 221, 154, 20);
		contentPnl.add(dateNaissanceLbl);
		
		cinLbl = new JLabel("CIN :");
		cinLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cinLbl.setForeground(new Color(143, 188, 143));
		cinLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		cinLbl.setBounds(63, 252, 154, 20);
		contentPnl.add(cinLbl);
		
		adresseLbl = new JLabel("Adresse :");
		adresseLbl.setHorizontalAlignment(SwingConstants.CENTER);
		adresseLbl.setForeground(new Color(143, 188, 143));
		adresseLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		adresseLbl.setBounds(63, 283, 154, 20);
		contentPnl.add(adresseLbl);
		
		numeroTeleLbl = new JLabel("Numero de Telephone :");
		numeroTeleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		numeroTeleLbl.setForeground(new Color(143, 188, 143));
		numeroTeleLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		numeroTeleLbl.setBounds(63, 314, 154, 20);
		contentPnl.add(numeroTeleLbl);
		
		nomTxt = new JTextField();
		nomTxt.setBounds(361, 161, 227, 20);
		contentPnl.add(nomTxt);
		nomTxt.setColumns(10);
		
		prenomTxt = new JTextField();
		prenomTxt.setColumns(10);
		prenomTxt.setBounds(361, 192, 227, 20);
		contentPnl.add(prenomTxt);
		
		cinTxt = new JTextField();
		cinTxt.setColumns(10);
		cinTxt.setBounds(361, 254, 227, 20);
		contentPnl.add(cinTxt);
		
		numeroTelephoneTxt = new JTextField();
		numeroTelephoneTxt.setColumns(10);
		numeroTelephoneTxt.setBounds(361, 316, 227, 20);
		contentPnl.add(numeroTelephoneTxt);
		
		dateNaissanceDtc = new JDateChooser();
		dateNaissanceDtc.setBounds(361, 221, 227, 20);
		contentPnl.add(dateNaissanceDtc);
		
		adresseTxt = new JTextField();
		adresseTxt.setColumns(10);
		adresseTxt.setBounds(361, 285, 227, 20);
		contentPnl.add(adresseTxt);
		
		iconAjouter = new ImageIcon(this.getClass().getResource("/accept.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		modifierImageLbl = new JLabel();
		modifierImageLbl.setIcon(new ImageIcon(iconAjouter));
		modifierImageLbl.setBounds(361, 359, 46, 42);
		contentPnl.add(modifierImageLbl);
		
		iconAnnuler = new ImageIcon(this.getClass().getResource("/annuler.png")).getImage();
		annulerImagreLbl = new JLabel();
		annulerImagreLbl.setIcon(new ImageIcon(iconAnnuler));
		annulerImagreLbl.setBounds(542, 359, 46, 42);
		contentPnl.add(annulerImagreLbl);
		
		retourImageLbl = new JLabel("");
		retourImageLbl.setBounds(494, 438, 46, 14);
		contentPnl.add(retourImageLbl);
		
		
		/*Remplissage des champs*/
		nomTxt.setText(candidatArg.getNom());
		prenomTxt.setText(candidatArg.getPrenom());
		dateNaissanceDtc.setDate(candidatArg.getDateNaissance());
		cinTxt.setText(candidatArg.getCin());
		adresseTxt.setText(candidatArg.getAdresse());
		numeroTelephoneTxt.setText(candidatArg.getNumTel());
		
		nomTxt.setEditable(false);
		prenomTxt.setEditable(false);
		cinTxt.setEditable(false);
		
		/*Action Listeners*/
		
		modifierImageLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nom = nomTxt.getText();
				String prenom = prenomTxt.getText();
				String cin = cinTxt.getText();
				String numTel = numeroTelephoneTxt.getText();
				String adresse = adresseTxt.getText();
				
				
				if(nom.isEmpty() || prenom.isEmpty() || cin.isEmpty() || numTel.isEmpty() || adresse.isEmpty() || dateNaissanceDtc.getDate() == null)
					JOptionPane.showMessageDialog(null,"Tous les champs sont obligatoires!");  
				else
				{
					candidatCtrl = new CandidatController(); 
					candidat = new Candidats();
							
					Date dateNaissance = new Date(dateNaissanceDtc.getDate().getTime());
					
					candidat.setId(candidatArg.getId());
					candidat.setNom(nom);
					candidat.setPrenom(prenom);
					candidat.setCin(cin);
					candidat.setDateNaissance(dateNaissance);
					candidat.setNumTel(numTel);
					candidat.setAdresse(adresse);
	
					
					int check = candidatCtrl.modifierCandidat(candidat);
					
					if(check>0) {
						candidatCtrl = new CandidatController();
						listCandidats = candidatCtrl.getCandidats();
						gestionCandidat.refresh(listCandidats);
						dispose();						
					}
					else
						JOptionPane.showMessageDialog(null,"Une erreur s'est produite!");
				}
			}
		});
		
		
		//Annuler clicked
		annulerImagreLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		
		
		
		
		
		
		
		
	}
}
