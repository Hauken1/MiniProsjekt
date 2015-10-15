import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 * Class for Defining how the table should look like.
 * Sets custom renders and size of columns in the tabel. 
 * It also adds a popup menu with options for when the a row is right-clicked.
 * @author Henrik Haukaas
 *
 */
public class Table extends JPanel {
//VARIABLER-START
	private JTable table; 
	private JPopupMenu popupMenu; 
	private final GridBagConstraints constraints;
	private Internationalization inter = new Internationalization();
//VARIABLER-SLUTT
//FUNKSJONER-START
	/**
	 * Constructor for the table
	 * Makes a table out of the data model
	 * sets size of the columns.
	 * sets cellrenders and editors
	 * adds a mouseListener to the tabel for when it is right-clicked.
	 * Makes the "EgenskapsEditor" so the user can give inputs on how a
	 * JTextArea-or JTextField Komponent should look like when saved to a new layout.
	 * @param tableModel	Current data model
	 */
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
      	JMenuItem slettRad = new JMenuItem(inter.returnMessage("deleterow"));
      	slettRad.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent e) {
      			tableModel.slettRad(table.getSelectedRow());
      		}
      	});
      	
      	JMenuItem editor = new JMenuItem(inter.returnMessage("egenskap"));
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
      			
      				JTextField rader = new JTextField("0");
  					JTextField kolonner = new JTextField("0");
  					JTextField bredde = new JTextField("0");
  					JTextField hoyde = new JTextField("0");
      				
      				if ( t == 1) {		//JtextField
      					
      					JPanel editorPanel = new JPanel();
      					editorPanel.add(new JLabel(inter.returnMessage("antkol")));
      					editorPanel.add(kolonner);
      					editorPanel.add(new JLabel(inter.returnMessage("hoy")));
      					editorPanel.add(hoyde);
      					editorPanel.add(new JLabel(inter.returnMessage("bredde")));
      					editorPanel.add(bredde);
      					editorPanel.setLayout(new BoxLayout(editorPanel, BoxLayout.Y_AXIS));
      					
      					svar = JOptionPane.showConfirmDialog(null, editorPanel, inter.returnMessage("editnavn"), JOptionPane.OK_CANCEL_OPTION);
      					
      					if (svar == JOptionPane.OK_OPTION) {
          					
      						String textRader = rader.getText();
      						String textKolonner = kolonner.getText();
      						String textHoyde = hoyde.getText();
      						String textBredde = bredde.getText();
      						try {
      							n1 = Integer.parseInt(textRader);
      							n2 = Integer.parseInt(textKolonner);
      							n3 = Integer.parseInt(textHoyde);
      							n4 = Integer.parseInt(textBredde);
      							tableModel.popupEditor(n1, n2 , n3, n4, table.getSelectedRow());
      						} catch (Exception e1) {
      							JOptionPane.showMessageDialog(null, inter.returnMessage("bruktall"));
      						}
      					}
      				}
      				
      				if ( t == 2) {	//Hvis det er et JTextArea
      				
      					JPanel editorPanel = new JPanel();
      					editorPanel.add(new JLabel(inter.returnMessage("antrad")));
      					editorPanel.add(rader);
      					editorPanel.add(new JLabel(inter.returnMessage("antkol")));
      					editorPanel.add(kolonner);
      					editorPanel.setLayout(new BoxLayout(editorPanel, BoxLayout.Y_AXIS));
      				
      					svar = JOptionPane.showConfirmDialog(null, editorPanel, inter.returnMessage("editnavn2"), JOptionPane.OK_CANCEL_OPTION);
      				
      					if (svar == JOptionPane.OK_OPTION) {
      						try {
      							String textRader = rader.getText();
      							String textKolonner = kolonner.getText();
      							n1 = Integer.parseInt(textRader);
      							n2 = Integer.parseInt(textKolonner);
      							tableModel.popupEditor(n1, n2 , n3, n4, table.getSelectedRow());
      						} catch(Exception e1){
      							JOptionPane.showMessageDialog(null, inter.returnMessage("brukttall"));
      						} 
      					} 
      				}	
      			} else {
      			JOptionPane.showMessageDialog(getParent(), 
      					inter.returnMessage("edittest"));
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
	/**
	 * Gets selected row
	 * @return	returns selected row
	 */
	 public int getSelectedRow() {
	        return table.getSelectedRow();
	    }
	/**
	 * Class for the mouselistener of the Table class
	 * Shows the popup menu when a selected row is right-clicked
	 * @author Henrik Haukaas
	 *
	 */
	 public class PopupMouseListener extends MouseAdapter {
		JPopupMenu popup; 
		 /**
		  * Constructor for the PopupMouseListerner class
		  * makes popup equal to popupMenu made in the table Class
		  * @see private void doEvent(mouseEvent e)
		  * @param popupMenu
		  */
		PopupMouseListener(JPopupMenu popupMenu) {
			popup = popupMenu; 
		}
		//Allerede spesifisert i javadoc.	
		public void mousePressed(MouseEvent e) {
			doEvent(e); 
		}
		//Allerede spesifisert i javadoc.
		public void mouseReleased(MouseEvent e) {
			doEvent(e);
					
		}
		/**
		 * shows the popup menu when the selected row is right clicked
		 * @param e	mouseevent pressed/released
		 */
		private void doEvent(MouseEvent e) {
			if (e.isPopupTrigger() && table.getSelectedRow() > -1  ) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}
//FUNKSJONER-SLUTT	 
}//SLUTT TABLE
