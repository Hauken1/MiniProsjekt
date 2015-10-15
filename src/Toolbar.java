import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

/**
 * Makes the Toolbar object and adds all the necessary components.
 * @author Henrik Haukaas
 *
 */
public class Toolbar extends JToolBar {
//VARIABLER-START  
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
//VARIABLER-SLUTT
    /**
     * Class constructor
     * Makes the components for the Toolbar.
     */
    public Toolbar() {
    	inter = new Internationalization();
    	opprettToolbar();
    }
	/**
	 * Makes all the JButtons needed for the Toolbar and adds them to the JToolbar. 
	 * Also adds ImageIcons to all of them.
	 */
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
   
	/**
	 * Used by GridBagFrame to add ny functionality to the the Toolbar.
	 * @return the ny JButton
	 */
    public JButton getNy() {
        return ny;
    }
    /**
     * Used by GridBagFrame to add hent functionality to the the Toolbar.
     * @return the hent JButton
     */
    public JButton getHent() {
    	return hent;
    }
    /**
     * Used by GridBagFrame to add lagre functionality to the the Toolbar.
     * @return the lagre JButton
     */
    public JButton getLagre() {
    	return lagre; 
    }
    /**
     * Used by GridBagFrame to add preview functionality to the the Toolbar.
     * @return the preview JButton
     */
    public JButton getPreview() {
    	return preview;
    }
    /**
     * Used by GridBagFrame to add genererKode functionality to the the Toolbar.
     * @return the genererKode JButton
     */
    public JButton getGenererKode(){
    	return genererKode;
    }
    /**
     * Used by GridBagFrame to add nyRad functionality to the the Toolbar.
     * @return the nyRad JButton
     */
    public JButton getNyRad(){
    	return nyRad;
    }
    /**
     * Used by GridBagFrame to add flyttOpp functionality to the the Toolbar.
     * @return the flyttOpp JButton
     */
    public JButton getFlyttOpp() {
    	return flyttOpp;
    }
    /**
     * Used by GridBagFrame to add flyttNed functionality to the the Toolbar.
     * @return the flyttNed JButton
     */
    public JButton getFlyttNed() {
    	return flyttNed;
    }
    /**
     * Used by GridBagFrame to add hjelp functionality to the the Toolbar.
     * @return the hjelp JButton
     */
    public JButton getHjelp() {
    	return hjelp; 
    }
}
