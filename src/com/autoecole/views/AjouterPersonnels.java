package com.autoecole.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class AjouterPersonnels extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public AjouterPersonnels() {
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
		nomLbl.setBounds(63, 159, 154, 20);
		contentPnl.add(nomLbl);
		
		JLabel prenomLbl = new JLabel("Prenom :");
		prenomLbl.setHorizontalAlignment(SwingConstants.CENTER);
		prenomLbl.setForeground(new Color(143, 188, 143));
		prenomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		prenomLbl.setBounds(63, 190, 154, 20);
		contentPnl.add(prenomLbl);
		
		JLabel dateNaissanceLbl = new JLabel("Date de Naissance :");
		dateNaissanceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateNaissanceLbl.setForeground(new Color(143, 188, 143));
		dateNaissanceLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateNaissanceLbl.setBounds(63, 221, 154, 20);
		contentPnl.add(dateNaissanceLbl);
		
		JLabel cinLbl = new JLabel("CIN :");
		cinLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cinLbl.setForeground(new Color(143, 188, 143));
		cinLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		cinLbl.setBounds(63, 252, 154, 20);
		contentPnl.add(cinLbl);
		
		JLabel adresseLbl = new JLabel("Adresse :");
		adresseLbl.setHorizontalAlignment(SwingConstants.CENTER);
		adresseLbl.setForeground(new Color(143, 188, 143));
		adresseLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		adresseLbl.setBounds(63, 283, 154, 20);
		contentPnl.add(adresseLbl);
		
		JLabel nnumeroTeleLbl = new JLabel("Numero de Telephone :");
		nnumeroTeleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nnumeroTeleLbl.setForeground(new Color(143, 188, 143));
		nnumeroTeleLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		nnumeroTeleLbl.setBounds(63, 314, 154, 20);
		contentPnl.add(nnumeroTeleLbl);
		
		JLabel posteLbl = new JLabel("Poste :");
		posteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		posteLbl.setForeground(new Color(143, 188, 143));
		posteLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		posteLbl.setBounds(63, 345, 154, 20);
		contentPnl.add(posteLbl);
		
		JLabel dateEmbLbl = new JLabel("Date D'Emboche :");
		dateEmbLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateEmbLbl.setForeground(new Color(143, 188, 143));
		dateEmbLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateEmbLbl.setBounds(63, 376, 154, 20);
		contentPnl.add(dateEmbLbl);
		
		textField = new JTextField();
		textField.setBounds(361, 161, 161, 20);
		contentPnl.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(361, 192, 161, 20);
		contentPnl.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(361, 254, 161, 20);
		contentPnl.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(361, 347, 161, 20);
		contentPnl.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(361, 316, 161, 20);
		contentPnl.add(textField_4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(361, 221, 161, 20);
		contentPnl.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(361, 376, 161, 20);
		contentPnl.add(dateChooser_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(361, 285, 161, 20);
		contentPnl.add(textField_5);
	}
}
