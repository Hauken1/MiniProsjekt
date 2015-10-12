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
    
    //Strenger for hvor lang de ulike ComboBoxene skal være:
    public static String[] TYPE = new String[]{"JLabel", "JTextField", "JTextArea", "JButton"};
    public static String[] FORANKRING = new String[]{"CENTER", "NORTH", "NORTHEAST", "EAST", "SOUTHEAST", "SOUTH", "SOUTHWEST", "WEST", "NORTHWEST"};
    public static String[] SKALERING = new String[]{"NONE", "HORIZONTAL", "VERTICAL", "BOTH"};
    
    public Komponent() {
    	rad = 0;
        kolonne = 0;
        kolonner = 1;
        rader = 1;
        anker = "java.awt.GridBagConstraints.CENTER";	//Brukes for å sende riktig constraints til nytt program. Dette er default input.
        fyll = "java.awt.GridBagConstraints.NONE";		// ---- | | -----. TODO må endres dynamisk eventuelt med return string funksjon
        forankring = 0;
        skalering = 0;
        variabelnavn = "";
        tekst = "";
        type = 0;
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
                type = (Integer)object;
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
                skalering = (Integer)object;
                break;
            }
            case 8: {
                forankring = (Integer)object;
                break;
            }
        }   
    }
   
}
