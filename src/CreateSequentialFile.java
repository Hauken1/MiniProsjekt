import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;

/**
 * Open and closes the choosen file that data is loaded or saved too.
 * Has functions that takes care of the output and input stream of data too file.
 * Also saves vector komponent object to choosen file.
 */
public class CreateSequentialFile {

	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	public CreateSequentialFile() {
	}
	
	/**
	 * Open file if path is not null. 
	 * @param path
	 * @param tableModel
	 */
	public void openOutputFile(Path path, TableModel tableModel) {
		if(path != null) {
			try { //Finds the target path for output to write to file
				output = new ObjectOutputStream(Files.newOutputStream(path));
				saveLayoutToFile(tableModel);
			} catch (IOException e){
				System.err.println("Error opening file.");
			}
		}
	}
	
	/**
	 * Open file if path is not null. 
	 * @param path
	 * @param tableModel
	 */
	public void openInputFile(Path path, TableModel tableModel) {
		if(path != null) {
			try { //Finds the target path for input to write to file
				input = new ObjectInputStream(Files.newInputStream(path));
				loadLayoutFromFile(tableModel);
			} catch (IOException e){
				System.err.println("Error opening file.");
			}
		}
	}
	
	/**
	 * Saves the vector komponent object to file.
	 * @param tableModel
	 */
	public void saveLayoutToFile(TableModel tableModel) {
		try {
			output.writeObject(tableModel.returnVector()); //Tries to write object to file
		} catch (IOException e) {	
			System.err.println("Error writing to file");
		}
	}
	
	/**
	 * Load the vector komponent object from file.
	 * @param tableModel
	 */
	public void loadLayoutFromFile(TableModel tableModel) {
		try {
				final Vector<Komponent> temp = (Vector<Komponent>) input.readObject();
				tableModel.setVector(temp);
		} catch (EOFException endOfFileE) {
			System.err.println("No more to read");
		} catch (ClassNotFoundException classNotFoundE) {
			System.err.println("Invalid object type.");
		} catch (IOException e) {
			System.err.println("Error loading from file.");
		}
		
	}
	
	/**
	 * Close file
	 */
	public void closeFile() {
		try {
			if(output != null)  //Checks if the output stream is closed
				output.close();
			if(input != null)
				input.close();
		} catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}
}
