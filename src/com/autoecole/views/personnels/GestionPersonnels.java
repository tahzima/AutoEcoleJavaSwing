package com.autoecole.views.personnels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.autoecole.beans.Personnels;
import com.autoecole.beans.SearchPersonnel;
import com.autoecole.beans.Users;
import com.autoecole.controller.PersonnelsController;
import com.autoecole.views.Menu;

import com.autoecole.views.Menu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class GestionPersonnels extends JPanel implements MouseListener{
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JTextField cinTxt;
	private Image iconRecherche;
	private Image iconAjouter;
	private Image iconModifier;
	private Image iconSupprimer;
	private JTable table;
	private TableModel tablemodelPersonnel;
	private String [] colonnesPersonnel={"Nom","Prenom","Cin","Date Naissance","Numero Telephone","Adresse","Poste","Date d'Embauche","Salaire"};
	private Object [][]dataPersonnel;
	private int dataSizePersonnel;
	public List<Personnels> listPersonnel;
	private JScrollPane scrollPane;
	private int idPersonnel;
	private int rowIndex;
	private JPanel contentPnl;
	private JLabel photoRechercheLbl;
	private JLabel supprimerLbl;
	private JLabel modifierLbl;
	private JLabel ajouterLbl;
	
	
	
	
	
	
	public void refresh(List<Personnels> list) {
		
		int k = list.size();
		dataPersonnel = new Object[k][10];
		
		for(int i=0;i<k;i++) {
			
			dataPersonnel[i][0]=list.get(i).getNom();
			dataPersonnel[i][1]=list.get(i).getPrenom();
			dataPersonnel[i][2]=list.get(i).getCin();
			dataPersonnel[i][3]=list.get(i).getDateNaissance();
			dataPersonnel[i][4]=list.get(i).getNumTele();
			dataPersonnel[i][5]=list.get(i).getAdresse();
			dataPersonnel[i][6]=list.get(i).getPoste();
			dataPersonnel[i][7]=list.get(i).getDateEmbauche();
			dataPersonnel[i][8]=list.get(i).getSalaire();
			dataPersonnel[i][9]=idPersonnel;

		}
		DefaultTableModel model  = new DefaultTableModel(dataPersonnel,colonnesPersonnel);
		table.setModel(model);
		
	}
	
	
	

	/**
	 * Create the panel.
	 */
	public GestionPersonnels() {
		setLayout(null);
		
		contentPnl = new JPanel();
		contentPnl.setBackground(Color.decode("#34495e"));
		contentPnl.setBounds(0, 0, Menu.WIDTH_SCREEN-160, Menu.HEIGHT_SCREEN);
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
		nomTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				cinTxt.setEditable(false);
			}
		});
		nomTxt.setBounds(77, 124, 86, 20);
		contentPnl.add(nomTxt);
		nomTxt.setColumns(10);
		
		JLabel prenomLbl = new JLabel("Prenom :");
		prenomLbl.setForeground(new Color(143, 188, 143));
		prenomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		prenomLbl.setBounds(213, 122, 50, 20);
		contentPnl.add(prenomLbl);
		
		prenomTxt = new JTextField();
		prenomTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				cinTxt.setEditable(false);
			}
		});
		prenomTxt.setColumns(10);
		prenomTxt.setBounds(273, 124, 86, 20);
		contentPnl.add(prenomTxt);
		
		cinTxt = new JTextField();
		cinTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				nomTxt.setEditable(false);
				prenomTxt.setEditable(false);
			}
		});
		cinTxt.setColumns(10);
		cinTxt.setBounds(454, 124, 86, 20);
		contentPnl.add(cinTxt);
		
		JLabel cinLbl = new JLabel("CIN :");
		cinLbl.setForeground(new Color(143, 188, 143));
		cinLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		cinLbl.setBounds(409, 120, 35, 20);
		contentPnl.add(cinLbl);
		
		photoRechercheLbl = new JLabel("");
		iconRecherche =  new ImageIcon(this.getClass().getResource("/searche.png")).getImage();
		photoRechercheLbl.setIcon(new ImageIcon(iconRecherche));
		photoRechercheLbl.setBounds(602, 114, 36, 40);
		contentPnl.add(photoRechercheLbl);
		photoRechercheLbl.addMouseListener(this);
		
		JLabel listPersonnelsLbl = new JLabel("Liste des personnels :");
		listPersonnelsLbl.setForeground(new Color(143, 188, 143));
		listPersonnelsLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		listPersonnelsLbl.setBounds(23, 183, 125, 31);
		contentPnl.add(listPersonnelsLbl);
		
		ajouterLbl = new JLabel("");
		ajouterLbl.addMouseListener(this);
		iconAjouter =  new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ajouterLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterLbl.setBounds(587, 174, 51, 40);
		contentPnl.add(ajouterLbl);
		
		modifierLbl = new JLabel("");
		modifierLbl.addMouseListener(this);
		iconModifier =  new ImageIcon(this.getClass().getResource("/modifier.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		modifierLbl.setIcon(new ImageIcon(iconModifier));
		modifierLbl.setBounds(23, 429, 51, 40);
		contentPnl.add(modifierLbl);
		
		supprimerLbl = new JLabel("");
		supprimerLbl.addMouseListener(this);
		iconSupprimer =  new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		supprimerLbl.setIcon(new ImageIcon(iconSupprimer));
		supprimerLbl.setBounds(84, 429, 51, 40);
		contentPnl.add(supprimerLbl);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 234, 628, 184);
		contentPnl.add(scrollPane);
		
		PersonnelsController PersonnelsController = new PersonnelsController();
		listPersonnel=PersonnelsController.getAll();
		dataSizePersonnel=listPersonnel.size();
		dataPersonnel=new Object[dataSizePersonnel][10];
		for(int k=0;k<dataSizePersonnel;k++)
		{
			dataPersonnel[k][0]=listPersonnel.get(k).getNom();
			dataPersonnel[k][1]=listPersonnel.get(k).getPrenom();
			dataPersonnel[k][2]=listPersonnel.get(k).getCin();
			dataPersonnel[k][3]=listPersonnel.get(k).getDateNaissance();
			dataPersonnel[k][4]=listPersonnel.get(k).getNumTele();
			dataPersonnel[k][5]=listPersonnel.get(k).getAdresse();
			dataPersonnel[k][6]=listPersonnel.get(k).getPoste();
			dataPersonnel[k][7]=listPersonnel.get(k).getDateEmbauche();
			dataPersonnel[k][8]=listPersonnel.get(k).getSalaire();
			idPersonnel=listPersonnel.get(k).getId();
			dataPersonnel[k][9]=idPersonnel;
		}
		tablemodelPersonnel = new DefaultTableModel(dataPersonnel,colonnesPersonnel);
		table= new JTable(tablemodelPersonnel);
		scrollPane.setViewportView(table);

	}




	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent()==photoRechercheLbl) {
			listPersonnel.clear();
			PersonnelsController gestionPersonnelController = new PersonnelsController();
			SearchPersonnel searchPersonnel = new SearchPersonnel();
			searchPersonnel.setCin(cinTxt.getText());
			searchPersonnel.setNom(nomTxt.getText());
			searchPersonnel.setPrenom(prenomTxt.getText());
			listPersonnel=gestionPersonnelController.search(searchPersonnel);
			refresh(listPersonnel);
		}
		if(e.getComponent()==supprimerLbl) {
			rowIndex = table.getSelectedRow();
			int id;
			boolean check;
			if(rowIndex == -1)
				JOptionPane.showMessageDialog(null,"Vous devez selectionner un Personnel!");
			else
			{
				id = (int)dataPersonnel[rowIndex][9];
				PersonnelsController gestionPersonnelController = new PersonnelsController();
				check = gestionPersonnelController.delete(id);
				
				if(check) {
					gestionPersonnelController = new PersonnelsController();
					listPersonnel = gestionPersonnelController.getAll();
					refresh(listPersonnel);
					JOptionPane.showMessageDialog(null,"Personnel supprimer!"); 
				}
				else
					JOptionPane.showMessageDialog(null,"Une erreur s'est produite!");  
			}
		}
		if(modifierLbl==e.getComponent()) {
			ModifierPersonnels modifierPersonnels = new ModifierPersonnels(idPersonnel,GestionPersonnels.this);
			modifierPersonnels.setVisible(true);
		}
		if(e.getComponent()==ajouterLbl) {
			AjouterPersonnels ajouterPersonnel = new AjouterPersonnels(GestionPersonnels.this);
			ajouterPersonnel.setVisible(true);
		}
	}




	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
