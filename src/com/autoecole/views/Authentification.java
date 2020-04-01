package com.autoecole.views;


import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Shape;

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
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Authentification extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton connecterBtn;
	private JButton exitBtn;
	
	
	
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
		
		setTitle("AutoEcole Maestro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#34495e"));
		panel.setBounds(400, 0, 400, 480);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Orbitron", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(61, 82, 157, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Orbitron", Font.PLAIN, 18));
		lblPassword.setBounds(61, 217, 157, 28);
		panel.add(lblPassword);
		
		textField = new RoundJTextField("ilyass");
		textField.setBounds(61, 125, 275, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new RoundJPasswordField("123");
		passwordField.setBounds(61, 256, 275, 28);
		panel.add(passwordField);
		
		connecterBtn = new RoundJButton("Se connecter");		
		connecterBtn.addMouseListener(this);
		connecterBtn.setBackground(Color.decode("#22a6b3"));
		connecterBtn.setFont(new Font("Orbitron", Font.PLAIN, 18));
		connecterBtn.setBounds(61, 337, 180, 28);
		panel.add(connecterBtn);
		
		exitBtn = new RoundJButton("Quitter");
		exitBtn.addMouseListener(this);
		exitBtn.setBackground(Color.decode("#22a6b3"));
		exitBtn.setFont(new Font("Orbitron", Font.PLAIN, 18));
		exitBtn.setBounds(61, 393, 180, 28);
		panel.add(exitBtn);
		
		JLabel lblNewLabel = new JLabel("");
		Image image =  new ImageIcon(this.getClass().getResource("/image.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(0, 0, 400, 480);
		contentPane.add(lblNewLabel);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent()==connecterBtn) {
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
		if(e.getComponent()==exitBtn) {
			dispose();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


class RoundJTextField extends JTextField {
    private Shape shape;
    public RoundJTextField(String lg) {
        super(lg);
        setOpaque(false); // As suggested by @AVD in comment.

    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
   }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
    }
    
}


class RoundJPasswordField extends JPasswordField {
    private Shape shape;
    public RoundJPasswordField(String psw) {
        super(psw);
        setOpaque(false); // As suggested by @AVD in comment.

    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
   }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
    }
    
}


class RoundJButton extends JButton {
    private Shape shape;
    public RoundJButton(String label) {
        super(label);
        setOpaque(false); // As suggested by @AVD in comment.

    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
   }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
    }
    
}
