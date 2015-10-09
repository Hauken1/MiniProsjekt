import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ComboBoxRendererUtfylling extends JLabel implements ListCellRenderer, TableCellRenderer  {

	static ImageIcon ingen;
    static ImageIcon horisontalt;
    static ImageIcon vertikalt;
    static ImageIcon begge;
	
    public ComboBoxRendererUtfylling() {
        setOpaque(true);
        ingen = new ImageIcon(this.getClass().getResource("Resources/skaler_ingen.png"));
        horisontalt = new ImageIcon(this.getClass().getResource("Resources/skaler_horisontalt.png"));
        vertikalt = new ImageIcon(this.getClass().getResource("Resources/skaler_vertikalt.png"));
        begge = new ImageIcon(this.getClass().getResource("Resources/skaler_begge.png"));
    }
    
	 public Component getListCellRendererComponent(JList jList, Object object, int n, boolean bl, boolean bl2) {
	        if (bl) {
	            this.setBackground(jList.getSelectionBackground());
	        } else {
	            this.setBackground(jList.getBackground());
	        }
	        if ((Integer)object == 0) {
	            setIcon(ingen);
	        } else if ((Integer)object == 1) {
	            setIcon(horisontalt);
	        } else if ((Integer)object == 2) {
	            setIcon(vertikalt);
	        } else if ((Integer)object == 3) {
	            setIcon(begge);
	        }
	        setSize(100, 20);
	        return this;
	    }
	 
	 public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int n, int n2) {
	        if (bl) {
	            this.setBackground(jTable.getSelectionBackground());
	        } else {
	            this.setBackground(jTable.getBackground());
	        }
	        if ((Integer)object == 0) {
	            this.setIcon(ingen);
	        } else if ((Integer)object == 1) {
	            this.setIcon(horisontalt);
	        } else if ((Integer)object == 2) {
	            this.setIcon(vertikalt);
	        } else if ((Integer)object == 3) {
	            this.setIcon(begge);
	        }
	        setSize(100,20);
	        return this; 
	        }

}
