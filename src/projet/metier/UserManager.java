package projet.metier;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import projet.error.ContactManagerException;
import projet.objets.User;

public class UserManager {
	private static final String USER_MANAGER= "UserManager.txt";
	private UserManager() {}
	
	public static   void serialise (User user) throws ContactManagerException
	{
		try (FileOutputStream foos=new FileOutputStream(USER_MANAGER) ;
				ObjectOutputStream oss=new  ObjectOutputStream(foos))
		{
			oss.writeObject(user);
		}catch ( IOException e)
		{
			throw new ContactManagerException(e.getMessage());
		}
		
	}
	public   static User  deserialise () throws ContactManagerException
	{
		
		try (FileInputStream foss=new FileInputStream(USER_MANAGER);
				ObjectInputStream oss=new ObjectInputStream(foss))
		{
			User user=( (User)oss.readObject());
			return user;
			
		}catch (IOException | ClassNotFoundException  e) {
			throw new ContactManagerException(e.getMessage());
		}
	}
	
	public static void update(User us) throws ContactManagerException
	{
		User user=deserialise();
		user.setPassword(us.getPassword());
		user.setUsername(us.getUsername());
		serialise(user);
	}
	
	public static boolean checkUser(String us,String psswd) throws ContactManagerException
	{
		User user=deserialise();
		if (user.getUsername().equals(us) && user.getPassword().equals(psswd))
		{
			return true ;
		}else 
		{
			return false ;
		}
	}
}
