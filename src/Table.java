import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.text.NumberFormat;

import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.NumberFormatter;

public class Table extends JPanel {

	private JTable table; 
	private JPopupMenu popupMenu; 
	private final GridBagConstraints constraints;
	
	public Table(TableModel tableModel){
		super(new GridLayout(1,0));
		int n; 
		constraints = new GridBagConstraints(); 
		
		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(600,130));
		table.setFillsViewportHeight(true);
		
		for (n = 0; n < 3; ++n) {
            table.getColumnModel().getColumn(n).setMinWidth(100);
            table.getColumnModel().getColumn(n).setMaxWidth(120);
            table.getColumnModel().getColumn(n).setResizable(false);
            if (n == 0) {
            	 table.getColumnModel().getColumn(n).setCellRenderer(new ComboBoxRendererType());
            	 table.getColumnModel().getColumn(n).setCellEditor(new DefaultCellEditor(new CellEditorType())); 
            }
        }
        for (n = 3; n <= 6; ++n) {
            table.getColumnModel().getColumn(n).setMinWidth(60);
            table.getColumnModel().getColumn(n).setMaxWidth(60);
        }
        for (n = 7; n <= 8; ++n) {
        	 table.getColumnModel().getColumn(n).setMinWidth(105);
             table.getColumnModel().getColumn(n).setMaxWidth(105);
             table.getColumnModel().getColumn(n).setResizable(false);
             if (n == 7) {
            	 table.getColumnModel().getColumn(n).setCellRenderer(new ComboBoxRendererUtfylling());
            	 table.getColumnModel().getColumn(n).setCellEditor(new DefaultCellEditor(new CellEditorUtfylling()));
             } else if (n == 8) {
            	 table.getColumnModel().getColumn(n).setCellRenderer(new ComboBoxRendererForankring());
            	 table.getColumnModel().getColumn(n).setCellEditor(new DefaultCellEditor(new CellEditorForankring()));
             } 
        }
        table.setRowHeight(30);
        table.setAutoResizeMode(5);
        table.setSelectionMode(0);
        
        popupMenu = new JPopupMenu(); 
      	JMenuItem slettRad = new JMenuItem("Slett rad");
      	slettRad.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent e) {
      			tableModel.slettRad(table.getSelectedRow());
      		}
      	});
      	
      	JMenuItem editor = new JMenuItem("Egenskapseditor for valgt type (JTextField/JTextArea)");
      	editor.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent e) {
      			int t;
      			t = (int) tableModel.getValueAt(table.getSelectedRow(),0);
      			if (t == 1 || t == 2) {		//sjekker om det er JTextField eller JTextArea
      			
      			NumberFormat format = NumberFormat.getInstance(); 
      			NumberFormatter formatter = new NumberFormatter(format);
      			formatter.setValueClass(Integer.class);
      			formatter.setMinimum(0);
      			formatter.setMaximum(150);
      			formatter.setCommitsOnValidEdit(true);
      			
      			JFormattedTextField felt1 = new JFormattedTextField(formatter);
      			JFormattedTextField felt2 = new JFormattedTextField(formatter);
      			JFormattedTextField felt3 = new JFormattedTextField(formatter);
      			JFormattedTextField felt4 = new JFormattedTextField(formatter);
      			
      			Object[] felter = {
      				"Felt1", felt1,
      				"Felt2", felt2,
      				"Felt3", felt3
      			};
      			JOptionPane.showConfirmDialog(null, felter, "Velg attributter", JOptionPane.OK_CANCEL_OPTION);
      				/*
      			JOptionPane pane = new JOptionPane(getParent());
      			pane.setMessage("Heisann");
      			pane.isShowing();
      			//TODO DialogDemo eksempel 
      			Container popupRamme = new JOptionPane();
      			popupRamme = popupRamme.getParent();
      			tableModel.popupEditor(popupRamme, table.getSelectedRow());
      			*/
      				
      				
      			} else {
      			JOptionPane.showMessageDialog(getParent(), 
           				"Type må være satt til JTextField eller JTextArea");
      			}
      		}
      	});
      	
    	popupMenu.add(editor);
      	popupMenu.add(slettRad);
      
      	PopupMouseListener mListener = new PopupMouseListener(popupMenu);
      	table.addMouseListener(mListener);
      	
        JScrollPane ScrollPane = new JScrollPane(table);
        add(ScrollPane);
	}
	 public int getSelectedRow() {
	        return table.getSelectedRow();
	    }
	
	 public class PopupMouseListener extends MouseAdapter {
		JPopupMenu popup; 
		 
		PopupMouseListener(JPopupMenu popupMenu) {
			popup = popupMenu; 
		}
			
		public void mousePressed(MouseEvent e) {
			doEvent(e); 
		}
		public void mouseReleased(MouseEvent e) {
			doEvent(e);
					
		}
			
		private void doEvent(MouseEvent e) {
			if (e.isPopupTrigger() && table.getSelectedRow() > -1  ) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		}
		}
	 
}
