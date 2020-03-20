package com.autoecole.views;


import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.autoecole.beans.Users;
import com.autoecole.controller.AuthentificationController;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Authentification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		panel.setBounds(400, 0, 400, 480);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Oswald", Font.BOLD, 18));
		lblNewLabel_1.setBounds(61, 144, 157, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Oswald", Font.BOLD, 18));
		lblPassword.setBounds(61, 249, 157, 28);
		panel.add(lblPassword);
		
		textField = new JTextField("ilyass");
		textField.setBounds(61, 187, 275, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField("123");
		passwordField.setBounds(61, 288, 275, 28);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Connect");
		
		
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Oswald", Font.BOLD, 18));
		btnNewButton.setBounds(61, 352, 275, 23);
		panel.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBackground(new Color(30, 144, 255));
		btnExit.setFont(new Font("Oswald", Font.BOLD, 18));
		btnExit.setBounds(61, 393, 275, 23);
		panel.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
		Image image =  new ImageIcon(this.getClass().getResource("/image.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(0, 0, 400, 480);
		contentPane.add(lblNewLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textField.getText();
				String password = passwordField.getText();
				AuthentificationController authentificationController = new AuthentificationController();
				if((login!=null && password!=null) && (!login.isEmpty()) && (!password.isEmpty())) {
					Users user;
					user=authentificationController.authentification(login, password);
					if(user.getId()>0) {
						List<Users> listUsers = new ArrayList<Users>();
						listUsers.add(user);
						Menu menu= new Menu(user);
						menu.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Erreur d'authentification");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Remplire les deux champs");
				}

			}
		});
	}
}
