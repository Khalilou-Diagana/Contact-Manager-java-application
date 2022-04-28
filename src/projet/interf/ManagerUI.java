package projet.interf;

import javax.swing.JFrame;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import projet.uils.Utilitaire;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

// classe principale qui vient après  la connexion 
public class ManagerUI extends JFrame {

	
	
	private static final long serialVersionUID = 1795872647813948452L;
	private static JButton noteBook;
	private static JButton add;
	private static JButton liste;
	private static JButton quitter;
	private JMenuBar menuBar;
	private JMenu menuCompte;
	private JMenuItem itemUser;
	private JMenuItem itemExit;
	private JMenuItem updateContact;
	private JMenuItem addContact;
	private JMenuItem newNoteBook;
	private JMenu menuFihcier;
	public ManagerUI() {
		setPreferredSize(new Dimension(600, 320));
		setSize(new Dimension(515, 320));
		setTitle("Contact manager");
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(0, 139, 139));
		headerPanel.setBounds(0, 0, 511, 128);
		getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contact");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(115, 11, 200, 51);
		headerPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Manager");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(217, 60, 75, 21);
		headerPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ManagerUI.class.getResource("/pictures/Contact-Manager.png")));
		lblNewLabel_2.setBounds(32, 11, 73, 85);
		headerPanel.add(lblNewLabel_2);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new LineBorder(new Color(0, 139, 139)));
		bottomPanel.setBackground(new Color(255, 255, 255));
		FlowLayout fl_bottomPanel = (FlowLayout) bottomPanel.getLayout();
		fl_bottomPanel.setVgap(30);
		fl_bottomPanel.setHgap(20);
		bottomPanel.setBounds(0, 127, 511, 142);
		getContentPane().add(bottomPanel);
		
		noteBook = new JButton("");
		noteBook.setToolTipText("Crr\u00E9er un nouveau carnet ");
		noteBook.setFocusable(false);
		noteBook.setPreferredSize(new Dimension(70, 80));
		noteBook.setBorder(new LineBorder(new Color(0, 139, 139)));
		noteBook.setBackground(new Color(255, 255, 255));
		noteBook.setIcon(new ImageIcon(ManagerUI.class.getResource("/pictures/manager_new.png")));
		noteBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onNoteBookClick();
				
			}
		});
		bottomPanel.add(noteBook);
		
		add = new JButton("");
		add.setToolTipText("Ajouter un contact dans votre carnet ");
		add.setPreferredSize(new Dimension(70, 80));
		add.setBorder(new LineBorder(new Color(0, 139, 139)));
		add.setFocusable(false);
		add.setIcon(new ImageIcon(ManagerUI.class.getResource("/pictures/manager_add.png")));
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onAddClick();
				
			}
		});
		bottomPanel.add(add);
		
		liste = new JButton("");
		liste.setToolTipText("Lister les contacts de votre carnet ");
		liste.setPreferredSize(new Dimension(70, 80));
		liste.setBorder(new LineBorder(new Color(0, 139, 139)));
		liste.setFocusable(false);
		liste.setIcon(new ImageIcon(ManagerUI.class.getResource("/pictures/manager_list.png")));
		liste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onListClick();
			}
		});
		bottomPanel.add(liste);
		
		quitter = new JButton(""); 
		quitter.setToolTipText("Quitter l'application ");
		quitter.setPreferredSize(new Dimension(70, 80));
		quitter.setBorder(new LineBorder(new Color(0, 139, 139)));
		quitter.setIcon(new ImageIcon(ManagerUI.class.getResource("/pictures/manager_exit.png")));
		quitter.setFocusable(false);
		quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onQuitteClick();
				
			}
		});
		bottomPanel.add(quitter);
		
		 menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuCompte = new JMenu("Compte");
		menuBar.add(menuCompte);
		
		itemUser = new JMenuItem("Modifier les paramètres de l'utilisateur ");
		itemUser.setIcon(new ImageIcon(ManagerUI.class.getResource("/pictures/paramaterManager.png")));
		itemUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onUpdateUseClick();
				
			}
		});
		menuCompte.add(itemUser);
		
		itemExit = new JMenuItem("Quitter la session");
		itemExit.setIcon(new ImageIcon(ManagerUI.class.getResource("/pictures/exit.png")));
		itemExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onQuitteClick();
				
			}
		});
		menuCompte.add(itemExit);
		
		menuFihcier = new JMenu("Fichier");
		menuFihcier.setMnemonic('F');
		menuBar.add(menuFihcier);
		
		newNoteBook = new JMenuItem("Nouveau carnet\r\n");
		newNoteBook.setIcon(new ImageIcon(ManagerUI.class.getResource("/pictures/notebook.png")));
		newNoteBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onNoteBookClick();
				
			}
		});
		menuFihcier.add(newNoteBook);
		
		addContact = new JMenuItem("Ajouter un contact");
		addContact.setIcon(new ImageIcon(ManagerUI.class.getResource("/pictures/plus.png")));
		addContact.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onAddClick();
				
			}
		});
		menuFihcier.add(addContact);
		
		updateContact = new JMenuItem("Modifier un contact");
		updateContact.setIcon(new ImageIcon(ManagerUI.class.getResource("/pictures/update.png")));
		updateContact.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				onUpdateClick();
				
				
			}
		});
		menuFihcier.add(updateContact);
		Utilitaire.center(this);
		Utilitaire.setLockAndFeel(this);
	}
	
	//Modifier un contact
	protected void onUpdateClick() {
			
			JOptionPane.showMessageDialog(null,"1. saisir le nom de votre carnet \n 2.lister les contacts de votre carnet \n 3.selectionner le contact que vous souhaitez modifier  \n 4. cliquer sur le boutton modifier ", "PROCESSUS DE MODIFICATION", JOptionPane.INFORMATION_MESSAGE);
			onListClick();
			
		
	}
	
	// Modifier les parametre de l'utilisateur 
	// login et password 
	protected void onUpdateUseClick() {
		UpdateUserInt upUser=new UpdateUserInt();
		upUser.display();
		
	}
	
	
	public void display ()
	{
		this.setVisible(true);
	}
	
	//Afficher la fenetre de listage des contacts 
	protected void onListClick()
	{
		ListeInterface list=new ListeInterface();
		list.display();
	}
	
	// Quitter la fenetre avec validation
	protected void onQuitteClick()
	{
		Utilitaire.exitWithConfirmation(this, "Voulez-vous quittez l'application");
	}
	
	//affiche la fenetre qui permet d'ajoutter un contacts dans un cartnet 
	protected void onAddClick()
	{
		AddContactInt ajouter=new  AddContactInt();
		ajouter.display();
	}
	
	// Afficher la fenetre qui permt de cr�er un nouveau carnet 
	protected void  onNoteBookClick()
	{
		NoteBooktInt noteBook= new NoteBooktInt();
		noteBook.display();
		
	}
	
	public void run() {
		this.setVisible(true);
	}
	
}
