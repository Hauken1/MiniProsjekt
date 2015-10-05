package Test;

import static org.junit.Assert.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.junit.Test;

public class FileChooserTest extends JFrame{

	@Test
	public void testGetFilePath() {
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		fileChooser.setSelectedFile();
	}

}
