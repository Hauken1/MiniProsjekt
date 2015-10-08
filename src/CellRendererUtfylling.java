import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CellRendererUtfylling extends JLabel implements TableCellRenderer {
	static ImageIcon ingen;
	static ImageIcon horisontalt; 
	static ImageIcon Vertikalt;
	static ImageIcon begge;
	
	public CellRendererUtfylling() {
		setOpaque(true); 
		ingen = new ImageIcon(getClass().getResource("Resources/NEW.GIF"));
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object object, boolean arg2, boolean arg3, int arg4,
			int arg5) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
