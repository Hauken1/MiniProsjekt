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
	
		/*
		MenuItems menuItems = new MenuItems();
	    
		//Table
	    JTable table = new JTable(new TableModel());
	    table.setPreferredScrollableViewportSize(new Dimension(500,70));
	    table.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(table);    
	    
	    //Lager selve menybaren
	    JMenuBar bar = new JMenuBar();
	    
	    bar.add(menuItems.returnFileMenu());
	    bar.add(menuItems.returnRedigerMenu());
	    bar.add(menuItems.returnHjelpMenu());
	    
	    constraints.weighty = 1;
	    constraints.weightx = 1;
	    constraints.anchor = GridBagConstraints.NORTHWEST;
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    addComponent(bar, 0, 0, 0, 1);		//Legger meny til framen
	    */
	    //Lager ToolBaren TODO legge til ImageIcon med mouseevent. Trenger nok ikke bruke JPanel. Skulle bare teste
	    //JToolBar buttonPanel = new JToolBar();
		Toolbar toolBar = new Toolbar(); 
		JToolBar jtoolBar = new JToolBar(); 
		
		jtoolBar.add(toolBar.getNy());
		jtoolBar.add(toolBar.getHent());
		jtoolBar.add(toolBar.getLagre());
		jtoolBar.add(toolBar.getPreview());
		jtoolBar.add(toolBar.getGenererKode());
		jtoolBar.add(toolBar.getNyRad());
		jtoolBar.add(toolBar.getFlyttOpp());
		jtoolBar.add(toolBar.getFlyttNed());
		jtoolBar.add(toolBar.getHjelp());
		
		
		
	    //constraints.insets = new Insets(0,1,0,1);
	    constraints.weighty = 1;
	    constraints.anchor = GridBagConstraints.NORTHWEST;
	    addComponent(jtoolBar, 0, 1, 0, 1);
	 /*
	    //TODO Bytt ut JLabel med ImageIcon.
	    for (int i = 1; i <= 5; i++)
	    {
	    	buttonPanel.add(new JButton("Test" + i));
	    }
	   */ 
	    constraints.fill = GridBagConstraints.BOTH;
	    constraints.weighty = 100;
	  //  addComponent(scrollPane, 0, 2, 0, 1);	//Legger scrollpane til framen
	     
	} // Slutt GridBagFrame constructor
	
	// Legg til komponent til kontaineren
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