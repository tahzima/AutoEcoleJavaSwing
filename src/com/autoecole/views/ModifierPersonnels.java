package com.autoecole.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ModifierPersonnels extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public ModifierPersonnels() {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(126, 214, 223));
		panel_1.setBounds(0, 57, 648, 10);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(126, 214, 223));
		panel_2.setBounds(0, 117, 648, 10);
		panel.add(panel_2);
		
		JLabel label = new JLabel("Gestion Personnels");
		label.setForeground(new Color(143, 188, 143));
		label.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(255, 11, 161, 48);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Modifier Personnel");
		label_1.setForeground(new Color(143, 188, 143));
		label_1.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		label_1.setBounds(255, 78, 161, 28);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Nom :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(143, 188, 143));
		label_2.setFont(new Font("Oswald", Font.PLAIN, 13));
		label_2.setBounds(63, 159, 154, 20);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Prenom :");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(143, 188, 143));
		label_3.setFont(new Font("Oswald", Font.PLAIN, 13));
		label_3.setBounds(63, 190, 154, 20);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Date de Naissance :");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(143, 188, 143));
		label_4.setFont(new Font("Oswald", Font.PLAIN, 13));
		label_4.setBounds(63, 221, 154, 20);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("CIN :");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(143, 188, 143));
		label_5.setFont(new Font("Oswald", Font.PLAIN, 13));
		label_5.setBounds(63, 252, 154, 20);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Adresse :");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(new Color(143, 188, 143));
		label_6.setFont(new Font("Oswald", Font.PLAIN, 13));
		label_6.setBounds(63, 283, 154, 20);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Numero de Telephone :");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(143, 188, 143));
		label_7.setFont(new Font("Oswald", Font.PLAIN, 13));
		label_7.setBounds(63, 314, 154, 20);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Poste :");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(new Color(143, 188, 143));
		label_8.setFont(new Font("Oswald", Font.PLAIN, 13));
		label_8.setBounds(63, 345, 154, 20);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Date D'Emboche :");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(new Color(143, 188, 143));
		label_9.setFont(new Font("Oswald", Font.PLAIN, 13));
		label_9.setBounds(63, 376, 154, 20);
		panel.add(label_9);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(361, 161, 161, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(361, 192, 161, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(361, 254, 161, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(361, 347, 161, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(361, 316, 161, 20);
		panel.add(textField_4);
	}
}
