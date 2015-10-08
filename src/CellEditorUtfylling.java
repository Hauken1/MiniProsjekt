import javax.swing.JComboBox;
import javax.swing.ListCellRenderer;

public class CellEditorUtfylling extends JComboBox {

	public CellEditorUtfylling() {
		for(int i = 0; i < Komponent.SKALERING.length; i++) {
			addItem(new Integer(i));
		}
	//	setRenderer((ListCellRenderer) new JComboBox());
	}
	
}
