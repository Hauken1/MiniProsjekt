import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar {
	private JButton ny;
    private JButton hent;
    private JButton lagre;
    private JButton genererKode;
    private JButton nyRad;
    private JButton hjelp;
    private JButton preview;
    private JButton flyttOpp;
    private JButton flyttNed;

    public Toolbar() {
    	opprettToolbar();
    }
	
    public void opprettToolbar () {
    	ny = new JButton("Ny" ,new ImageIcon(getClass().getResource("Resources/NEW.GIF")));
    	ny.addActionListener(
    			new ActionListener() // anonymous inner class
   	         {  
   	            // terminerer applikasjonen når bruker trykker avslutt
   	            @Override
   	            public void actionPerformed(ActionEvent event)
   	            {
   	  
   	            } 
   	         }
   	    );
    	
    	hent = new JButton("Hent", new ImageIcon(getClass().getResource("Resources/OPENDOC.GIF")));
    	hent.addActionListener(
    			new ActionListener() // anonymous inner class
      	         {  
      	            // terminerer applikasjonen når bruker trykker avslutt
      	            @Override
      	            public void actionPerformed(ActionEvent event)
      	            {
      	               
      	            } 
      	         }
      	    );
    	lagre = new JButton("Lagre", new ImageIcon(getClass().getResource("Resources/SAVE.GIF")));
    	lagre.addActionListener(
    			new ActionListener() // anonymous inner class
      	         {  
      	            // terminerer applikasjonen når bruker trykker avslutt
      	            @Override
      	            public void actionPerformed(ActionEvent event)
      	            {
      	               
      	            } 
      	         }
      	    );
    	addSeparator();
    	preview = new JButton("Preview", new ImageIcon(getClass().getResource("Resources/ExecuteProject.GIF")));
    	preview.addActionListener(
    			new ActionListener() // anonymous inner class
      	         {  
      	            // terminerer applikasjonen når bruker trykker avslutt
      	            @Override
      	            public void actionPerformed(ActionEvent event)
      	            {
      	               
      	            } 
      	         }
      	    );
    	genererKode = new JButton("Generer Kode", new ImageIcon(getClass().getResource("Resources/savejava.GIF")));
    	genererKode.addActionListener(
    			new ActionListener() // anonymous inner class
      	         {  
      	            // terminerer applikasjonen når bruker trykker avslutt
      	            @Override
      	            public void actionPerformed(ActionEvent event)
      	            {
      	               
      	            } 
      	         }
      	    );
    	addSeparator();
    	nyRad = new JButton("Ny Rad", new ImageIcon(getClass().getResource("Resources/NEWROW.GIF")));
    	nyRad.addActionListener(
    			new ActionListener() // anonymous inner class
      	         {  
      	            // terminerer applikasjonen når bruker trykker avslutt
      	            @Override
      	            public void actionPerformed(ActionEvent event)
      	            {
      	      
      	            } 
      	         }
      	    );
    	flyttOpp = new JButton("Flytt Opp", new ImageIcon(getClass().getResource("Resources/MoveRowUp.GIF")));
    	flyttOpp.addActionListener(
    			new ActionListener() // anonymous inner class
      	         {  
      	            // terminerer applikasjonen når bruker trykker avslutt
      	            @Override
      	            public void actionPerformed(ActionEvent event)
      	            {
      	               
      	            } 
      	         }
      	    );
    	flyttNed = new JButton("Flytt Ned", new ImageIcon(getClass().getResource("Resources/MoveRowDown.GIF")));
    	flyttNed.addActionListener(
    			new ActionListener() // anonymous inner class
      	         {  
      	            // terminerer applikasjonen når bruker trykker avslutt
      	            @Override
      	            public void actionPerformed(ActionEvent event)
      	            {
      	              
      	            } 
      	         }
      	    );
    	addSeparator();
    	hjelp = new JButton("Hjelp", new ImageIcon(getClass().getResource("Resources/HELP.GIF")));
    	hjelp.addActionListener(
    			new ActionListener() // anonymous inner class
      	         {  
      	            // terminerer applikasjonen når bruker trykker avslutt
      	            @Override
      	            public void actionPerformed(ActionEvent event)
      	            {
      	            	JOptionPane.showMessageDialog(getParent(), "Ikke nødvendig??");
      	            } 
      	         }
      	    );
    	
    }
	
    public JButton getNy() {
        return ny;
    }
    
    public JButton getHent() {
    	return hent;
    }
    
    public JButton getLagre() {
    	return lagre; 
    }
    
    public JButton getPreview() {
    	return preview;
    }
    
    public JButton getGenererKode(){
    	return genererKode;
    }
    
    public JButton getNyRad(){
    	return nyRad;
    }
    
    public JButton getFlyttOpp() {
    	return flyttOpp;
    }
    
    public JButton getFlyttNed() {
    	return flyttNed;
    }
    
    public JButton getHjelp() {
    	return hjelp; 
    }
    
}
