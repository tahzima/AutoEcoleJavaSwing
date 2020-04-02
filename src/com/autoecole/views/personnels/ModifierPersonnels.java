package com.autoecole.views.personnels;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
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
import com.autoecole.controller.PersonnelsController;
import com.sun.istack.internal.FinalArrayList;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class ModifierPersonnels extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JTextField cinTxt;
	private JTextField posteTxt;
	private JTextField numTeleTxt;
	private JTextField adresseTxt;
	private Image iconAjouter;
	private Image iconAnnuler;
	private Image iconRetour;
	private JTextField salaireTxt;
	private Personnels personnel;
	JDateChooser dateEmbDtc;
	JDateChooser dateNaissDtc;
	private JLabel imageRetourLbl;
	private JLabel imageAnnulerLbl;
	private JLabel imageModifierLbl;
	private int idPersonnel;
	private GestionPersonnels gestionPersonnel;
	/**
	 * Create the frame.
	 */
	public ModifierPersonnels(final int idPersonnel, final GestionPersonnels gestionPersonnel) {
		this.idPersonnel=idPersonnel;
		this.gestionPersonnel=gestionPersonnel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(52, 73, 94));
		panel.setBounds(0, 0, 648, 480);
		contentPane.add(panel);
		
		JPanel separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(new Color(126, 214, 223));
		separateur1Pnl.setBounds(0, 57, 648, 10);
		panel.add(separateur1Pnl);
		
		JPanel separateur2Pnl = new JPanel();
		separateur2Pnl.setBackground(new Color(126, 214, 223));
		separateur2Pnl.setBounds(0, 117, 648, 10);
		panel.add(separateur2Pnl);
		
		JLabel gestionPersonnelLbl = new JLabel("Gestion Personnels");
		gestionPersonnelLbl.setForeground(new Color(143, 188, 143));
		gestionPersonnelLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionPersonnelLbl.setBounds(255, 11, 161, 48);
		panel.add(gestionPersonnelLbl);
		
		JLabel modifierPersonnelLbl = new JLabel("Modifier Personnel");
		modifierPersonnelLbl.setForeground(new Color(143, 188, 143));
		modifierPersonnelLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		modifierPersonnelLbl.setBounds(255, 78, 161, 28);
		panel.add(modifierPersonnelLbl);
		
		JLabel nomLbl = new JLabel("Nom :");
		nomLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nomLbl.setForeground(new Color(143, 188, 143));
		nomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		nomLbl.setBounds(63, 138, 154, 20);
		panel.add(nomLbl);
		
		JLabel prenomLbl = new JLabel("Prenom :");
		prenomLbl.setHorizontalAlignment(SwingConstants.CENTER);
		prenomLbl.setForeground(new Color(143, 188, 143));
		prenomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		prenomLbl.setBounds(63, 169, 154, 20);
		panel.add(prenomLbl);
		
		JLabel dateNaissanceLbl = new JLabel("Date de Naissance :");
		dateNaissanceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateNaissanceLbl.setForeground(new Color(143, 188, 143));
		dateNaissanceLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateNaissanceLbl.setBounds(63, 200, 154, 20);
		panel.add(dateNaissanceLbl);
		
		JLabel cinLbl = new JLabel("CIN :");
		cinLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cinLbl.setForeground(new Color(143, 188, 143));
		cinLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		cinLbl.setBounds(63, 231, 154, 20);
		panel.add(cinLbl);
		
		JLabel adresseLbl = new JLabel("Adresse :");
		adresseLbl.setHorizontalAlignment(SwingConstants.CENTER);
		adresseLbl.setForeground(new Color(143, 188, 143));
		adresseLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		adresseLbl.setBounds(63, 262, 154, 20);
		panel.add(adresseLbl);
		
		JLabel numTeleLbl = new JLabel("Numero de Telephone :");
		numTeleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		numTeleLbl.setForeground(new Color(143, 188, 143));
		numTeleLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		numTeleLbl.setBounds(63, 293, 154, 20);
		panel.add(numTeleLbl);
		
		JLabel posteLbl = new JLabel("Poste :");
		posteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		posteLbl.setForeground(new Color(143, 188, 143));
		posteLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		posteLbl.setBounds(63, 324, 154, 20);
		panel.add(posteLbl);
		
		JLabel lblDateDembauche = new JLabel("Date D'Embauche :");
		lblDateDembauche.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateDembauche.setForeground(new Color(143, 188, 143));
		lblDateDembauche.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblDateDembauche.setBounds(63, 355, 154, 20);
		panel.add(lblDateDembauche);
		
		nomTxt = new JTextField();
		nomTxt.setColumns(10);
		nomTxt.setBounds(381, 140, 161, 20);
		panel.add(nomTxt);
		
		prenomTxt = new JTextField();
		prenomTxt.setColumns(10);
		prenomTxt.setBounds(381, 171, 161, 20);
		panel.add(prenomTxt);
		
		cinTxt = new JTextField();
		cinTxt.setColumns(10);
		cinTxt.setBounds(381, 233, 161, 20);
		panel.add(cinTxt);
		
		posteTxt = new JTextField();
		posteTxt.setColumns(10);
		posteTxt.setBounds(381, 326, 161, 20);
		panel.add(posteTxt);
		
		numTeleTxt = new JTextField();
		numTeleTxt.setColumns(10);
		numTeleTxt.setBounds(381, 295, 161, 20);
		panel.add(numTeleTxt);
		
		dateNaissDtc = new JDateChooser();
		dateNaissDtc.setBounds(381, 200, 161, 20);
		panel.add(dateNaissDtc);
		
		dateEmbDtc = new JDateChooser();
		dateEmbDtc.setBounds(381, 355, 161, 20);
		panel.add(dateEmbDtc);
		
		adresseTxt = new JTextField();
		adresseTxt.setColumns(10);
		adresseTxt.setBounds(381, 264, 161, 20);
		panel.add(adresseTxt);
		
		imageRetourLbl = new JLabel("");
		imageRetourLbl.addMouseListener(this);
		iconRetour = new ImageIcon(this.getClass().getResource("/retour.png")).getImage();
		imageRetourLbl.setIcon(new ImageIcon(iconRetour));
		imageRetourLbl.setBounds(496, 424, 46, 45);
		panel.add(imageRetourLbl);
		
		imageAnnulerLbl = new JLabel("");
		imageAnnulerLbl.addMouseListener(this);
		iconAnnuler = new ImageIcon(this.getClass().getResource("/annuler.png")).getImage();
		imageAnnulerLbl.setIcon(new ImageIcon(iconAnnuler));
		imageAnnulerLbl.setBounds(275, 424, 46, 45);
		panel.add(imageAnnulerLbl);
		
		imageModifierLbl = new JLabel("");
		imageModifierLbl.addMouseListener(this);
		iconAjouter = new ImageIcon(this.getClass().getResource("/valider.png")).getImage();
		imageModifierLbl.setIcon(new ImageIcon(iconAjouter));
		imageModifierLbl.setBounds(63, 424, 46, 45);
		panel.add(imageModifierLbl);
		
		salaireTxt = new JTextField();
		salaireTxt.setColumns(10);
		salaireTxt.setBounds(381, 386, 161, 20);
		panel.add(salaireTxt);
		
		JLabel salaireLbl = new JLabel("Salaire :");
		salaireLbl.setHorizontalAlignment(SwingConstants.CENTER);
		salaireLbl.setForeground(new Color(143, 188, 143));
		salaireLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		salaireLbl.setBounds(63, 386, 154, 20);
		panel.add(salaireLbl);
		
		nomTxt.disable();
		prenomTxt.disable();
		cinTxt.disable();
		PersonnelsController personnelController = new PersonnelsController();
		personnel=personnelController.findById(idPersonnel);
		nomTxt.setText(personnel.getNom());
		prenomTxt.setText(personnel.getPrenom());
		cinTxt.setText(personnel.getCin());
		adresseTxt.setText(personnel.getAdresse());
		posteTxt.setText(personnel.getPoste());
		salaireTxt.setText(personnel.getSalaire().toString());
		dateEmbDtc.setDate(personnel.getDateEmbauche());
		dateNaissDtc.setDate(personnel.getDateNaissance());
		numTeleTxt.setText(personnel.getNumTele());
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent()==imageRetourLbl) {
			dispose();
		}
		if(imageAnnulerLbl==e.getComponent()) {
			nomTxt.setText(null);
			prenomTxt.setText(null);
			cinTxt.setText(null);
			adresseTxt.setText(null);
			numTeleTxt.setText(null);
			dateNaissDtc.setDate(null);
			dateEmbDtc.setDate(null);
			posteTxt.setText(null);
			salaireTxt.setText(null);
		}
		if(e.getComponent()==imageModifierLbl) {
			PersonnelsController personnelController = new PersonnelsController();
			boolean result;
			Personnels personnel = new Personnels();
			List<Personnels> listPersonnel = new ArrayList<Personnels>();
			try {
				if(salaireTxt.getText()!=null && !salaireTxt.getText().isEmpty() && dateEmbDtc.getDateFormatString()!=null && dateNaissDtc.getDateFormatString()!=null && !dateEmbDtc.getDateFormatString().isEmpty() && !dateNaissDtc.getDateFormatString().isEmpty() && nomTxt.getText()!=null && prenomTxt.getText()!=null && posteTxt.getText()!=null && numTeleTxt.getText()!=null && !numTeleTxt.getText().isEmpty() && adresseTxt.getText()!=null && cinTxt.getText()!=null) {
					java.sql.Date dateN = new java.sql.Date(dateNaissDtc.getDate().getTime());
					java.sql.Date dateE = new java.sql.Date(dateEmbDtc.getDate().getTime());
					personnel.setId(idPersonnel);
					personnel.setPrenom(prenomTxt.getText());
					personnel.setNom(nomTxt.getText());
					personnel.setCin(cinTxt.getText());
					personnel.setAdresse(adresseTxt.getText());
					personnel.setNumTele(numTeleTxt.getText());
					personnel.setPoste(posteTxt.getText());
					personnel.setSalaire(Float.valueOf(salaireTxt.getText()));
					personnel.setDateEmbauche(dateE);
					personnel.setDateNaissance(dateN);
					result=personnelController.update(personnel);
					if(result==true) {
						listPersonnel=personnelController.getAll();
						gestionPersonnel.refresh(listPersonnel);
						JOptionPane.showMessageDialog(null, "Bien Modifier");
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
