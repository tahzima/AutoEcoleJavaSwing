package com.autoecole.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 800, 480);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(0, 0, 150, 480);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 235));
		panel_2.setBounds(0, 0, 150, 70);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(70, 130, 180));
		panel_3.setBounds(0, 80, 150, 88);
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(70, 130, 180));
		panel_4.setBounds(0, 179, 150, 31);
		panel_1.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(70, 130, 180));
		panel_5.setBounds(0, 221, 150, 31);
		panel_1.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(70, 130, 180));
		panel_6.setBounds(0, 263, 150, 31);
		panel_1.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(70, 130, 180));
		panel_7.setBounds(0, 305, 150, 31);
		panel_1.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(70, 130, 180));
		panel_8.setBounds(0, 438, 150, 31);
		panel_1.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(47, 79, 79));
		panel_9.setBounds(149, 0, 651, 70);
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(47, 79, 79));
		panel_10.setBounds(149, 80, 651, 88);
		panel.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(47, 79, 79));
		panel_11.setBounds(149, 179, 651, 300);
		panel.add(panel_11);
	}

}
