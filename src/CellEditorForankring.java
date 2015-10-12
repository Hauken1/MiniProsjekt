import javax.swing.JComboBox;

public class CellEditorForankring extends JComboBox {

	public CellEditorForankring() {
		for(int i = 0; i < Komponent.FORANKRING.length; i++) {
			addItem(new Integer(i));
		}
		setRenderer(new ComboBoxRendererForankring());
	}
}
