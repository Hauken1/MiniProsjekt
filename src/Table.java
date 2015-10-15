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

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
      			int n1 = 0;
      			int n2 = 0;
      			int n3 = 0;
      			int n4 = 0;
      			int svar;
      			
      			t = (int) tableModel.getValueAt(table.getSelectedRow(),0);
      			if (t == 1 || t == 2) {		//sjekker om det er JTextField eller JTextArea
      			
      				JTextField rader = new JTextField(10);
  					JTextField kolonner = new JTextField(10);
  					JTextField bredde = new JTextField(10);
  					JTextField hoyde = new JTextField(10);
      				
      				if ( t == 1) {		//JtextField
      					
      					JPanel editorPanel = new JPanel();
      					editorPanel.add(new JLabel("Antall rader:"));
      					editorPanel.add(rader);
      					editorPanel.add(new JLabel("Antall kolonner:"));
      					editorPanel.add(kolonner);
      					editorPanel.add(new JLabel("Angi hoyde:"));
      					editorPanel.add(hoyde);
      					editorPanel.add(new JLabel("Angi Bredde:"));
      					editorPanel.add(bredde);
      					editorPanel.setLayout(new BoxLayout(editorPanel, BoxLayout.Y_AXIS));
      					
      					svar = JOptionPane.showConfirmDialog(null, editorPanel, "Skriv inn attributter for valgt JTextField", JOptionPane.OK_CANCEL_OPTION);
      					
      					if (svar == JOptionPane.OK_OPTION) {
          					
      						String textRader = rader.getText();
      						String textKolonner = kolonner.getText();
      						String textHoyde = hoyde.getText();
      						String textBredde = bredde.getText();
      						
      						n1 = Integer.parseInt(textRader);
      						n2 = Integer.parseInt(textKolonner);
      						n3 = Integer.parseInt(textHoyde);
      						n4 = Integer.parseInt(textBredde);
      						tableModel.popupEditor(n1, n2 , n3, n4, table.getSelectedRow());
      					}
      				}
      				
      				if ( t == 2) {	//Hvis det er et JTextArea
      				
      					JPanel editorPanel = new JPanel();
      					editorPanel.add(new JLabel("Antall rader:"));
      					editorPanel.add(rader);
      					editorPanel.add(new JLabel("Antall kolonner:"));
      					editorPanel.add(kolonner);
      					editorPanel.setLayout(new BoxLayout(editorPanel, BoxLayout.Y_AXIS));
      				
      					svar = JOptionPane.showConfirmDialog(null, editorPanel, "Skriv inn attributter for valgt JTextArea", JOptionPane.OK_CANCEL_OPTION);
      				
      					if (svar == JOptionPane.OK_OPTION) {
      					
      						String textRader = rader.getText();
      						String textKolonner = kolonner.getText();
      						n1 = Integer.parseInt(textRader);
      						n2 = Integer.parseInt(textKolonner);
      						tableModel.popupEditor(n1, n2 , n3, n4, table.getSelectedRow());
      					} 
      				}	
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
