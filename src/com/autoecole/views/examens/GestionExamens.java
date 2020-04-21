package com.autoecole.views.examens;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import com.autoecole.beans.Candidats;
import com.autoecole.beans.Examens;
import com.autoecole.controller.CandidatController;
import com.autoecole.controller.ExamenController;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import com.toedter.calendar.JDateChooser;

public class GestionExamens extends JPanel implements MouseListener {
	private JLabel rechercheLbl;
	private JLabel listExamensLbl;
	private JLabel ajouterLbl;
	private JLabel modifierLbl;
	private JLabel actualiserLbl;
	private JLabel supprimerLbl;
	private JLabel gestionExamensLbl;
	private JLabel dateLbl;
	private JLabel rehercheLbl;
	private JLabel resultatsLbl;
	private JPanel separateur1Pnl;
	private JPanel separateur2Pnl;
	private JTable examensTable;
	private JScrollPane scroll;
	private JDateChooser examenDateChooser;
	
	/* VARIABLES */
	private Image iconRecherche;
	private Image iconAjouter;
	private Image iconModifier;
	private Image iconSupprimer;
	private Image iconActualiser;
	private DefaultTableModel examensTableModel;
	private String[] columns = { "Date Examen", "Echecs total", "Candidat", "Permis","Decision Finale","Date theorique", "Note theorique", "Decision theorique", "Echec theorique", "Date pratique", "Decision Pratique", "Echecs pratique" };
	private Object[][] rows;
	private ArrayList<Examens> listExamens;
	private ExamenController examenCtrl;
	private CandidatController candidatCtrl;
	private int rowIndex;
	private int idExamen;
	private int check;
	private Candidats candidat;
	private Examens examen;

	public ArrayList<Examens> getListExamens() {return listExamens;}
	public void setListExamens(ArrayList<Examens> listExamens) {this.listExamens = listExamens;}

	/*AJUSTER LA TAILLE DES COLONNES*/
	private void resizeTableColumns() {
		examensTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    for(int column=0;column<examensTable.getColumnCount();column++){
	      DefaultTableColumnModel colModel = (DefaultTableColumnModel) examensTable.getColumnModel();
	      TableColumn col = colModel.getColumn(column);
	      int preferredWidth = 0;

	      TableCellRenderer renderer = col.getHeaderRenderer();
	      if (renderer == null)
	        renderer = examensTable.getTableHeader().getDefaultRenderer();
	      
	      Component comp = renderer.getTableCellRendererComponent(examensTable, col.getHeaderValue(), false, false, 0, 0);
	      preferredWidth = comp.getPreferredSize().width;
	      
	      for (int row = 0; row < examensTable.getRowCount(); row++) {
				TableCellRenderer cellRenderer = examensTable.getCellRenderer(row, column);
				Component c = examensTable.prepareRenderer(cellRenderer, row, column);
				int width = c.getPreferredSize().width + examensTable.getIntercellSpacing().width;
				preferredWidth = Math.max(preferredWidth, width);
	      }
	      col.setPreferredWidth(preferredWidth+5);
	    }	
	}

	
	
	/* LOAD JTABLE */
	public void refresh(List<Examens> list) {

		int k = list.size();
		rows = new Object[k][16];

		for (int i = 0; i < k; i++) {

			candidatCtrl = new CandidatController();
			String nomCandidat = candidatCtrl.findById(list.get(i).getIdCandidat()).getNom();
			String prenomCandidat = candidatCtrl.findById(list.get(i).getIdCandidat()).getPrenom();

			rows[i][0] = listExamens.get(i).getDateExamen();
			rows[i][1] = listExamens.get(i).getNbEchecTotal();
			rows[i][2] = nomCandidat + " " + prenomCandidat;
			rows[i][3] = listExamens.get(i).getTypePermis();
			rows[i][4] = listExamens.get(i).getDecisionFinale();
			rows[i][5] = listExamens.get(i).getDateExamenTheorique();
			rows[i][6] = listExamens.get(i).getNoteTheorique();
			rows[i][7] = listExamens.get(i).getDecisionTheorique();
			rows[i][8] = listExamens.get(i).getNbEchecTheorique();
			rows[i][9] = listExamens.get(i).getDateExamenPratique();
			rows[i][10] = listExamens.get(i).getDecisionPratique();
			rows[i][11] = listExamens.get(i).getNbEchecPratique();
			rows[i][12] = listExamens.get(i).getIdExamen();
			rows[i][13] = listExamens.get(i).getIdExamenTheorique();
			rows[i][14] = listExamens.get(i).getIdExamenPratique();
			rows[i][15] = listExamens.get(i).getIdCandidat();
		}
		DefaultTableModel model = new DefaultTableModel(rows, columns);
		examensTable.setModel(model);
		resizeTableColumns();
	}
	
	
	

	/**
	 * Create the panel.
	 */
	public GestionExamens() {

		setBackground(Color.decode("#34495e"));
		setBounds(0, 0, 648, 480);
		setLayout(null);

		/* JTABLE */
		// REMPLISSAGE DU TABLE MODEL
		examenCtrl = new ExamenController();
		listExamens = examenCtrl.getAll();
		int k = listExamens.size();
		rows = new Object[k][16];

		candidatCtrl = new CandidatController();

		for (int i = 0; i < k; i++) {
			candidatCtrl = new CandidatController();
			String nomCandidat = candidatCtrl.findById(listExamens.get(i).getIdCandidat()).getNom();
			String prenomCandidat = candidatCtrl.findById(listExamens.get(i).getIdCandidat()).getPrenom();

			rows[i][0] = listExamens.get(i).getDateExamen();
			rows[i][1] = listExamens.get(i).getNbEchecTotal();
			rows[i][2] = nomCandidat + " " + prenomCandidat;
			rows[i][3] = listExamens.get(i).getTypePermis();
			rows[i][4] = listExamens.get(i).getDecisionFinale();
			rows[i][5] = listExamens.get(i).getDateExamenTheorique();
			rows[i][6] = listExamens.get(i).getNoteTheorique();
			rows[i][7] = listExamens.get(i).getDecisionTheorique();
			rows[i][8] = listExamens.get(i).getNbEchecTheorique();
			rows[i][9] = listExamens.get(i).getDateExamenPratique();
			rows[i][10] = listExamens.get(i).getDecisionPratique();
			rows[i][11] = listExamens.get(i).getNbEchecPratique();
			rows[i][12] = listExamens.get(i).getIdExamen();
			rows[i][13] = listExamens.get(i).getIdExamenTheorique();
			rows[i][14] = listExamens.get(i).getIdExamenPratique();
			rows[i][15] = listExamens.get(i).getIdCandidat();
		}
		examensTableModel = new DefaultTableModel(rows, columns);

		// Création du JTable
		examensTable = new JTable(examensTableModel);
		resizeTableColumns();
		for (int i =0; i<examensTableModel.getColumnCount();i++)
			examensTable.setDefaultRenderer(examensTable.getColumnClass(i), new ExamenCellRenderer());
		
		scroll = new JScrollPane(examensTable);
		scroll.setBounds(10, 219, 641, 199);
		add(scroll);
		
		/* CREATION DES COMPOSANTS */
		separateur1Pnl = new JPanel();
		separateur1Pnl.setBackground(Color.decode("#7ed6df"));
		separateur1Pnl.setBounds(0, 57, 648, 10);
		add(separateur1Pnl);

		separateur2Pnl = new JPanel();
		separateur2Pnl.setBackground(Color.decode("#7ed6df"));
		separateur2Pnl.setBounds(0, 153, 648, 10);
		add(separateur2Pnl);

		gestionExamensLbl = new JLabel("Gestion Examens");
		gestionExamensLbl.setForeground(new Color(143, 188, 143));
		gestionExamensLbl.setFont(new Font("Oswald", Font.PLAIN, 18));
		gestionExamensLbl.setBounds(255, 11, 161, 48);
		add(gestionExamensLbl);

		dateLbl = new JLabel("Date :");
		dateLbl.setForeground(new Color(143, 188, 143));
		dateLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateLbl.setBounds(38, 122, 36, 20);
		add(dateLbl);

		rehercheLbl = new JLabel("Recherche :");
		rehercheLbl.setForeground(new Color(143, 188, 143));
		rehercheLbl.setFont(new Font("Oswald", Font.PLAIN, 18));
		rehercheLbl.setBounds(283, 78, 106, 28);
		add(rehercheLbl);

		iconRecherche = new ImageIcon(this.getClass().getResource("/searche.png")).getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		rechercheLbl = new JLabel();
		rechercheLbl.setIcon(new ImageIcon(iconRecherche));
		rechercheLbl.setBounds(602, 114, 36, 40);
		add(rechercheLbl);

		listExamensLbl = new JLabel("Liste des examens :");
		listExamensLbl.setForeground(new Color(143, 188, 143));
		listExamensLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		listExamensLbl.setBounds(23, 183, 125, 31);
		add(listExamensLbl);

		iconAjouter = new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		ajouterLbl = new JLabel("");
		ajouterLbl.setIcon(new ImageIcon(iconAjouter));
		ajouterLbl.setBounds(587, 174, 40, 40);
		add(ajouterLbl);

		iconModifier = new ImageIcon(this.getClass().getResource("/modifier.png")).getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		modifierLbl = new JLabel();
		modifierLbl.setIcon(new ImageIcon(iconModifier));
		modifierLbl.setBounds(23, 429, 51, 40);
		add(modifierLbl);

		supprimerLbl = new JLabel("");
		iconSupprimer = new ImageIcon(this.getClass().getResource("/delete.png")).getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		supprimerLbl.setIcon(new ImageIcon(iconSupprimer));
		supprimerLbl.setBounds(84, 429, 51, 40);
		add(supprimerLbl);

		iconActualiser = new ImageIcon(this.getClass().getResource("/actualiser.png")).getImage().getScaledInstance(40,
				40, Image.SCALE_SMOOTH);
		actualiserLbl = new JLabel();
		actualiserLbl.setIcon(new ImageIcon(iconActualiser));
		actualiserLbl.setBounds(591, 429, 36, 40);
		add(actualiserLbl);

		examenDateChooser = new JDateChooser();
		examenDateChooser.setBounds(84, 122, 140, 20);
		add(examenDateChooser);
		
		resultatsLbl = new JLabel("R\u00E9sultats");
		resultatsLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		resultatsLbl.setForeground(Color.YELLOW);
		resultatsLbl.setBounds(145, 429, 79, 40);
		add(resultatsLbl);

		//ACTION LISTENERS
		rechercheLbl.addMouseListener(this);
		modifierLbl.addMouseListener(this);
		ajouterLbl.addMouseListener(this);
		supprimerLbl.addMouseListener(this);
		actualiserLbl.addMouseListener(this);
		resultatsLbl.addMouseListener(this);
		
	}

	/* Buttons Clicked */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Ajouter clicked
		if (e.getComponent() == ajouterLbl) {
			AjouterExamens ajouterExament = new AjouterExamens(GestionExamens.this);
			ajouterExament.setVisible(true);
		}
		// Modifier clicked
		else if (e.getComponent() == modifierLbl) {
			rowIndex = examensTable.getSelectedRow();

			if (rowIndex == -1)
				JOptionPane.showMessageDialog(null, "Vous devez selectionner un examen!");
			else {
				examen = new Examens();
				examen = listExamens.get(rowIndex);

				ModifierExamens modifierCandidat = new ModifierExamens(examen, GestionExamens.this);
				modifierCandidat.setVisible(true);
			}
		}
		// Supprimer clicked
		else if (e.getComponent() == supprimerLbl) {
			rowIndex = examensTable.getSelectedRow();

			if (rowIndex == -1)
				JOptionPane.showMessageDialog(null, "Vous devez selectionner un examen!");
			else {
				int confirm = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cet examen?",
						"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (confirm == JOptionPane.YES_OPTION) {
					idExamen = (int) rows[rowIndex][12];
					check = examenCtrl.delete(idExamen);

					if (check > 0) {
						examenCtrl = new ExamenController();
						listExamens = examenCtrl.getAll();
						refresh(listExamens);
					} else
						JOptionPane.showMessageDialog(null, "Une erreur s'est produite!");
				}
			}
		}
		// Recherche clicked
		else if (e.getComponent() == rechercheLbl) {
			if(examenDateChooser.getDate() == null)
					JOptionPane.showMessageDialog(null, "Vous devez selectionner une date!");
			else {
				listExamens = new ArrayList<Examens>();
				Date date = new Date(examenDateChooser.getDate().getTime());
				listExamens = examenCtrl.search(date);
				refresh(listExamens);
			}
			
		}
		// Actualiser clicked
		else if (e.getComponent() == actualiserLbl) {
			examenCtrl = new ExamenController();
			listExamens = examenCtrl.getAll();
			refresh(listExamens);
		}
		//Resultats clicked
		else if(e.getComponent() == resultatsLbl) {
			rowIndex = examensTable.getSelectedRow();

			if (rowIndex == -1)
				JOptionPane.showMessageDialog(null, "Vous devez selectionner un examen!");
			else {
				examen = new Examens();
				examen = listExamens.get(rowIndex);
				ResultatsExamens resultatExamen = new ResultatsExamens(examen, GestionExamens.this);
				resultatExamen.setVisible(true);
			}
		}
	}

	/* NOT USED */
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	
	class ExamenCellRenderer extends DefaultTableCellRenderer {
		   public Component getTableCellRendererComponent(   JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		   {
			   String decisionFinale = listExamens.get(row).getDecisionFinale();			   
			   
			   if(decisionFinale.equals(Examens.Decision.EN_ATTENTE.toString()))
				   setBackground(Color.white);
			   else if(decisionFinale.equals(Examens.Decision.EN_PROGRESSION.toString()))
				   setBackground(Color.cyan);
			   else if(decisionFinale.equals(Examens.Decision.REUSSI.toString()))
				   setBackground(Color.green);
			   else if(decisionFinale.equals(Examens.Decision.ECHOUE.toString()))
				   setBackground(Color.red);
			   else if(decisionFinale.equals(Examens.Decision.RATTRAPAGE.toString()))
				   setBackground(Color.yellow);
		  
		      return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		   }
		}
}
