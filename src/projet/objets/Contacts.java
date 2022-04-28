package projet.objets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// la classe contacts est un liste de contact 
public class Contacts implements Serializable  {

	private static final long serialVersionUID = -5324587547930513523L;
	private  List<Contact> liste;
		
	public Contacts() {		
			liste=new ArrayList<Contact>();
		}
	
	public List<Contact> getListe() {
		return liste;
	}
	
	public void setListe(List<Contact> liste) {
		this.liste = liste;
	}

	public Contacts(ArrayList<Contact> liste) 
	{
		super();
		this.liste = liste;
	}

	// cette fonction permet de ranger la liste des  contacts 
	public  void sort() {
		Collections.sort(liste);
	} 
	
	// cette fonction permet d'ajoutter un nouveau conatct dans la liste des contacts 
	public void add(Contact newContact) {	
		newContact.setIdentifiant(getMaxId()+1);
		liste.add(newContact);
	}
	// cette fonction permet de modifier conatct dans la liste des contacts 
	public void update (Contact contact){
		move(contact.getIdentifiant());
		liste.add(contact);
		sort();
	}
	

	// Recherche ub contact � partir de son identifiant 
	public Contact find(Integer identifant )
	{
		int i;
		for(i=0;i<liste.size();i++)
		{
			if(liste.get(i).getIdentifiant().equals(identifant))
			{
				return liste.get(i);
			}
		}
		return null;
		
	}
	// Recherche ub contact � partir de son nom 
	public Contact find(String nom )
	{
		int i;
		for(i=0;i<liste.size();i++)
		{
			if(liste.get(i).getNom().equals(nom))
			{
				return liste.get(i);
			}
		}
		return null;
		
	}
	
	// supprime un contact � partir de sont identifiant 
	public void move(Integer id )
	{
		int i;
	
		for(i=0;i<liste.size();i++)
		{
			if(liste.get(i).getIdentifiant().equals(id))
			{
				liste.remove(i);
			}
		}
			
	}
	// Determine le crit�re de recherche du contact (par son nom ou par sont Identifiant )
	public   <T> Contact  checkCritere(T critere ) 
	{
		if (critere instanceof String)
		{
			String nom=(String)critere;
			Contact c= find(nom);
			return  c;
		}else if (critere instanceof Integer)
		{
			Integer identifiant=(Integer)critere;
			Contact c= find(identifiant);
			return c;
		}
		return null;
	}
	
	
	// chercher l'id le plus elev� dans la liste des contacts 
	private int getMaxId()
	{
		if (liste.size()==0)
		{
			return 0;
		}
		sort();
		return liste.get(liste.size() -1).getIdentifiant();
	}
	
	
	

	
}
