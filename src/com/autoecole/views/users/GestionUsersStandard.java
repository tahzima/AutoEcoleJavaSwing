package com.autoecole.views.users;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import com.autoecole.beans.Users;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GestionUsersStandard extends JPanel implements MouseListener {
	private JLabel salutationLbl;
	private JLabel modifierLbl;
	private JLabel ajouterLbl;
	private JLabel gestionUsersLbl;
	private JPanel separateur1Pnl;

	/*VARIABLES*/
	private Image iconAjouter;
	private Image iconModifier;
	private Users globalUser;
	private JLabel loginLbl;
	
	public void setLogin(String login) {
		loginLbl.setText("("+login+")");
	}
	
	
	/**
	 * Create the panel.
	 */
	public GestionUsersStandard(Users localUser) {
		
		setBackground(Color.decode("#34495e"));
		setBounds(0, 0, 661, 488);
		setLayout(null);
		
		
		/*CREATION DES COMPOSANTS*/
		separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(Color.decode("#7ed6df"));
		separateur1Pnl.setBounds(0, 57, 648, 10);
		add(separateur1Pnl);
		
		gestionUsersLbl = new JLabel("Gestion Utilisateurs");
		gestionUsersLbl.setForeground(new Color(143, 188, 143));
		gestionUsersLbl.setFont(new Font("Oswald", Font.PLAIN, 18));
		gestionUsersLbl.setBounds(255, 11, 161, 48);
		add(gestionUsersLbl);
				
		String salutation = "Bienvenu "+localUser.getPrenom()+" "+localUser.getNom();
		
		salutationLbl = new JLabel(salutation,SwingConstants.CENTER);
		salutationLbl.setForeground(Color.decode("#7ed6df"));
		salutationLbl.setFont(new Font("Oswald", Font.PLAIN, 25));
		salutationLbl.setBounds(0, 115, 661, 48);
		add(salutationLbl);
		
		
		iconModifier =  new ImageIcon(this.getClass().getResource("/modifier.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		modifierLbl = new JLabel();
		modifierLbl.setIcon(new ImageIcon(iconModifier));
		modifierLbl.setBounds(411, 278, 73, 63);
		modifierLbl.addMouseListener(this);
		add(modifierLbl);
		
		iconAjouter =  new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ajouterLbl = new JLabel("");
		ajouterLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterLbl.setBounds(233, 278, 73, 63);
		ajouterLbl.addMouseListener(this);
		add(ajouterLbl);
		
		loginLbl = new JLabel("",SwingConstants.CENTER);
		setLogin(localUser.getLogin());
		loginLbl.setForeground(Color.decode("#7ed6df"));
		loginLbl.setFont(new Font("Oswald", Font.PLAIN, 24));
		loginLbl.setBounds(0, 174, 661, 48);
		add(loginLbl);
		
		/*Local to Global*/
		globalUser = localUser;
		
	}

	/*Buttons Clicked*/
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent() == ajouterLbl) {
			AjouterUsers ajouterUsers = new AjouterUsers(GestionUsersStandard.this);
			ajouterUsers.setVisible(true);
		}
		else if(e.getComponent() == modifierLbl) {
			ModifierUsers modifierUsers = new ModifierUsers(globalUser,GestionUsersStandard.this);
			modifierUsers.setVisible(true);
		}
	}

	/*NOT USED*/
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}


