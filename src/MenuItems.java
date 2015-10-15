import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Creates the top bar with file/edit/help drop downs.
 */
public class MenuItems {

	private Internationalization inter;
	private CreateSequentialFile stream;
	private FileChooser file;
	private JMenu fileMenu;
	private JMenu redigerMenu;
	private JMenu hjelpMenu;
	
	/**
	 * Initializes other class calls and the drop down bars
	 */
	public MenuItems() {
		
		stream = new CreateSequentialFile();
		file = new FileChooser();
		inter = new Internationalization();
		
		fileMenu = new JMenu(inter.returnMessage("file"));
		fileMenu.setMnemonic('F');
		
		redigerMenu = new JMenu(inter.returnMessage("edit"));
		redigerMenu.setMnemonic('r');
		
		hjelpMenu = new JMenu(inter.returnMessage("help"));
		hjelpMenu.setMnemonic('H');
	}
	
	/**
	 * Makes the drop down for fileMenu(New, Load, Save, Save As, Quit).
	 * With corresponding action listener and their call functions
	 * @param tablemodel
	 * @return fileMenu
	 */
	public JMenu returnFileMenu(TableModel tablemodel) {
		
		//Lage "Ny" funksjon til fil meny
	    JMenuItem nyItem = new JMenuItem(inter.returnMessage("new")); //Lage ny menyitem
	    nyItem.setMnemonic('A'); // set mnemonic to A
	    fileMenu.add(nyItem); // legge til "NY" item til fil meny
	 
	    nyItem.addActionListener (
	    	new ActionListener()
	    	{
	    		@Override
	    		public void actionPerformed(ActionEvent event)
	    		{
	    			tablemodel.nyTabell();
	    		}
	    	}
	    );
	    
	    //Lage "Hent" funksjon til fil meny
	    JMenuItem hentItem = new JMenuItem(inter.returnMessage("load")); //Lage hent menyitem
	    hentItem.setMnemonic('h');
	    fileMenu.add(hentItem);
	    hentItem.addActionListener(
	    	new ActionListener()
	    	{
	    		@Override
	    		public void  actionPerformed(ActionEvent event)
	    		{
	    			stream.openInputFile(file.loadLayoutPath(), tablemodel);
	    			stream.closeFile();
	    		}
	    	}	
	    );
	    
	    //Lage "Lagre" funksjon til fil meny
	    JMenuItem lagreItem = new JMenuItem(inter.returnMessage("save")); //Lage lagre menyitem
	    lagreItem.setMnemonic('h');
	    fileMenu.add(lagreItem);
	    lagreItem.addActionListener(
	    	new ActionListener()
	    	{
	    		@Override
	    		public void  actionPerformed(ActionEvent event)
	    		{
	    			stream.openOutputFile(file.saveLayout(), tablemodel);
	    			stream.closeFile();
	    		}
	    	}	
	    );
	    //Lage "Lagre Som" funksjon til fil meny
	    JMenuItem lagreSomItem = new JMenuItem(inter.returnMessage("saveAs")); //Lage lagre som menyitem
	    lagreSomItem.setMnemonic('h');
	    fileMenu.add(lagreSomItem);
	    lagreSomItem.addActionListener(
	    	new ActionListener()
	    	{
	    		@Override
	    		public void  actionPerformed(ActionEvent event)
	    		{
	    			stream.openOutputFile(file.saveLayoutAtPath(), tablemodel);
	    			stream.closeFile();
	    		}
	    	}	
	    );
	    //Lage "Avslutt" funksjon til fil meny
	    JMenuItem avsluttItem = new JMenuItem(inter.returnMessage("quit")); // lage avslutt item
	    avsluttItem.setMnemonic('x'); // set mnemonic to x
	    fileMenu.add(avsluttItem); // legge til avslutt item til fil meny
	    avsluttItem.addActionListener(
	    	new ActionListener() // anonymous inner class
	         {  
	            // terminerer applikasjonen når bruker trykker avslutt
	            @Override
	            public void actionPerformed(ActionEvent event)
	            {
	               System.exit(0); // avslutter applikasjonen
	            } 
	         }
	    );
		
		return fileMenu;
	}
	
	/**
	 * Makes the drop down for fileMenu(new row).
	 * With corresponding action listener and their call functions
	 * @param tablemodel object
	 * @return redigerMenu
	 */
	public JMenu returnRedigerMenu(TableModel tablemodel) {
		//Lage "ny tabel" funksjon til fil meny
	    JMenuItem nytabellItem = new JMenuItem(inter.returnMessage("newRow")); // lage avslutt item
	    nytabellItem.setMnemonic('n'); // set mnemonic to x
	    redigerMenu.add(nytabellItem);
	    nytabellItem.addActionListener(
	    	new ActionListener() // anonymous inner class
	         {
	            @Override
	            public void actionPerformed(ActionEvent event)
	            {
	               tablemodel.nyRad();
	            } 
	         }
	    );
		return redigerMenu;
	}
	
	/**
	 * Makes the drop down for hjelpMenu
	 * @return hjelpMenu
	 */
	public JMenu returnHjelpMenu(Container frame) {
		
		JMenuItem hjelpItem = new JMenuItem(inter.returnMessage("help")); // lage avslutt item
	    hjelpItem.setMnemonic('n'); // set mnemonic to x
	    hjelpMenu.add(hjelpItem);
	    hjelpItem.addActionListener(
	    	new ActionListener() // anonymous inner class
	         {
	            @Override
	            public void actionPerformed(ActionEvent event)
	            {
	               JOptionPane.showMessageDialog(frame , inter.returnMessage("helpText"));
	            } 
	         }
	    );
		
		return hjelpMenu;
	}
}
