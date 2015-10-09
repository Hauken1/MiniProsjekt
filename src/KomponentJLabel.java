
public class KomponentJLabel extends Komponent {

	public KomponentJLabel() {
		type = 0;
	}
	
	public KomponentJLabel(Komponent komponent) {
		super();
		type = 0; 
		
	}
	public KomponentJLabel(String string, String string2, int n, int n2, int n3, int n4){
		super(n,n2,n4,n3);
		type = 0;
		variabelnavn = string; 
		tekst = string2; 
	}
	
}
