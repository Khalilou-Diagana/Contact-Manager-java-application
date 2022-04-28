 package projet.uils;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;



import projet.error.ContactManagerException;
import projet.objets.Contact;
import projet.objets.Contacts;

public class Manager implements Serializable{
	
	

	
	
	private static final long serialVersionUID = 2064243589565990260L;
	private static Contacts liste=new Contacts();
	
	
	// serialise la liste des contacts dans un fichier donné en parametre 
	private static void serialise (String fileName) throws ContactManagerException
	{
		try (FileOutputStream foos=new FileOutputStream(fileName) ;
				ObjectOutputStream oss=new  ObjectOutputStream(foos))
		{
			oss.writeObject(getListe());
		}catch ( IOException e)
		{
			throw new ContactManagerException(e.getMessage());
		}
		
	}
	// deserialise la liste des contacts dans un fichier donné en parametre 
	private static  Contacts  deserialise (String fileName) throws ContactManagerException
	{
		
		try (FileInputStream foss=new FileInputStream(fileName);
				ObjectInputStream oss=new ObjectInputStream(foss))
		{
			setListe( (Contacts)oss.readObject());
			return liste;
			
		}catch (IOException | ClassNotFoundException  e) {
			throw new ContactManagerException(e.getMessage());
		}
	}
	// donne l'extension .ser aux fichiers 
	public static String PointSer(String fileName)
	{
		return fileName+=".ser";
	}
	
	public static Contacts getListe() {
		return liste;
	}

	public static void setListe(Contacts liste) {
		Manager.liste = liste;
	}
	
	//ajout un contact dans un fichier(carnet ) déjà existant  
	public static  void  addContact(Contact contact,String fileName) throws ContactManagerException
	{	
		fileName=PointSer(fileName);
		liste=deserialise(fileName);
		liste.add(contact);
		serialise(fileName);
		
	}
	// ajouter un nouveau contact à un nouveau fichier ( carnet de contact  ) 
	// creation d'un nouveau carnet 
	public  static void  add(Contact contact,String fileName) throws ContactManagerException

	{
		fileName=PointSer(fileName);
		
		liste.add(contact);
		serialise(fileName);
		
		
	}
	
	
	//Supprimer un contact du carnet 
	public static  void deleteContact(String fileName,Integer  identifiant ) throws ContactManagerException
	{
		fileName=PointSer(fileName);
		liste=deserialise(fileName);
		if (liste.find(identifiant)==null)
		{
			throw new ContactManagerException("le contact que vous tentez de supprimer n'existe pas ");
		}
		liste.move(identifiant);
		serialise(fileName);
	}
	
	// Modifier un contact du carnet 
	public static void updateContact(String fileName,Contact contact) throws ContactManagerException
	{
		fileName=PointSer(fileName);
		liste=deserialise(fileName);
		liste.sort();
		if (liste.find(contact.getIdentifiant())==null)
		{
			throw new ContactManagerException("le contact que vous tentez de modifier n'existe pas ");
		}
		
		liste.update(contact);
		serialise(fileName);
	}
	

	// cherche un contact selon le critère fourni en parametre (String : nom) ou (Integer : identifiant )
	public static <T> Contact SearchContact(T critere ,String fileName) throws ContactManagerException
	{
		fileName=PointSer(fileName);
		liste=deserialise(fileName);
		Contact contact=liste.checkCritere(critere);
		serialise(fileName);
		return contact;
	}
	//Permet de lister les contats d'un carnet (retourne la liste des contacts enregistré dans le fichier 
	public static List<Contact> list(String fileName) throws ContactManagerException
	{
		fileName=PointSer(fileName);
		Contacts contacts=deserialise(fileName);
		return contacts.getListe();
	}
	
	
	
}
