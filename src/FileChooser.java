import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileChooser extends JFrame {

	private JFileChooser fileChooser;
	
	public FileChooser() {
		
	}
	
	/**
	 * Allow user to specify file
	 * @return fileChooser.getSelectedFile().toPath();
	 */
	public Path getFilePath() {
		
		// configure dialog allowing selection of a file
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		
		//if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION)
			return null;
		
		// return Path representing the selected file
		return fileChooser.getSelectedFile().toPath();
	}
	
	
	/**
	 * Allow user to specify where to save file
	 */
	public void saveLayout() {
		fileChooser = new JFileChooser();
		fileChooser.showSaveDialog(this);
		
			
		
		
		
	}
	
}
