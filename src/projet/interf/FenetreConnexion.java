 package projet.interf;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import projet.error.ContactManagerException;
import projet.metier.UserManager;
import projet.uils.Utilitaire;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class FenetreConnexion extends JFrame {
	
	private static final long serialVersionUID = -5820770565202727122L;
	private JTextField tFLogin;
	private JPasswordField tFPassword;
	private JButton quitter;
	private JButton valider;
	public FenetreConnexion() {
		setResizable(false);
		setSize(new Dimension(328, 156));
		setTitle("Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255, 255, 255));
		FlowLayout fl_topPanel = (FlowLayout) topPanel.getLayout();
		fl_topPanel.setVgap(10);
		fl_topPanel.setHgap(26);
		getContentPane().add(topPanel);
		
		JLabel lLogin = new JLabel("Login :");
		lLogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		topPanel.add(lLogin);
		
		tFLogin = new JTextField();
		tFLogin.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		topPanel.add(tFLogin);
		tFLogin.setColumns(15);
		
		JPanel middlePanel = new JPanel();
		middlePanel.setBackground(new Color(255, 255, 255));
		FlowLayout fl_middlePanel = (FlowLayout) middlePanel.getLayout();
		fl_middlePanel.setVgap(10);
		getContentPane().add(middlePanel);
		
		JLabel lPassword = new JLabel("Password :");
		lPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		middlePanel.add(lPassword);
		
		tFPassword = new JPasswordField();
		tFPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 128, 128)));
		tFPassword.setEchoChar('*');
		tFPassword.setColumns(15);
		middlePanel.add(tFPassword);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout = (FlowLayout) bottomPanel.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setVgap(10);
		getContentPane().add(bottomPanel);
		
		valider = new JButton("Valider");
		valider.setFocusable(false);
		valider.setFont(new Font("Times New Roman", Font.BOLD, 13));
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onConnexionClick();
				//dispose();
			}
		});
		
		bottomPanel.add(valider);
		
		 quitter = new JButton("Quitter");
		 quitter.setFocusable(false);
		 quitter.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onQuitterclick();
				
			}
		});
		bottomPanel.add(quitter);
		Utilitaire.center(this);
		Utilitaire.setLockAndFeel(this);
	}
	
	 protected void onQuitterclick() {
		 Utilitaire.exitWithConfirmation(this, "Voulez-vous cette fenêtre ? ");
		
	}

	protected void onConnexionClick() {
		
		String login=tFLogin.getText();
		String password=String.valueOf(tFPassword.getPassword());
		
		try {
			if(UserManager.checkUser(login, password))
			{
				ManagerUI app=new ManagerUI();
				app.run();
				dispose();
			}else {
				JOptionPane.showMessageDialog(null,"Login ou mot de passe incorrect", "ERROR", JOptionPane.ERROR_MESSAGE);
				tFLogin.setText(null);
				tFPassword.setText(null);
			}
		} catch (ContactManagerException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public void showme()
	{
		this.setVisible(true);
	}

}
