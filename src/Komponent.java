import java.io.Serializable;

public class Komponent implements Serializable{

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
    	rad = 0;
        kolonne = 0;
        kolonner = 1;
        rader = 1;
        anker = "java.awt.GridBagConstraints.CENTER";
        fyll = "java.awt.GridBagConstraints.NONE";
        forankring = 0;
        skalering = 0;
        variabelnavn = "";
        tekst = "";
        type = -1;
    }
    
    public Komponent(int n, int n2, int n3, int n4) {
    	this();
    	rad = n;
    	kolonne = n2;
    	kolonner = n3;
    	rader = n4;
    }
    
    public Object getKolonne(int n) {
        switch (n) {
            case 0: {
                return new Integer(type);
            }
            case 1: {
                return variabelnavn;
            }
            case 2: {
                return tekst;
            }
            case 3: {
                return new Integer(rad);
            }
            case 4: {
                return new Integer(kolonne);
            }
            case 5: {
                return new Integer(rader);
            }
            case 6: {
                return new Integer(kolonner);
            }
            case 7: {
                return new Integer(skalering);
            }
            case 8: {
                return new Integer(forankring);
            }
        }
        return null;
    }
    
    public void setKolonne(int n, Object object) {
        switch (n) {
            case 0: {
                this.type = (Integer)object;
                break;
            }
            case 1: {
                variabelnavn = (String)object;
                break;
            }
            case 2: {
                tekst = (String)object;
                break;
            }
            case 3: {
                rad = (Integer)object;
                break;
            }
            case 4: {
                kolonne = (Integer)object;
                break;
            }
            case 5: {
                rader = (Integer)object;
                break;
            }
            case 6: {
                kolonner = (Integer)object;
                break;
            }
            case 7: {
            	
                //this.skalering = (Integer)object;
                //this.setUtfylling(SKALERING[this.skalering]);
                break;
            }
            case 8: {
                //this.forankring = (Integer)object;
                //this.setAnker(FORANKRING[this.forankring]);
            }
        }
    }
   
    
    
}
