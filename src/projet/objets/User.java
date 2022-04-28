package projet.objets;

import java.io.Serializable;
// cette classe permet de modeliser le manager de l'application  
public class User implements Serializable{
	
	private static final long serialVersionUID = 5230659682335790361L;
	private String  username;
	private String password;
	
	public User(String username,String psswd)
	{
		this.username=username;
		this.password=psswd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}





