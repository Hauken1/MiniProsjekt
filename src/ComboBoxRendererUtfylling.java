import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRendererUtfylling extends JLabel implements ListCellRenderer  {

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

}
