import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
/**
 * ComboBoxRendererForankring Class
 * Renders the JComboBox (list) and the cell (tablecell) for Forankring
 * @author Henrik Haukaas
 */
public class ComboBoxRendererForankring extends DefaultTableCellRenderer implements ListCellRenderer, TableCellRenderer  { 
//VARIABLER-START
	 static ImageIcon senter;
	 static ImageIcon nord;
	 static ImageIcon nordoest;
	 static ImageIcon oest;
	 static ImageIcon soeroest;
	 static ImageIcon soer;
	 static ImageIcon soervest;
	 static ImageIcon vest;
	 static ImageIcon nordvest;
//VARIABLER-SLUTT
//FUNKSJONER-START
	 /**
	  * Class constructor
	  * Initialize ImageIcons used for the list with images.
	  */
	public ComboBoxRendererForankring () {
		setOpaque(true);
		senter = new ImageIcon(this.getClass().getResource("Resources/anchor_center.png"));
        nord = new ImageIcon(this.getClass().getResource("Resources/anchor_north.png"));
        nordoest = new ImageIcon(this.getClass().getResource("Resources/anchor_northeast.png"));
        oest = new ImageIcon(this.getClass().getResource("Resources/anchor_east.png"));
        soeroest = new ImageIcon(this.getClass().getResource("Resources/anchor_southeast.png"));
        soer = new ImageIcon(this.getClass().getResource("Resources/anchor_south.png"));
        soervest = new ImageIcon(this.getClass().getResource("Resources/anchor_southwest.png"));
        vest = new ImageIcon(this.getClass().getResource("Resources/anchor_west.png"));
        nordvest = new ImageIcon(this.getClass().getResource("Resources/anchor_northwest.png"));
		
	}
	//Allerede spesifisert av JavaDoc
	 public Component getListCellRendererComponent(JList list, Object value, int n, boolean bl, boolean bl2) {
	        if (bl) {
	            setBackground(list.getSelectionBackground());
	        } else {
	            setBackground(list.getBackground());
	        }
	        if ((Integer)value == 0) {
	            setIcon(senter);
	        } else if ((Integer)value == 1) {
	            setIcon(nord);
	        } else if ((Integer)value == 2) {
	            setIcon(nordoest);
	        } else if ((Integer)value == 3) {
	            setIcon(oest);
	        } else if ((Integer)value == 4) {
	        	setIcon(soeroest);
	        } else if ((Integer)value == 5) {
	        	setIcon(soer);
	        } else if ((Integer)value == 6) {
	        	setIcon(soervest);
	        } else if ((Integer)value == 7) {
	        	setIcon(vest);
	        } else if ((Integer)value == 8) {
	        	setIcon(nordvest);
	        }
	        
	        setSize(100, 20);
	        return this;
	    }
	//Allerede spesifisert av JavaDoc
	 public Component getTableCellRendererComponent(JTable table, Object value, boolean b1, boolean b2, int row, int col) {
		
		 
		 if (b1 ) {
			 setBackground(table.getSelectionBackground());
		 } else {
			 setBackground(table.getBackground());
		 }
		 
		 if ((Integer)value == 0) {
			 setIcon(senter);
		 } else if ((Integer)value == 1) {
			 setIcon(nord);
		 } else if ((Integer)value == 2) {
			 setIcon(nordoest);
		 } else if ((Integer)value == 3) {
			 setIcon(oest);
		 } else if ((Integer)value == 4) {
			 setIcon(soeroest);
		 } else if ((Integer)value == 5) {
			 setIcon(soer);
		 } else if ((Integer)value == 6) {
			 setIcon(soervest);
		 } else if ((Integer)value == 7) {
			 setIcon(vest);
		 } else if ((Integer)value == 8) {
			 setIcon(nordvest);
		 }

		 return this; 	
	 }
//FUNKSJONER SLUTT	
} //SLUTT 
