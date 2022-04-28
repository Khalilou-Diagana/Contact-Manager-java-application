package projet.uils;




import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;


import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;




public class Utilitaire {
	
	// adapte la fenetre a celui du system d'exploitation 
	public static void setLockAndFeel(Component component)
	{
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//elle force le composant de la fenetre a appeler sa methode updateUI
			SwingUtilities.updateComponentTreeUI(component);
			
		}catch (InstantiationException |ClassNotFoundException |UnsupportedLookAndFeelException | IllegalAccessException e) {
			
			System.err.println("error while setting Lock and Feel");
		}
	}
	// centrer la fenetre 
	public static void center (Component component)
	{
		Dimension screnSize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=component.getPreferredSize();
		
		if(frameSize.height > screnSize.height)
			frameSize.height=screnSize.height;
		
		if(frameSize.width > screnSize.width)
			frameSize.width = screnSize.width;
		
		
		component.setLocation((screnSize.width - frameSize.width) /2,(screnSize.height -frameSize.height)/2);
	}
	
	//Quitter une fenetre avec confirmation 
	public static void exitWithConfirmation (Window window,String message)
	{
		if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(null, message))
		{
			window.dispose();
		}
	}

}
