import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    	hent = new JButton("Hent", new ImageIcon(getClass().getResource("Resources/OPENDOC.GIF")));
    	lagre = new JButton("Lagre", new ImageIcon(getClass().getResource("Resources/SAVE.GIF")));
    	addSeparator();
    	preview = new JButton("Preview", new ImageIcon(getClass().getResource("Resources/ExecuteProject.GIF")));
    	genererKode = new JButton("Generer Kode", new ImageIcon(getClass().getResource("Resources/savejava.GIF")));
    	addSeparator();
    	nyRad = new JButton("Ny Rad", new ImageIcon(getClass().getResource("Resources/NEWROW.GIF")));
    	flyttOpp = new JButton("Flytt Opp", new ImageIcon(getClass().getResource("Resources/MoveRowUp.GIF")));
    	flyttNed = new JButton("Flytt Ned", new ImageIcon(getClass().getResource("Resources/MoveRowDown.GIF")));
    	addSeparator();
    	hjelp = new JButton("Hjelp", new ImageIcon(getClass().getResource("Resources/HELP.GIF")));
    	
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
    	return flyttOpp;
    }
    
    public JButton getHjelp() {
    	return hjelp; 
    }
    
}
