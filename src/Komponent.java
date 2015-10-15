import java.io.Serializable;
/**
 * Class that makes the component of the TableModel
 * Sets attributes to the given component
 * @author Henrik Haukaas
 *
 */
public class Komponent implements Serializable{
//VARIABLER-START
	int rad;
    int kolonne;
    int kolonner;
    int rader;
    int forankring;
    int skalering;
    int type;
    int textRader;
    int textKolonner;
    int textBredde;
    int textHoyde;
    String anker;
    String fyll;
    String variabelnavn;
    String tekst;
    
    //Strenger for hvor lang de ulike ComboBoxene skal være:
    public static String[] TYPE = new String[]{"JLabel", "JTextField", "JTextArea", "JButton"};
    public static String[] FORANKRING = new String[]{"CENTER", "NORTH", "NORTHEAST", "EAST", "SOUTHEAST", "SOUTH", "SOUTHWEST", "WEST", "NORTHWEST"};
    public static String[] SKALERING = new String[]{"NONE", "HORIZONTAL", "VERTICAL", "BOTH"};
//VARIABLER-SLUTT    
//FUNKSJONER-START
    /**
     * Class constructor
     * Sets the default data for a given Komponent
     */
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
        textRader = 0;
        textKolonner= 0;
        textBredde= 0;
        textHoyde = 0;
        
    }
    
    /**
     * Constructor that sets the data for the given Komponent
     * Calls the main constructor to set all the data
     * @param string	text being set to variabelnavn string
     * @param string2	text being set to tekst string
     * @param n	integer being set to the rad variable
     * @param n2 integer being set to the kolonne variable
     * @param n3 integer being set to the kolonner variable
     * @param n4 integer being set to the rader variable
     */
    public Komponent(String string, String string2, int n, int n2, int n3, int n4){
    	this();
		rad = n;
		kolonne = n2;
		kolonner = n3;
		rader = n4;
		variabelnavn = string; 
		tekst = string2; 
	}
    /**
     * gets the data of the given column and returns it
     * @param n	Column number
     * @return	returns the data of the given column
     */
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
            case 9: {
                return new Integer(textRader);
            }
            case 10: {
                return new Integer(textKolonner);
            }
            case 11: {
                return new Integer(textBredde);
            }
            case 12: {
                return new Integer(textHoyde);
            }
            
            
        }
        return null;
    }
    /**
     * Sets the value of a given column
     * @param n	Column number
     * @param object	data that is being set to the column object
     */
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
    /**
     * Used to give user-chosen attributes to a JTextField or JTextArea 
     * @see editor in Table class (ActionListener)
     * @param n1	Given rows to the JTextArea
     * @param n2	Given columns to JTextArea/JTextField
     * @param n3	Given height to JTextArea/JTextField
     * @param n4	Given width to JTextArea/JTextField
     */
    public void egenskapsEditor(int n1, int n2, int n3, int n4) {
    	textRader = n1;
    	textKolonner = n2; 
    	textHoyde = n3; 
    	textBredde = n4;
    
    }
//FUNKSJONER-SLUTT   
}//KOMPONENT SLUTT
