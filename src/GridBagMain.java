import javax.swing.JFrame;

/**
 * Main class that starts the program calls.
 */
public class GridBagMain
{ 
	/**
	 * Calls the main fram object and sets its window properties.
	 * @param args
	 */
   public static void main(String[] args)
   { 
      GridBagFrame gridBagFrame = new GridBagFrame();  
      gridBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gridBagFrame.setSize(800, 300); 
      gridBagFrame.setVisible(true); 
   } 
} // end class GridBagMain