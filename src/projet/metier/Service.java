package projet.metier;

import java.util.List;

import projet.error.ContactManagerException;
import projet.objets.Contact;
import projet.uils.Manager;


// la classe des services 
public class Service {
	
	// cette classe n'est pas instanciable 
	private Service() {}
	
	// creer  un nouveau carnet 
	/*
	 * au niveau de la creation d'un nouveau carnet il faut obligatoirement que celui-ci contienne au moins un contact 
	 */
	public static void createNewFile(String fileName,Contact contact) throws ContactManagerException
	{
		Manager.add(contact, fileName);
	}
	
	// 	ajouter un contact contact dans le carnet du choix
	public static void addContact(String fileName,Contact contact) throws ContactManagerException
	{
		
		Manager.addContact(contact, fileName);
	}
	//Modifier d'un contact de d'un carnet du carnet donné en parametre 
	public static void updateContact(String fileName,Contact contact) throws ContactManagerException
	{
		Manager.updateContact(fileName, contact);
	}
	// supprimer un contact du carnet de votre choix 
	public static void deleteContact(String fileName, Contact contact ) throws ContactManagerException
	{
		Manager.deleteContact(fileName, contact.getIdentifiant());
	}
	//rechercher un contact par le criter fourni en parametre ( nom ou identifiant )
	public static <T> Contact SearcheContact(T critere,String fileName ) throws ContactManagerException
	{
		Contact contact=Manager.SearchContact(critere, fileName);
		if (contact == null)
		{
			throw new ContactManagerException("le contact que vous cherchez est introuvable");
		}
		return contact;
	}
	//returne la liste des contacts d'un carnet donné 
	public static List<Contact> lister(String fileName) throws ContactManagerException
	{
		return Manager.list(fileName);
		
	}
	
}
