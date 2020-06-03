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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AjouterSeances extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField personnelTxt;
	private JTextField vehiculeTxt;
	private Image iconAjouter;
	private Image iconAnnuler;
	private Image iconRetour;
	private JLabel annulerLbl;
	private JLabel ajouterLbl;
	private JLabel retourLbl;
	private JComboBox typeSeanceCmb;
	private JDateChooser dateChooser;
	private GestionSeances gestionSeance;

	/**
	 * Create the frame.
	 */
	public AjouterSeances(GestionSeances gestionSeance) {
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
		
		JLabel lblGestionSeances = new JLabel("Gestion Seances");
		lblGestionSeances.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionSeances.setForeground(new Color(143, 188, 143));
		lblGestionSeances.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		lblGestionSeances.setBounds(177, 11, 315, 48);
		panel.add(lblGestionSeances);
		
		JLabel lblAjouterSeance = new JLabel("Ajouter Seance");
		lblAjouterSeance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterSeance.setForeground(new Color(143, 188, 143));
		lblAjouterSeance.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		lblAjouterSeance.setBounds(177, 78, 315, 28);
		panel.add(lblAjouterSeance);
		
		JLabel lblTypeDeSeance = new JLabel("Type de Seance :");
		lblTypeDeSeance.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeDeSeance.setForeground(new Color(143, 188, 143));
		lblTypeDeSeance.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblTypeDeSeance.setBounds(45, 159, 154, 20);
		panel.add(lblTypeDeSeance);
		
		JLabel lblVehicules = new JLabel("Marque du Vehicules :");
		lblVehicules.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicules.setForeground(new Color(143, 188, 143));
		lblVehicules.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblVehicules.setBounds(45, 200, 154, 20);
		panel.add(lblVehicules);
		
		JLabel lblPersonnel = new JLabel("Personnel :");
		lblPersonnel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnel.setForeground(new Color(143, 188, 143));
		lblPersonnel.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblPersonnel.setBounds(45, 237, 154, 20);
		panel.add(lblPersonnel);
		
		personnelTxt = new JTextField();
		personnelTxt.setColumns(10);
		personnelTxt.setBounds(342, 239, 161, 20);
		panel.add(personnelTxt);
		
		vehiculeTxt = new JTextField();
		vehiculeTxt.setColumns(10);
		vehiculeTxt.setBounds(342, 202, 161, 20);
		panel.add(vehiculeTxt);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(342, 281, 161, 20);
		panel.add(dateChooser);
		
		ajouterLbl = new JLabel("");
		ajouterLbl.addMouseListener(this);
		iconAjouter = new ImageIcon(this.getClass().getResource("/valider.png")).getImage();
		ajouterLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterLbl.setBounds(580, 159, 46, 45);
		panel.add(ajouterLbl);
		
		annulerLbl = new JLabel("");
		annulerLbl.addMouseListener(this);
		iconAnnuler = new ImageIcon(this.getClass().getResource("/Annuler.png")).getImage();
		annulerLbl.setIcon(new ImageIcon(iconAnnuler));
		annulerLbl.setBounds(580, 215, 46, 45);
		panel.add(annulerLbl);
		
		retourLbl = new JLabel("");
		retourLbl.addMouseListener(this);
		iconRetour = new ImageIcon(this.getClass().getResource("/retour.png")).getImage();
		retourLbl.setIcon(new ImageIcon(iconRetour));
		retourLbl.setBounds(580, 269, 46, 32);
		panel.add(retourLbl);
		
		JLabel lblDateSeance = new JLabel("Date Seance :");
		lblDateSeance.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateSeance.setForeground(new Color(143, 188, 143));
		lblDateSeance.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblDateSeance.setBounds(45, 283, 154, 20);
		panel.add(lblDateSeance);
		
		typeSeanceCmb = new JComboBox();
		typeSeanceCmb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(typeSeanceCmb.getSelectedItem().equals("Theorique")) {
					vehiculeTxt.disable();
				}else if(typeSeanceCmb.getSelectedItem().equals("Pratique")) {
					vehiculeTxt.enable();
				}
			}
		});
		typeSeanceCmb.addItem("Theorique");
		typeSeanceCmb.addItem("Pratique");
		typeSeanceCmb.setBounds(342, 159, 161, 20);
		panel.add(typeSeanceCmb);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent()==annulerLbl) {
			personnelTxt.setText("");
			vehiculeTxt.setText("");
			dateChooser.setDate(null);
			typeSeanceCmb.setSelectedIndex(-1);
		}
		if(e.getComponent()==retourLbl) {
			dispose();
		}
		if(e.getComponent()==ajouterLbl) {
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
				if(personnelTxt.getText().equalsIgnoreCase(listPersonnel.get(i).getNom())) {
					idPersonnel=listPersonnel.get(i).getId();
				}
			}
			for(int i=0;i<listVehiculeSize;i++) {
				if(vehiculeTxt.getText().equalsIgnoreCase(listVehicule.get(i).getMarque())) {
					idVehicule=listVehicule.get(i).getId();
				}
			}

			try {
				
				if(typeSeanceCmb.getSelectedItem().equals("Theorique") || vehiculeTxt.getText().isEmpty() || !personnelTxt.getText().isEmpty()) {
					Date dateSeance = new Date(dateChooser.getDate().getTime());
					Seances seance = new Seances();
					seance.setId_Personnels(idPersonnel);
					seance.setId_Vehicules(idVehicule);
					seance.setDate(dateSeance);
					seance.setTypeSeance(typeSeanceCmb.getSelectedItem().toString());
					seance.setId_Vehicules(idVehicule);
					int check=seanceController.add(seance);
					if(check!=0) {
						JOptionPane.showMessageDialog(null,"Seance Bien Ajouter");
						listSeance = seanceController.getAll();
						gestionSeance.refresh(listSeance); 
					}else {
						JOptionPane.showMessageDialog(null,"Error!"); 
					}
				}else if(typeSeanceCmb.getSelectedItem().equals("Pratique") && !vehiculeTxt.getText().isEmpty() && !personnelTxt.getText().isEmpty()) {
					Date dateSeance = new Date(dateChooser.getDate().getTime());
					Seances seance = new Seances();
					seance.setId_Personnels(idPersonnel);
					seance.setId_Vehicules(idVehicule);
					seance.setDate(dateSeance);
					seance.setTypeSeance(typeSeanceCmb.getSelectedItem().toString());
					seance.setId_Vehicules(idVehicule);
					int check=seanceController.add(seance);
					if(check!=0) {
						JOptionPane.showMessageDialog(null,"Seance Bien Ajouter");
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
