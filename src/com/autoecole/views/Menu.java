package com.autoecole.views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.autoecole.beans.Users;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JPanel contentPnl;
	private JPanel menuPnl;
	private JPanel autoEcoleNomPnl;
	private JLabel autoecoleLbl;
	private JLabel maestroLbl;
	private JPanel userPnl;
	private JLabel userLbl;
	private JLabel userLogoLbl;
	private JPanel clientPnl;
	private JLabel clientLbl;
	private JPanel personnelPnl;
	private JLabel personnelLbl;
	private JPanel examenPnl;
	private JLabel examenLbl;
	private JPanel voiturePnl;
	private JLabel voitureLbl;
	private JPanel deconnecterPnl;
	private JLabel deconnecterLbl;
	private JLayeredPane contentLpn;
	private Image image;
	private JLayeredPane layeredPane;
	/**
	 * Create the frame.
	 */
	
	public void switchPanels (JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public Menu(Users user) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPnl = new JPanel();
		contentPnl.setBackground(Color.decode("#34495e"));
		contentPnl.setBounds(0, 0, 800, 480);
		contentPane.add(contentPnl);
		contentPnl.setLayout(null);
		
		menuPnl = new JPanel();
		menuPnl.setBackground(Color.decode("#7ed6df"));
		menuPnl.setBounds(0, 0, 150, 480);
		contentPnl.add(menuPnl);
		menuPnl.setLayout(null);
		
		autoEcoleNomPnl = new JPanel();
		autoEcoleNomPnl.setBackground(Color.decode("#7ed6df"));
		autoEcoleNomPnl.setBounds(0, 0, 150, 70);
		menuPnl.add(autoEcoleNomPnl);
		autoEcoleNomPnl.setLayout(null);
		
		autoecoleLbl = new JLabel("Auto-Ecole");
		autoecoleLbl.setBounds(0, 0, 150, 35);
		autoecoleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		autoecoleLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		autoEcoleNomPnl.add(autoecoleLbl);
		
		maestroLbl = new JLabel("MAESTRO");
		maestroLbl.setHorizontalAlignment(SwingConstants.CENTER);
		maestroLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		maestroLbl.setBounds(0, 35, 150, 35);
		autoEcoleNomPnl.add(maestroLbl);
		
		userPnl = new JPanel();
		userPnl.setBackground(Color.decode("#22a6b3"));
		userPnl.setBounds(0, 80, 150, 88);
		menuPnl.add(userPnl);
		userPnl.setLayout(null);
		
		userLbl = new JLabel(""+user.getLogin());
		userLbl.setBounds(0, 51, 150, 37);
		userLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		userPnl.add(userLbl);
		
		userLogoLbl = new JLabel("");
		image =  new ImageIcon(this.getClass().getResource("/logoUser.png")).getImage();
		userLogoLbl.setIcon(new ImageIcon(image));
		userLogoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userLogoLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		userLogoLbl.setBounds(0, 0, 150, 59);
		userPnl.add(userLogoLbl);
		
		clientPnl = new JPanel();
		clientPnl.setBackground(Color.decode("#22a6b3"));
		clientPnl.setBounds(0, 179, 150, 31);
		menuPnl.add(clientPnl);
		clientPnl.setLayout(null);
		
		clientLbl = new JLabel("Client");
		clientLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		clientLbl.setHorizontalAlignment(SwingConstants.CENTER);
		clientLbl.setBounds(0, 0, 150, 31);
		clientPnl.add(clientLbl);
		
		personnelPnl = new JPanel();
		personnelPnl.setBackground(Color.decode("#22a6b3"));
		personnelPnl.setBounds(0, 221, 150, 31);
		menuPnl.add(personnelPnl);
		personnelPnl.setLayout(null);
		
		personnelLbl = new JLabel("Personnel");
		personnelLbl.setHorizontalAlignment(SwingConstants.CENTER);
		personnelLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		personnelLbl.setBounds(0, 0, 150, 31);
		personnelPnl.add(personnelLbl);
		personnelLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionPersonnels gestionPersonnels = new GestionPersonnels();
				switchPanels(gestionPersonnels);
			}
		});
		
		examenPnl = new JPanel();
		examenPnl.setBackground(Color.decode("#22a6b3"));
		examenPnl.setBounds(0, 263, 150, 31);
		menuPnl.add(examenPnl);
		examenPnl.setLayout(null);
		
		examenLbl = new JLabel("Examen");
		examenLbl.setHorizontalAlignment(SwingConstants.CENTER);
		examenLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		examenLbl.setBounds(0, 0, 150, 31);
		examenPnl.add(examenLbl);
		
		voiturePnl = new JPanel();
		voiturePnl.setBackground(Color.decode("#22a6b3"));
		voiturePnl.setBounds(0, 305, 150, 31);
		menuPnl.add(voiturePnl);
		voiturePnl.setLayout(null);
		
		voitureLbl = new JLabel("Voiture");
		voitureLbl.setHorizontalAlignment(SwingConstants.CENTER);
		voitureLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		voitureLbl.setBounds(0, 0, 150, 31);
		voiturePnl.add(voitureLbl);
		
		deconnecterPnl = new JPanel();
		deconnecterPnl.setBackground(Color.decode("#22a6b3"));
		deconnecterPnl.setBounds(0, 438, 150, 31);
		menuPnl.add(deconnecterPnl);
		deconnecterPnl.setLayout(null);
		
		deconnecterLbl = new JLabel("Deconnecter");
		deconnecterLbl.setHorizontalAlignment(SwingConstants.CENTER);
		deconnecterLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		deconnecterLbl.setBounds(0, 0, 150, 31);
		deconnecterPnl.add(deconnecterLbl);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(152, 0, 648, 480);
		layeredPane.setLayout(new CardLayout(0, 0));
		contentPnl.add(layeredPane);
		deconnecterLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Authentification authentification = new Authentification();
				authentification.setVisible(true);
				dispose();
			}
		});
	}
}
