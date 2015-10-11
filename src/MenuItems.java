import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuItems {

	private Internationalization inter;
	private CreateSequentialFile stream;
	private FileChooser file;
	private JMenu fileMenu;
	private JMenu redigerMenu;
	private JMenu hjelpMenu;
	
	public MenuItems() {
		
		fileMenu = new JMenu("Fil");
		fileMenu.setMnemonic('F');
		
		redigerMenu = new JMenu("Rediger");
		redigerMenu.setMnemonic('r');
		
		hjelpMenu = new JMenu("Hjelp");
		hjelpMenu.setMnemonic('H');
		
		stream = new CreateSequentialFile();
		file = new FileChooser();
		inter = new Internationalization();
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
	    			//Todo Fjern dette?
	    			/*
	    			if(file.pathNotFound()) {
	    				stream.openOutputFile(file.saveLayoutAtPath(), tablemodel);
		    			stream.closeFile();
		    			file.setPathToNull();
	    			} else {
	    				stream.openOutputFile(file.saveLayout(), tablemodel);
		    			stream.closeFile();
		    			file.setPathToNull();
	    			}
	    			*/
	    		}
	    	}
	    );
	    
	    //Lage "Hent" funksjon til fil meny
	    JMenuItem hentItem = new JMenuItem("Hent"); //Lage hent menyitem
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
	    JMenuItem lagreItem = new JMenuItem("Lagre"); //Lage lagre menyitem
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
	    JMenuItem lagreSomItem = new JMenuItem("Lagre Som"); //Lage lagre som menyitem
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
	    JMenuItem avsluttItem = new JMenuItem("Avslutt"); // lage avslutt item
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
	
	public JMenu returnRedigerMenu() {
		return redigerMenu;
	}
	
	public JMenu returnHjelpMenu() {
		return hjelpMenu;
	}
}
