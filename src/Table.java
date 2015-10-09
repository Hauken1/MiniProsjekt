import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Table extends JPanel {

	private JTable table; 
	private final GridBagConstraints constraints;
	
	public Table(TableModel tableModel){
		super(new GridLayout(1,0));
		int n; 
		constraints = new GridBagConstraints(); 
		
		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(600,130));
		table.setFillsViewportHeight(true);
	//	table.getColumnModel().getColumn(n).setCellEditor(new DefaultCellEditor());
		
		for (n = 0; n < 3; ++n) {
            table.getColumnModel().getColumn(n).setMinWidth(100);
            table.getColumnModel().getColumn(n).setMaxWidth(120);
            
        }
        for (n = 3; n <= 6; ++n) {
            table.getColumnModel().getColumn(n).setMinWidth(60);
            table.getColumnModel().getColumn(n).setMaxWidth(60);
        }
        for (n = 7; n <= 8; ++n) {
        	 table.getColumnModel().getColumn(n).setMinWidth(90);
             table.getColumnModel().getColumn(n).setMaxWidth(90);
             table.getColumnModel().getColumn(n).setResizable(false);
             if (n == 7) {
            	 table.getColumnModel().getColumn(n).setCellRenderer(new CellRendererUtfylling());
            	 table.getColumnModel().getColumn(n).setCellEditor(new DefaultCellEditor(new CellEditorUtfylling()));
             }
        }
        table.setRowHeight(30);
        table.setAutoResizeMode(5);
        table.setSelectionMode(0);
        JScrollPane ScrollPane = new JScrollPane(table);
        add(ScrollPane);
	}
	 public int getSelectedRow() {
	        return table.getSelectedRow();
	    }
}
