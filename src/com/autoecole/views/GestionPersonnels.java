package com.autoecole.views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionPersonnels extends JPanel {
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JTextField cinTxt;
	private Image iconRecherche;
	private Image iconAjouter;
	private Image iconModifier;
	private Image iconSupprimer;

	/**
	 * Create the panel.
	 */
	public GestionPersonnels() {
		setLayout(null);
		
		JPanel contentPnl = new JPanel();
		contentPnl.setBackground(Color.decode("#34495e"));
		contentPnl.setBounds(0, 0, 648, 480);
		add(contentPnl);
		contentPnl.setLayout(null);
		
		JPanel separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(Color.decode("#7ed6df"));
		separateur1Pnl.setBounds(0, 57, 648, 10);
		contentPnl.add(separateur1Pnl);
		
		JPanel separateur2Pnl = new JPanel();
		separateur2Pnl.setBackground(Color.decode("#7ed6df"));
		separateur2Pnl.setBounds(0, 153, 648, 10);
		contentPnl.add(separateur2Pnl);
		
		JLabel gestionPersonnelsLbl = new JLabel("Gestion Personnels");
		gestionPersonnelsLbl.setForeground(new Color(143, 188, 143));
		gestionPersonnelsLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionPersonnelsLbl.setBounds(255, 11, 161, 48);
		contentPnl.add(gestionPersonnelsLbl);
		
		JLabel nomLbl = new JLabel("Nom :");
		nomLbl.setForeground(new Color(143, 188, 143));
		nomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		nomLbl.setBounds(38, 122, 36, 20);
		contentPnl.add(nomLbl);
		
		JLabel rehercheLbl = new JLabel("Recherche :");
		rehercheLbl.setForeground(new Color(143, 188, 143));
		rehercheLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		rehercheLbl.setBounds(283, 78, 106, 28);
		contentPnl.add(rehercheLbl);
		
		nomTxt = new JTextField();
		nomTxt.setBounds(77, 124, 86, 20);
		contentPnl.add(nomTxt);
		nomTxt.setColumns(10);
		
		JLabel prenomLbl = new JLabel("Prenom :");
		prenomLbl.setForeground(new Color(143, 188, 143));
		prenomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		prenomLbl.setBounds(213, 122, 50, 20);
		contentPnl.add(prenomLbl);
		
		prenomTxt = new JTextField();
		prenomTxt.setColumns(10);
		prenomTxt.setBounds(273, 124, 86, 20);
		contentPnl.add(prenomTxt);
		
		cinTxt = new JTextField();
		cinTxt.setColumns(10);
		cinTxt.setBounds(454, 124, 86, 20);
		contentPnl.add(cinTxt);
		
		JLabel cinLbl = new JLabel("CIN :");
		cinLbl.setForeground(new Color(143, 188, 143));
		cinLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		cinLbl.setBounds(409, 120, 35, 20);
		contentPnl.add(cinLbl);
		
		JLabel photoRechercheLbl = new JLabel("");
		iconRecherche =  new ImageIcon(this.getClass().getResource("/searche.png")).getImage();
		photoRechercheLbl.setIcon(new ImageIcon(iconRecherche));
		photoRechercheLbl.setBounds(602, 114, 36, 40);
		contentPnl.add(photoRechercheLbl);
		
		JLabel listPersonnelsLbl = new JLabel("Liste des personnels :");
		listPersonnelsLbl.setForeground(new Color(143, 188, 143));
		listPersonnelsLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		listPersonnelsLbl.setBounds(23, 183, 125, 31);
		contentPnl.add(listPersonnelsLbl);
		
		JLabel ajouterLbl = new JLabel("");
		iconAjouter =  new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage();
		ajouterLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterLbl.setBounds(587, 174, 51, 40);
		contentPnl.add(ajouterLbl);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 225, 628, 193);
		contentPnl.add(tabbedPane);
		
		JLabel modifierLbl = new JLabel("");
		modifierLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModifierPersonnels modifierPersonnel = new ModifierPersonnels();
				modifierPersonnel.setVisible(true);
				Menu menu = new Menu(null);
				
			}
		});
		iconModifier =  new ImageIcon(this.getClass().getResource("/modifier.png")).getImage();
		modifierLbl.setIcon(new ImageIcon(iconModifier));
		modifierLbl.setBounds(23, 429, 51, 40);
		contentPnl.add(modifierLbl);
		
		JLabel supprimerLbl = new JLabel("");
		iconSupprimer =  new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		supprimerLbl.setIcon(new ImageIcon(iconSupprimer));
		supprimerLbl.setBounds(84, 429, 51, 40);
		contentPnl.add(supprimerLbl);

	}
}
