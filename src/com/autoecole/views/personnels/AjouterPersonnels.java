package com.autoecole.views.personnels;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.autoecole.beans.Personnels;
import com.autoecole.controller.GestionPersonnelsController;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class AjouterPersonnels extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JTextField cinTxt;
	private JTextField posteTxt;
	private JTextField numeroTelephoneTxt;
	private JTextField adresseTxt;
	private Image iconAjouter;
	private Image iconAnnuler;
	private Image iconRetour;
	private JTextField salaireTxt;
	private JLabel ajouterImageLbl;
	JDateChooser dateNaissanceDtc ;
	JDateChooser dateEmbaucheDtc;
	private GestionPersonnels gestionPersonnel;
	private JLabel annulerImagreLbl;
	private JLabel retourImageLbl;
	/**
	 * Create the frame.
	 */
	public AjouterPersonnels(final GestionPersonnels gestionPersonnel) {
		this.gestionPersonnel=gestionPersonnel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPnl = new JPanel();
		contentPnl.setLayout(null);
		contentPnl.setBackground(new Color(52, 73, 94));
		contentPnl.setBounds(0, 0, 648, 480);
		contentPane.add(contentPnl);
		
		JPanel separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(new Color(126, 214, 223));
		separateur1Pnl.setBounds(0, 57, 648, 10);
		contentPnl.add(separateur1Pnl);
		
		JPanel separateur2Pnl = new JPanel();
		separateur2Pnl.setBackground(new Color(126, 214, 223));
		separateur2Pnl.setBounds(0, 117, 648, 10);
		contentPnl.add(separateur2Pnl);
		
		JLabel gestionPersonnelLbl = new JLabel("Gestion Personnels");
		gestionPersonnelLbl.setForeground(new Color(143, 188, 143));
		gestionPersonnelLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionPersonnelLbl.setBounds(255, 11, 161, 48);
		contentPnl.add(gestionPersonnelLbl);
		
		JLabel ajouterPersonnelLbl = new JLabel("Ajouter Personnel");
		ajouterPersonnelLbl.setForeground(new Color(143, 188, 143));
		ajouterPersonnelLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		ajouterPersonnelLbl.setBounds(255, 78, 154, 28);
		contentPnl.add(ajouterPersonnelLbl);
		
		JLabel nomLbl = new JLabel("Nom :");
		nomLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nomLbl.setForeground(new Color(143, 188, 143));
		nomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		nomLbl.setBounds(63, 154, 154, 20);
		contentPnl.add(nomLbl);
		
		JLabel prenomLbl = new JLabel("Prenom :");
		prenomLbl.setHorizontalAlignment(SwingConstants.CENTER);
		prenomLbl.setForeground(new Color(143, 188, 143));
		prenomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		prenomLbl.setBounds(63, 185, 154, 20);
		contentPnl.add(prenomLbl);
		
		JLabel dateNaissanceLbl = new JLabel("Date de Naissance :");
		dateNaissanceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateNaissanceLbl.setForeground(new Color(143, 188, 143));
		dateNaissanceLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateNaissanceLbl.setBounds(63, 216, 154, 20);
		contentPnl.add(dateNaissanceLbl);
		
		JLabel cinLbl = new JLabel("CIN :");
		cinLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cinLbl.setForeground(new Color(143, 188, 143));
		cinLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		cinLbl.setBounds(63, 247, 154, 20);
		contentPnl.add(cinLbl);
		
		JLabel adresseLbl = new JLabel("Adresse :");
		adresseLbl.setHorizontalAlignment(SwingConstants.CENTER);
		adresseLbl.setForeground(new Color(143, 188, 143));
		adresseLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		adresseLbl.setBounds(63, 278, 154, 20);
		contentPnl.add(adresseLbl);
		
		JLabel numeroTeleLbl = new JLabel("Numero de Telephone :");
		numeroTeleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		numeroTeleLbl.setForeground(new Color(143, 188, 143));
		numeroTeleLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		numeroTeleLbl.setBounds(63, 309, 154, 20);
		contentPnl.add(numeroTeleLbl);
		
		JLabel posteLbl = new JLabel("Poste :");
		posteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		posteLbl.setForeground(new Color(143, 188, 143));
		posteLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		posteLbl.setBounds(63, 340, 154, 20);
		contentPnl.add(posteLbl);
		
		JLabel dateEmbLbl = new JLabel("Date D'Emboche :");
		dateEmbLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateEmbLbl.setForeground(new Color(143, 188, 143));
		dateEmbLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateEmbLbl.setBounds(63, 371, 154, 20);
		contentPnl.add(dateEmbLbl);
		
		nomTxt = new JTextField();
		nomTxt.setBounds(361, 156, 161, 20);
		contentPnl.add(nomTxt);
		nomTxt.setColumns(10);
		
		prenomTxt = new JTextField();
		prenomTxt.setColumns(10);
		prenomTxt.setBounds(361, 187, 161, 20);
		contentPnl.add(prenomTxt);
		
		cinTxt = new JTextField();
		cinTxt.setColumns(10);
		cinTxt.setBounds(361, 249, 161, 20);
		contentPnl.add(cinTxt);
		
		posteTxt = new JTextField();
		posteTxt.setColumns(10);
		posteTxt.setBounds(361, 342, 161, 20);
		contentPnl.add(posteTxt);
		
		numeroTelephoneTxt = new JTextField();
		numeroTelephoneTxt.setColumns(10);
		numeroTelephoneTxt.setBounds(361, 311, 161, 20);
		contentPnl.add(numeroTelephoneTxt);
		
		dateNaissanceDtc = new JDateChooser();
		dateNaissanceDtc.setBounds(361, 216, 161, 20);
		contentPnl.add(dateNaissanceDtc);
		
		dateEmbaucheDtc = new JDateChooser();
		dateEmbaucheDtc.setBounds(361, 371, 161, 20);
		contentPnl.add(dateEmbaucheDtc);
		
		adresseTxt = new JTextField();
		adresseTxt.setColumns(10);
		adresseTxt.setBounds(361, 280, 161, 20);
		contentPnl.add(adresseTxt);
		
		ajouterImageLbl = new JLabel("");
		ajouterImageLbl.addMouseListener(this);
		iconAjouter = new ImageIcon(this.getClass().getResource("/valider.png")).getImage();
		ajouterImageLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterImageLbl.setBounds(63, 435, 46, 45);
		contentPnl.add(ajouterImageLbl);
		
		annulerImagreLbl = new JLabel("");
		annulerImagreLbl.addMouseListener(this);
		iconAnnuler = new ImageIcon(this.getClass().getResource("/annuler.png")).getImage();
		annulerImagreLbl.setIcon(new ImageIcon(iconAnnuler));
		annulerImagreLbl.setBounds(275, 435, 46, 45);
		contentPnl.add(annulerImagreLbl);
		
		retourImageLbl = new JLabel("");
		retourImageLbl.addMouseListener(this);
		iconRetour = new ImageIcon(this.getClass().getResource("/retour.png")).getImage();
		retourImageLbl.setIcon(new ImageIcon(iconRetour));
		retourImageLbl.setBounds(496, 435, 46, 45);
		contentPnl.add(retourImageLbl);
		
		JLabel salaireLbl = new JLabel("Salaire :");
		salaireLbl.setHorizontalAlignment(SwingConstants.CENTER);
		salaireLbl.setForeground(new Color(143, 188, 143));
		salaireLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		salaireLbl.setBounds(63, 402, 154, 20);
		contentPnl.add(salaireLbl);
		
		salaireTxt = new JTextField();
		salaireTxt.setColumns(10);
		salaireTxt.setBounds(361, 404, 161, 20);
		contentPnl.add(salaireTxt);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent()==ajouterImageLbl) {
			GestionPersonnelsController gestionPersonnelController = new GestionPersonnelsController();
			boolean result;
			Personnels personnel = new Personnels();
			List<Personnels> listPersonnel = new ArrayList<Personnels>();
			try {
				if(salaireTxt.getText()!=null && !salaireTxt.getText().isEmpty() && dateEmbaucheDtc.getDateFormatString()!=null && dateNaissanceDtc.getDateFormatString()!=null && !dateEmbaucheDtc.getDateFormatString().isEmpty() && !dateNaissanceDtc.getDateFormatString().isEmpty() && nomTxt.getText()!=null && prenomTxt.getText()!=null && posteTxt.getText()!=null && numeroTelephoneTxt.getText()!=null && !numeroTelephoneTxt.getText().isEmpty() && adresseTxt.getText()!=null && cinTxt.getText()!=null) {
					java.sql.Date dateN = new java.sql.Date(dateNaissanceDtc.getDate().getTime());
					java.sql.Date dateE = new java.sql.Date(dateEmbaucheDtc.getDate().getTime());
					personnel.setPrenom(prenomTxt.getText());
					personnel.setNom(nomTxt.getText());
					personnel.setCin(cinTxt.getText());
					personnel.setAdresse(adresseTxt.getText());
					personnel.setNumTele(numeroTelephoneTxt.getText());
					personnel.setPoste(posteTxt.getText());
					personnel.setSalaire(Float.valueOf(salaireTxt.getText()));
					personnel.setDateEmbauche(dateE);
					personnel.setDateNaissance(dateN);
					result=gestionPersonnelController.add(personnel);
					if(result==true) {
						listPersonnel=gestionPersonnelController.getAll();
						gestionPersonnel.refresh(listPersonnel);
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
		if(e.getComponent()==annulerImagreLbl) {
			nomTxt.setText(null);
			prenomTxt.setText(null);
			cinTxt.setText(null);
			adresseTxt.setText(null);
			numeroTelephoneTxt.setText(null);
			dateNaissanceDtc.setDate(null);
			dateEmbaucheDtc.setDate(null);
			posteTxt.setText(null);
			salaireTxt.setText(null);
		}
		if(retourImageLbl==e.getComponent()) {
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
