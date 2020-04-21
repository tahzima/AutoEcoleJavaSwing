package com.autoecole.views.seances;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.autoecole.beans.Personnels;
import com.autoecole.beans.Seances;
import com.autoecole.beans.SearchSeance;
import com.autoecole.beans.Vehicules;
import com.autoecole.controller.PersonnelsController;
import com.autoecole.controller.SeanceController;
import com.autoecole.controller.VehiculeController;
import com.autoecole.views.vehicule.GestionVehicules;
import com.autoecole.views.vehicule.ModifierVehicule;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GestionSeances extends JPanel implements MouseListener {
	private JTextField typeSeancesTxt;
	private JLabel imageRechercheLbl;
	private JLabel imageAjouterLbl;
	private JLabel imageModifierLbl;
	private JLabel imageSupprimerLbl;
	private Image iconRecherche;
	private Image iconModifier;
	private Image iconSupprimer;
	private Image iconAjouter;
	private List<Seances> listSeance;
	private JTable table;
	private TableModel tablemodelSeance;
	private String [] colonnesSeance={"Date","Type de Seance","Vehicule","Personnel"};
	private Object [][]dataSeance;
	private int dataSizeSeance;
	private int idSeance;
	private int rowIndex;
	private JDateChooser dateChooser;
	
	/**
	 * Create the panel.
	 */
	
	public void refresh(List<Seances> list) {
		
		dataSeance = new Object[list.size()][5];
		VehiculeController vehiculeController = new VehiculeController();
		PersonnelsController personnelontroller = new PersonnelsController();
		Vehicules vehicule;
		Personnels personnel;
		
		for(int i=0;i<list.size();i++) {
			
			vehicule = new Vehicules();
			personnel = new Personnels();
			vehicule=vehiculeController.findById(list.get(i).getId_Vehicules());
			personnel=personnelontroller.findById(list.get(i).getId_Personnels());
			dataSeance[i][0]=list.get(i).getDate();
			dataSeance[i][1]=list.get(i).getTypeSeance();
			dataSeance[i][2]=vehicule.getMarque();
			dataSeance[i][3]=personnel.getNom();
			idSeance=list.get(i).getId();
			dataSeance[i][4]=idSeance;

		}
		
		DefaultTableModel model  = new DefaultTableModel(dataSeance,colonnesSeance);
		table.setModel(model);
		
	}
	
	public GestionSeances() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(52, 73, 94));
		panel.setBounds(0, 0, 649, 488);
		add(panel);
		
		JPanel separateur1 = new JPanel();
		separateur1.setBackground(new Color(126, 214, 223));
		separateur1.setBounds(0, 57, 648, 10);
		panel.add(separateur1);
		
		JPanel separateur2 = new JPanel();
		separateur2.setBackground(new Color(126, 214, 223));
		separateur2.setBounds(0, 153, 648, 10);
		panel.add(separateur2);
		
		JLabel gestionSeancesLbl = new JLabel("Gestion Seances");
		gestionSeancesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		gestionSeancesLbl.setForeground(new Color(143, 188, 143));
		gestionSeancesLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionSeancesLbl.setBounds(255, 11, 161, 48);
		panel.add(gestionSeancesLbl);
		
		JLabel typeSeancesLbl = new JLabel("type de Seance :");
		typeSeancesLbl.setForeground(new Color(143, 188, 143));
		typeSeancesLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		typeSeancesLbl.setBounds(38, 122, 125, 20);
		panel.add(typeSeancesLbl);
		
		JLabel rechercheLbl = new JLabel("Recherche :");
		rechercheLbl.setHorizontalAlignment(SwingConstants.CENTER);
		rechercheLbl.setForeground(new Color(143, 188, 143));
		rechercheLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		rechercheLbl.setBounds(283, 78, 106, 28);
		panel.add(rechercheLbl);
		
		typeSeancesTxt = new JTextField();
		typeSeancesTxt.setColumns(10);
		typeSeancesTxt.setBounds(171, 124, 86, 20);
		panel.add(typeSeancesTxt);
		
		JLabel dateLbl = new JLabel("Date de Seance :");
		dateLbl.setForeground(new Color(143, 188, 143));
		dateLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateLbl.setBounds(319, 120, 125, 20);
		panel.add(dateLbl);
		
		imageRechercheLbl = new JLabel("");
		imageRechercheLbl.addMouseListener(this);
		iconRecherche =  new ImageIcon(this.getClass().getResource("/searche.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageRechercheLbl.setIcon(new ImageIcon(iconRecherche));
		imageRechercheLbl.setBounds(602, 114, 36, 40);
		panel.add(imageRechercheLbl);
		
		JLabel listeSeances = new JLabel("Liste des Seances :");
		listeSeances.setForeground(new Color(143, 188, 143));
		listeSeances.setFont(new Font("Oswald", Font.PLAIN, 13));
		listeSeances.setBounds(23, 183, 125, 31);
		panel.add(listeSeances);
		
		imageAjouterLbl = new JLabel("");
		imageAjouterLbl.addMouseListener(this);
		iconAjouter =  new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage();
		imageAjouterLbl.setIcon(new ImageIcon(iconAjouter));
		imageAjouterLbl.setBounds(587, 174, 51, 40);
		panel.add(imageAjouterLbl);
		
		imageModifierLbl = new JLabel("");
		imageModifierLbl.addMouseListener(this);
		iconModifier =  new ImageIcon(this.getClass().getResource("/modifier.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageModifierLbl.setIcon(new ImageIcon(iconModifier));
		imageModifierLbl.setBounds(23, 429, 51, 40);
		panel.add(imageModifierLbl);
		
		imageSupprimerLbl = new JLabel("");
		imageSupprimerLbl.addMouseListener(this);
		iconSupprimer =  new ImageIcon(this.getClass().getResource("/delete.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageSupprimerLbl.setIcon(new ImageIcon(iconSupprimer));
		imageSupprimerLbl.setBounds(84, 429, 51, 40);
		panel.add(imageSupprimerLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 234, 628, 184);
		panel.add(scrollPane);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(454, 120, 106, 22);
		panel.add(dateChooser);
		
		SeanceController SeanceController = new SeanceController();
		listSeance=SeanceController.getAll();
		dataSizeSeance=listSeance.size();
		dataSeance=new Object[dataSizeSeance][5];
		for(int k=0;k<dataSizeSeance;k++)
		{
			Vehicules vehicule = new Vehicules();
			Personnels personnel = new Personnels();
			VehiculeController vehiculeController = new VehiculeController();
			PersonnelsController personnelontroller = new PersonnelsController();
			vehicule=vehiculeController.findById(listSeance.get(k).getId_Vehicules());
			personnel=personnelontroller.findById(listSeance.get(k).getId_Personnels());
			dataSeance[k][0]=listSeance.get(k).getDate();
			dataSeance[k][1]=listSeance.get(k).getTypeSeance();
			dataSeance[k][2]=vehicule.getMarque();
			dataSeance[k][3]=personnel.getNom();
			idSeance=listSeance.get(k).getId();
			dataSeance[k][4]=idSeance;
		}
		tablemodelSeance = new DefaultTableModel(dataSeance,colonnesSeance);
		table= new JTable(tablemodelSeance);
		scrollPane.setViewportView(table);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent()==imageRechercheLbl) {

			if(!typeSeancesTxt.getText().isEmpty() && dateChooser.getDate()!=null) {
				SearchSeance searchSeance= new SearchSeance();
				SeanceController seanceController = new SeanceController();
				Date dateS=new Date(dateChooser.getDate().getTime());
				searchSeance.setTypeSeance(typeSeancesTxt.getText());
				searchSeance.setDateSeance(dateS);
				listSeance=seanceController.search(searchSeance);
				refresh(listSeance);
			}else {
				JOptionPane.showMessageDialog(null,"Vous Devez Remplire Tous Les Champs !!!!!"); 
			}
		}
		if(e.getComponent()==imageSupprimerLbl) {
			rowIndex = table.getSelectedRow();
			int id;
			int check;
			if(rowIndex == -1)
				JOptionPane.showMessageDialog(null,"Vous devez selectionner une Seance!");
			else
			{
				id = (int)dataSeance[rowIndex][4];
				SeanceController seanceController = new SeanceController();
				check = seanceController.delete(id);
				
				if(check>0) {
					seanceController = new SeanceController();
					listSeance.clear();
					listSeance = seanceController.getAll();
					refresh(listSeance);
					JOptionPane.showMessageDialog(null,"Seance supprimer!"); 
				}
				else
					JOptionPane.showMessageDialog(null,"Une erreur s'est produite!");  
			}
		}
		if(e.getComponent()==imageAjouterLbl) {
			AjouterSeances ajouterSeance = new AjouterSeances(GestionSeances.this);
			ajouterSeance.setVisible(true);
		}
		if(e.getComponent()==imageModifierLbl) {
			if(table.getSelectedRow()>=0) {
				idSeance=listSeance.get(table.getSelectedRow()).getId();
				ModifierSeances modifierSeance = new ModifierSeances(idSeance,GestionSeances.this);
				modifierSeance.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(null,"Vous devez selectionnez une Seance!");
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
