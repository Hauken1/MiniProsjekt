import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GridBagMain
{ 
   public static void main(String[] args)
   { 
	   
	   try {
		   // Set cross-platform Java L&F 
		   UIManager.setLookAndFeel(
		   UIManager.getSystemLookAndFeelClassName());
	   } 
	   catch (UnsupportedLookAndFeelException e) {
		   // handle exception
	   }
	   catch (ClassNotFoundException e) {
		   // handle exception
	   }
	   catch (InstantiationException e) {
		   // handle exception
	   }
	   catch (IllegalAccessException e) {
		   // handle exception
	   } 
	   
      GridBagFrame gridBagFrame = new GridBagFrame();  
      gridBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gridBagFrame.setSize(800, 300); 
      gridBagFrame.setVisible(true); 
   } 
} // end class GridBagMain