package projet.interf;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

import projet.error.ContactManagerException;
import projet.metier.Service;
import projet.objets.Contact;

import java.awt.Color;

public class  UpdateContactInt extends AbstractInt {

	
	private static final long serialVersionUID = -8375804301417104568L;
	public static String HEADER_lABEL="Modifier un Contact ";
	public static String TITLE="Modification  d'un Contact";
	private ListeInterface listeInterface;

	public UpdateContactInt(String hederLabel, String title) {
		super(hederLabel, title);
		
	}
	public UpdateContactInt() {
		super(HEADER_lABEL, TITLE);
		reset.setBorder(new LineBorder(new Color(0, 139, 139)));
		quitter.setBorder(new LineBorder(new Color(0, 139, 139)));
		valider.setBorder(new LineBorder(new Color(0, 139, 139)));
		quitter.setPreferredSize(new Dimension(80, 30));
		reset.setPreferredSize(new Dimension(80, 30));
		valider.setPreferredSize(new Dimension(80, 30));
		labelHeader.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelHeader.setIcon(new ImageIcon(UpdateContactInt.class.getResource("/pictures/update_contact.png")));
		
		
	}
	public UpdateContactInt(ListeInterface listeInterface) {
		
		this();
		this.listeInterface= listeInterface;	
	}
	@Override
	protected void onValiderClick() {
		try {
			if (ctrlChamp()==true)
			{
				checkPhoneNember();
				Service.updateContact(this.jFCarnet.getText(), new Contact(Integer.parseInt(jFIdentifiant.getText()),this.jFNom.getText(), this.jFPrenom.getText(), Integer.valueOf(this.jFTelephone.getText()), this.jFEmail.getText()));
				
				JOptionPane.showMessageDialog(null, "Modification d'un contact ", "Succés de l'opération ", JOptionPane.INFORMATION_MESSAGE);
				
				listeInterface.loead();
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "veuillez saisir tous les champs ", "saisi de champs ", JOptionPane.ERROR_MESSAGE);
				
			}
		}catch (ContactManagerException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Contact Manager Exception  ", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	// charge le nom du carnet et  les données du contact dans les champs de la fenetre UpdateContact 
	public void charge(Contact contact,String carnet) {
		jFCarnet.setText(carnet);
		jFNom.setText(contact.getNom());
		jFIdentifiant.setText(String.valueOf(contact.getIdentifiant()));
		jFPrenom.setText(contact.getPrenom());
		jFEmail.setText(contact.getEmail());
		jFTelephone.setText(String.valueOf(contact.getNumeroTelephone()));
		
		
	}


}
