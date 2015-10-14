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
	
	// sette opp GUI:
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
	    bar.add(menuItems.returnHjelpMenu());    	
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