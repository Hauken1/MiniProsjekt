import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;

public class GridBagFrame extends JFrame 
{
	
	private final GridBagLayout layout; // layout of this frame
	private final GridBagConstraints constraints; // layout's constraints
	
	// set up GUI
	public GridBagFrame()
	{
		super("GridBagLayout");
		layout = new GridBagLayout(); //Initiate layout
		setLayout(layout);
		constraints = new GridBagConstraints(); // instantiate constraints
	     
		//Create GUI-Components (tables, toolbar, meny, m.m)
	     JTable table = new JTable(new TableModel());
	     table.setPreferredScrollableViewportSize(new Dimension(500,70));
	     table.setFillsViewportHeight(true);
	     
	     JScrollPane scrollPane = new JScrollPane(table);
	     
	     //
	     constraints.weightx = 1;
	     constraints.weighty = 1;  
	     constraints.fill = GridBagConstraints.BOTH;
	     constraints.gridwidth = GridBagConstraints.REMAINDER;
	     addComponent(scrollPane);
	     
	} // end GridBagFrame constructor
	 
	// add a component to the container
	private void addComponent(Component component) 
	{
		layout.setConstraints(component, constraints);
	    add(component); // add component
	} 
	
	//Constructor for JTable
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
	
	
	}
	 
} // end class GridBagFrame