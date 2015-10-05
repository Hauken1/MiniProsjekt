import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CreateSequentialFile {

	private static ObjectOutputStream output;
	
	/**
	 * Open file 
	 */
	public static void openFile() {
		try { //Finds the target path for output to write to file
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("clients.ser"))); //Needs to be gotten from fileChooser.java
		} catch (IOException e){
			System.err.println("Error opening file.");
		}
	}
	
	/**
	 * Add layout to file
	 */
	public static void saveLayoutToFile() {
		try {
			output.writeObject(obj); //Tries to write object to file
		} catch (IOException e) {	
			System.err.println("Error writing to file");
		}
	}
	
	/**
	 * Close file and terminate application
	 */
	public static void closeFile() {
		try {
			if(output != null) //Checks if the output stream is closed
				output.close();
		} catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}
}
