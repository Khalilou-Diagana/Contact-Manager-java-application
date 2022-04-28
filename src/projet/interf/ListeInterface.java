package projet.interf;

import javax.swing.JPanel;


import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import projet.error.ContactManagerException;
import projet.metier.Service;
import projet.objets.Contact;
import projet.objets.ContactModel;
import projet.uils.Utilitaire;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

// la fenetre qui permet de :
/*
 * 1-lister les contacts d 'un carnet  
 * 2-modifier un contact du carnet 
 * 3- supprimer un contact du carnet 
 * 4- ajouter un contact dans un carnet 
 */
public class ListeInterface extends JDialog {
	
	private static final long serialVersionUID = 1076995977707102933L;

	private JTextField jFCarnetl;
	private JTextField jFCritere;
	private JTable table;
	private JButton ajouter;
	private JButton recherche;
	private JButton supprimer;
	private JButton quitter;
	private JButton reset;
	private JButton lister;
	private ContactModel ContactModel;
	private JButton modifier;
	private JRadioButton radioId;
	private JRadioButton radioName;
	public ListeInterface() {
		setTitle("Liste des contacts ");
		setModal(true);
		initComponents();
	}
	public void initComponents()
	{
		setPreferredSize(new Dimension(800, 475));
		setSize(new Dimension(808, 475));
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel designPanel = new JPanel();
		designPanel.setBackground(new Color(95, 158, 160));
		designPanel.setBounds(0, 0, 153, 445);
		getContentPane().add(designPanel);
		designPanel.setLayout(null);
		
		JLabel listage = new JLabel("Listage");
		listage.setForeground(new Color(0, 139, 139));
		listage.setBackground(new Color(0, 139, 139));
		listage.setFont(new Font("Tahoma", Font.BOLD, 24));
		listage.setBounds(31, 190, 99, 47);
		designPanel.add(listage);
		
		JLabel manager = new JLabel("Manager");
		manager.setForeground(new Color(255, 255, 255));
		manager.setFont(new Font("Tahoma", Font.BOLD, 17));
		manager.setBounds(50, 49, 80, 14);
		designPanel.add(manager);
		
		JLabel cercle = new JLabel("");
		cercle.setIcon(new ImageIcon(ListeInterface.class.getResource("/pictures/dry-clean (2).png")));
		cercle.setHorizontalAlignment(SwingConstants.CENTER);
		cercle.setBounds(10, 153, 133, 139);
		designPanel.add(cercle);
		
		JLabel contact = new JLabel("Contact");
		contact.setFont(new Font("Tahoma", Font.BOLD, 30));
		contact.setBounds(10, 11, 133, 41);
		designPanel.add(contact);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(95, 158, 160));
		mainPanel.setBounds(151, 0, 643, 445);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new BorderLayout(5, 5));
		
		JPanel bottomPanel = new JPanel();
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(255, 255, 255));
		FlowLayout fl_rightPanel = (FlowLayout) rightPanel.getLayout();
		fl_rightPanel.setHgap(10);
		bottomPanel.add(rightPanel, BorderLayout.EAST);
		
		ajouter = new JButton("");
		ajouter.setFocusable(false);
		ajouter.setToolTipText("Ajouter un contact");
		ajouter.setIcon(new ImageIcon(ListeInterface.class.getResource("/pictures/add.png")));
		ajouter.setBorder(new LineBorder(new Color(0, 139, 139)));
		ajouter.setPreferredSize(new Dimension(45, 45));
		ajouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onAjouterClick();
				loead();
			}
		});
		rightPanel.add(ajouter);
		
		 modifier = new JButton("");
		 modifier.setFocusable(false);
		modifier.setIcon(new ImageIcon(ListeInterface.class.getResource("/pictures/refresh.png")));
		modifier.setToolTipText("Ajouter un contact");
		modifier.setPreferredSize(new Dimension(45, 45));
		modifier.setBorder(new LineBorder(new Color(0, 139, 139)));
		modifier.addActionListener(new ActionListener(
				) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onModifierClick();
				
			}

			
		});
		rightPanel.add(modifier);
		
		recherche = new JButton("");
		recherche.setFocusable(false);
		recherche.setToolTipText("Chercer un contact ");
		recherche.setBorder(new LineBorder(new Color(0, 139, 139)));
		recherche.setPreferredSize(new Dimension(45, 45));
		recherche.setIcon(new ImageIcon(ListeInterface.class.getResource("/pictures/recherche.png")));
		recherche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					onSearchClick();
			}
		});
		rightPanel.add(recherche);
		
		supprimer = new JButton("");
		supprimer.setFocusable(false);
		supprimer.setIcon(new ImageIcon(ListeInterface.class.getResource("/pictures/delete.png")));
		supprimer.setToolTipText("Supprimer le contact selectionn\u00E9\r\n");
		supprimer.setBorder(new LineBorder(new Color(0, 139, 139)));
		supprimer.setPreferredSize(new Dimension(45, 45));
		supprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onDeleteClick();
				
			}
		});
		rightPanel.add(supprimer);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(255, 255, 255));
		FlowLayout fl_leftPanel = (FlowLayout) leftPanel.getLayout();
		fl_leftPanel.setVgap(15);
		fl_leftPanel.setHgap(10);
		bottomPanel.add(leftPanel, BorderLayout.WEST);
		
		quitter = new JButton("Quitter");
		quitter.setBorder(new LineBorder(new Color(0, 139, 139)));
		quitter.setFocusable(false);
		quitter.setToolTipText("Quitter cette fen\u00EAtre ");
		quitter.setFont(new Font("Times New Roman", Font.BOLD, 13));
		quitter.setPreferredSize(new Dimension(80, 30));
		quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				onQuitteClick();
				
			}
		});
		leftPanel.add(quitter);
		
		reset = new JButton("Reset");
		reset.setFocusable(false);
		reset.setBorder(new LineBorder(new Color(0, 139, 139)));
		reset.setToolTipText("Vider les champs");
		reset.setForeground(new Color(0, 0, 0));
		reset.setBackground(new Color(255, 255, 255));
		reset.setFont(new Font("Times New Roman", Font.BOLD, 13));
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onResetClick();
			
			}
		});
		reset.setPreferredSize(new Dimension(80, 30));
		leftPanel.add(reset);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 255, 255));
		FlowLayout fl_centerPanel = (FlowLayout) centerPanel.getLayout();
		fl_centerPanel.setVgap(15);
		fl_centerPanel.setHgap(10);
		bottomPanel.add(centerPanel, BorderLayout.CENTER);
		
		lister = new JButton("Lister");
		lister.setFocusable(false);
		lister.setBorder(new LineBorder(new Color(0, 139, 139)));
		lister.setToolTipText("Lister les contacts de votre carnet");
		lister.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lister.setPreferredSize(new Dimension(80, 30));
		lister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onListeClick();
				
			}
		});
		centerPanel.add(lister);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(70dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(127dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(8dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(9dlu;default)"),}));
		
		JLabel noteBookLabel = new JLabel("Carnet");
		noteBookLabel.setIcon(new ImageIcon(ListeInterface.class.getResource("/pictures/phone-book.png")));
		noteBookLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		headerPanel.add(noteBookLabel, "4, 4");
		
		JLabel searchLabel = new JLabel("Recherche");
		searchLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		headerPanel.add(searchLabel, "12, 4");
		
		radioName = new JRadioButton("Nom");
		radioName.setFocusable(false);
		radioName.setBackground(Color.WHITE);
		radioName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		radioName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioName.isSelected())
				{
					radioId.setSelected(false);
				}
				
			}
		});
		headerPanel.add(radioName, "18, 4");
		
		jFCarnetl = new JTextField();
		jFCarnetl.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jFCarnetl.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		jFCarnetl.setOpaque(false);
		headerPanel.add(jFCarnetl, "4, 6, fill, default");
		jFCarnetl.setColumns(10);
		
		jFCritere = new JTextField();
		jFCritere.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jFCritere.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		jFCritere.setOpaque(false);
		headerPanel.add(jFCritere, "12, 6, fill, default");
		jFCritere.setColumns(10);
		
		radioId = new JRadioButton("Identifiant ");
		radioId.setFocusable(false);
		radioId.setBackground(Color.WHITE);
		radioId.setFont(new Font("Times New Roman", Font.BOLD, 13));
		radioId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioId.isSelected())
				{
					radioName.setSelected(false);
				}
				
			}
		});
		headerPanel.add(radioId, "18, 6");
		
		JPanel tablePanel = new JPanel();
		mainPanel.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane =  new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tablePanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 139, 139)));
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ContactModel = new ContactModel();
		table.setModel(ContactModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(83);
		table.getColumnModel().getColumn(1).setPreferredWidth(158);
		table.getColumnModel().getColumn(2).setPreferredWidth(154);
		table.getColumnModel().getColumn(3).setPreferredWidth(128);
		table.getColumnModel().getColumn(4).setPreferredWidth(310);
		scrollPane.setViewportView(table);
		Utilitaire.center(this);
		Utilitaire.setLockAndFeel(this);
	}
	
	  //cette fonction permet de vider les champs 
	 
	protected void onResetClick() {
	
		jFCarnetl.setText(null);
		jFCritere.setText(null);
		ContactModel.clear();
		radioName.setSelected(false); 
		radioId.setSelected(false);
		
	}
	
	
	 //Pour quitter la fenetre 
	 
	protected void onQuitteClick()
	{
		Utilitaire.exitWithConfirmation(this, "Voulez-vous fermer  cette fenêtre ? ");
	}
	
	 //pour cherhcer un contact par son nom ou son identifiant 
	 
	protected void onSearchClick() {
		if (checkAll()==false)
		{
			JOptionPane.showMessageDialog(null, "veuillez saisir le nom de votre carnet et le critère de recherche",
					"saisis de champs", JOptionPane.ERROR_MESSAGE);
		}else if (!(radioId.isSelected() ||radioName.isSelected()))
		{
			JOptionPane.showMessageDialog(null, "veuillez choisir votre critère de recherche ",
					"saisis de champs", JOptionPane.ERROR_MESSAGE);
		}else
		{
			try {
				Contact contact=null;
				if (radioId.isSelected())
				{	
					 contact=Service.SearcheContact(Integer.valueOf(jFCritere.getText()), jFCarnetl.getText());
				}
				else if (radioName.isSelected())
				{
				 contact=Service.SearcheContact(jFCritere.getText(), jFCarnetl.getText());
				}
				for (int i=0;i<table.getRowCount();i++) {
					if (table.getValueAt(i, 0).equals(contact.getIdentifiant()))
					{
						table.setRowSelectionInterval(i, i);
					}
				}
			
				JOptionPane.showMessageDialog(null,"le contact que vous cherchez selectionné dans la table ",
						"Recherche d'un contact", JOptionPane.INFORMATION_MESSAGE);
			}catch (ContactManagerException e) {
				
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "veuillez verifier votre critère de recherhce ", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	

	 // pour supprimer un contact 

	protected void onDeleteClick() {
		if (checkCarnet()==false)
		{
			JOptionPane.showMessageDialog(null, "veuillez saisir le nom de votre carnet ", "Saisi de champs", JOptionPane.ERROR_MESSAGE);
		}
		else 
		{
			int selectedRow=table.getSelectedRow();
			
			if (selectedRow <0)
			{
				JOptionPane.showMessageDialog(null, "Veillez selectionner le contact que vous voulez supprimer ",
						"Selection de contact", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (JOptionPane.YES_OPTION ==JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer ce contact ?"))
				{
					Contact contact= (Contact)ContactModel.getValueAt(selectedRow, ContactModel.OBJECT_COL);
					try {
						Service.deleteContact(jFCarnetl.getText(), contact);
						JOptionPane.showMessageDialog(null, "contact supprimé avec succés ",
								"succés de l'operation", JOptionPane.INFORMATION_MESSAGE);
						loead();
					} catch (ContactManagerException e) {
						
						JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
	

	 // pour ajouter un contact dans la un carnet 

	protected void onAjouterClick() {

		
		AddContactInt ajout=new AddContactInt();
		ajout.jFCarnet.setText(jFCarnetl.getText());
		ajout.display();
		
	}
	

	 // pour modifier un contact selectionné dans le tableau 
	
	protected void onModifierClick() {
		if (checkCarnet()==false)
		{
			JOptionPane.showMessageDialog(null, "veuillez saisir le nom de votre carnet ", "saisis de champs",
					JOptionPane.ERROR_MESSAGE);
		}
		else 
		{
			int selectedRow=table.getSelectedRow();
			if (selectedRow <0)
			{
				JOptionPane.showMessageDialog(null, "Veillez selectionner le contact que vous voulez modifier ", 
						"Selection de contact", JOptionPane.ERROR_MESSAGE);
			}
			else {
				Contact contact= (Contact)ContactModel.getValueAt(selectedRow, ContactModel.OBJECT_COL);
				UpdateContactInt upInt=new UpdateContactInt(this);
				upInt.charge(contact,jFCarnetl.getText());
				upInt.display();
			}
		}
	}
	
	
	// pour lister les contacts d'un carnet 
	 
	
	protected void onListeClick() {
		try 
		{
			if(checkCarnet()==true){
				
				List<Contact> liste=Service.lister(jFCarnetl.getText());
				if (liste.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "la liste est vide ", "saisi de champs", JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					ContactModel.loadData(liste);
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Veillez saisir le nom de votre carnet ", "saisi de champs", JOptionPane.ERROR_MESSAGE);
			}
		}catch (ContactManagerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public void display ()
	{
		this.setVisible(true);
	}
	
	protected boolean checkCarnet()
	{
		if (jFCarnetl.getText().equals(null))
		{
			return false;
		}
		else {
			return true;
		}
	}
	
	// verifie si le le champs critere et le champs carnet ne sont pas vide 
	protected boolean checkAll()
	{
		if (checkCarnet()==false || jFCritere.getText().equals(null))
		{
			return false ;
		}else 
			return true ;
	}
	
	public void loead() {
		try {
			List<Contact> liste=Service.lister(jFCarnetl.getText());
			ContactModel.loadData(liste);
		}catch (ContactManagerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
