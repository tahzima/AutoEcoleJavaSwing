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
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLayeredPane;

public class Menu extends JFrame {

	/*COMPONENETS*/
	private JPanel frame;
	private JPanel bigPanel;
	private JPanel menuPanel;
	private JPanel userPnl;
	private JPanel candidatPnl;
	private JPanel personnelPnl;
	private JPanel examenPnl;
	private JPanel voiturePnl;
	private JLayeredPane layeredPane;
	private Image image;
	private JLabel autoecoleLbl;
	private JLabel maestroLbl;
	private JLabel userLbl;
	private JLabel userLogoLbl;
	private JLabel candidatLbl;
	private JLabel personnelLbl;
	private JLabel examenLbl;
	private JLabel voitureLbl;
	private JPanel deconnecterPnl;
	private JLabel deconnecterLbl;
	
	
	public final static int WIDTH_SCREEN = 1000;
	public final static int HEIGHT_SCREEN = 800;
	
	public Menu(Users user) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 821,513);
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		frame.setLayout(null);
	
		
		bigPanel = new JPanel();
		bigPanel.setBackground(Color.decode("#34495e"));
		bigPanel.setBounds(0, 0, WIDTH_SCREEN,HEIGHT_SCREEN);
		frame.add(bigPanel);
		bigPanel.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.decode("#7ed6df"));
		menuPanel.setBounds(0, 0, 150, HEIGHT_SCREEN);
		bigPanel.add(menuPanel);
		menuPanel.setLayout(null);
		
		autoecoleLbl = new JLabel("Auto-Ecole");
		autoecoleLbl.setBounds(0, 0, 150, 35);
		autoecoleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		autoecoleLbl.setBackground(Color.decode("#7ed6df"));
		autoecoleLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		menuPanel.add(autoecoleLbl);
		
		maestroLbl = new JLabel("MAESTRO");
		maestroLbl.setHorizontalAlignment(SwingConstants.CENTER);
		maestroLbl.setBackground(Color.decode("#7ed6df"));
		maestroLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		maestroLbl.setBounds(0, 35, 150, 35);
		menuPanel.add(maestroLbl);
		
		userPnl = new JPanel();
		userPnl.setBackground(Color.decode("#22a6b3"));
		userPnl.setBounds(0, 80, 150, 88);
		menuPanel.add(userPnl);
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
		
		candidatPnl = new JPanel();
		candidatPnl.setBackground(Color.decode("#22a6b3"));
		candidatPnl.setBounds(0, 179, 150, 31);
		menuPanel.add(candidatPnl);
		candidatPnl.setLayout(null);
		
		candidatLbl = new JLabel("Candidat");
		candidatLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionCandidats gestionCandidats = new GestionCandidats();
				switchPanels(gestionCandidats);
			}
		});
		candidatLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		candidatLbl.setHorizontalAlignment(SwingConstants.CENTER);
		candidatLbl.setBounds(0, 0, 150, 31);
		candidatPnl.add(candidatLbl);
		
		personnelPnl = new JPanel();
		personnelPnl.setBackground(Color.decode("#22a6b3"));
		personnelPnl.setBounds(0, 221, 150, 31);
		menuPanel.add(personnelPnl);
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
		menuPanel.add(examenPnl);
		examenPnl.setLayout(null);
		
		examenLbl = new JLabel("Examen");
		examenLbl.setHorizontalAlignment(SwingConstants.CENTER);
		examenLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		examenLbl.setBounds(0, 0, 150, 31);
		examenPnl.add(examenLbl);
		
		voiturePnl = new JPanel();
		voiturePnl.setBackground(Color.decode("#22a6b3"));
		voiturePnl.setBounds(0, 305, 150, 31);
		menuPanel.add(voiturePnl);
		voiturePnl.setLayout(null);
		
		voitureLbl = new JLabel("Voiture");
		voitureLbl.setHorizontalAlignment(SwingConstants.CENTER);
		voitureLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		voitureLbl.setBounds(0, 0, 150, 31);
		voiturePnl.add(voitureLbl);
		
		deconnecterPnl = new JPanel();
		deconnecterPnl.setBackground(Color.decode("#22a6b3"));
		deconnecterPnl.setBounds(0, 438, 150, 31);
		menuPanel.add(deconnecterPnl);
		deconnecterPnl.setLayout(null);
		
		deconnecterLbl = new JLabel("Deconnecter");
		deconnecterLbl.setHorizontalAlignment(SwingConstants.CENTER);
		deconnecterLbl.setFont(new Font("Oswald", Font.BOLD, 18));
		deconnecterLbl.setBounds(0, 0, 150, 31);
		deconnecterPnl.add(deconnecterLbl);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(152, 0, 648, 480);
		bigPanel.add(layeredPane);
		deconnecterLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Authentification authentification = new Authentification();
				authentification.setVisible(true);
				dispose();
			}
		});
	}
	
	public void switchPanels (JPanel panel) {
		if(bigPanel!=null) {
			bigPanel.removeAll();
			bigPanel.add(menuPanel);
			panel.setBounds(160, 0, WIDTH_SCREEN-160, HEIGHT_SCREEN);
			bigPanel.add(panel);
			bigPanel.repaint();
			bigPanel.revalidate();
		}
	}
	
}
