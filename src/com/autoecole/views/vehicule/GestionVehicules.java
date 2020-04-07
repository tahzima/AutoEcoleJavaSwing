package com.autoecole.views.vehicule;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.autoecole.beans.Personnels;
import com.autoecole.beans.SearcheVehicule;
import com.autoecole.beans.Vehicules;
import com.autoecole.controller.PersonnelsController;
import com.autoecole.controller.VehiculeController;
import com.autoecole.views.personnels.GestionPersonnels;
import com.autoecole.views.personnels.ModifierPersonnels;

import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GestionVehicules extends JPanel implements MouseListener{
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
	private JScrollPane scrollPan;
	private JLabel rechercheImageLbl;
	private JLabel modifierImageLbl;
	private JLabel supprimerImageLbl;
	private JLabel ajouterImageLbl;;
	private int rowIndex;
	
	
	public void refresh(List<Vehicules> list) {
		
		int k = list.size();
		dataVehicule = new Object[k][11];
		dataSizeVehicule=list.size();
		dataVehicule=new Object[dataSizeVehicule][11];
		
		for(k=0;k<dataSizeVehicule;k++)
		{
			dataVehicule[k][0]=list.get(k).getType();
			dataVehicule[k][1]=list.get(k).getMarque();
			dataVehicule[k][2]=list.get(k).getModele();
			dataVehicule[k][3]=list.get(k).getNbPlace();
			dataVehicule[k][4]=list.get(k).getTypeCarburant();
			dataVehicule[k][5]=list.get(k).getMatricule();
			dataVehicule[k][6]=list.get(k).getPuissanceFiscale();
			dataVehicule[k][7]=list.get(k).getAssurance();
			dataVehicule[k][8]=list.get(k).getDateLimiteAssurance();
			dataVehicule[k][9]=list.get(k).getKmVidange();
			idVehicule=list.get(k).getId();
			dataVehicule[k][10]=idVehicule;
		}
		tablemodelVehicule = new DefaultTableModel(dataVehicule,colonnesVehicule);
		table= new JTable(tablemodelVehicule);
		scrollPan.setViewportView(table);
	}
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
		
		JLabel gestionVoiture = new JLabel("Gestion Vehicules");
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
		typeTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				marqueTxt.setEnabled(true);
				matriculeTxt.setEnabled(false);
			}
		});
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
		marqueTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				typeTxt.setEditable(true);
				matriculeTxt.setEditable(false);
			}
		});
		panel.add(marqueTxt);
		
		matriculeTxt = new JTextField();
		matriculeTxt.setColumns(10);
		matriculeTxt.setBounds(480, 124, 86, 20);
		matriculeTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				marqueTxt.setEnabled(false);
				typeTxt.setEnabled(false);
			}
		});
		panel.add(matriculeTxt);
		
		JLabel lblMatricule = new JLabel("Matricule :");
		lblMatricule.setForeground(new Color(143, 188, 143));
		lblMatricule.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblMatricule.setBounds(408, 122, 61, 20);
		panel.add(lblMatricule);
		
		scrollPan = new JScrollPane();
		scrollPan.setBounds(10, 225, 628, 184);
		panel.add(scrollPan);
		
		rechercheImageLbl = new JLabel("");
		rechercheImageLbl.addMouseListener(this);
		iconRechercher =  new ImageIcon(this.getClass().getResource("/searche.png")).getImage();
		rechercheImageLbl.setIcon(new ImageIcon(iconRechercher));
		rechercheImageLbl.setBounds(602, 114, 36, 40);
		panel.add(rechercheImageLbl);
		
		JLabel listVoitureLbl = new JLabel("Liste des Voitures :");
		listVoitureLbl.setForeground(new Color(143, 188, 143));
		listVoitureLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		listVoitureLbl.setBounds(23, 183, 125, 31);
		panel.add(listVoitureLbl);
		
		ajouterImageLbl = new JLabel("");
		ajouterImageLbl.addMouseListener(this);
		iconAjouter =  new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage();
		ajouterImageLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterImageLbl.setBounds(587, 174, 51, 40);
		panel.add(ajouterImageLbl);
		
		modifierImageLbl = new JLabel("");
		modifierImageLbl.addMouseListener(this);
		iconModifier =  new ImageIcon(this.getClass().getResource("/modifier.png")).getImage();
		modifierImageLbl.setIcon(new ImageIcon(iconModifier));
		modifierImageLbl.setBounds(23, 429, 51, 40);
		panel.add(modifierImageLbl);
		
		supprimerImageLbl = new JLabel("");
		iconSupprimer =  new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		supprimerImageLbl.addMouseListener(this);
		
		supprimerImageLbl.setIcon(new ImageIcon(iconSupprimer));
		supprimerImageLbl.setBounds(84, 429, 51, 40);
		panel.add(supprimerImageLbl);
		
		table = new JTable();
		scrollPan.setViewportView(table);

		VehiculeController vehiculeController = new VehiculeController();
		listVehicule=vehiculeController.getAll();
		refresh(listVehicule);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(rechercheImageLbl==e.getComponent()) {
			VehiculeController vehiculeController = new VehiculeController();
			SearcheVehicule params = new SearcheVehicule();
			params.setType(typeTxt.getText());
			params.setMarque(marqueTxt.getText());
			params.setMatricule(matriculeTxt.getText());
			if((!typeTxt.getText().isEmpty()) || !marqueTxt.getText().isEmpty() || !matriculeTxt.getText().isEmpty()) {
				listVehicule.clear();
				listVehicule=vehiculeController.search(params);;
				refresh(listVehicule);
			}else {
				JOptionPane.showMessageDialog(null, "vehicule introuvable");
			}
		}
		if(supprimerImageLbl==e.getComponent()) {
			rowIndex = table.getSelectedRow();
			int id;
			boolean check;
			if(rowIndex == -1)
				JOptionPane.showMessageDialog(null,"Vous devez selectionner un vehicule!");
			else
			{
				id = listVehicule.get(rowIndex).getId();
				VehiculeController vehiculeController = new VehiculeController();
				check = vehiculeController.delete(id);
				if(check==true) {
					vehiculeController = new VehiculeController();
					listVehicule.clear();
					listVehicule = vehiculeController.getAll();
					refresh(listVehicule);
					JOptionPane.showMessageDialog(null,"Vehicule supprimier!"); 
				}
				else
					JOptionPane.showMessageDialog(null,"Une erreur s'est produite!");  
			}
		}
		if(modifierImageLbl==e.getComponent()) {
			if(table.getSelectedRow()>=0) {
				idVehicule=listVehicule.get(table.getSelectedRow()).getId();
				ModifierVehicule modifierVehicule = new ModifierVehicule(idVehicule,GestionVehicules.this);
				modifierVehicule.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(null,"Vous devez selectionnez un Vehicule!");
		}
		if(ajouterImageLbl==e.getComponent()) {
			AjouterVehicule ajouterVehicule = new AjouterVehicule(GestionVehicules.this);
			ajouterVehicule.setVisible(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
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
