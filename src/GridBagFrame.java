import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.FlowLayout; //test
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenuBar;


public class GridBagFrame extends JFrame 
{
	private final GridBagLayout layout; // layout of this frame
	private final GridBagConstraints constraints; // layout's constraints
	
	// sette opp GUI:
	public GridBagFrame()
	{
		super("GridBagLayout editor");
		layout = new GridBagLayout(); //Inititialisere layout
		setLayout(layout);
		constraints = new GridBagConstraints(); // instantiate constraints
		
		//GUI-Komponenter (tables, toolbar, meny, m.m)
		
		//Table
	    JTable table = new JTable(new TableModel());
	    table.setPreferredScrollableViewportSize(new Dimension(500,70));
	    table.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(table);
	    
	    //Menyer
	    JMenu filMenu = new JMenu("Fil"); // Lager fil meny
	    filMenu.setMnemonic('F'); // set mnemonic to F
	    
	    JMenu redigerMenu = new JMenu("Rediger"); //Lager rediger meny
	    redigerMenu.setMnemonic('r');
	    
	    JMenu hjelpMenu = new JMenu("Hjelp"); //Lager rediger meny
	    hjelpMenu.setMnemonic('H');
	    
	    //Lage "Ny" funksjon til fil meny
	    JMenuItem nyItem = new JMenuItem("Ny"); //Lage ny menyitem
	    nyItem.setMnemonic('A'); // set mnemonic to A
	    filMenu.add(nyItem); // legge til "NY" item til fil meny
	  
	    nyItem.addActionListener (
	    	new ActionListener()
	    	{
	    		@Override
	    		public void actionPerformed(ActionEvent event)
	    		{
	    		//TODO Funksjon for å lage ny fil
	    		}
	    	}
	    );
	    //Lage "Hent" funksjon til fil meny
	    JMenuItem hentItem = new JMenuItem("Hent"); //Lage hent menyitem
	    hentItem.setMnemonic('h');
	    filMenu.add(hentItem);
	    hentItem.addActionListener(
	    	new ActionListener()
	    	{
	    		@Override
	    		public void  actionPerformed(ActionEvent event)
	    		{
	    			//TODO Funksjon for hent fil
	    		}
	    	}	
	    );
	    //Lage "Lagre" funksjon til fil meny
	    JMenuItem lagreItem = new JMenuItem("Lagre"); //Lage lagre menyitem
	    lagreItem.setMnemonic('h');
	    filMenu.add(lagreItem);
	    lagreItem.addActionListener(
	    	new ActionListener()
	    	{
	    		@Override
	    		public void  actionPerformed(ActionEvent event)
	    		{
	    			//TODO Funksjon for å lagre
	    		}
	    	}	
	    );
	    //Lage "Lagre Som" funksjon til fil meny
	    JMenuItem lagreSomItem = new JMenuItem("Lagre Som"); //Lage lagre som menyitem
	    lagreSomItem.setMnemonic('h');
	    filMenu.add(lagreSomItem);
	    lagreSomItem.addActionListener(
	    	new ActionListener()
	    	{
	    		@Override
	    		public void  actionPerformed(ActionEvent event)
	    		{
	    			//TODO Funksjon for å lagre som
	    		}
	    	}	
	    );
	    //Lage "Avslutt" funksjon til fil meny
	    JMenuItem avsluttItem = new JMenuItem("Avslutt"); // lage avslutt item
	    avsluttItem.setMnemonic('x'); // set mnemonic to x
	    filMenu.add(avsluttItem); // legge til avslutt item til fil meny
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
	    
	    //Lager selve menybaren
	    JMenuBar bar = new JMenuBar();
	    setJMenuBar(bar);
	    bar.add(filMenu);
	    bar.add(redigerMenu);
	    bar.add(hjelpMenu);
	    
	    //Standard constraints TODO Sette det øverst til venstre
	    constraints.fill = GridBagConstraints.BOTH;
	    constraints.gridwidth = GridBagConstraints.REMAINDER;
	    constraints.anchor = GridBagConstraints.NORTHWEST;
	    
	    //Legger til menybaren
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    addComponent(bar);		//Legger meny til framen
	    
	    //Lager ToolBaren TODO legge til ImageIcon med mouseevent. Trenger nok ikke bruke JPanel. Skulle bare teste
	    JPanel buttonPanel = new JPanel();
	    constraints.anchor = GridBagConstraints.NORTHWEST;
	    constraints.gridwidth = GridBagConstraints.RELATIVE; 
	    constraints.gridx = 0; 
	    constraints.gridy = 1; 
	    constraints.insets = new Insets(0,1,0,1);
	    addComponent(buttonPanel);
	 
	    //TODO Bytt ut JLabel med ImageIcon.
	    for (int i = 1; i <= 9; i++)
	    {
	    	buttonPanel.add(new JLabel("Test" + i));
	    }
	    
	    //Scrollpane
	    constraints.gridx = 0;
	    constraints.gridy = 2; 
	    addComponent(scrollPane);	//Legger scrollpane til framen
	     
	} // Slutt GridBagFrame constructor
	 
	// Legg til komponent til kontaineren
	private void addComponent(Component component) 
	{
		layout.setConstraints(component, constraints);
	    add(component); // Legge til Komponent
	} 
	
	//Constructor for JTable
	class TableModel extends AbstractTableModel {
		
		private String[] columnNames = {
				"Type",
				"Variablenavn",
				"Tekst",
				"Rad",
				"Kolonne",
				"Rader",
				"Kolonner",
				"Utfylling",
				"Forankring"};
		
		public int getColumnCount() {
			return columnNames.length;
		}
		
		public String getColumnName(int col) {
			return columnNames[col];
		}
		
		@Override
		public int getRowCount() {
			// TODO Kun for data
			return 0;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Kun for data
			return null;
		}
	}
} // Slutt class GridBagFrame