package projet.interf;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import projet.error.ContactManagerException;
import projet.metier.UserManager;
import projet.objets.User;
import projet.uils.Utilitaire;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;

public class UpdateUserInt extends JDialog {

	
	private static final long serialVersionUID = -8061839781506964975L;
	private JTextField jFLogui;
	private JPasswordField pFActPassword;
	private JPasswordField pFNewPassword;
	private JPasswordField pFConfirm;
	private JButton valider;
	private JButton reset;
	private JButton quitter;
	public UpdateUserInt() {
		setSize(new Dimension(450, 300));
		setPreferredSize(new Dimension(450, 300));
		setResizable(false);
		
		initComponent();
	}

	public void initComponent()
	{
		setModal(true);
		setTitle("Mise à jour du compte ");
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setVgap(5);
		borderLayout.setHgap(5);
		getContentPane().setBackground(new Color(0, 139, 139));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(0, 139, 139));
		getContentPane().add(headerPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Mise à jour du compte ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		headerPanel.add(lblNewLabel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(255, 255, 255));
		FlowLayout fl_bottomPanel = (FlowLayout) bottomPanel.getLayout();
		fl_bottomPanel.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		valider = new JButton("Valider");
		valider.setFont(new Font("Times New Roman", Font.BOLD, 13));
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onValiderClick();
				
			}
		});
		bottomPanel.add(valider);
		
		reset = new JButton("Reset");
		reset.setFont(new Font("Times New Roman", Font.BOLD, 13));
		bottomPanel.add(reset);
		
		quitter = new JButton("Quitter");
		quitter.setFont(new Font("Times New Roman", Font.BOLD, 13));
		bottomPanel.add(quitter);
		
		JPanel centerPanrl = new JPanel();
		centerPanrl.setBackground(new Color(255, 255, 255));
		getContentPane().add(centerPanrl, BorderLayout.CENTER);
		centerPanrl.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(96dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(17dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(19dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),}));
		
		JLabel lblNewLabel_1 = new JLabel("Login :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		centerPanrl.add(lblNewLabel_1, "2, 2, right, default");
		
		jFLogui = new JTextField();
		jFLogui.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		centerPanrl.add(jFLogui, "4, 2, fill, default");
		jFLogui.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe actuel  :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		centerPanrl.add(lblNewLabel_2, "2, 4, right, default");
		
		pFActPassword = new JPasswordField();
		pFActPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		centerPanrl.add(pFActPassword, "4, 4, fill, default");
		
		JLabel lblNewLabel_3 = new JLabel("Nouveau mot de passe :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		centerPanrl.add(lblNewLabel_3, "2, 6, right, default");
		
		pFNewPassword = new JPasswordField();
		pFNewPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		centerPanrl.add(pFNewPassword, "4, 6, fill, default");
		
		JLabel lblNewLabel_4 = new JLabel("Confirmation du mot de passe :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		centerPanrl.add(lblNewLabel_4, "2, 8, right, default");
		
		pFConfirm = new JPasswordField();
		pFConfirm.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 139, 139)));
		centerPanrl.add(pFConfirm, "4, 8, fill, default");
		Utilitaire.center(this);
		Utilitaire.setLockAndFeel(this);
	}

	protected void onValiderClick() {
		if (checkfildes()==false)
		{
			JOptionPane.showMessageDialog(null, "veuillez saisir tout les champs", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else 
		{
			try {
				User user=UserManager.deserialise();
				String actuel=String.valueOf(pFActPassword.getPassword());
				if (user.getPassword().equals(actuel))
				{
					String password=String.valueOf(pFNewPassword.getPassword());
					String confirm=String.valueOf(pFConfirm.getPassword());
					if (password.equals(confirm))
					{
						UserManager.update(new User(jFLogui.getText(), password)); 
						JOptionPane.showMessageDialog(null, "vos données ont été modifié avec succès",
								"Mise � jour du compte", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "veuillez verifier votre nouveau mot de passe ", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "le login que vous avez saisis est incorrecte", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}catch (ContactManagerException e) 
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	private boolean checkfildes()
	{
		if (jFLogui.getText().equals(null) ||
				pFActPassword.getText().equals(null) 
				|| pFNewPassword.getText().equals(null)
				|| pFConfirm.getText().equals(null))
		{
			return false;
		}
		else 
		{
			return true ;
		}
	}
	public void display ()
	{
		this.setVisible(true);
	}

}
