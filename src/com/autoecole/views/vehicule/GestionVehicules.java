package com.autoecole.views.vehicule;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.autoecole.beans.Vehicules;
import com.autoecole.controller.GestionVehiculeController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GestionVehicules extends JPanel {
	private JTextField typeTxt;
	private JTextField marqueTxt;
	private JTextField matriculeTxt;
	private Image iconRechercher;
	private Image iconAjouter;
	private Image iconModifier;
	private Image iconSupprimer;
	private TableModel tablemodelVehicule;
	private String [] colonnesVehicule={"type","marque","modele","nombre de place","type de carburant","matricule","puissance fiscale","assurance","date limite d'assurance","Km vidange"};
	private Object [][]dataVehicule;
	private int dataSizeVehicule;
	private List<Vehicules> listVehicule;
	private int idVehicule;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public GestionVehicules() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(52, 73, 94));
		panel.setBounds(0, 0, 648, 480);
		add(panel);
		
		JPanel separateurPnl1 = new JPanel();
		separateurPnl1.setBackground(new Color(126, 214, 223));
		separateurPnl1.setBounds(0, 57, 648, 10);
		panel.add(separateurPnl1);
		
		JPanel separateurPnl2 = new JPanel();
		separateurPnl2.setBackground(new Color(126, 214, 223));
		separateurPnl2.setBounds(0, 153, 648, 10);
		panel.add(separateurPnl2);
		
		JLabel gestionVoiture = new JLabel("Gestion Voitures");
		gestionVoiture.setHorizontalAlignment(SwingConstants.CENTER);
		gestionVoiture.setForeground(new Color(143, 188, 143));
		gestionVoiture.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionVoiture.setBounds(255, 11, 161, 48);
		panel.add(gestionVoiture);
		
		JLabel typeLbl = new JLabel("Type :");
		typeLbl.setForeground(new Color(143, 188, 143));
		typeLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		typeLbl.setBounds(38, 122, 36, 20);
		panel.add(typeLbl);
		
		JLabel rechercheLbl = new JLabel("Recherche :");
		rechercheLbl.setForeground(new Color(143, 188, 143));
		rechercheLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		rechercheLbl.setBounds(283, 78, 106, 28);
		panel.add(rechercheLbl);
		
		typeTxt = new JTextField();
		typeTxt.setColumns(10);
		typeTxt.setBounds(77, 124, 86, 20);
		panel.add(typeTxt);
		
		JLabel marqueLbl = new JLabel("Marque :");
		marqueLbl.setForeground(new Color(143, 188, 143));
		marqueLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		marqueLbl.setBounds(213, 122, 50, 20);
		panel.add(marqueLbl);
		
		marqueTxt = new JTextField();
		marqueTxt.setColumns(10);
		marqueTxt.setBounds(273, 124, 86, 20);
		panel.add(marqueTxt);
		
		matriculeTxt = new JTextField();
		matriculeTxt.setColumns(10);
		matriculeTxt.setBounds(480, 124, 86, 20);
		panel.add(matriculeTxt);
		
		JLabel lblMatricule = new JLabel("Matricule :");
		lblMatricule.setForeground(new Color(143, 188, 143));
		lblMatricule.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblMatricule.setBounds(408, 122, 61, 20);
		panel.add(lblMatricule);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 225, 628, 184);
		panel.add(scroll);
		
		JLabel rechercheImageLbl = new JLabel("");
		rechercheImageLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vehicules vehicule = new Vehicules();
				GestionVehiculeController gestionVehiculeController = new GestionVehiculeController();
				if((!typeTxt.getText().isEmpty()) && !marqueTxt.getText().isEmpty() && !matriculeTxt.getText().isEmpty()) {
					vehicule=gestionVehiculeController.getPersonnelsByTypeMarqueMatricule(typeTxt.getText(), marqueTxt.getText(), matriculeTxt.getText());
					if(vehicule!=null) {
						listVehicule.clear();
						listVehicule.add(vehicule);
						dataSizeVehicule=listVehicule.size();
						dataVehicule=new Object[dataSizeVehicule][11];
						for(int k=0;k<dataSizeVehicule;k++)
						{
							dataVehicule[k][0]=listVehicule.get(k).getType();
							dataVehicule[k][1]=listVehicule.get(k).getMarque();
							dataVehicule[k][2]=listVehicule.get(k).getModele();
							dataVehicule[k][3]=listVehicule.get(k).getNbPlace();
							dataVehicule[k][4]=listVehicule.get(k).getTypeCarburant();
							dataVehicule[k][5]=listVehicule.get(k).getMatricule();
							dataVehicule[k][6]=listVehicule.get(k).getPuissanceFiscale();
							dataVehicule[k][7]=listVehicule.get(k).getAssurance();
							dataVehicule[k][8]=listVehicule.get(k).getDateLimiteAssurance();
							dataVehicule[k][9]=listVehicule.get(k).getKmVidange();
							idVehicule=listVehicule.get(k).getId();
							dataVehicule[k][10]=idVehicule;
						}
						tablemodelVehicule = new DefaultTableModel(dataVehicule,colonnesVehicule);
						table= new JTable(tablemodelVehicule);
						scroll.setViewportView(table);
					}else {
						JOptionPane.showMessageDialog(null, "personnel introuvable");
					}
				}else {
					JOptionPane.showMessageDialog(null, "vous devez remplire les champs");
				}
			}
		});
		iconRechercher =  new ImageIcon(this.getClass().getResource("/searche.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		rechercheImageLbl.setIcon(new ImageIcon(iconRechercher));
		rechercheImageLbl.setBounds(602, 114, 36, 40);
		panel.add(rechercheImageLbl);
		
		JLabel listVoitureLbl = new JLabel("Liste des Voitures :");
		listVoitureLbl.setForeground(new Color(143, 188, 143));
		listVoitureLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		listVoitureLbl.setBounds(23, 183, 125, 31);
		panel.add(listVoitureLbl);
		
		JLabel ajouterImageLbl = new JLabel("");
		iconAjouter =  new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage();
		ajouterImageLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterImageLbl.setBounds(587, 174, 51, 40);
		panel.add(ajouterImageLbl);
		
		JLabel modifierImageLbl = new JLabel("");
		iconModifier =  new ImageIcon(this.getClass().getResource("/modifier.png")).getImage();
		modifierImageLbl.setIcon(new ImageIcon(iconModifier));
		modifierImageLbl.setBounds(23, 429, 51, 40);
		panel.add(modifierImageLbl);
		
		JLabel supprimerImageLbl = new JLabel("");
		iconSupprimer =  new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		supprimerImageLbl.setIcon(new ImageIcon(iconSupprimer));
		supprimerImageLbl.setBounds(84, 429, 51, 40);
		panel.add(supprimerImageLbl);
		
		table = new JTable();
		scroll.setViewportView(table);

		GestionVehiculeController gestionVehiculeController = new GestionVehiculeController();
		listVehicule=gestionVehiculeController.getAllVehicules();
		dataSizeVehicule=listVehicule.size();
		dataVehicule=new Object[dataSizeVehicule][11];
		for(int k=0;k<dataSizeVehicule;k++)
		{
			dataVehicule[k][0]=listVehicule.get(k).getType();
			dataVehicule[k][1]=listVehicule.get(k).getMarque();
			dataVehicule[k][2]=listVehicule.get(k).getModele();
			dataVehicule[k][3]=listVehicule.get(k).getNbPlace();
			dataVehicule[k][4]=listVehicule.get(k).getTypeCarburant();
			dataVehicule[k][5]=listVehicule.get(k).getMatricule();
			dataVehicule[k][6]=listVehicule.get(k).getPuissanceFiscale();
			dataVehicule[k][7]=listVehicule.get(k).getAssurance();
			dataVehicule[k][8]=listVehicule.get(k).getDateLimiteAssurance();
			dataVehicule[k][9]=listVehicule.get(k).getKmVidange();
			idVehicule=listVehicule.get(k).getId();
			dataVehicule[k][10]=idVehicule;
		}
		tablemodelVehicule = new DefaultTableModel(dataVehicule,colonnesVehicule);
		table= new JTable(tablemodelVehicule);
		scroll.setViewportView(table);
	}
}
