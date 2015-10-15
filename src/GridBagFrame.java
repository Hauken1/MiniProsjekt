import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToolBar;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JMenuBar;

/**
 * Class that creates the layout that handles most of the GUI on the screen.
 * Sets the constraints on the top bar, toolbar and table
 * and adds them to the layout
 */
public class GridBagFrame extends JFrame 
{
	private final GridBagLayout layout; // layout of this frame
	private final GridBagConstraints constraints; // layout's constraints
	private Toolbar toolBar;
	private Table table;
	private TableModel tableModel;
	private CreateSequentialFile stream;
	private FileChooser file;
	private CodeGenerator codeG;
	private Internationalization inter;
	
	JToolBar jtoolBar = new JToolBar(); 
	
	/*
	 * Constructor that gets called in the Main function. Creates the layout
	 * Initializes class calls
	 * Set constraints on GUI bar, toolbar and table.
	 * Adds the bar, toolbar and table to the layout
	 * Sets the action listener for the toolbar with it's
	 * responding function call.
	 */
	public GridBagFrame()
	{
		super("GridBagLayout editor");
		layout = new GridBagLayout(); //Inititialisere layout
		setLayout(layout);
		constraints = new GridBagConstraints(); // instantiate constraints
		
		//GUI-Komponenter (tables, toolbar, meny, m.m)
		MenuItems menuItems = new MenuItems();

		//Tablemodel
		tableModel = new TableModel();
		
		//Toolbar
		toolBar = new Toolbar();
		
		//Table
		table = new Table(tableModel);
		
		//CodeGenerator
		codeG = new CodeGenerator();
		
		//Fil klasser
		stream = new CreateSequentialFile();
		file = new FileChooser();
		inter = new Internationalization();
	  
	    //Lager selve menybaren
	    JMenuBar bar = new JMenuBar();
	    
	    bar.add(menuItems.returnFileMenu(tableModel));
	    bar.add(menuItems.returnRedigerMenu(tableModel));
	    bar.add(menuItems.returnHjelpMenu(getParent()));
	   
	    constraints.weighty = 1;
	    constraints.weightx = 1;
	    constraints.anchor = GridBagConstraints.NORTHWEST;
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    addComponent(bar, 0, 0, 0, 1);		//Legger meny til framen
	    
	    //Lager ToolBaren TODO legge til mouseevent. 
	    ActionListener actionNy = new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
            	tableModel.nyTabell(); 
            }
        };
	    toolBar.getNy().addActionListener(actionNy);
	    
	    
    	//Hente fil funksjonalitet		
		ActionListener actionHent = new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
            	stream.openInputFile(file.loadLayoutPath(), tableModel);
    			stream.closeFile();
            }
        };
		toolBar.getHent().addActionListener(actionHent);
		
		
		//Lagre funksjonalitet
		ActionListener actionLagre = new ActionListener(){

        	public void actionPerformed(ActionEvent actionEvent) {
        		stream.openOutputFile(file.saveLayout(), tableModel);
    			stream.closeFile();
            }
        };
		toolBar.getLagre().addActionListener(actionLagre);
		
		
		//Generer et preview av java kildekoden
		ActionListener actionPreview = new ActionListener(){

        	public void actionPerformed(ActionEvent actionEvent) {
        		
        		codeG.openPreviewFile(tableModel);
           		codeG.closeFile();
        		
        		/*
        		Thread thread = new Thread() {
        			
        			public void run() {
        				tableModel.tilJavaKode(true, null);
        			}
        		};
        		thread.start(); 
        		*/
            }
        };
		toolBar.getPreview().addActionListener(actionPreview);
		
		
		//Genererer java kildekode
		ActionListener actionGenerer = new ActionListener(){

        	public void actionPerformed(ActionEvent actionEvent) {
        		
        		codeG.openSourceFile(tableModel);
           		codeG.closeFile();
           		
            }
        };
		toolBar.getGenererKode().addActionListener(actionGenerer);
		
		
		//Ny rad funksjonalitet
		ActionListener actionNyRad = new ActionListener(){

        	public void actionPerformed(ActionEvent actionEvent) {
           		tableModel.nyRad(); 
            }
        };
		toolBar.getNyRad().addActionListener(actionNyRad);
		
		
		//Flytt rad opp funksjonalitet
		ActionListener actionFlyttOpp = new ActionListener(){

        	public void actionPerformed(ActionEvent actionEvent) {
        		if (table.getSelectedRow() >= 0 && table.getSelectedRow() <= 8) {
        			int n = table.getSelectedRow();
        			tableModel.flyttOpp(n);
        		}
        		 
            }
        };		
		toolBar.getFlyttOpp().addActionListener(actionFlyttOpp);
		
		
		//Flytt rad ned funksjonalitet
		ActionListener actionFlyttNed = new ActionListener(){

        	public void actionPerformed(ActionEvent actionEvent) {
           		if (table.getSelectedRow() >= 0 && table.getSelectedRow() <= 8) {
           			int n = table.getSelectedRow();
               		tableModel.flyttNed(n);
           		}
            }
        };
		toolBar.getFlyttNed().addActionListener(actionFlyttNed);
		
		
		//Hjelp funksjonalitet
		ActionListener actionGetHjelp = new ActionListener(){

        	public void actionPerformed(ActionEvent actionEvent) {
           		JOptionPane.showMessageDialog(getParent(), inter.returnMessage("helpText"));
            }
        };
		toolBar.getHjelp().addActionListener(actionGetHjelp);
		
		constraints.weightx = 0;
		constraints.weighty = 1;
	    addComponent(toolBar, 0, 1, 0, 0);
	    
	  //constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.anchor = GridBagConstraints.LINE_START;
	    constraints.weighty = 100;
	    constraints.weightx = 1;
	  
	    addComponent(table, 0, 2, 0, 0);	//Legger scrollpane med tabel til framen
	     
	} // Slutt GridBagFrame constructor
	
	/**
	 * Add the given component with it's constraints to the layout.
	 * @param component
	 * @param column
	 * @param row
	 * @param width
	 * @param height
	 */
	private void addComponent(Component component, int column, int row, int width, int height) 
	{
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
	    add(component); // Legge til Komponent
	} 
	
} // Slutt class GridBagFrame