package com.autoecole.views.users;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.autoecole.beans.Users;
import com.autoecole.controller.UsersController;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ModifierUsers extends JFrame implements MouseListener,DocumentListener{

	/*COMPONENTS*/
	private JPanel contentPane;
	private JPanel contentPnl;
	private JPanel separateur1Pnl;
	private JPanel separateur2Pnl;
	private JLabel gestionUsersLbl ;
	private JLabel modifierUserLbl;
	private JLabel loginLbl;
	private JLabel modifierImageLbl;
	private JLabel annulerImagreLbl;
	private JLabel retourImageLbl;
	private JLabel newPasswordLbl;
	private JLabel confirmerNewPasswordpLbl;
	private JLabel passwordVisibleLbl;
	private JTextField loginTxt;
	private JPasswordField newPasswordTxt;
	private JPasswordField confirmNewPasswordTxt;
	/*VARIABLES*/
	private Image iconAjouter;
	private Image iconAnnuler;
	private Image iconPassword;
	private Users userParam;
	private UsersController usersCtrl;
	private Object gestionUsers;
	private boolean passwordVisible = false;
	
	/**
	 * Create the frame.
	 */
	public ModifierUsers(final Users userArg,final  Object gestionUsersPanel) {
		setTitle("Modifier Examen");
		
		setLocationRelativeTo(null);
		setBounds(100, 100, 451, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Local To Global*/
		gestionUsers = gestionUsersPanel;
		userParam = userArg;
		
		/*Création des composants*/
		contentPnl = new JPanel();
		contentPnl.setLayout(null);
		contentPnl.setBackground(new Color(52, 73, 94));
		contentPnl.setBounds(0, 0, 442, 378);
		contentPane.add(contentPnl);
		
		separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(new Color(126, 214, 223));
		separateur1Pnl.setBounds(0, 57, 432, 10);
		contentPnl.add(separateur1Pnl);
		
		separateur2Pnl = new JPanel();
		separateur2Pnl.setBackground(new Color(126, 214, 223));
		separateur2Pnl.setBounds(0, 117, 432, 10);
		contentPnl.add(separateur2Pnl);
		
		gestionUsersLbl = new JLabel("Gestion Users");
		gestionUsersLbl.setForeground(new Color(143, 188, 143));
		gestionUsersLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionUsersLbl.setBounds(169, 11, 161, 48);
		contentPnl.add(gestionUsersLbl);
		
		modifierUserLbl = new JLabel("Modifier User");
		modifierUserLbl.setForeground(new Color(143, 188, 143));
		modifierUserLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		modifierUserLbl.setBounds(169, 78, 154, 28);
		contentPnl.add(modifierUserLbl);
		
		loginLbl = new JLabel("Login :");
		loginLbl.setHorizontalAlignment(SwingConstants.CENTER);
		loginLbl.setForeground(new Color(143, 188, 143));
		loginLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		loginLbl.setBounds(94, 163, 53, 20);
		contentPnl.add(loginLbl);
		
		newPasswordLbl = new JLabel("Nouveau MDP :");
		newPasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		newPasswordLbl.setForeground(new Color(143, 188, 143));
		newPasswordLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		newPasswordLbl.setBounds(57, 214, 90, 20);
		contentPnl.add(newPasswordLbl);
		
		iconAjouter = new ImageIcon(this.getClass().getResource("/accept.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		modifierImageLbl = new JLabel();
		modifierImageLbl.setIcon(new ImageIcon(iconAjouter));
		modifierImageLbl.setBounds(274, 322, 46, 42);
		contentPnl.add(modifierImageLbl);
		
		iconAnnuler = new ImageIcon(this.getClass().getResource("/annuler.png")).getImage();
		annulerImagreLbl = new JLabel();
		annulerImagreLbl.setIcon(new ImageIcon(iconAnnuler));
		annulerImagreLbl.setBounds(350, 322, 46, 42);
		contentPnl.add(annulerImagreLbl);
		
		retourImageLbl = new JLabel("");
		retourImageLbl.setBounds(494, 438, 46, 14);
		contentPnl.add(retourImageLbl);		
								
		loginTxt = new JTextField(userParam.getLogin());
		loginTxt.setBounds(169, 165, 227, 20);
		loginTxt.setColumns(10);
		contentPnl.add(loginTxt);
		
		newPasswordTxt = new JPasswordField(userParam.getPassword());
		newPasswordTxt.setBounds(169, 216, 227, 20);
		newPasswordTxt.setColumns(10);
		contentPnl.add(newPasswordTxt);
		
		confirmerNewPasswordpLbl = new JLabel("Confirmer Nouveau MDP :");
		confirmerNewPasswordpLbl.setHorizontalAlignment(SwingConstants.CENTER);
		confirmerNewPasswordpLbl.setForeground(new Color(143, 188, 143));
		confirmerNewPasswordpLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		confirmerNewPasswordpLbl.setBounds(11, 266, 136, 20);
		contentPnl.add(confirmerNewPasswordpLbl);
		
		confirmNewPasswordTxt = new JPasswordField(userParam.getPassword());
		confirmNewPasswordTxt.setBounds(169, 268, 227, 20);
		confirmNewPasswordTxt.setColumns(10);
		confirmNewPasswordTxt.setEditable(false);
		contentPnl.add(confirmNewPasswordTxt);
		
		iconPassword = new ImageIcon(this.getClass().getResource("/show.png")).getImage().getScaledInstance(20, 10, Image.SCALE_SMOOTH);
		passwordVisibleLbl = new JLabel();
		passwordVisibleLbl.setIcon(new ImageIcon(iconPassword));
		passwordVisibleLbl.setBounds(406, 214, 20, 20);
		contentPnl.add(passwordVisibleLbl);
		
		
		/*Action Listeners*/
		modifierImageLbl.addMouseListener(this);
		annulerImagreLbl.addMouseListener(this);
		passwordVisibleLbl.addMouseListener(this);
		newPasswordTxt.getDocument().addDocumentListener(this);
		                                                                                                                                                                                                                                                                                
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Modifier Clicked
		if(e.getComponent() == modifierImageLbl) {
			String login = loginTxt.getText();
			String newPassword = String.valueOf(newPasswordTxt.getPassword());
			String confirmNewPassword = String.valueOf(confirmNewPasswordTxt.getPassword());
			
			if(login.isEmpty() && newPassword.isEmpty() && confirmNewPassword.isEmpty())
				JOptionPane.showMessageDialog(null,"Vous devez saisir au moins un champ");  
			else{
				JPasswordField oldPasswordField = new JPasswordField();
				int action = 0;
				
				if(gestionUsers instanceof GestionUsersStandard)
					action = JOptionPane.showConfirmDialog(null, oldPasswordField, "Veuillez entrer votre ancien mot de passe :", JOptionPane.OK_CANCEL_OPTION);
				else if(gestionUsers instanceof GestionUsersAdmin)
					oldPasswordField.setText(userParam.getPassword());
				
				if(action == JOptionPane.OK_OPTION) {
					String oldPassword = String.valueOf(oldPasswordField.getPassword());

					if(!userParam.getPassword().equals(oldPassword))
						JOptionPane.showMessageDialog(null, "Mot de passe incorrect!");
					else {
						
						if(!login.isEmpty()) {
							if(!userParam.getLogin().equals(login))
								userParam.setLogin(login);
						}
						
						if(!newPassword.isEmpty()) {
							if(!newPassword.equals(confirmNewPassword))
								JOptionPane.showMessageDialog(null, "Les deux mots de passe ne sont pas identiques!");
							else {
								userParam.setPassword(newPassword);
							}
						}
						
						usersCtrl = new UsersController();
						int check = usersCtrl.edit(userParam);
						
						if(check!=1)
							JOptionPane.showMessageDialog(null, "Une erreur s'est produite!");
						else {
							
							if(gestionUsers instanceof GestionUsersAdmin) {
								((GestionUsersAdmin) gestionUsers).setListUsers(usersCtrl.getAll());
								((GestionUsersAdmin)gestionUsers).refresh(((GestionUsersAdmin) gestionUsers).getListUsers());
							}
							else if(gestionUsers instanceof GestionUsersStandard)
								((GestionUsersStandard)gestionUsers).setLogin(userParam.getLogin());
							
							dispose();
						}
					}
				}				
			}
		}
		//Visibilite du mot de passe
		else if(e.getComponent() == passwordVisibleLbl) {
			if(passwordVisible) {
				iconPassword = new ImageIcon(this.getClass().getResource("/show.png")).getImage().getScaledInstance(20, 10, Image.SCALE_SMOOTH);
				passwordVisibleLbl.setIcon(new ImageIcon(iconPassword));
				passwordVisible = false;
				newPasswordTxt.setEchoChar('•');
				confirmNewPasswordTxt.setEchoChar('•');
			}
			else {
				iconPassword = new ImageIcon(this.getClass().getResource("/hide.png")).getImage().getScaledInstance(20, 10, Image.SCALE_SMOOTH);
				passwordVisibleLbl.setIcon(new ImageIcon(iconPassword));
				passwordVisible = true;
				newPasswordTxt.setEchoChar((char)0);
				confirmNewPasswordTxt.setEchoChar((char)0);
			}
		}
		//Annuler Clicked
		else if(e.getComponent() == annulerImagreLbl)
			dispose();
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		if(e.getDocument() == newPasswordTxt.getDocument())
			confirmNewPasswordTxt.setEditable(true);
	}
	
	@Override
	public void removeUpdate(DocumentEvent e) {
		if(e.getDocument() == newPasswordTxt.getDocument()) {
			if(String.valueOf(newPasswordTxt.getPassword()).isEmpty())
				confirmNewPasswordTxt.setEditable(false);
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
	@Override
	public void changedUpdate(DocumentEvent e) {}
	

	
}
