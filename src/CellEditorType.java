import javax.swing.JComboBox;
/**
 * CellEditor for the "Type" column
 * Adds items and sets renderer for the JComboBOx
 * @author Henrik Haukaas
 *
 */
public class CellEditorType extends JComboBox {
	/**
	 * Class constructor
	 * Adds all necessary items for showing in the JComboBOx
	 * and sets renderer
	 */
	public CellEditorType() {
		for(int i = 0; i < Komponent.TYPE.length; i++) {
			addItem(new Integer(i));
		}
		setRenderer(new ComboBoxRendererType());
	}
}
