import javax.swing.JComboBox;

public class CellEditorType extends JComboBox {

	public CellEditorType() {
		for(int i = 0; i < Komponent.TYPE.length; i++) {
			addItem(new Integer(i));
		}
		setRenderer(new ComboBoxRendererType());
	}
}
