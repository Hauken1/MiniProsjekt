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
	 * @return selected path from dialog
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
	 * @return selected path from dialog
	 */
	public Path saveLayout() {
		if(pathNotFound()) {
			int result = fileChooser.showSaveDialog(this);
			
			//if user clicked Cancel button on dialog, return
			if (result == JFileChooser.CANCEL_OPTION)
				return null;
			
			return path = fileChooser.getSelectedFile().toPath();
		}
		return path;
	}
	
	/**
	 * Allow user to specify where to save file
	 * @return selected path from dialog
	 */
	public Path saveLayoutAtPath() {
		int result = fileChooser.showSaveDialog(this);
		
		//if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION)
			return null; 
		
		return path = fileChooser.getSelectedFile().toPath();
	}
	
	/**
	 * Checks if a path is already set
	 * @return true or false
	 */
	public boolean pathNotFound() {
		if (path != null) 
			return false;
		
		return true;
	}
	
	/**
	 * Resets the path to null
	 */
	public void setPathToNull() {
		path = null;
	}
	
	/**
	 * Returns the name and not the file type
	 * @return file name without .extension
	 */
	public String returnPathName() {
		String t;
		if(!pathNotFound()) {
			t = fileChooser.getSelectedFile().getName();
			System.out.println("File name: " + t);
			return t.substring(0, t.indexOf("."));
		}
		return "temp";
	}
}
