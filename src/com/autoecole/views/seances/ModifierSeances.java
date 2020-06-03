package com.autoecole.views.seances;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import com.autoecole.beans.Personnels;
import com.autoecole.beans.Seances;
import com.autoecole.beans.Vehicules;
import com.autoecole.controller.PersonnelsController;
import com.autoecole.controller.SeanceController;
import com.autoecole.controller.VehiculeController;
import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;

public class ModifierSeances extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField nomPersonnelTxt;
	private JTextField marqueVehiculeTxt;
	private JLabel retourLbl;
	private JLabel annulerLbl;
	private JLabel modifierLbl;
	private JDateChooser dateChooser;
	private JComboBox comboBox;
	private Image iconAnnuler;
	private Image iconRetour;
	private Image iconModifier;
	private int idSeance;
	private GestionSeances gestionSeance;

	/**
	 * Create the frame.
	 */
	public ModifierSeances(int idSeance,GestionSeances gestionSeance) {
		this.idSeance=idSeance;
		this.gestionSeance=gestionSeance;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(52, 73, 94));
		panel.setBounds(0, 0, 648, 330);
		contentPane.add(panel);
		
		JPanel separateur1 = new JPanel();
		separateur1.setBackground(new Color(126, 214, 223));
		separateur1.setBounds(0, 57, 648, 10);
		panel.add(separateur1);
		
		JPanel separateur2 = new JPanel();
		separateur2.setBackground(new Color(126, 214, 223));
		separateur2.setBounds(0, 117, 648, 10);
		panel.add(separateur2);
		
		JLabel gestionSeancesLbl = new JLabel("Gestion Seances");
		gestionSeancesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		gestionSeancesLbl.setForeground(new Color(143, 188, 143));
		gestionSeancesLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionSeancesLbl.setBounds(177, 11, 315, 48);
		panel.add(gestionSeancesLbl);
		
		JLabel modifierSeanceLbl = new JLabel("Modifier Seance");
		modifierSeanceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		modifierSeanceLbl.setForeground(new Color(143, 188, 143));
		modifierSeanceLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		modifierSeanceLbl.setBounds(177, 78, 315, 28);
		panel.add(modifierSeanceLbl);
		
		JLabel TypeSeanceLbl = new JLabel("Type de Seance :");
		TypeSeanceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TypeSeanceLbl.setForeground(new Color(143, 188, 143));
		TypeSeanceLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		TypeSeanceLbl.setBounds(45, 159, 154, 20);
		panel.add(TypeSeanceLbl);
		
		JLabel marqueVehiculeLbl = new JLabel("Marque du Vehicules :");
		marqueVehiculeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		marqueVehiculeLbl.setForeground(new Color(143, 188, 143));
		marqueVehiculeLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		marqueVehiculeLbl.setBounds(45, 200, 154, 20);
		panel.add(marqueVehiculeLbl);
		
		JLabel personnelNomLbl = new JLabel("Nom du Personnel :");
		personnelNomLbl.setHorizontalAlignment(SwingConstants.CENTER);
		personnelNomLbl.setForeground(new Color(143, 188, 143));
		personnelNomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		personnelNomLbl.setBounds(45, 237, 154, 20);
		panel.add(personnelNomLbl);
		
		nomPersonnelTxt = new JTextField();
		nomPersonnelTxt.setColumns(10);
		nomPersonnelTxt.setBounds(342, 239, 161, 20);
		panel.add(nomPersonnelTxt);
		
		marqueVehiculeTxt = new JTextField();
		marqueVehiculeTxt.setColumns(10);
		marqueVehiculeTxt.setBounds(342, 202, 161, 20);
		panel.add(marqueVehiculeTxt);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(342, 281, 161, 20);
		panel.add(dateChooser);
		
		modifierLbl = new JLabel("");
		modifierLbl.addMouseListener(this);
		iconModifier = new ImageIcon(this.getClass().getResource("/valider.png")).getImage();
		modifierLbl.setIcon(new ImageIcon(iconModifier));
		modifierLbl.setBounds(580, 159, 46, 45);
		panel.add(modifierLbl);
		
		annulerLbl = new JLabel("");
		annulerLbl.addMouseListener(this);
		iconAnnuler = new ImageIcon(this.getClass().getResource("/annuler.png")).getImage();
		annulerLbl.setIcon(new ImageIcon(iconAnnuler));
		annulerLbl.setBounds(580, 215, 46, 45);
		panel.add(annulerLbl);
		
		retourLbl = new JLabel("");
		retourLbl.addMouseListener(this);
		iconRetour = new ImageIcon(this.getClass().getResource("/retour.png")).getImage();
		retourLbl.setIcon(new ImageIcon(iconRetour));
		retourLbl.setBounds(580, 269, 46, 32);
		panel.add(retourLbl);
		
		JLabel dateSeanceLbl = new JLabel("Date Seance :");
		dateSeanceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateSeanceLbl.setForeground(new Color(143, 188, 143));
		dateSeanceLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateSeanceLbl.setBounds(45, 283, 154, 20);
		panel.add(dateSeanceLbl);
		
		comboBox = new JComboBox();
		comboBox.addItem("Theorique");
		comboBox.addItem("Pratique");
		comboBox.setBounds(342, 159, 161, 20);
		panel.add(comboBox);
		
		Seances seance = new Seances();
		List<Personnels> listPersonnel = new ArrayList<Personnels>();
		List<Vehicules> listVehicule = new ArrayList<Vehicules>();
		List<Seances> listSeance = new ArrayList<Seances>();
		
		PersonnelsController personnelController = new PersonnelsController();
		VehiculeController vehiculeController = new VehiculeController();
		SeanceController seanceController = new SeanceController();
		
		listPersonnel = personnelController.getAll();
		listVehicule = vehiculeController.getAll();
		listSeance = seanceController.getAll();
		
		int listPersonnelSize =listPersonnel.size();
		int listVehiculeSize = listVehicule.size();
		
		String nomPersonnel="";
		String marqueVehicule="";
		
		for(int i = 0; i<listSeance.size() ; i++) {
			if(listSeance.get(i).getId()==idSeance) {
				seance.setDate(listSeance.get(i).getDate());
				seance.setId(listSeance.get(i).getId());
				seance.setId_Personnels(listSeance.get(i).getId_Personnels());
				seance.setId_Vehicules(listSeance.get(i).getId_Vehicules());
				seance.setTypeSeance(listSeance.get(i).getTypeSeance());
			}
		}
		for(int i=0;i<listPersonnelSize;i++) {
			if(seance.getId_Personnels()==listPersonnel.get(i).getId()) {
				nomPersonnel=listPersonnel.get(i).getNom();
			}
		}
		for(int i=0;i<listVehiculeSize;i++) {
			if(seance.getId_Vehicules()==listVehicule.get(i).getId()) {
				marqueVehicule=listVehicule.get(i).getMarque();
			}
		}
		comboBox.setSelectedItem(seance.getTypeSeance());
		marqueVehiculeTxt.setText(marqueVehicule);
		nomPersonnelTxt.setText(nomPersonnel);
		dateChooser.setDate(seance.getDate());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent()==modifierLbl) {

			List<Personnels> listPersonnel = new ArrayList<Personnels>();
			List<Vehicules> listVehicule = new ArrayList<Vehicules>();
			List<Seances> listSeance = new ArrayList<Seances>();
			
			PersonnelsController personnelController = new PersonnelsController();
			VehiculeController vehiculeController = new VehiculeController();
			SeanceController seanceController = new SeanceController();
			
			listPersonnel = personnelController.getAll();
			listVehicule = vehiculeController.getAll();
			
			int listPersonnelSize =listPersonnel.size();
			int listVehiculeSize = listVehicule.size();
			int idPersonnel=-1;
			int idVehicule=-1;
			
			for(int i=0;i<listPersonnelSize;i++) {
				if(nomPersonnelTxt.getText().equalsIgnoreCase(listPersonnel.get(i).getNom())) {
					idPersonnel=listPersonnel.get(i).getId();
				}
			}
			for(int i=0;i<listVehiculeSize;i++) {
				if(marqueVehiculeTxt.getText().equalsIgnoreCase(listVehicule.get(i).getMarque())) {
					idVehicule=listVehicule.get(i).getId();
				}
			}

			try {
				
				if(comboBox.getSelectedItem().equals("Theorique") || marqueVehiculeTxt.getText().isEmpty() || !nomPersonnelTxt.getText().isEmpty()) {
					Date dateSeance = new Date(dateChooser.getDate().getTime());
					Seances seance = new Seances();
					seance.setId_Personnels(idPersonnel);
					seance.setId_Vehicules(idVehicule);
					seance.setDate(dateSeance);
					seance.setTypeSeance(comboBox.getSelectedItem().toString());
					seance.setId(idSeance);
					int check=seanceController.edit(seance);
					if(check!=0) {
						JOptionPane.showMessageDialog(null,"Seance Bien Modifier");
						listSeance = seanceController.getAll();
						gestionSeance.refresh(listSeance); 
					}else {
						JOptionPane.showMessageDialog(null,"Error!"); 
					}
				}else if(comboBox.getSelectedItem().equals("Pratique") && !marqueVehiculeTxt.getText().isEmpty() && !nomPersonnelTxt.getText().isEmpty()) {
					Date dateSeance = new Date(dateChooser.getDate().getTime());
					Seances seance = new Seances();
					seance.setId_Personnels(idPersonnel);
					seance.setId_Vehicules(idVehicule);
					seance.setDate(dateSeance);
					seance.setTypeSeance(comboBox.getSelectedItem().toString());
					seance.setId(idSeance);
					int check=seanceController.edit(seance);
					if(check!=0) {
						JOptionPane.showMessageDialog(null,"Seance Bien Modifier");
						listSeance = seanceController.getAll();
						gestionSeance.refresh(listSeance); 
					}else {
						JOptionPane.showMessageDialog(null,"Error!!"); 
					}
				}else {
					JOptionPane.showMessageDialog(null,"Error!!!");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		if(e.getComponent()==annulerLbl) {
			comboBox.setSelectedIndex(-1);
			dateChooser.setDate(null);
			marqueVehiculeTxt.setText(null);
			nomPersonnelTxt.setText(null);
		}
		if(e.getComponent()==retourLbl) {
			dispose();
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
