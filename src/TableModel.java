import java.util.Vector;

import javax.swing.JLabel;
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
		
		private Vector data = new Vector(); 
		
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
				label = new JLabel(); 
				data.setElementAt(label, n);
				break;
			}
			case 1 : {
				label = new JLabel(); 
				data.setElementAt(label, n);
			}
			}
		}
		
		public void nyRad() {
		}
		
		public void flyttOpp() {
			
			
		}
		
		public void flyttNed() {
			
		}
}
