import java.io.FileNotFoundException;
import java.nio.file.Path;
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
	 * Open file to write too for source code
	 */
	public void openSourceFile(TableModel tm) {
		Path p = file.saveLayoutAtPath();
		if(p != null){
			try {
				output = new Formatter(p.toString());
			} catch (SecurityException se) {
				System.err.println("Write permisson denied.");
			} catch (FileNotFoundException f) {
				System.err.println("Error opening file");
			}
			javaSourceCodeToFile(tm);
		}
	}
	
	/**
	 * Writes the source code of the tabel til file with main
	 * @param tablemodel object
	 */
	public void javaSourceCodeToFile(TableModel tm) {
		output.format("import javax.swing.*;"
					+ "\nimport java.awt.*;"
					+ "\n/**\n* Code generated from GridBagLayout Editor\n*/" 
					+ "\npublic class "+file.returnPathName()+" extends JPanel {");
					typeCreation(tm);
		output.format("\n\n\tpublic "+file.returnPathName()+" () {"
					+ "\n\t  GridBagLayout layout = new GridBagLayout();" 
					+ "\n\t  GridBagConstraints gbc = new GridBagConstraints();"
					+ "\n\t  setLayout(layout);"); 
					constraints(tm);
		output.format("\n\t}"
					+ "\n\n\tstatic public void main(String[] args) {" 
					+ "\n\t  JFrame frame = new JFrame(\"Simple Stuff\");"
					+ "\n\t  GridBagPanel panel = new GridBagPanel();" 
					+ "\n\t  frame.add(panel, BorderLayout.CENTER);"
					+ "\n\t  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);" 
					+ "\n\t  frame.setSize(800, 300);"
					+ "\n\t  frame.setVisible(true);" 
					+ "\n  }"
					+ "\n}" 
					+ ""
					+ "" 
					+ ""
					+ "");
	}
	
	/**
	 * Open file to write too for preview
	 */
	public void openPreviewFile(TableModel tm) {
		Path p = file.saveLayoutAtPath();
		if(p != null){
			try {
				output = new Formatter(p.toString());
			} catch (SecurityException se) {
				System.err.println("Write permisson denied.");
			} catch (FileNotFoundException f) {
				System.err.println("Error opening file");
			}
			javaPreviewToFile(tm);
		}
	}
	/**
	 * Writes the preview code of your tabel to file
	 * @param tablemodel object
	 */
	public void javaPreviewToFile(TableModel tm) {
		output.format("import javax.swing.*;"
					+ "\nimport java.awt.*;"
					+ "\n/**\n* Code generated from GridBagLayout Editor\n*/" 
					+ "\npublic class "+file.returnPathName()+" extends JPanel {");
					typeCreation(tm);
		output.format("\n\n\tpublic "+file.returnPathName()+" () {"
					+ "\n\t  GridBagLayout layout = new GridBagLayout();" 
					+ "\n\t  GridBagConstraints gbc = new GridBagConstraints();"
					+ "\n\t  setLayout(layout);"); 
					constraints(tm);
		output.format("\n}" ); 
	}
	
	/**
	 * Checks the tabel object types and writes the proper type to file
	 * @param tabelmodel object
	 */
	public void typeCreation(TableModel tm) {
		String[] t= {"1, 2, 3, 4"};
		for (int i=0; i<=tm.getRowCount(); i++) {
			if (t[0].equals(tm.getValueAt(1, 0))) {
				output.format("\n\tJLabel "+tm.getValueAt(i, 1)+" = new JLabel ("+tm.getValueAt(i, 2)+");");
			}
			if (t[2].equals(tm.getValueAt(1, 0))) {
				output.format("\n\tJTextField "+tm.getValueAt(i, 1)+" = new JTextField ("+tm.getValueAt(i, 2)+");");
			}
			if (t[4].equals(tm.getValueAt(1, 0))) {
				output.format("\n\tJTextArea "+tm.getValueAt(i, 1)+" = new JTextArea ("+tm.getValueAt(i, 2)+");");
			}
			if (t[1].equals(tm.getValueAt(1, 0))) {
				output.format("\n\tJButton "+tm.getValueAt(i, 1)+" = new JButton ("+tm.getValueAt(i, 2)+");");
			}
		}
	}
	
	/**
	 * Writes the correct constraints for the given type to file
	 * @param tabelmodel object
	 */
	public void constraints(TableModel tm) {
    	String t="4";
		for (int i=0; i<=tm.getRowCount(); i++) {
			if (t.equals(tm.getValueAt(i, 0))) {
				output.format(""
						+ "\n\t  gbc.gridx = "+tm.getValueAt(i, 4)+";"
						+ "\n\t  gbc.gridy = "+tm.getValueAt(i, 3)+";" 
						+ "\n\t  gbc.gridwidth = "+tm.getValueAt(i, 6)+";"
						+ "\n\t  gbc.gridheight = "+tm.getValueAt(i, 5)+";" 
						+ "\n\t  gbc.anchor = "+tm.getValueAt(i, 9)+";"
						+ "\n\t  gbc.fill = "+tm.getValueAt(i, 10)+";"
						+ "\n\t  JScrollPane " +tm.getValueAt(i, 1)+"JScrollPane = new JScrollPane ("+tm.getValueAt(i, 1)+");"
						+ "\n\t  layout.setConstraints ("+tm.getValueAt(i, 1)+"ScrollPane, gbc);"
						+ "\n\t  add ("+tm.getValueAt(i, 1)+"ScrollPane);" 
						+ "\n\t  "+tm.getValueAt(i, 1)+".setLineWrap (true);"
						+ "\n\t  "+tm.getValueAt(i, 1)+".setWrapStyleWord (true);");
			} else {
				output.format(""
						+ "\n\t  gbc.gridx = "+tm.getValueAt(i, 4)+";"
						+ "\n\t  gbc.gridy = "+tm.getValueAt(i, 3)+";" 
						+ "\n\t  gbc.gridwidth = "+tm.getValueAt(i, 6)+";"
						+ "\n\t  gbc.gridheight = "+tm.getValueAt(i, 5)+";" 
						+ "\n\t  gbc.anchor = "+tm.getValueAt(i, 9)+";"
						+ "\n\t  gbc.fill = "+tm.getValueAt(i, 10)+";"
						+ "\n\t  layout.setConstraints ("+tm.getValueAt(i, 1)+", gbc);"
						+ "\n\t  add ("+tm.getValueAt(i, 1)+");" );
			}
		}
	}
	/**
	 * Checks if there is a file to close
	 */
	public void closeFile() {
		if (output != null)
			output.close();
	}
}
