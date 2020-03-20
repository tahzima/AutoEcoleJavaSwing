package com.autoecole.views;

import java.awt.Color;

import javax.swing.JPanel;

public class GestionPersonnels extends JPanel {

	/**
	 * Create the panel.
	 */
	public GestionPersonnels() {
		setLayout(null);
		
		JPanel contentPnl = new JPanel();
		contentPnl.setBackground(Color.decode("#34495e"));
		contentPnl.setBounds(0, 0, 648, 480);
		add(contentPnl);
		contentPnl.setLayout(null);
		
		JPanel separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(Color.decode("#7ed6df"));
		separateur1Pnl.setBounds(0, 70, 648, 10);
		contentPnl.add(separateur1Pnl);
		
		JPanel separateur2Pnl = new JPanel();
		separateur2Pnl.setBackground(Color.decode("#7ed6df"));
		separateur2Pnl.setBounds(0, 168, 648, 10);
		contentPnl.add(separateur2Pnl);

	}

}
