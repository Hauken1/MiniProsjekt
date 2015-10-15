import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;

/**
 * Class that creates the layout that handles most of the GUI on the screen.
 * Sets the constraints on the top bar, toolbar and table
 * and adds them to the layout
 */
public class GridBagFrame extends JFrame 
{
	private final BorderLayout layout;
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
		layout = new BorderLayout(); //Inititialisere layout
		setLayout(layout);
		
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
	    	
	    add(bar, BorderLayout.NORTH); //Legger meny til framen
	
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
		
		add(toolBar, BorderLayout.CENTER);	//Legger toolbaren til framen
	    add(table, BorderLayout.SOUTH);	//Legger tabellen til framen
	    
	} // Slutt GridBagFrame constructor

} // Slutt class GridBagFrame