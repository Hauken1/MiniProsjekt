import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

class TableModel extends AbstractTableModel {
	private JLabel label; 	
	
		private String[] columnNames = {
				"Type",
				"Variablenavn",
				"Tekst",
				"Rad",
				"Kolonne",
				"Rader",
				"Kolonner",
				"Utfylling",
				"Forankring"};
		
		private Vector<Object> data = new Vector<Object>(); 
		private ArrayList<Object> list = new ArrayList<Object>();  
		
		public int getColumnCount() {
			return columnNames.length;
		}
		
		public String getColumnName(int col) {
			return columnNames[col];
		}
		
		@Override
		public int getRowCount() {
			// TODO Kun for data
			return data.size(); 
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Kun for data
			return null; 
		}
		
		public void setValueAt(Object object, int n) {
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
		}
		
		public void nyRad() {
			data.add(new KomponentJLabel("Ny" + data.size(), "", 1, 1, 1, 1));
			fireTableRowsInserted(data.size() - 1 , data.size() - 1);
		}
		
		public void nyTabell(){
			int n = data.size(); 
			data.removeAllElements();
			fireTableRowsDeleted(0,n);
		}
		public void flyttOpp() {
			
			
		}
		
		public void flyttNed() {
			
		}
		
		public void tilJavaKode(boolean n, File fil) {
			
		}
		
}
