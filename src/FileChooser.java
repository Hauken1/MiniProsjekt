import java.io.File;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileChooser extends JFrame {

	private JFileChooser fileChooser;
	private Path path;
	
	public FileChooser() {
		fileChooser = new JFileChooser();
	}
	
	/**
	 * Allow user to specify file
	 * @return fileChooser.getSelectedFile().toPath();
	 */
	public Path loadLayoutPath() {
		// configure dialog allowing selection of a file
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		
		//if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION)
			return null;
		
		// return Path representing the selected file
		return path = fileChooser.getSelectedFile().toPath();
	}
	
	/**
	 * Allow user to specify where to save file
	 */
	public Path saveLayout() {
		if(pathNotFound()) {
			System.out.println("Ingen path funnet " + path);
			fileChooser.showSaveDialog(this);
			return path = fileChooser.getSelectedFile().toPath();
		}
		return path;
	}
	
	public Path saveLayoutAtPath() {
		int result = fileChooser.showSaveDialog(this);
		System.out.println("First result: " + result);
		//if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION)
			return null; 
		
		return path = fileChooser.getSelectedFile().toPath();
	}
	
	public boolean pathNotFound() {
		if (path != null) {
			System.out.println("path ikke null: " + path);
			return false;
		}
		return true;
	}
	
	public void setPathToNull() {
		path = null;
	}
}
