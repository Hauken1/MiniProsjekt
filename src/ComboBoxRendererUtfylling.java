import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
/**
 * ComboBoxRendererUtfylling Class
 * Renders the JComboBox (list) and the cell (tablecell) for Utfylling
 * @author Henrik Haukaas
 */
public class ComboBoxRendererUtfylling extends DefaultTableCellRenderer implements ListCellRenderer, TableCellRenderer  {
//VARIABLER-START
	static ImageIcon ingen;
    static ImageIcon horisontalt;
    static ImageIcon vertikalt;
    static ImageIcon begge;
//VARIABLER-SLUTT
//FUNKSJONER-START	
    /**
     * Class constructor
     * Initialize ImageIcons used for the list with images.
     */
    public ComboBoxRendererUtfylling() {
        setOpaque(true);
        ingen = new ImageIcon(this.getClass().getResource("Resources/skaler_ingen.png"));
        horisontalt = new ImageIcon(this.getClass().getResource("Resources/skaler_horisontalt.png"));
        vertikalt = new ImageIcon(this.getClass().getResource("Resources/skaler_vertikalt.png"));
        begge = new ImageIcon(this.getClass().getResource("Resources/skaler_begge.png"));
    }
    //Allerede spesifisert av JavaDoc:
	 public Component getListCellRendererComponent(JList list, Object value, int n, boolean bl, boolean bl2) {
	        if (bl) {
	            setBackground(list.getSelectionBackground());
	        } else {
	            setBackground(list.getBackground());
	        }
	        if ((Integer)value == 0) {
	            setIcon(ingen);
	        } else if ((Integer)value == 1) {
	            setIcon(horisontalt);
	        } else if ((Integer)value == 2) {
	            setIcon(vertikalt);
	        } else if ((Integer)value == 3) {
	            setIcon(begge);
	        }
	        
	        setSize(100, 20);
	        return this;
	  }
	//Allerede spesifisert av JavaDoc:
	 public Component getTableCellRendererComponent(JTable table, Object value, boolean b1, boolean b2, int row, int col) {
		
		 setOpaque(true);
		 
		 if (b1 ) {
			 setBackground(table.getSelectionBackground());
		 } else {
			 setBackground(table.getBackground());
		 }
		 
		    if ((Integer)value == 0) {
	            setIcon(ingen);
	        } else if ((Integer)value == 1) {
	            setIcon(horisontalt);
	        } else if ((Integer)value == 2) {
	            setIcon(vertikalt);
	        } else if ((Integer)value == 3) {
	            setIcon(begge);
	        }
		    
		return this; 
	  }
//FUNKSJONER-SLUTT
} //SLUTT