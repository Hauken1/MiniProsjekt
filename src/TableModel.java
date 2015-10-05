import javax.swing.table.AbstractTableModel;

class TableModel extends AbstractTableModel {
		
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
		
		public int getColumnCount() {
			return columnNames.length;
		}
		
		public String getColumnName(int col) {
			return columnNames[col];
		}
		
		@Override
		public int getRowCount() {
			// TODO Kun for data
			return 0;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Kun for data
			return null;
		}
		
	/*	public void nyRad() {
			componentJLabel nyRad = new KomponentJLabel(); 
		}
		*/
}
