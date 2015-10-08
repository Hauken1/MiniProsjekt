import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table extends JPanel {

	private JTable table; 
	
	public Table(TableModel tableModel){
		super(new GridLayout(1,0));
		int n; 
		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(700,100));
		table.setFillsViewportHeight(true);
		
		for (n = 0; n < 3; ++n) {
            this.table.getColumnModel().getColumn(n).setMinWidth(100);
        }
        for (n = 3; n < 8; ++n) {
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
