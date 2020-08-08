package com.autoecole.views.statistiques;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.autoecole.controller.StatistiquesController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Locale.Category;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class statistique extends JPanel  {
	private StatistiquesController statistiqueController = new StatistiquesController();
	private JTextField moyenneTHTxt;
	private JTextField totalPersonnesTxt;
	private JTextField personnesReussiteTxt;
	private JTextField personneEchouantTxt;
	/**
	 * Create the panel.
	 */
	public statistique() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 653, 475);
		panel.setBackground(new Color(52, 73, 94));
		add(panel);
		panel.setLayout(null);
		
		JButton showChartBtn = new JButton("Show Chart");
		showChartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultCategoryDataset defaultDataset = new DefaultCategoryDataset();
				defaultDataset.setValue(statistiqueController.getNbCandidatTheorique(), "Nombre des Personnes", "Theorique");
				defaultDataset.setValue(statistiqueController.getNbCandidatPratique(), "Nombre des Personnes", "Pratique");
				JFreeChart jChart = ChartFactory.createBarChart("Examen Record", "Type Examen", "Nombre des Personnes", defaultDataset , PlotOrientation.VERTICAL , true, true, false);
				CategoryPlot plot = jChart.getCategoryPlot();
				plot.setRangeGridlinePaint(Color.black);
				ChartFrame chartFrame = new ChartFrame("Examen record", jChart, true);
				chartFrame.setVisible(true);
				chartFrame.setSize(800, 600);
			}
		});
		showChartBtn.setBounds(437, 409, 112, 23);
		panel.add(showChartBtn);
		
		JLabel statistiquesLbl = new JLabel("Statistiques");
		statistiquesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		statistiquesLbl.setForeground(new Color(143, 188, 143));
		statistiquesLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		statistiquesLbl.setBounds(255, 0, 161, 48);
		panel.add(statistiquesLbl);
		
		JPanel separateurPnl = new JPanel();
		separateurPnl.setBackground(new Color(126, 214, 223));
		separateurPnl.setBounds(0, 46, 648, 10);
		panel.add(separateurPnl);
		
		JLabel personnesEchoueesLbl = new JLabel("selon les personnes \u00E9chouees :");
		personnesEchoueesLbl.setForeground(new Color(143, 188, 143));
		personnesEchoueesLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		personnesEchoueesLbl.setBounds(75, 80, 204, 20);
		panel.add(personnesEchoueesLbl);
		
		JLabel personnesReussiteLbl = new JLabel("selon les personnes r\u00E9ussite :");
		personnesReussiteLbl.setForeground(new Color(143, 188, 143));
		personnesReussiteLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		personnesReussiteLbl.setBounds(75, 162, 204, 20);
		panel.add(personnesReussiteLbl);
		
		JLabel totalPersonneLbl = new JLabel("selon le total des personnes :");
		totalPersonneLbl.setForeground(new Color(143, 188, 143));
		totalPersonneLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		totalPersonneLbl.setBounds(75, 244, 204, 20);
		panel.add(totalPersonneLbl);
		
		JLabel moyenneExamenTHLbl = new JLabel("selon la moyenne Examen Theorique :");
		moyenneExamenTHLbl.setForeground(new Color(143, 188, 143));
		moyenneExamenTHLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		moyenneExamenTHLbl.setBounds(75, 326, 204, 20);
		panel.add(moyenneExamenTHLbl);
		
		JLabel typeExamenLbl = new JLabel("selon le type d'examen :");
		typeExamenLbl.setForeground(new Color(143, 188, 143));
		typeExamenLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		typeExamenLbl.setBounds(75, 408, 204, 20);
		panel.add(typeExamenLbl);
		
		moyenneTHTxt = new JTextField();
		moyenneTHTxt.setText(String.valueOf(statistiqueController.getNoteMoyenneTH()));
		moyenneTHTxt.disable();
		moyenneTHTxt.setBounds(437, 328, 112, 20);
		panel.add(moyenneTHTxt);
		moyenneTHTxt.setColumns(10);
		
		totalPersonnesTxt = new JTextField();
		totalPersonnesTxt.setText(String.valueOf(statistiqueController.getAllCandidat()));
		totalPersonnesTxt.disable();
		totalPersonnesTxt.setColumns(10);
		totalPersonnesTxt.setBounds(437, 246, 112, 20);
		panel.add(totalPersonnesTxt);
		
		personnesReussiteTxt = new JTextField();
		personnesReussiteTxt.setText(String.valueOf(statistiqueController.getAllCandidatReussi()));
		personnesReussiteTxt.disable();
		personnesReussiteTxt.setColumns(10);
		personnesReussiteTxt.setBounds(437, 164, 112, 20);
		panel.add(personnesReussiteTxt);
		
		personneEchouantTxt = new JTextField();
		personneEchouantTxt.setText(String.valueOf(statistiqueController.getAllCandidatEchouer()));
		personneEchouantTxt.disable();
		personneEchouantTxt.setColumns(10);
		personneEchouantTxt.setBounds(437, 82, 112, 20);
		panel.add(personneEchouantTxt);
		
	}
}
