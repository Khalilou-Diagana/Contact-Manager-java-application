package projet.objets;



import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


import javax.swing.table.AbstractTableModel;








public  class ContactModel extends  AbstractTableModel{
	
	private static final long serialVersionUID = -8737034386194311514L;
	public static final int OBJECT_COL=-1;
	public static final int ID_COL=0;
	
	protected  Vector<Object[]> rows= new Vector<>();
	protected List<Contact> contacts =new ArrayList<>();
	
	private String[] nomColoms= {"IDENTIFIANT","NOM","PRENOM","TELEPHONE","EMAIL"};
	
	 public Vector<Object[]> getRows() {
		return rows;
	}
	public void setRows(Vector<Object[]> rows) {
		this.rows = rows;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public String[] getNomColoms() {
		return nomColoms;
	}
	public void setNomColoms(String[] nomColoms) {
		this.nomColoms = nomColoms;
	}
	public   ContactModel() {
		
	}

	
	public void loadData(List<Contact> contacts)
	{
		rows.clear();
		this.contacts.clear();
		this.contacts.addAll(0,contacts);
		for (Contact contact : contacts)
		{
			rows.add(new Object[] {
					contact.getIdentifiant(),
					contact.getNom(),
					contact.getPrenom(),
					contact.getNumeroTelephone(),
					contact.getEmail()
			});
		}
		fireTableDataChanged();	
	}
	
	public void load(Contact contact)
	{
		rows.clear();
		this.contacts.clear();
		//this.contacts.addAll(0,contact);
		
			rows.add(new Object[] {
					contact.getIdentifiant(),
					contact.getNom(),
					contact.getPrenom(),
					contact.getNumeroTelephone(),
					contact.getEmail()
			});
		
		fireTableDataChanged();	
	}
	
	

	public void clear()
	{
		rows.clear();
		this.contacts.clear();
		
		
		fireTableDataChanged();
	}
	
	

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return nomColoms[columnIndex];
	}

	
	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public int getColumnCount() {
		return nomColoms.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case OBJECT_COL: return contacts.get(rowIndex);
			
		default: return rows.get(rowIndex)[columnIndex];		
		}
	}

	
	
}
