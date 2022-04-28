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

public class  NoteBooktInt extends AbstractInt {



	private static final long serialVersionUID = 7168638560376418021L;
	public static String HEADER_lABEL="Créer un nouveau carnet  ";
	public static String TITLE="Creation d'un nouveau carnet ";

	public NoteBooktInt(String hederLabel, String title) {
		super(hederLabel, title);
		
	}
	public NoteBooktInt() {
		super(HEADER_lABEL, TITLE);
		reset.setBorder(new LineBorder(new Color(0, 139, 139)));
		quitter.setBorder(new LineBorder(new Color(0, 139, 139)));
		valider.setBorder(new LineBorder(new Color(0, 139, 139)));
		reset.setPreferredSize(new Dimension(80, 30));
		quitter.setPreferredSize(new Dimension(80, 30));
		valider.setPreferredSize(new Dimension(80, 30));
		labelHeader.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelHeader.setIcon(new ImageIcon(NoteBooktInt.class.getResource("/pictures/new_book.png")));
			
	}
	@Override
	protected void onValiderClick() {
		try 
		{
			if(ctrlChamp()==true)
			{
				checkPhoneNember();
				Service.createNewFile(this.jFCarnet.getText(), new Contact(this.jFNom.getText(), this.jFPrenom.getText(), Integer.valueOf(this.jFTelephone.getText()), this.jFEmail.getText()));
				
				JOptionPane.showMessageDialog(null, "Creation du carnet avec succés ", "Succés de l'opération ", JOptionPane.INFORMATION_MESSAGE);
				onResetClick();
			}
			else {
				JOptionPane.showMessageDialog(null, "veuillez saisir tous les champs ", "saisi de champs ", JOptionPane.ERROR_MESSAGE);
			}
		}catch (ContactManagerException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Contact Manager Exception  ", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}
	


}
