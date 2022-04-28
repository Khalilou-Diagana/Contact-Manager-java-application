 package projet.objets ;

import java.io.Serializable;

import projet.error.ContactManagerException;
import projet.uils.TestEmail;


public class Contact implements Serializable ,Comparable<Contact>{

	
	private static final long serialVersionUID = 5941510288487801758L;
	private Integer identifiant;
	private String nom;
	private String prenom;
	private int numeroTelephone;
	private String email;

	
	
	
	
	public Contact(String nom, String prenom, Integer numeroTelephone, String email) throws ContactManagerException {
		
		this.nom = nom;
		this.prenom = prenom;
		this.numeroTelephone=numeroTelephone;
		setEmail(email);
		
	}
	public Contact(int id ,String nom, String prenom, Integer numeroTelephone, String email) throws ContactManagerException {
		this(nom, prenom, numeroTelephone, email);
		this.setIdentifiant(id);
	}
	

	public Integer getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(Integer identifiant) {
		
		
			this.identifiant = identifiant;
		
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String presnom) {
		this.prenom = presnom;
	}


	public int getNumeroTelephone() {
		
		return numeroTelephone;
	}


	public void setNumeroTelephone(Integer numeroTelephone){
		
			this.numeroTelephone = numeroTelephone;
	
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) throws ContactManagerException {
		if(TestEmail.validate(email)==true)
		{
			this.email = email;
		}
		else 
		{
			throw new ContactManagerException("le format de votre email est invalide ");
		}
		
	}

	@Override
	public int compareTo(Contact contact) {
		
		 return this.identifiant.compareTo(contact.identifiant);
		
	}
	
	
}
