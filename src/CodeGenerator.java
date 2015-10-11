import java.io.FileNotFoundException;
import java.util.Formatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class CodeGenerator {

	private Formatter output;
	private FileChooser file;
	
	
	public CodeGenerator() {
		file = new FileChooser();
	}
	/**
	 * Open file to write too
	 */
	public void openFile() {
		try {
			output = new Formatter(file.saveLayoutAtPath().toString());
		} catch (SecurityException se) {
			System.err.println("Write permisson denied.");
		} catch (FileNotFoundException f) {
			System.err.println("Error opening file");
		}
	}
	
	public void javaSourceCodeToFile() {
		output.format("import javax.swing.*;"
					+ "\nimport java.awt.*;"
					+ "\n/**\n* Code generated from GridBagLayout Editor\n*/" 
					+ "\npublic class GridBagPanel extends JPanel {"
					+ "\n\tJLabel ny0 = new JLabel (\"Test om dette fungerer\");" 
					+ "\n\n\tpublic GridBagPanel () {"
					+ "\n\t  GridBagLayout layout = new GridBagLayout();" 
					+ "\n\t  GridBagConstraints gbc = new GridBagConstraints();"
					+ "\n\t  setLayout(layout);" 
					+ "\n\t  gbc.gridx = 1;"
					+ "\n\t  gbc.gridy = 1;" 
					+ "\n\t  gbc.gridwidth = 1;"
					+ "\n\t  gbc.gridheight = 1;" 
					+ "\n\t  gbc.anchor = java.awt.GridBagConstraints.CENTER;"
					+ "\n\t  gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;" 
					+ "\n\t  layout.setConstraints (ny0, gbc);"
					+ "\n\t  add (ny0);" 
					+ "\n\t}"
					+ "\n\n\tstatic public void main(String[] args) {" 
					+ "\n\t  JFrame app = new JFrame(\"Simple Stuff\");"
					+ "\n\t  GridBagPanel test = new GridBagPanel();" 
					+ "\n\t  app.add(test, BorderLayout.CENTER);"
					+ "\n\t  app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);" 
					+ "\n\t  app.setSize(800, 300);"
					+ "\n\t  app.setVisible(true);" 
					+ "\n  }"
					+ "\n}" 
					+ ""
					+ "" 
					+ ""
					+ "");
		
	
	}
	
	public void javaPreviewToFile() {
		System.out.printf("\nPreview kaller jorden");
	}
	
	/**
	 * Checks if there is a file to close
	 */
	public void closeFile() {
		if (output != null)
			output.close();
	}
}
