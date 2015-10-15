import javax.swing.JComboBox;
/**
 * CellEditor for the "Utfylling" column
 * Adds items and sets renderer for the JComboBOx
 * @author Henrik Haukaas
 *
 */
public class CellEditorUtfylling extends JComboBox {
	/**
	 * Class constructor
	 * Adds all necessary items for showing in the JComboBOx
	 * and sets renderer
	 */
	public CellEditorUtfylling() {
		for(int i = 0; i < Komponent.SKALERING.length; i++) {
			addItem(new Integer(i));
		}
		setRenderer(new ComboBoxRendererUtfylling());
	}
}
