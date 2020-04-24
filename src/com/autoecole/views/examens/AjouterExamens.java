package com.autoecole.views.examens;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import com.autoecole.beans.Candidats;
import com.autoecole.beans.Examens;
import com.autoecole.beans.SearchCandidat;
import com.autoecole.controller.CandidatController;
import com.autoecole.controller.ExamenController;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class AjouterExamens extends JFrame implements MouseListener{

	/*COMPONENTS*/
	private JPanel contentPane;
	private JPanel contentPnl;
	private JPanel separateur1Pnl;
	private JPanel separateur2Pnl;
	private JLabel gestionExamenLbl ;
	private JLabel ajouterExamenLbl;
	private JLabel ajouterImageLbl;
	private JLabel annulerImagreLbl;
	private JLabel retourImageLbl;
	private JLabel nomLbl;
	private JLabel prenomLbl;
	private JLabel cinLbl;
	private JLabel rechercheLbl;
	private JTable examensTable;
	private JScrollPane scrollPane; 
	private JComboBox typePermisComboBox;
	private JDateChooser dateExamenChooser;
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JTextField cinTxt;
	private JLabel dateLbl;
	private JLabel typePermisLbl;
	
	/*VARIABLES*/
	private Image iconRecherche;
	private Image iconAjouter;
	private Image iconAnnuler;
	private CandidatController candidatCtrl;
	private ArrayList<Candidats> listCandidats;
	private GestionExamens gestionExamen;
	private DefaultTableModel candidatsTableModel;
	private String[] columns = {"Nom","Prénom","CIN","Date de naissance","Téléphone","Adresse"};
	private Object[][] rows;
	private ExamenController examensCtrl;
	
	/*LOAD JTABLE*/
	public void refresh(List<Candidats> list) {
		
		int k = list.size();
		rows = new Object[k][7];
		
		for(int i=0;i<k;i++) {
			
			rows[i][0] = list.get(i).getNom();	
			rows[i][1] = list.get(i).getPrenom();
			rows[i][2] = list.get(i).getCin();
			rows[i][3] = list.get(i).getDateNaissance();
			rows[i][4] = list.get(i).getNumTel();
			rows[i][5] = list.get(i).getAdresse();
			rows[i][6] = list.get(i).getId();

		}
		DefaultTableModel model  = new DefaultTableModel(rows,columns);
		examensTable.setModel(model);	
	}
	
	/**
	 * Create the frame.
	 */
	public AjouterExamens(final GestionExamens gestionExam) {
		
		setLocationRelativeTo(null);
		setBounds(100, 100, 664, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPnl = new JPanel();
		contentPnl.setLayout(null);
		contentPnl.setBackground(new Color(52, 73, 94));
		contentPnl.setBounds(0, 0, 648, 497);
		contentPane.add(contentPnl);
		
		
		/*JTABLE*/
		//REMPLISSAGE DU TABLE MODEL
		candidatCtrl = new CandidatController();
		listCandidats = candidatCtrl.getAll();
		int k = listCandidats.size();
		rows = new Object[k][7];

		for(int i=0;i<k;i++) {
						
			rows[i][0] = listCandidats.get(i).getNom();	
			rows[i][1] = listCandidats.get(i).getPrenom();
			rows[i][2] = listCandidats.get(i).getCin();
			rows[i][3] = listCandidats.get(i).getDateNaissance();
			rows[i][4] = listCandidats.get(i).getNumTel();
			rows[i][5] = listCandidats.get(i).getAdresse();
			rows[i][6] = listCandidats.get(i).getId();

		}
		candidatsTableModel = new DefaultTableModel(rows,columns);
		
		//Création du JTable
		examensTable = new JTable(candidatsTableModel);
		scrollPane = new JScrollPane(examensTable);
		scrollPane.setBounds(10, 268, 628, 147);
		contentPnl.add(scrollPane);
		
		/*Création des composants*/
		
		separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(new Color(126, 214, 223));
		separateur1Pnl.setBounds(0, 57, 648, 10);
		contentPnl.add(separateur1Pnl);
		
		separateur2Pnl = new JPanel();
		separateur2Pnl.setBackground(new Color(126, 214, 223));
		separateur2Pnl.setBounds(0, 117, 648, 10);
		contentPnl.add(separateur2Pnl);
		
		gestionExamenLbl = new JLabel("Gestion Examen");
		gestionExamenLbl.setForeground(new Color(143, 188, 143));
		gestionExamenLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionExamenLbl.setBounds(255, 11, 161, 48);
		contentPnl.add(gestionExamenLbl);
		
		ajouterExamenLbl = new JLabel("Ajouter Examen");
		ajouterExamenLbl.setForeground(new Color(143, 188, 143));
		ajouterExamenLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		ajouterExamenLbl.setBounds(255, 78, 154, 28);
		contentPnl.add(ajouterExamenLbl);
		
		iconAjouter = new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ajouterImageLbl = new JLabel();
		ajouterImageLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterImageLbl.setBounds(504, 438, 46, 42);
		contentPnl.add(ajouterImageLbl);
		
		iconAnnuler = new ImageIcon(this.getClass().getResource("/annuler.png")).getImage();
		annulerImagreLbl = new JLabel();
		annulerImagreLbl.setIcon(new ImageIcon(iconAnnuler));
		annulerImagreLbl.setBounds(578, 438, 46, 42);
		contentPnl.add(annulerImagreLbl);
		
		retourImageLbl = new JLabel("");
		retourImageLbl.setBounds(494, 438, 46, 14);
		contentPnl.add(retourImageLbl);
		
		
		nomLbl = new JLabel("Nom :");
		nomLbl.setForeground(new Color(143, 188, 143));
		nomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		nomLbl.setBounds(10, 218, 36, 20);
		contentPnl.add(nomLbl);
		
		nomTxt = new JTextField();
		nomTxt.setColumns(10);
		nomTxt.setBounds(49, 220, 86, 20);
		contentPnl.add(nomTxt);
		
		prenomLbl = new JLabel("Prenom :");
		prenomLbl.setForeground(new Color(143, 188, 143));
		prenomLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		prenomLbl.setBounds(185, 218, 50, 20);
		contentPnl.add(prenomLbl);
		
		prenomTxt = new JTextField();
		prenomTxt.setColumns(10);
		prenomTxt.setBounds(245, 220, 86, 20);
		contentPnl.add(prenomTxt);
		
		cinLbl = new JLabel("CIN :");
		cinLbl.setForeground(new Color(143, 188, 143));
		cinLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		cinLbl.setBounds(381, 216, 35, 20);
		contentPnl.add(cinLbl);
		
		cinTxt = new JTextField();
		cinTxt.setColumns(10);
		cinTxt.setBounds(426, 220, 86, 20);
		contentPnl.add(cinTxt);
		
		iconRecherche = new ImageIcon(this.getClass().getResource("/searche.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		rechercheLbl = new JLabel();
		rechercheLbl.setIcon(new ImageIcon(iconRecherche));
		rechercheLbl.setBounds(578, 210, 36, 40);
		contentPnl.add(rechercheLbl);
		
		dateLbl = new JLabel("Date d'examen :");
		dateLbl.setForeground(new Color(143, 188, 143));
		dateLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateLbl.setBounds(10, 155, 88, 20);
		contentPnl.add(dateLbl);
		
		typePermisLbl = new JLabel("Type Permis :");
		typePermisLbl.setForeground(new Color(143, 188, 143));
		typePermisLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		typePermisLbl.setBounds(337, 155, 79, 20);
		contentPnl.add(typePermisLbl);
		
		String[] permis = {"A1","A","B","C","D","E(B)","E(C)","E(D)"};
		typePermisComboBox = new JComboBox(permis);
		typePermisComboBox.setBounds(426, 158, 188, 18);
		typePermisComboBox.setSelectedIndex(-1);
		contentPnl.add(typePermisComboBox);
		
		dateExamenChooser = new JDateChooser();
		dateExamenChooser.setBounds(108, 155, 217, 20);
		contentPnl.add(dateExamenChooser);

		
		/*ACTION LISTENERS*/
		ajouterImageLbl.addMouseListener(this);
		annulerImagreLbl.addMouseListener(this);		
		
		/*Local To Global*/
		gestionExamen = gestionExam;
	}


	//BUTTONS
	@Override
	public void mouseClicked(MouseEvent e) {
		//Ajouter Clicked
		if(e.getComponent() == ajouterImageLbl) {
			
			int selectedPermisIndex = typePermisComboBox.getSelectedIndex();
			int selectedCandidatIndex = examensTable.getSelectedRow();
			
			if(!(dateExamenChooser.getDate()==null) && selectedPermisIndex!=-1 && selectedCandidatIndex!=-1) {
				Date dateExamen = new Date(dateExamenChooser.getDate().getTime()); 
				int idCandidat = (int)rows[selectedCandidatIndex][6];
				String typePermis = typePermisComboBox.getSelectedItem().toString();
				Examens examen = new Examens();
				
				examen.setDateExamen(dateExamen);
				examen.setDateExamenTheorique(dateExamen);
				examen.setDateExamenPratique(dateExamen);
				examen.setIdCandidat(idCandidat);
				examen.setTypePermis(typePermis);
				examen.setDecisionFinale(Examens.Decision.EN_ATTENTE.toString());
				examen.setDecisionTheorique(Examens.Decision.EN_ATTENTE.toString());
				examen.setDecisionPratique(Examens.Decision.EN_ATTENTE.toString());
				
				examensCtrl = new ExamenController();
				int check = examensCtrl.add(examen);
				
				if(check==1) {
					examensCtrl = new ExamenController();
					gestionExamen.setListExamens(examensCtrl.getAll());
					gestionExamen.refresh(gestionExamen.getListExamens());
					dispose();
				}
				else if(check==-1)
					JOptionPane.showMessageDialog(null,"Cette examen existe déjà!");
				else
					JOptionPane.showMessageDialog(null,"Une erreur s'est produite!");
			}
			else
				JOptionPane.showMessageDialog(null, "Vous devez spécifier un candidat, une date d'examen et un type de permis");
		}
		//Recherche Clicked
		else if(e.getComponent() == rechercheLbl) {
			SearchCandidat params = new SearchCandidat();

			params.setNom(nomTxt.getText().toString());
			params.setPrenom(prenomTxt.getText().toString());
			params.setCin(cinTxt.getText().toString());
			
			List<Candidats> listTempCandidats = candidatCtrl.search(params);
			refresh(listTempCandidats);
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
