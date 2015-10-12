import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

class TableModel extends AbstractTableModel {
	private JLabel label;
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
		//private ArrayList<Object> list = new ArrayList<Object>();  
		
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
            return ((Komponent) data.elementAt(row)).getKolonne(col);
           
        }
		
		public Class getColumnClass(int n) {
	        return getValueAt(0, n).getClass();
	    }
		
		 public boolean isCellEditable(int n, int n2) {
		        return true;
		    }
		
		public void setValueAt(Object object, int n, int n2) {
	
			((Komponent)this.data.elementAt(n)).setKolonne(n2, object);
			fireTableCellUpdated(n, n2);
			
			//data.setElementAt(object, n);
			/*
			switch(n) {
			case 0 : {
				//label = new JLabel().data.elementAt(n)); 
				data.setElementAt(object, n);
				break;
			}
			case 1 : {
				label = new JLabel(); 
				data.setElementAt(object, n);
			}
			}
			*/
		
		}
		
		public void nyRad() {
			data.add(new KomponentJLabel("Rad " + data.size(), "Temp", 1, 1, 1, 1));
			fireTableRowsInserted(data.size() - 1 , data.size() - 1);
		}
		
		public void nyTabell(){
			int n = data.size(); 
			data.removeAllElements();
			fireTableRowsDeleted(0,n);
		}
		
		public void flyttOpp(int n) {
			if (n > 0 && n < data.size()) {
				Komponent temp = data.elementAt(n);	//Lager et temp object med dataen.
				slettRad(n);
				data.insertElementAt(temp, n - 1);	//Flytter raden opp
				fireTableRowsInserted(n - 1, n -1);	//Oppdaterer
			}
			
		}
		
		public void flyttNed(int n) {
			if ( n < data.size() - 1 ) {
				Komponent temp = data.elementAt(n);	//Lager et temp object med dataen.
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
		
		public void setVector(Vector<Komponent> newData) {
			data = newData;
			for (int i=0; i<=data.size(); i++) {
				fireTableRowsInserted(i, i);
			}
		}
}
