import javax.swing.JComboBox;
/**
 * CellEditor for the "Forankring" column
 * Adds items and sets renderer for the JComboBox
 * @author Henrik Haukaas
 *
 */
public class CellEditorForankring extends JComboBox {
	/**
	 * Class constructor
	 * Adds all necessary items for showing in the JComboBOx
	 * Sets renderer
	 */
	public CellEditorForankring() {
		for(int i = 0; i < Komponent.FORANKRING.length; i++) {
			addItem(new Integer(i));
		}
		setRenderer(new ComboBoxRendererForankring());
	}
}
