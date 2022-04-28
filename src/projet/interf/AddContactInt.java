package projet.interf;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import projet.error.ContactManagerException;
import projet.metier.Service;
import projet.objets.Contact;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class  AddContactInt extends AbstractInt {


	private static final long serialVersionUID = -3255504288648575664L;
	public static String HEADER_lABEL="Ajouter un Contact ";
	public static String TITLE="Ajout d'un Contact";

	public AddContactInt(String hederLabel, String title) {
		super(hederLabel, title);
		
	}
	public AddContactInt() {
		super(HEADER_lABEL, TITLE);
		reset.setPreferredSize(new Dimension(80, 30));
		quitter.setPreferredSize(new Dimension(80, 30));
		valider.setPreferredSize(new Dimension(80, 30));
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setHgap(10);
		labelHeader.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelHeader.setIcon(new ImageIcon(AddContactInt.class.getResource("/pictures/add_contact .png")));
		
		
	}
	@Override
	protected void onValiderClick() {
		
		try {
				if (ctrlChamp()==true)
				{
					checkPhoneNember();
					Service.addContact(this.jFCarnet.getText(), new Contact(this.jFNom.getText(), this.jFPrenom.getText(), Integer.valueOf(this.jFTelephone.getText()), this.jFEmail.getText()));
					
					JOptionPane.showMessageDialog(null, "Ajout d'un nouveau contact avec succés ", "Succés de l'opération ", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "veuillez saisir tous les champs ", "saisi de champs ", JOptionPane.ERROR_MESSAGE);
				}
			}catch (ContactManagerException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(), "Contact Manager Exception  ", JOptionPane.ERROR_MESSAGE);
			}
	}

}
