package com.autoecole.views.vehicule;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
import com.autoecole.beans.Vehicules;
import com.autoecole.controller.PersonnelsController;
import com.autoecole.controller.VehiculeController;
import com.sun.xml.internal.bind.v2.util.TypeCast;
import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;

public class ModifierVehicule extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField typeTxt;
	private JTextField marqueTxt;
	private JTextField modeleTxt;
	private JTextField puissanceFiscaleTxt;
	private JTextField matriculetxt;
	private JTextField nbPlaceTxt;
	private JTextField assuranceTxt;
	private JTextField kmVidangeTxt;
	private JLabel retourLbl;
	private JLabel annulerLbl;
	private JLabel validerLbl;
	private GestionVehicules gestionVehicule;
	private Image iconRetour;
	private Image iconAnnuler;
	private Image iconValider;
	private int idV;
	private Vehicules vehicule;
	private JLabel dateLimiteAssuranceLbl;
	private JComboBox typeCarburantCmb;
	private JDateChooser dateLimiteAssuranceDtc;
	

	/**
	 * Create the frame.
	 */
	public ModifierVehicule(int idVehicule, GestionVehicules gestionVehicule) {
		this.idV=idVehicule;
		this.gestionVehicule=gestionVehicule;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(52, 73, 94));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(new Color(126, 214, 223));
		separateur1Pnl.setBounds(0, 57, 648, 10);
		panel.add(separateur1Pnl);
		
		JPanel separateur2Pnl = new JPanel();
		separateur2Pnl.setBackground(new Color(126, 214, 223));
		separateur2Pnl.setBounds(0, 117, 648, 10);
		panel.add(separateur2Pnl);
		
		JLabel gestionVehiculeLbl = new JLabel("Gestion Vehicules");
		gestionVehiculeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		gestionVehiculeLbl.setForeground(new Color(143, 188, 143));
		gestionVehiculeLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionVehiculeLbl.setBounds(177, 11, 315, 48);
		panel.add(gestionVehiculeLbl);
		
		JLabel modifierVehiculeLbl = new JLabel("Modifier Vehicule");
		modifierVehiculeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		modifierVehiculeLbl.setForeground(new Color(143, 188, 143));
		modifierVehiculeLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		modifierVehiculeLbl.setBounds(177, 78, 315, 28);
		panel.add(modifierVehiculeLbl);
		
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
		
		JLabel typeCarburantLbl = new JLabel("Type de Carburant :");
		typeCarburantLbl.setHorizontalAlignment(SwingConstants.CENTER);
		typeCarburantLbl.setForeground(new Color(143, 188, 143));
		typeCarburantLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		typeCarburantLbl.setBounds(45, 283, 154, 20);
		panel.add(typeCarburantLbl);
		
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
		
		JLabel assurance = new JLabel("Assurance :");
		assurance.setHorizontalAlignment(SwingConstants.CENTER);
		assurance.setForeground(new Color(143, 188, 143));
		assurance.setFont(new Font("Oswald", Font.PLAIN, 13));
		assurance.setBounds(45, 376, 154, 20);
		panel.add(assurance);
		
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
		
		matriculetxt = new JTextField();
		matriculetxt.setColumns(10);
		matriculetxt.setBounds(342, 314, 161, 20);
		panel.add(matriculetxt);
		
		dateLimiteAssuranceDtc = new JDateChooser();
		dateLimiteAssuranceDtc.setBounds(342, 405, 161, 20);
		panel.add(dateLimiteAssuranceDtc);
		
		nbPlaceTxt = new JTextField();
		nbPlaceTxt.setColumns(10);
		nbPlaceTxt.setBounds(342, 252, 161, 20);
		panel.add(nbPlaceTxt);
		
		validerLbl = new JLabel("");
		validerLbl.addMouseListener(this);
		iconValider = new ImageIcon(this.getClass().getResource("/valider.png")).getImage();
		validerLbl.setIcon(new ImageIcon(iconValider));
		validerLbl.setBounds(580, 159, 46, 45);
		panel.add(validerLbl);
		
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
		
		dateLimiteAssuranceLbl = new JLabel("Date Limite Assurance :");
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
		
		JLabel kmVidange = new JLabel("KM Vidange :");
		kmVidange.setHorizontalAlignment(SwingConstants.CENTER);
		kmVidange.setForeground(new Color(143, 188, 143));
		kmVidange.setFont(new Font("Oswald", Font.PLAIN, 13));
		kmVidange.setBounds(45, 438, 154, 20);
		panel.add(kmVidange);
		
		kmVidangeTxt = new JTextField();
		kmVidangeTxt.setColumns(10);
		kmVidangeTxt.setBounds(342, 438, 161, 20);
		panel.add(kmVidangeTxt);
		
		
		typeTxt.disable();
		matriculetxt.disable();
		marqueTxt.disable();
		VehiculeController vehiculeController = new VehiculeController();
		vehicule= new Vehicules();
		vehicule= vehiculeController.findById(idV);
		typeTxt.setText(vehicule.getType());
		marqueTxt.setText(vehicule.getMarque());
		modeleTxt.setText(vehicule.getModele());
		typeCarburantCmb.setSelectedItem(vehicule.getTypeCarburant());
		matriculetxt.setText(vehicule.getMatricule());
		assuranceTxt.setText(vehicule.getAssurance());
		dateLimiteAssuranceDtc.setDate(vehicule.getDateLimiteAssurance());
		kmVidangeTxt.setText(String.valueOf(vehicule.getKmVidange()));
		nbPlaceTxt.setText(String.valueOf(vehicule.getNbPlace()));
		puissanceFiscaleTxt.setText(String.valueOf(vehicule.getPuissanceFiscale()));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(retourLbl==e.getComponent()) {
			dispose();
		}
		if(annulerLbl==e.getComponent()) {
			typeTxt.setText(null);
			matriculetxt.setText(null);
			modeleTxt.setText(null);
			marqueTxt.setText(null);
			puissanceFiscaleTxt.setText(null);
			nbPlaceTxt.setText(null);
			puissanceFiscaleTxt.setText(null);
			dateLimiteAssuranceDtc.setDate(null);
			kmVidangeTxt.setText(null);
			assuranceTxt.setText(null);
		}
		if(validerLbl==e.getComponent()) {
			VehiculeController vehiculeController = new VehiculeController();
			boolean result;
			Vehicules vehicule = new Vehicules();
			try {
					Date dateAssurance = new Date(dateLimiteAssuranceDtc.getDate().getTime());
					vehicule.setId(Integer.valueOf(idV));
					vehicule.setType(typeTxt.getText());
					vehicule.setMarque(marqueTxt.getText());
					vehicule.setModele(modeleTxt.getText());
					vehicule.setNbPlace(Integer.valueOf(nbPlaceTxt.getText()));
					vehicule.setTypeCarburant(typeCarburantCmb.getSelectedItem().toString());
					vehicule.setMatricule(matriculetxt.getText());
					vehicule.setPuissanceFiscale(Integer.valueOf(puissanceFiscaleTxt.getText()));
					vehicule.setAssurance(assuranceTxt.getText());
					vehicule.setDateLimiteAssurance(dateAssurance);
					vehicule.setKmVidange(Integer.valueOf(kmVidangeTxt.getText()));
					result=vehiculeController.update(vehicule);
					if(result==true) {
						List<Vehicules> listVehicule = new ArrayList<Vehicules>();
						listVehicule=vehiculeController.getAll();
						gestionVehicule.refresh(listVehicule);
						JOptionPane.showMessageDialog(null, "Bien Modifier");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "ERROR");
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
