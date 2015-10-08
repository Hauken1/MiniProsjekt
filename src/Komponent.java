
public class Komponent {

	int rad;
    int kolonne;
    int kolonner;
    int rader;
    int forankring;
    int skalering;
    int type;
    String anker;
    String fyll;
    String variabelnavn;
    String tekst;
    public static String[] TYPE = new String[]{"JLabel", "JButton", "JTextField", "JTextArea", "JCheckBox", "JList", "JComboBox", "JSpinnerList", "JSpinnerNumber"};
    public static String[] FORANKRING = new String[]{"CENTER", "NORTH", "NORTHEAST", "EAST", "SOUTHEAST", "SOUTH", "SOUTHWEST", "WEST", "NORTHWEST"};
    public static String[] SKALERING = new String[]{"NONE", "HORIZONTAL", "VERTICAL", "BOTH"};
    
    public Komponent() {
    	this.rad = 0;
        this.kolonne = 0;
        this.kolonner = 1;
        this.rader = 1;
        this.anker = "java.awt.GridBagConstraints.CENTER";
        this.fyll = "java.awt.GridBagConstraints.NONE";
        this.forankring = 0;
        this.skalering = 0;
        this.variabelnavn = "";
        this.tekst = "";
        this.type = -1;
    }
    
    public Komponent(int n, int n2, int n3, int n4) {
    	this();
    	rad = n;
    	kolonne = n2;
    	kolonner = n3;
    	rader = n4;
    }
}
