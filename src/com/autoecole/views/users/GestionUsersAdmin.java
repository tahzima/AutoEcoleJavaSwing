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

public class GestionUsersAdmin extends JPanel implements DocumentListener,MouseListener {
	
	/*COMPONENTS*/
	private JLabel prenomLbl;
	private JLabel loginLbl;
	private JLabel rechercheLbl;
	private JLabel listUsersLbl;
	private JLabel ajouterLbl;
	private JLabel modifierLbl;
	private JLabel actualiserLbl;
	private JLabel supprimerLbl;
	private JLabel gestionUsersLbl;
	private JLabel nomLbl;
	private JLabel rehercheLbl;
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JTextField loginTxt;
	private JPanel separateur1Pnl;
	private JPanel separateur2Pnl;
	private JTable usersTable;
	private JScrollPane scroll;

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
	
	public ArrayList<Users> getListUsers() {
		return listUsers;}
	
	public void setListUsers(ArrayList<Users> listUsers) {
		this.listUsers = listUsers;}
	
	/*LOAD JTABLE*/
	public void refresh(List<Users> list) {
		
		int k = list.size();
		rows = new Object[k][7];
		
		for(int i=0;i<k;i++) {
			
			rows[i][0] = list.get(i).getLogin();	
			rows[i][1] = list.get(i).getNom();
			rows[i][2] = list.get(i).getPrenom();
			rows[i][3] = list.get(i).getCin();
			rows[i][4] = list.get(i).getPoste();
			rows[i][5] = list.get(i).getId();
			rows[i][6] = list.get(i).getId_Personnels();

		}
		DefaultTableModel model  = new DefaultTableModel(rows,columns);
		usersTable.setModel(model);	
	}
	

	/**
	 * Create the panel.
	 */
	public GestionUsersAdmin() {
		
		setBackground(Color.decode("#34495e"));
		setBounds(0, 0, 661, 488);
		setLayout(null);
		

		/*JTABLE*/
		//REMPLISSAGE DU TABLE MODEL
		usersCtrl = new UsersController();
		listUsers = usersCtrl.getAll();
		int k = listUsers.size();
		rows = new Object[k][7];

		for(int i=0;i<k;i++) {
			rows[i][0] = listUsers.get(i).getLogin();	
			rows[i][1] = listUsers.get(i).getNom();
			rows[i][2] = listUsers.get(i).getPrenom();
			rows[i][3] = listUsers.get(i).getCin();
			rows[i][4] = listUsers.get(i).getPoste();
			rows[i][5] = listUsers.get(i).getId();
			rows[i][6] = listUsers.get(i).getId_Personnels();
		}
		usersTableModel = new DefaultTableModel(rows,columns);

		//Cr�ation du JTable
		usersTable = new JTable(usersTableModel);
		scroll = new JScrollPane(usersTable);
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
		
		gestionUsersLbl = new JLabel("Gestion Utilisateurs");
		gestionUsersLbl.setForeground(new Color(143, 188, 143));
		gestionUsersLbl.setFont(new Font("Oswald", Font.PLAIN, 18));
		gestionUsersLbl.setBounds(255, 11, 161, 48);
		add(gestionUsersLbl);
		
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
		
		loginTxt = new JTextField();
		loginTxt.setColumns(10);
		loginTxt.setBounds(454, 124, 86, 20);
		add(loginTxt);
		
		loginLbl = new JLabel("Login :");
		loginLbl.setForeground(new Color(143, 188, 143));
		loginLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		loginLbl.setBounds(409, 120, 35, 20);
		add(loginLbl);
		
		iconRecherche =  new ImageIcon(this.getClass().getResource("/searche.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		rechercheLbl = new JLabel();
		rechercheLbl.setIcon(new ImageIcon(iconRecherche));
		rechercheLbl.setBounds(602, 114, 36, 40);
		add(rechercheLbl);
		
		listUsersLbl = new JLabel("Liste des utilisateurs:");
		listUsersLbl.setForeground(new Color(143, 188, 143));
		listUsersLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		listUsersLbl.setBounds(23, 183, 125, 31);
		add(listUsersLbl);
		
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
		loginTxt.getDocument().addDocumentListener(this);
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
			loginTxt.setEditable(false);
		}
		if(e.getDocument()==loginTxt.getDocument()){
				nomTxt.setEditable(false);
				prenomTxt.setEditable(false);
		}
	}
	
	@Override
	public void removeUpdate(DocumentEvent e) {
		if(e.getDocument()==nomTxt.getDocument()|| e.getDocument()==prenomTxt.getDocument()){
			if(nomTxt.getText().isEmpty() && prenomTxt.getText().isEmpty()) {
				loginTxt.setEditable(true);
			}
		}
		if(e.getDocument()==loginTxt.getDocument()){
			if(loginTxt.getText().isEmpty())
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
			AjouterUsers ajouterUsers = new AjouterUsers(GestionUsersAdmin.this);
			ajouterUsers.setVisible(true);
		}
		//Modifier clicked
		else if(e.getComponent() == modifierLbl) {
			rowIndex = usersTable.getSelectedRow();
			
			if(rowIndex == -1)
				JOptionPane.showMessageDialog(null,"Vous devez selectionner un candidat!");
			else{
				user = new Users();
				user = listUsers.get(rowIndex);
				
				ModifierUsers modifierUsers = new ModifierUsers(user,GestionUsersAdmin.this);
				modifierUsers.setVisible(true);	
			}
		}
		//Supprimer clicked
		else if(e.getComponent() == supprimerLbl) {
			rowIndex = usersTable.getSelectedRow();
			
			if(rowIndex == -1)
				JOptionPane.showMessageDialog(null,"Vous devez selectionner un utilisateur!");
			else if(((String)rows[rowIndex][0]).equals("admin"))
				JOptionPane.showMessageDialog(null, "Impossible de supprimer l'administrateur!", "Erreur", JOptionPane.ERROR_MESSAGE);
			else
			{
				int confirm = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cet utilisateur?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if(confirm == JOptionPane.YES_OPTION){
					
					int idUser = (int)rows[rowIndex][5];
					check = usersCtrl.delete(idUser);
					
					if(check>0) {
						usersCtrl = new UsersController();
						listUsers = usersCtrl.getAll();
						refresh(listUsers);
					}
					else
						JOptionPane.showMessageDialog(null,"Une erreur s'est produite!");  
				}
			}
		}
		//Recherche clicked
		else if(e.getComponent() == rechercheLbl) {
			SearchUser params = new SearchUser();

			params.setNom(nomTxt.getText().toString());
			params.setPrenom(prenomTxt.getText().toString());
			params.setLogin(loginTxt.getText().toString());
			
			listUsers = new ArrayList<Users>();
			listUsers = usersCtrl.search(params);
			
			refresh(listUsers);
		}
		//Actualiser clicked
		else if(e.getComponent() == actualiserLbl) {
			usersCtrl = new UsersController();
			listUsers = usersCtrl.getAll();
			refresh(listUsers);
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


