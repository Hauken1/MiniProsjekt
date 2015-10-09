import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CreateSequentialFile {

	private ObjectInputStream input;
	private ObjectOutputStream output;
	private HelpClassAccount account;
	
	public CreateSequentialFile() {
	}
	
	/**
	 * Open file 
	 */
	public void openOutputFile(Path path) {
		if(path != null) {
			try { //Finds the target path for output to write to file
				output = new ObjectOutputStream(Files.newOutputStream(path));
				saveLayoutToFile();
			} catch (IOException e){
				System.err.println("Error opening file.");
			}
		}
	}
	
	/**
	 * Open file 
	 */
	public void openInputFile(Path path) {
		if(path != null) {
			try { //Finds the target path for input to write to file
				input = new ObjectInputStream(Files.newInputStream(path));
				loadLayoutFromFile();
			} catch (IOException e){
				System.err.println("Error opening file.");
			}
		}
	}
	
	/**
	 * Saves an layout to file
	 */
	public void saveLayoutToFile() {
		account = new HelpClassAccount();
		try {
			output.writeObject(account); //Tries to write object to file (needs object to write)
		} catch (IOException e) {	
			System.err.println("Error writing to file");
		}
	}
	
	/**
	 * Load a selected layout from file
	 */
	public void loadLayoutFromFile() {
		//For later use
		try {
				HelpClassAccount record = (HelpClassAccount) input.readObject();
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
