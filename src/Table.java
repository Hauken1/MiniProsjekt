import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table extends JPanel {

	private JTable table; 
	
	public Table(TableModel tableModel){
		
		int n; 
		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(700,70));
		table.setFillsViewportHeight(true);
		
		for (n = 0; n < 3; ++n) {
            this.table.getColumnModel().getColumn(n).setMinWidth(100);
        }
        for (n = 3; n < 6; ++n) {
            this.table.getColumnModel().getColumn(n).setMinWidth(60);
            this.table.getColumnModel().getColumn(n).setMaxWidth(60);
        }
        table.setRowHeight(20);
        table.setAutoResizeMode(0);
        table.setSelectionMode(0);
        JScrollPane ScrollPane = new JScrollPane(table);
        add(ScrollPane);
       
	}
}
