package ObjectsForTest;
import java.awt.Container;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class TableModelTest extends AbstractTableModel {
	private JLabel label;
	private InternationalizationTest inter = new InternationalizationTest();
	
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
		
		private Vector<KomponentTest> data = new Vector<KomponentTest>();   
		
		public int getColumnCount() {
			return columnNames.length;
		}
		
		public String getColumnName(int col) {
			return columnNames[col];
		}
		
		@Override
		public int getRowCount() {
			return data.size(); 
		}

		@Override
		public Object getValueAt(int row, int col) {
            return ((KomponentTest) data.elementAt(row)).getKolonne(col);
           
        }
		
		public Class getColumnClass(int n) {
	        return getValueAt(0, n).getClass();
	    }
		
		 public boolean isCellEditable(int n, int n2) {
		        return true;
		    }
		
		public void setValueAt(Object object, int n, int n2) {
			((KomponentTest)this.data.elementAt(n)).setKolonne(n2, object);
			fireTableCellUpdated(n, n2);
		}
		
		public void nyTabell(){
			int n = data.size(); 
			data.removeAllElements();
			fireTableRowsDeleted(0,n);
		}
		
		public void flyttOpp(int n) {
			if (n > 0 && n < data.size()) {
				KomponentTest temp = data.elementAt(n);	//Lager et temp object med dataen.
				slettRad(n);
				data.insertElementAt(temp, n - 1);	//Flytter raden opp
				fireTableRowsInserted(n - 1, n -1);	//Oppdaterer
			}
		}
		
		public void flyttNed(int n) {
			if ( n < data.size() - 1 ) {
				KomponentTest temp = data.elementAt(n);	//Lager et temp object med dataen.
				slettRad(n);
				data.insertElementAt(temp, n + 1);	//Flytter raden ned
				fireTableRowsInserted(n + 1, n + 1);	//Oppdaterer
			}
		}
		
		public void slettRad(int n) {
			data.removeElementAt(n);
			fireTableRowsDeleted(n,n);
		}
		
		public void tilJavaKode(boolean n, File fil) {
		}
		
		public Object returnVector() {
			return data;
		}
		
		public void setVector(Vector<KomponentTest> newData) {
			data = newData;
			for (int i=0; i<=data.size(); i++) {
				fireTableRowsInserted(i, i);
			}
		}
		
		public void popupEditor(Container editor, int n) {
		}
		
		public void append(KomponentTest komponent) {
			data.add(komponent);
		}
		
		public void saveToFile(ObjectOutputStream oos) throws IOException {
	        oos.writeObject(data);
	    }

	    public void loadFromFile(ObjectInputStream ois) throws IOException,
	            ClassNotFoundException {
	        data = (Vector<KomponentTest>) ois.readObject();
	    }
}