package com.autoecole.views.users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.autoecole.service.Database;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPasswordField pwd = new JPasswordField(10);
	    int action = JOptionPane.showConfirmDialog(null, pwd,"Enter Password",JOptionPane.OK_CANCEL_OPTION);
	    if(action < 0)JOptionPane.showMessageDialog(null,"Cancel, X or escape key selected");
	    else JOptionPane.showMessageDialog(null,"Your password is "+new String(pwd.getPassword()));
	    System.exit(0);
		
	}

}
