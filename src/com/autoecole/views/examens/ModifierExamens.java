package com.autoecole.views.examens;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.autoecole.beans.Examens;
import com.autoecole.controller.CandidatController;
import com.autoecole.controller.ExamenController;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JRadioButton;

public class ModifierExamens extends JFrame implements MouseListener{

	/*COMPONENTS*/
	private JPanel contentPane;
	private JPanel contentPnl;
	private JPanel separateur1Pnl;
	private JPanel separateur2Pnl;
	private JLabel gestionExamensLbl ;
	private JLabel modifierExamenLbl;
	private JLabel candidatLbl;
	private JLabel modifierImageLbl;
	private JLabel annulerImagreLbl;
	private JLabel retourImageLbl;
	private JLabel typePermisLbl;
	private JDateChooser dateExamenChooser;
	private JRadioButton examenTheoriqueRadio;
	private JRadioButton examenPratiqueRadio;
	private JTextField candidatTxt;
	private JTextField typePermisTxt;
	
	/*VARIABLES*/
	private Image iconAjouter;
	private Image iconAnnuler;
	private Examens examenParams;
	private CandidatController candidatCtrl;
	private ExamenController examenCtrl;
	private ArrayList<Examens> listExamens;
	private GestionExamens gestionExamen;
	
	/**
	 * Create the frame.
	 */
	public ModifierExamens(final Examens examenArg,final  GestionExamens gestionExam) {
		setTitle("Modifier Examen");
		
		setLocationRelativeTo(null);
		setBounds(100, 100, 451, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Local To Global*/
		gestionExamen = gestionExam;
		examenParams = examenArg;
		
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
		
		gestionExamensLbl = new JLabel("Gestion Examens");
		gestionExamensLbl.setForeground(new Color(143, 188, 143));
		gestionExamensLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionExamensLbl.setBounds(169, 11, 161, 48);
		contentPnl.add(gestionExamensLbl);
		
		modifierExamenLbl = new JLabel("Modifier Examen");
		modifierExamenLbl.setForeground(new Color(143, 188, 143));
		modifierExamenLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		modifierExamenLbl.setBounds(169, 78, 154, 28);
		contentPnl.add(modifierExamenLbl);
		
		candidatLbl = new JLabel("Candidat :");
		candidatLbl.setHorizontalAlignment(SwingConstants.CENTER);
		candidatLbl.setForeground(new Color(143, 188, 143));
		candidatLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		candidatLbl.setBounds(28, 163, 74, 20);
		contentPnl.add(candidatLbl);
		
		typePermisLbl = new JLabel("Type Permis :");
		typePermisLbl.setHorizontalAlignment(SwingConstants.CENTER);
		typePermisLbl.setForeground(new Color(143, 188, 143));
		typePermisLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		typePermisLbl.setBounds(28, 206, 90, 20);
		contentPnl.add(typePermisLbl);
		
		dateExamenChooser = new JDateChooser();
		dateExamenChooser.setBounds(169, 269, 227, 20);
		contentPnl.add(dateExamenChooser);
		
		iconAjouter = new ImageIcon(this.getClass().getResource("/accept.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		modifierImageLbl = new JLabel();
		modifierImageLbl.setIcon(new ImageIcon(iconAjouter));
		modifierImageLbl.setBounds(280, 322, 46, 42);
		contentPnl.add(modifierImageLbl);
		
		iconAnnuler = new ImageIcon(this.getClass().getResource("/annuler.png")).getImage();
		annulerImagreLbl = new JLabel();
		annulerImagreLbl.setIcon(new ImageIcon(iconAnnuler));
		annulerImagreLbl.setBounds(350, 322, 46, 42);
		contentPnl.add(annulerImagreLbl);
		
		retourImageLbl = new JLabel("");
		retourImageLbl.setBounds(494, 438, 46, 14);
		contentPnl.add(retourImageLbl);		
		
		ButtonGroup butttonGroup = new ButtonGroup();

		examenTheoriqueRadio = new JRadioButton("Date examen th\u00E9orique");
		examenTheoriqueRadio.setBounds(17, 258, 154, 23);
		examenTheoriqueRadio.setBackground(new Color(52, 73, 94));
		examenTheoriqueRadio.setForeground(new Color(143, 188, 143));
		examenTheoriqueRadio.setFont(new Font("Oswald", Font.PLAIN, 13));
		contentPnl.add(examenTheoriqueRadio);
		
		examenPratiqueRadio = new JRadioButton("Date examen pratique");
		examenPratiqueRadio.setBounds(17, 279, 146, 23);
		examenPratiqueRadio.setBackground(new Color(52, 73, 94));
		examenPratiqueRadio.setForeground(new Color(143, 188, 143));
		examenPratiqueRadio.setFont(new Font("Oswald", Font.PLAIN, 13));
		contentPnl.add(examenPratiqueRadio);
		
		butttonGroup.add(examenTheoriqueRadio);
		butttonGroup.add(examenPratiqueRadio);
				
		candidatCtrl = new CandidatController();
		String nomCandidat = candidatCtrl.findById(examenParams.getIdCandidat()).getNom();
		String prenomCandidat = candidatCtrl.findById(examenParams.getIdCandidat()).getPrenom();
		
		candidatTxt = new JTextField(nomCandidat+" "+prenomCandidat);
		candidatTxt.setEditable(false);
		candidatTxt.setBounds(169, 165, 227, 20);
		candidatTxt.setColumns(10);
		contentPnl.add(candidatTxt);
		
		typePermisTxt = new JTextField(examenParams.getTypePermis());
		typePermisTxt.setEditable(false);
		typePermisTxt.setBounds(169, 208, 120, 20);
		typePermisTxt.setColumns(10);
		contentPnl.add(typePermisTxt);

		/*Action Listeners*/
		modifierImageLbl.addMouseListener(this);
		annulerImagreLbl.addMouseListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Modifier Clicked
		if(e.getComponent() == modifierImageLbl) {
			if(dateExamenChooser.getDate() == null || (!examenTheoriqueRadio.isSelected() && !examenPratiqueRadio.isSelected()))
				JOptionPane.showMessageDialog(null,"Vous devez specifier le type d'examen puis choisir une date!");  
			else{
				Date dateExamen = new Date(dateExamenChooser.getDate().getTime());
				
				examenCtrl = new ExamenController();
				
				int choix = 0;
				int check = 0;
				
				if(examenTheoriqueRadio.isSelected()) {
					choix = 1;
					examenParams.setDateExamen(dateExamen);
					examenParams.setDateExamenTheorique(dateExamen);
					examenParams.setDateExamenPratique(dateExamen);
				}
				else if(examenPratiqueRadio.isSelected()) {
					choix = 2;
					examenParams.setDateExamenPratique(dateExamen);
				}
					
				check = examenCtrl.edit(examenParams,choix);
				
				if(check==1) {
					examenCtrl = new ExamenController();
					listExamens = examenCtrl.getAll();
					gestionExamen.refresh(listExamens);
					dispose();						
				}
				else
					JOptionPane.showMessageDialog(null,"Une erreur s'est produite!");
			}
		}
		//Annuler Clicked
		else if(e.getComponent() == annulerImagreLbl)
			dispose();
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
