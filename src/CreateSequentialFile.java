import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;

public class CreateSequentialFile {

	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	public CreateSequentialFile() {
	}
	
	/**
	 * Open file to save data
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
	 * Open file from where to load data
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
	 * Saves an layout to file
	 */
	public void saveLayoutToFile(TableModel tableModel) {
		try {
			output.writeObject(tableModel.returnVector()); //Tries to write object to file
		} catch (IOException e) {	
			System.err.println("Error writing to file");
		}
	}
	
	/**
	 * Load a selected layout from file
	 */
	public void loadLayoutFromFile(TableModel tableModel) {
		try {
				final Vector<Komponent> test = (Vector<Komponent>) input.readObject();
				tableModel.setVector(test);
		} catch (EOFException endOfFileE) {
			System.err.println("No more to read");
		} catch (ClassNotFoundException classNotFoundE) {
			System.err.println("Invalid object type.");
		} catch (IOException e) {
			System.err.println("Error loading from file.");
		}
		
	}
	
	/**
	 * Close file and terminate application
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
