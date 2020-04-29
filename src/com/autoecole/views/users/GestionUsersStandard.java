package com.autoecole.views.users;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.autoecole.beans.Candidats;
import com.autoecole.beans.SearchCandidat;
import com.autoecole.beans.SearchUser;
import com.autoecole.beans.Users;
import com.autoecole.controller.CandidatController;
import com.autoecole.controller.UsersController;

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

public class GestionUsersStandard extends JPanel implements MouseListener {
	private JLabel salutationLbl;
	private JLabel modifierLbl;
	private JLabel ajouterLbl;
	private JLabel gestionUsersLbl;
	private JPanel separateur1Pnl;

	/*VARIABLES*/
	private Image iconRecherche;
	private Image iconAjouter;
	private Image iconModifier;
	private Image iconSupprimer;
	private Image iconActualiser;
	private DefaultTableModel usersTableModel;
	private String[] columns = {"Login","Nom","Prenom","CIN","Poste"};
	private Object[][] rows;
	private ArrayList<Users> listUsers;
	private UsersController usersCtrl;
	private int rowIndex;
	private int check;
	private Users user;
	private JLabel loginLbl;
	
	public void setLogin(String login) {
		loginLbl.setText("("+login+")");
	}
	
	
	/**
	 * Create the panel.
	 */
	public GestionUsersStandard(Users user) {
		
		setBackground(Color.decode("#34495e"));
		setBounds(0, 0, 661, 488);
		setLayout(null);
		
		
		/*CREATION DES COMPOSANTS*/
		separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(Color.decode("#7ed6df"));
		separateur1Pnl.setBounds(0, 57, 648, 10);
		add(separateur1Pnl);
		
		gestionUsersLbl = new JLabel("Gestion Utilisateurs");
		gestionUsersLbl.setForeground(new Color(143, 188, 143));
		gestionUsersLbl.setFont(new Font("Oswald", Font.PLAIN, 18));
		gestionUsersLbl.setBounds(255, 11, 161, 48);
		add(gestionUsersLbl);
		
		iconRecherche =  new ImageIcon(this.getClass().getResource("/searche.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		
		String salutation = "Bienvenu "+user.getPrenom()+" "+user.getNom();
		
		salutationLbl = new JLabel(salutation,SwingConstants.CENTER);
		salutationLbl.setForeground(Color.decode("#7ed6df"));
		salutationLbl.setFont(new Font("Oswald", Font.PLAIN, 25));
		salutationLbl.setBounds(0, 115, 661, 48);
		add(salutationLbl);
		
		
		iconModifier =  new ImageIcon(this.getClass().getResource("/modifier.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		modifierLbl = new JLabel();
		modifierLbl.setIcon(new ImageIcon(iconModifier));
		modifierLbl.setBounds(411, 278, 73, 63);
		add(modifierLbl);
		
		iconAjouter =  new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ajouterLbl = new JLabel("");
		ajouterLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterLbl.setBounds(233, 278, 73, 63);
		add(ajouterLbl);
		
		iconActualiser =  new ImageIcon(this.getClass().getResource("/actualiser.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		modifierLbl.addMouseListener(this);
		
		loginLbl = new JLabel("",SwingConstants.CENTER);
		setLogin(user.getLogin());
		loginLbl.setForeground(Color.decode("#7ed6df"));
		loginLbl.setFont(new Font("Oswald", Font.PLAIN, 24));
		loginLbl.setBounds(0, 174, 661, 48);
		add(loginLbl);
		
	}

	/*Buttons Clicked*/
	@Override
	public void mouseClicked(MouseEvent e) {
		
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
}


