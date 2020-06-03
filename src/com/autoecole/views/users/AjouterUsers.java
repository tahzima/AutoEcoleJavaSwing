package com.autoecole.views.users;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import com.autoecole.beans.Personnels;
import com.autoecole.beans.SearchPersonnel;
import com.autoecole.beans.Users;
import com.autoecole.controller.PersonnelsController;
import com.autoecole.controller.UsersController;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JTable;

public class AjouterUsers extends JFrame implements MouseListener,DocumentListener{

	/*COMPONENTS*/
	private JPanel contentPane;
	private JPanel contentPnl;
	private JPanel separateur1Pnl;
	private JPanel separateur2Pnl;
	private JLabel gestionUsersLbl ;
	private JLabel ajouterUserLbl;
	private JLabel ajouterImageLbl;
	private JLabel annulerImagreLbl;
	private JLabel retourImageLbl;
	private JLabel nomLbl;
	private JLabel prenomLbl;
	private JLabel cinLbl;
	private JLabel rechercheLbl;
	private JLabel loginLbl;
	private JLabel passwordLbl;
	private JLabel confirmerMdpLbl;
	private JTable personnelsTable;
	private JScrollPane scrollPane; 
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JTextField cinTxt;
	private JTextField loginTxt;
	private JPasswordField passwordTxt;
	private JPasswordField confirmerMdpTxt;
	private JLabel passwordVisibleLbl;
	/*VARIABLES*/
	private Image iconRecherche;
	private Image iconAjouter;
	private Image iconAnnuler;
	private PersonnelsController personnelsCtrl;
	private UsersController usersCtrl;
	private List<Personnels> listPersonnels;
	private Object gestionUsers;
	private DefaultTableModel candidatsTableModel;
	private String[] columns = {"Nom","Prenom","Cin","Date Naissance","Numero Telephone","Adresse","Poste","Date d'Embauche","Salaire"};
	private Object[][] rows;
	private boolean passwordVisible = false;
	private Image iconPassword;

	
	/*LOAD JTABLE*/
	public void refresh(List<Personnels> list) {
		
		int k = list.size();
		rows = new Object[k][10];
		
		for(int i=0;i<k;i++) {
			
			rows[i][0]=list.get(i).getNom();
			rows[i][1]=list.get(i).getPrenom();
			rows[i][2]=list.get(i).getCin();
			rows[i][3]=list.get(i).getDateNaissance();
			rows[i][4]=list.get(i).getNumTele();
			rows[i][5]=list.get(i).getAdresse();
			rows[i][6]=list.get(i).getPoste();
			rows[i][7]=list.get(i).getDateEmbauche();
			rows[i][8]=list.get(i).getSalaire();
			rows[i][9]=list.get(i).getId();
		}
		DefaultTableModel model  = new DefaultTableModel(rows,columns);
		personnelsTable.setModel(model);	
	}
	
	/**
	 * Create the frame.
	 */
	public AjouterUsers(final Object gestionUsersPanel) {
		
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
		personnelsCtrl = new PersonnelsController();
		listPersonnels = personnelsCtrl.getAll();
		int k = listPersonnels.size();
		rows = new Object[k][10];

		for(int i=0;i<k;i++) {

			rows[i][0]=listPersonnels.get(i).getNom();
			rows[i][1]=listPersonnels.get(i).getPrenom();
			rows[i][2]=listPersonnels.get(i).getCin();
			rows[i][3]=listPersonnels.get(i).getDateNaissance();
			rows[i][4]=listPersonnels.get(i).getNumTele();
			rows[i][5]=listPersonnels.get(i).getAdresse();
			rows[i][6]=listPersonnels.get(i).getPoste();
			rows[i][7]=listPersonnels.get(i).getDateEmbauche();
			rows[i][8]=listPersonnels.get(i).getSalaire();
			rows[i][9]=listPersonnels.get(i).getId();
			
		}
		candidatsTableModel = new DefaultTableModel(rows,columns);
		
		//Création du JTable
		personnelsTable = new JTable(candidatsTableModel);
		scrollPane = new JScrollPane(personnelsTable);
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
		
		gestionUsersLbl = new JLabel("Gestion Users");
		gestionUsersLbl.setForeground(new Color(143, 188, 143));
		gestionUsersLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		gestionUsersLbl.setBounds(255, 11, 161, 48);
		contentPnl.add(gestionUsersLbl);
		
		ajouterUserLbl = new JLabel("Ajouter User");
		ajouterUserLbl.setForeground(new Color(143, 188, 143));
		ajouterUserLbl.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 18));
		ajouterUserLbl.setBounds(255, 78, 154, 28);
		contentPnl.add(ajouterUserLbl);
		
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
		cinLbl.setBounds(380, 218, 35, 20);
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
		
		loginLbl = new JLabel("Login :");
		loginLbl.setForeground(new Color(143, 188, 143));
		loginLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		loginLbl.setBounds(10, 155, 46, 20);
		contentPnl.add(loginLbl);
		
		passwordLbl = new JLabel("Mot de passe :");
		passwordLbl.setForeground(new Color(143, 188, 143));
		passwordLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		passwordLbl.setBounds(183, 155, 79, 20);
		contentPnl.add(passwordLbl);
		
		loginTxt = new JTextField();
		loginTxt.setBounds(49, 157, 108, 20);
		contentPnl.add(loginTxt);
		loginTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(262, 157, 108, 20);
		contentPnl.add(passwordTxt);
		passwordTxt.setColumns(10);
		
		confirmerMdpLbl = new JLabel("Confirmer le MDP :");
		confirmerMdpLbl.setForeground(new Color(143, 188, 143));
		confirmerMdpLbl.setFont(new Font("Oswald", Font.PLAIN, 13));
		confirmerMdpLbl.setBounds(402, 155, 94, 20);
		contentPnl.add(confirmerMdpLbl);
		
		confirmerMdpTxt = new JPasswordField();
		confirmerMdpTxt.setColumns(10);
		confirmerMdpTxt.setBounds(506, 157, 108, 20);
		confirmerMdpTxt.setEditable(false);
		contentPnl.add(confirmerMdpTxt);
		
		iconPassword = new ImageIcon(this.getClass().getResource("/show.png")).getImage().getScaledInstance(20, 10, Image.SCALE_SMOOTH);
		passwordVisibleLbl = new JLabel();
		passwordVisibleLbl.setIcon(new ImageIcon(iconPassword));
		passwordVisibleLbl.setBounds(624, 155, 20, 20);
		contentPnl.add(passwordVisibleLbl);
		
		
		/*ACTION LISTENERS*/
		ajouterImageLbl.addMouseListener(this);
		annulerImagreLbl.addMouseListener(this);
		rechercheLbl.addMouseListener(this);
		passwordVisibleLbl.addMouseListener(this);
		passwordTxt.getDocument().addDocumentListener(this);

		/*Local To Global*/
		gestionUsers = gestionUsersPanel;
	}


	//BUTTONS
	@Override
	public void mouseClicked(MouseEvent e) {
		//Ajouter Clicked
		if(e.getComponent() == ajouterImageLbl) {
			
			String login = loginTxt.getText();
			String password = String.valueOf(passwordTxt.getPassword());
			String confirmPassword = String.valueOf(confirmerMdpTxt.getPassword());
			int selectedPersonnelIndex = personnelsTable.getSelectedRow();
			int idPersonnel = listPersonnels.get(selectedPersonnelIndex).getId();
			
			if(selectedPersonnelIndex==-1 || login.isEmpty() ||  password.isEmpty() || confirmPassword.isEmpty())
				JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires!");
			else {
				usersCtrl = new UsersController();
				int personnelAccountAlreadyExist = usersCtrl.checkUserExistByPersonnelId(idPersonnel);
				int userLoginAlreadyExist = usersCtrl.checkUserExistByLogin(login);
				
				if(personnelAccountAlreadyExist != 0)
					JOptionPane.showMessageDialog(null, "Cet employee possede deja un compte!");
				else if(userLoginAlreadyExist != 0)
					JOptionPane.showMessageDialog(null, "Ce login existe deja");
				else {
					if(!password.equals(confirmPassword))
						JOptionPane.showMessageDialog(null, "Les deux mots de passe ne sont pas identiques");
					else {		
						Users user = new Users();
						user.setLogin(login);
						user.setPassword(password);
						user.setId_Personnels(listPersonnels.get(selectedPersonnelIndex).getId());
						
						usersCtrl = new UsersController();
						
						int check = usersCtrl.add(user);
						
						if(check!=1)
							JOptionPane.showMessageDialog(null, "Une erreur s'est produite!");
						else {
							if(gestionUsers instanceof GestionUsersAdmin) {
								((GestionUsersAdmin) gestionUsers).setListUsers(usersCtrl.getAll());
								((GestionUsersAdmin)gestionUsers).refresh(((GestionUsersAdmin) gestionUsers).getListUsers());
							}
							
							dispose();
						}
					}
				}
			}
		}
		//Recherche Clicked
		else if(e.getComponent() == rechercheLbl) {
			listPersonnels.clear();
			PersonnelsController gestionPersonnelController = new PersonnelsController();
			SearchPersonnel searchPersonnel = new SearchPersonnel();
			searchPersonnel.setCin(cinTxt.getText());
			searchPersonnel.setNom(nomTxt.getText());
			searchPersonnel.setPrenom(prenomTxt.getText());
			listPersonnels=gestionPersonnelController.search(searchPersonnel);
			refresh(listPersonnels);			
		}
		//Visibilite du mot de passe
		else if(e.getComponent() == passwordVisibleLbl) {
			if(passwordVisible) {
				iconPassword = new ImageIcon(this.getClass().getResource("/show.png")).getImage().getScaledInstance(20, 10, Image.SCALE_SMOOTH);
				passwordVisibleLbl.setIcon(new ImageIcon(iconPassword));
				passwordVisible = false;
				passwordTxt.setEchoChar('•');
				confirmerMdpTxt.setEchoChar('•');
			}
			else {
				iconPassword = new ImageIcon(this.getClass().getResource("/hide.png")).getImage().getScaledInstance(20, 10, Image.SCALE_SMOOTH);
				passwordVisibleLbl.setIcon(new ImageIcon(iconPassword));
				passwordVisible = true;
				passwordTxt.setEchoChar((char)0);
				confirmerMdpTxt.setEchoChar((char)0);
			}
		}
		//Annuler Clicked
		else if(e.getComponent() == annulerImagreLbl)
			dispose();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(e.getDocument() == passwordTxt.getDocument())
			confirmerMdpTxt.setEditable(true);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if(e.getDocument() == passwordTxt.getDocument()) {
			if(String.valueOf(passwordTxt.getPassword()).isEmpty())
				confirmerMdpTxt.setEditable(false);
		}
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
	@Override
	public void changedUpdate(DocumentEvent e) {}
}
