package com.autoecole.controller;



import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;
import java.awt.BorderLayout;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test {

 public static void main(String[] a) {
   JFrame frame = new JFrame();
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(300, 200);
   
   JDateChooser dateChooser = new JDateChooser();
   frame.getContentPane().add(dateChooser, BorderLayout.NORTH);
   
   JButton btnNewButton = new JButton("New button");
   btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
   		/*
		int year = dateChooser.getDate().getYear();
   		int month = dateChooser.getDate().getMonth();
   		int day = dateChooser.getDate().getDay();
   		*/
		
   		Date d = new Date(dateChooser.getDate().getTime());
		
		
   		System.out.println(d);
   	}
   });
   frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
   frame.setVisible(true);
   
   
   
   
   
 }

}

  