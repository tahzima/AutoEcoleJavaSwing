package com.autoecole.views.vehicule;

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

import com.autoecole.beans.Vehicules;
import com.autoecole.controller.VehiculeController;
import com.autoecole.views.vehicule.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AjouterVehicule extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField typeTxt;
	private JTextField marqueTxt;
	private JTextField modeleTxt;
	private JTextField puissanceFiscaleTxt;
	private JTextField matriculeTxt;
	private JTextField nbPlaceTxt;
	private JTextField assuranceTxt;
	private JTextField kmVidangeTxt;
	private JLabel ajouterLbl;
	private JLabel annulerLbl;
	private JLabel retourLbl;
	private Image iconRetour;
	private Image iconAnnuler;
	private Image iconAjouter;
	private JComboBox typeCarburantCmb;
	private JDateChooser dateLimiteAssuranceDtc;
	private GestionVehicules gsVehicules;
	
	/**
	 * Create the frame.
	 */
	public AjouterVehicule(final GestionVehicules gestionVehicules) {
		this.gsVehicules=gestionVehicules;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(52, 73, 94));
		panel.setBounds(0, 0, 648, 480);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(126, 214, 223));
		panel_1.setBounds(0, 57, 648, 10);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(126, 214, 223));
		panel_2.setBounds(0, 117, 648, 10);
		panel.add(panel_2);
		
		JLabel gestionVehiculeLbl = new JLabel("Gestion Vehicules");
		gestionVehiculeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		gestionVehiculeLbl.setForeground(new Color(143, 188, 143));
		gestionVehiculeLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionVehiculeLbl.setBounds(177, 11, 315, 48);
		panel.add(gestionVehiculeLbl);
		
		JLabel ajouterPersonnelLbl = new JLabel("Ajouter Vehicule");
		ajouterPersonnelLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ajouterPersonnelLbl.setForeground(new Color(143, 188, 143));
		ajouterPersonnelLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		ajouterPersonnelLbl.setBounds(177, 78, 315, 28);
		panel.add(ajouterPersonnelLbl);
		
		JLabel typeLbl = new JLabel("Type :");
		typeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		typeLbl.setForeground(new Color(143, 188, 143));
		typeLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		typeLbl.setBounds(45, 159, 154, 20);
		panel.add(typeLbl);
		
		JLabel marqueLbl = new JLabel("Marque :");
		marqueLbl.setHorizontalAlignment(SwingConstants.CENTER);
		marqueLbl.setForeground(new Color(143, 188, 143));
		marqueLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		marqueLbl.setBounds(45, 190, 154, 20);
		panel.add(marqueLbl);
		
		JLabel modeleLbl = new JLabel("Modele :");
		modeleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		modeleLbl.setForeground(new Color(143, 188, 143));
		modeleLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		modeleLbl.setBounds(45, 221, 154, 20);
		panel.add(modeleLbl);
		
		JLabel nbPlaceLbl = new JLabel("Nombre de place :");
		nbPlaceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nbPlaceLbl.setForeground(new Color(143, 188, 143));
		nbPlaceLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		nbPlaceLbl.setBounds(45, 252, 154, 20);
		panel.add(nbPlaceLbl);
		
		JLabel typeCarburant = new JLabel("Type de Carburant :");
		typeCarburant.setHorizontalAlignment(SwingConstants.CENTER);
		typeCarburant.setForeground(new Color(143, 188, 143));
		typeCarburant.setFont(new Font("Oswald", Font.PLAIN, 13));
		typeCarburant.setBounds(45, 283, 154, 20);
		panel.add(typeCarburant);
		
		JLabel matriculeLbl = new JLabel("Matricule :");
		matriculeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		matriculeLbl.setForeground(new Color(143, 188, 143));
		matriculeLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		matriculeLbl.setBounds(45, 314, 154, 20);
		panel.add(matriculeLbl);
		
		JLabel puissanceFiscaleLbl = new JLabel("Puissance Fiscale :");
		puissanceFiscaleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		puissanceFiscaleLbl.setForeground(new Color(143, 188, 143));
		puissanceFiscaleLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		puissanceFiscaleLbl.setBounds(45, 345, 154, 20);
		panel.add(puissanceFiscaleLbl);
		
		JLabel assuranceLbl = new JLabel("Assurance :");
		assuranceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		assuranceLbl.setForeground(new Color(143, 188, 143));
		assuranceLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		assuranceLbl.setBounds(45, 376, 154, 20);
		panel.add(assuranceLbl);
		
		typeTxt = new JTextField();
		typeTxt.setColumns(10);
		typeTxt.setBounds(342, 159, 161, 20);
		panel.add(typeTxt);
		
		marqueTxt = new JTextField();
		marqueTxt.setColumns(10);
		marqueTxt.setBounds(342, 190, 161, 20);
		panel.add(marqueTxt);
		
		modeleTxt = new JTextField();
		modeleTxt.setColumns(10);
		modeleTxt.setBounds(342, 221, 161, 20);
		panel.add(modeleTxt);
		
		puissanceFiscaleTxt = new JTextField();
		puissanceFiscaleTxt.setColumns(10);
		puissanceFiscaleTxt.setBounds(342, 345, 161, 20);
		panel.add(puissanceFiscaleTxt);
		
		matriculeTxt = new JTextField();
		matriculeTxt.setColumns(10);
		matriculeTxt.setBounds(342, 314, 161, 20);
		panel.add(matriculeTxt);
		
		dateLimiteAssuranceDtc = new JDateChooser();
		dateLimiteAssuranceDtc.setBounds(342, 405, 161, 20);
		panel.add(dateLimiteAssuranceDtc);
		
		nbPlaceTxt = new JTextField();
		nbPlaceTxt.setColumns(10);
		nbPlaceTxt.setBounds(342, 252, 161, 20);
		panel.add(nbPlaceTxt);
		
		ajouterLbl = new JLabel("");
		ajouterLbl.addMouseListener(this);
		iconAjouter = new ImageIcon(this.getClass().getResource("/valider.png")).getImage();
		ajouterLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterLbl.setBounds(580, 159, 46, 45);
		panel.add(ajouterLbl);
		
		annulerLbl = new JLabel("");
		annulerLbl.addMouseListener(this);
		iconAnnuler = new ImageIcon(this.getClass().getResource("/annuler.png")).getImage();
		annulerLbl.setIcon(new ImageIcon(iconAnnuler));
		annulerLbl.setBounds(580, 289, 46, 45);
		panel.add(annulerLbl);
		
		retourLbl = new JLabel("");
		retourLbl.addMouseListener(this);
		iconRetour = new ImageIcon(this.getClass().getResource("/retour.png")).getImage();
		retourLbl.setIcon(new ImageIcon(iconRetour));
		retourLbl.setBounds(580, 413, 46, 45);
		panel.add(retourLbl);
		
		JLabel dateLimiteAssuranceLbl = new JLabel("Date Limite Assurance :");
		dateLimiteAssuranceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateLimiteAssuranceLbl.setForeground(new Color(143, 188, 143));
		dateLimiteAssuranceLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateLimiteAssuranceLbl.setBounds(45, 407, 154, 20);
		panel.add(dateLimiteAssuranceLbl);
		
		assuranceTxt = new JTextField();
		assuranceTxt.setColumns(10);
		assuranceTxt.setBounds(342, 376, 161, 20);
		panel.add(assuranceTxt);
		
		typeCarburantCmb = new JComboBox();
		typeCarburantCmb.setBounds(342, 283, 161, 20);
		typeCarburantCmb.addItem("Essence");
		typeCarburantCmb.addItem("diesel");
		panel.add(typeCarburantCmb);
		
		JLabel kmVidangeLbl = new JLabel("KM Vidange :");
		kmVidangeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		kmVidangeLbl.setForeground(new Color(143, 188, 143));
		kmVidangeLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		kmVidangeLbl.setBounds(45, 438, 154, 20);
		panel.add(kmVidangeLbl);
		
		kmVidangeTxt = new JTextField();
		kmVidangeTxt.setColumns(10);
		kmVidangeTxt.setBounds(342, 438, 161, 20);
		panel.add(kmVidangeTxt);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(ajouterLbl==e.getComponent()) {
			VehiculeController vehiculeController = new VehiculeController();
			boolean result;
			Vehicules vehicule = new Vehicules();
			List<Vehicules> listVehicule = new ArrayList<Vehicules>();
			try {
				if(!typeTxt.getText().isEmpty() && !marqueTxt.getText().isEmpty() && !matriculeTxt.getText().isEmpty() && !modeleTxt.getText().isEmpty() && !nbPlaceTxt.getText().isEmpty() && !puissanceFiscaleTxt.getText().isEmpty() && !assuranceTxt.getText().isEmpty() && !kmVidangeTxt.getText().isEmpty() && dateLimiteAssuranceDtc.getDate()!=null && typeCarburantCmb!=null) {
					Date dateAssurance = new Date(dateLimiteAssuranceDtc.getDate().getTime());
					vehicule.setType(typeTxt.getText());
					vehicule.setMarque(marqueTxt.getText());
					vehicule.setModele(modeleTxt.getText());
					vehicule.setNbPlace(Integer.valueOf(nbPlaceTxt.getText()));
					vehicule.setTypeCarburant(typeCarburantCmb.getSelectedItem().toString());
					vehicule.setMatricule(matriculeTxt.getText());
					vehicule.setPuissanceFiscale(Integer.valueOf(puissanceFiscaleTxt.getText()));
					vehicule.setAssurance(assuranceTxt.getText());
					vehicule.setDateLimiteAssurance(dateAssurance);
					vehicule.setKmVidange(Integer.valueOf(kmVidangeTxt.getText()));
					result=vehiculeController.add(vehicule);
					if(result) {
						listVehicule=vehiculeController.getAll();
						gsVehicules.refresh(listVehicule);
						JOptionPane.showMessageDialog(null, "Bien Ajouter");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				}else {
					JOptionPane.showMessageDialog(null, "vous devez remplire tous les champes");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		if(annulerLbl==e.getComponent()) {
			typeTxt.setText(null);
			marqueTxt.setText(null);
			modeleTxt.setText(null);
			nbPlaceTxt.setText(null);
			matriculeTxt.setText(null);
			puissanceFiscaleTxt.setText(null);
			assuranceTxt.setText(null);
			dateLimiteAssuranceDtc.setDate(null);
			kmVidangeTxt.setText(null);
		}
		if(retourLbl==e.getComponent()) {
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
