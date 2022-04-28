package projet.interf;



import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import projet.error.ContactManagerException;
import projet.uils.Utilitaire;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;



import java.awt.Dimension;


public abstract class AbstractInt extends JDialog {
	
	
	
	private static final long serialVersionUID = -3949685732707686870L;
	protected JTextField jFCarnet;
	protected JTextField jFIdentifiant;
	protected JTextField jFNom;
	protected JTextField jFPrenom;
	protected JTextField jFTelephone;
	protected JTextField jFEmail;
	protected JButton valider;
	protected JButton reset;
	protected JButton quitter;
	protected JLabel labelHeader;

	
	public AbstractInt(String hederLabel,String title) {
		setModal(true);
		
		initComponents (hederLabel,title);
	}
	
	public void setIcon(ImageIcon icon )
	{
		labelHeader.setIcon(icon);
	}
	public void initComponents (String hederLabel,String title)
	{
		setTitle(title);
		setPreferredSize(new Dimension(500, 450));
		setSize(new Dimension(500, 450));
		setResizable(false);
		getContentPane().setBackground(new Color(0, 139, 139));
		getContentPane().setLayout(new BorderLayout(5, 5));
		
		JPanel header = new JPanel();
		header.setBackground(new Color(0, 139, 139));
		getContentPane().add(header, BorderLayout.NORTH);
		
		labelHeader = new JLabel(hederLabel);
		labelHeader.setForeground(Color.WHITE);
		labelHeader.setFont(new Font("Times New Roman", Font.BOLD, 24));
		//labelHeader.setIcon(new ImageIcon(AbtractInt.class.getResource("/pictures/manager_new.png")));
		labelHeader.setHorizontalAlignment(SwingConstants.LEFT);
		header.add(labelHeader);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(255, 255, 255));
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(10);
		panel_2.setBackground(new Color(255, 255, 255));
		bottomPanel.add(panel_2, BorderLayout.EAST);
		
		 valider = new JButton("Valider");
		valider.setPreferredSize(new Dimension(65, 30));
		valider.setFocusable(false);
		valider.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 139, 139)));
		valider.setFont(new Font("Times New Roman", Font.BOLD, 13));
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onValiderClick();
				
			}
		});
		panel_2.add(valider);
		
		quitter = new JButton("Quitter");
		quitter.setPreferredSize(new Dimension(65, 30));
		quitter.setFocusable(false);
		quitter.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 139, 139)));
		quitter.setFont(new Font("Times New Roman", Font.BOLD, 13));
		quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onQuitteClick();
				
			}

		});
		panel_2.add(quitter);
		
		reset = new JButton("Reset");
		reset.setPreferredSize(new Dimension(65, 30));
		reset.setFocusable(false);
		reset.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 139, 139)));
		reset.setFont(new Font("Times New Roman", Font.BOLD, 13));
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					onResetClick();
				
			}
		});
		panel_2.add(reset);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		bottomPanel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contact");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setBounds(0, 0, 97, 21);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("manager");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setBounds(20, 19, 97, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_1);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 255, 255));
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(47dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(118dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(76dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(10dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(9dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(9dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(9dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(9dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(7dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_3 = new JLabel("Carnet :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		centerPanel.add(lblNewLabel_3, "6, 6, right, default");
		
		jFCarnet = new JTextField();
		jFCarnet.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jFCarnet.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		jFCarnet.setOpaque(false);
		centerPanel.add(jFCarnet, "8, 6, fill, default");
		jFCarnet.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Identifiant :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		centerPanel.add(lblNewLabel_4, "5, 10, 2, 1, right, default");
		
		jFIdentifiant = new JTextField();
		jFIdentifiant.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jFIdentifiant.setEditable(false);
		jFIdentifiant.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		jFIdentifiant.setOpaque(false);
		centerPanel.add(jFIdentifiant, "8, 10, fill, default");
		jFIdentifiant.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nom :");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		centerPanel.add(lblNewLabel_5, "5, 14, 2, 1, right, default");
		
		jFNom = new JTextField();
		jFNom.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jFNom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		jFNom.setOpaque(false);
		centerPanel.add(jFNom, "8, 14, fill, default");
		jFNom.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Prenom :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		centerPanel.add(lblNewLabel_6, "5, 18, 2, 1, right, default");
		
		jFPrenom = new JTextField();
		jFPrenom.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jFPrenom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		jFPrenom.setOpaque(false);
		centerPanel.add(jFPrenom, "8, 18, fill, default");
		jFPrenom.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Telephone :");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		centerPanel.add(lblNewLabel_7, "5, 22, 2, 1, right, default");
		
		jFTelephone = new JTextField();
		jFTelephone.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jFTelephone.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		jFTelephone.setOpaque(false);
		centerPanel.add(jFTelephone, "8, 22, fill, default");
		jFTelephone.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Email :\r\n");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		centerPanel.add(lblNewLabel_8, "5, 26, 2, 1, right, default");
		
		jFEmail = new JTextField();
		jFEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jFEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		jFEmail.setOpaque(false);
		centerPanel.add(jFEmail, "8, 26, fill, default");
		jFEmail.setColumns(10);
		Utilitaire.center(this);
		Utilitaire.setLockAndFeel(this);
	}
	protected abstract void onValiderClick();

	public void display ()
	{
		this.setVisible(true);
	}
	
	// vider les champs 
	public void onResetClick() {
		jFCarnet.setText(null);
		jFNom.setText(null);
		jFIdentifiant.setText(null);
		jFPrenom.setText(null);
		jFEmail.setText(null);
		jFTelephone.setText(null);
		
	}
	
	// Vérifier si tous les champs sont saisis 
	public boolean ctrlChamp()
	{
			if(jFCarnet.getText().equals(null) 
				|| jFNom.getText().equals(null)
				|| jFPrenom.getText().equals(null)
				||jFTelephone.getText().equals(null)
				|| jFEmail.getText().equals(null))
			{
				return false;
			}else {
				return true;
			}
	}
	//verifier si la donnée saisi dans le champs Telephone est int OU Integer 
	public void checkPhoneNember() throws ContactManagerException
	{	try {
		Integer.valueOf(this.jFTelephone.getText());
	} catch (Exception e) {
		throw new ContactManagerException("le numero de telephone doit être numerique ");
	}
		
	}
	
	public void onQuitteClick()
	{
		Utilitaire.exitWithConfirmation(this, "Voulez-vous cette fenêtre ? ");
	}
}
