import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
/**
 * Class that makes the TableModel for the table. 
 * This is where all all the tables data get stored. 
 * @author Henrik Haukaas
 */
class TableModel extends AbstractTableModel {
//VARIABLER-START 	
	private Internationalization inter = new Internationalization();
	
	private String[] columnNames = {
		inter.returnMessage("type"),
		inter.returnMessage("variableName"),
		inter.returnMessage("text"),
		inter.returnMessage("row"),
		inter.returnMessage("column"),
		inter.returnMessage("rows"),
		inter.returnMessage("columns"),
		inter.returnMessage("fill"),
		inter.returnMessage("anchor")};
		
	private Vector<Komponent> data = new Vector<Komponent>();   
//VARIABLER-SLUTT 	
	
//FUNKSJONER-START	
	//Allerede spesifisert i javadoc:
	public int getColumnCount() {
		return columnNames.length;
	}
	//Allerede spesifisert i javadoc:
	public String getColumnName(int col) {
		return columnNames[col];
	}
	//Allerede spesifisert i javadoc:
	@Override
	public int getRowCount() {
		return data.size(); 
	}
	//Allerede spesifisert i javadoc:
	@Override
	public Object getValueAt(int row, int col) {
        return ((Komponent) data.elementAt(row)).getKolonne(col);
           
    }
	//Allerede spesifisert i javadoc:
	public Class getColumnClass(int n) {
		return getValueAt(0, n).getClass();
	}
	//Allerede spesifisert i javadoc:
	public boolean isCellEditable(int n, int n2) {
		return true;
	 }
	//Allerede spesifisert i javadoc:
	//Setter medsendt komponent til riktig rad og kolonne
	public void setValueAt(Object object, int n, int n2) {
		((Komponent)data.elementAt(n)).setKolonne(n2, object);
		fireTableCellUpdated(n, n2);
	}
	/**
	 * Makes a new Komponent object into the data Vector
	 * and adds it to the TableModel. Updates the table afterwards. 
	 *   
	 */
	public void nyRad() {
		try {
		data.add(new Komponent("Rad" + data.size(), "Temp", 1, 1, 1, 1));
		fireTableRowsInserted(data.size() - 1 , data.size() - 1);
		} catch (Exception c2) {
			System.out.println(inter.returnMessage("feil"));
		}
	}
	/**
	 * Removes all the elements of the current data Vector. 
	 * Updates the table when elements is removed. 
	 */
	public void nyTabell(){
		int n = data.size(); 
		data.removeAllElements();
		fireTableRowsDeleted(0,n);
	}
	/**
	 * Takes the row currently selected, makes a temporary object of it,
	 * removes the row, and then inserts it one row higher in the table
	 * then it already was. 
	 * @param n	Row currently selected
	 */
	public void flyttOpp(int n) {
		if (n > 0 && n < data.size()) {
			Komponent temp = data.elementAt(n);	//Lager et temp object med dataen.
			slettRad(n);
			data.insertElementAt(temp, n - 1);	//Flytter raden opp
			fireTableRowsInserted(n - 1, n -1);	//Oppdaterer
		}
	}
	/**
	 * Takes the row currently selected, makes a temporary object of it,
	 * removes the row, and then inserts it one row lower in the table
	 * then it already was. 
	 * Updates the row afterwards.
	 * @param n	Row currently selected
	 */
	public void flyttNed(int n) {
		if ( n < data.size() - 1 ) {
			Komponent temp = data.elementAt(n);	//Lager et temp object med dataen.
			slettRad(n);
				data.insertElementAt(temp, n + 1);	//Flytter raden ned
				fireTableRowsInserted(n + 1, n + 1);	//Oppdaterer
		}
	}
	/**
	 * Removes the row currently selected.
	 * Updates the row afterwards.
	 * @param n	Row currently selected
	 */
	public void slettRad(int n) {
		data.removeElementAt(n);
		fireTableRowsDeleted(n,n);
	}
	/**
	 * Returns the data vector 
	 * Used when saving data to file. 
	 * @return data returns data vector
	 */
	public Object returnVector() {
		return data;
	}
	/**
	 * Sets a data vector to be equal as the @param newData 
	 * Used when loading data from file.
	 * @param newData	Data vector of some object
	 */
	public void setVector(Vector<Komponent> newData) {
		data = newData;
		for (int i=0; i<=data.size(); i++) {
			fireTableRowsInserted(i, i);
		}
	}
	/**
	 * Makes a a Komponent of the data of the row currently selected and 
	 * forward it to Komponent so that the data can be changed to the users preference.
	 * Updates the tablerow when changes has been made. 
	 * @param n1	user input with the number of rows of the current component
	 * @param n2	user input with the number of columns of the current component
	 * @param n3	user input with the height of the current component
	 * @param n4	user input with the width of the current component
	 * @param radnr	the row currently selected
	 */
	public void popupEditor(int n1, int n2, int n3, int n4, int radnr) {
		Komponent komponent = data.elementAt(radnr);
		komponent.egenskapsEditor(n1, n2, n3, n4);
		fireTableRowsUpdated(radnr, radnr);
	}		
//FUNKSJONER-SLUTT	
}//TableModel slutt
