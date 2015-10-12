import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar {
	private Internationalization inter;
	
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
    	inter = new Internationalization();
    	opprettToolbar();
    }
	
    public void opprettToolbar () {
    	ny = new JButton(inter.returnMessage("new"), new ImageIcon(getClass().getResource("Resources/NEW.GIF")));
    	add(ny);
    	
    	hent = new JButton(inter.returnMessage("load"), new ImageIcon(getClass().getResource("Resources/OPENDOC.GIF")));
    	add(hent);
    	
    	lagre = new JButton(inter.returnMessage("save"), new ImageIcon(getClass().getResource("Resources/SAVE.GIF")));
    	add(lagre);
    	
    	addSeparator();
    	preview = new JButton(inter.returnMessage("preview"), new ImageIcon(getClass().getResource("Resources/ExecuteProject.GIF")));
    	add(preview);
    	
    	genererKode = new JButton(inter.returnMessage("SourceCode"), new ImageIcon(getClass().getResource("Resources/savejava.GIF")));
    	add(genererKode);
    	
    	addSeparator();
    	nyRad = new JButton(inter.returnMessage("newRow"), new ImageIcon(getClass().getResource("Resources/NEWROW.GIF")));
    	add(nyRad);
    	
    	flyttOpp = new JButton(inter.returnMessage("rowUp"), new ImageIcon(getClass().getResource("Resources/MoveRowUp.GIF")));
    	add(flyttOpp);
    	
    	flyttNed = new JButton(inter.returnMessage("rowDown"), new ImageIcon(getClass().getResource("Resources/MoveRowDown.GIF")));
    	add(flyttNed);
    	
    	addSeparator();
    	hjelp = new JButton(inter.returnMessage("help"), new ImageIcon(getClass().getResource("Resources/HELP.GIF")));
    	add(hjelp);
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
