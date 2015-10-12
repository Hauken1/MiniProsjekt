import java.util.*;

public class Internationalization {
	
	private ResourceBundle messages;
	
	public Internationalization() {
	}

    /**
     * Returns the choosen message
     * @param message
     * @return string with correct language or default set to us
     */
    public String returnMessage(String message) {   	
    	Locale no = new Locale("no", "NO");
    	Locale us = new Locale("en", "US");
    	
    	if(no.equals(Locale.getDefault())) {
    		messages = ResourceBundle.getBundle("MessagesBundle", no);
    		return messages.getString(message);
    	}
    	if(us.equals(Locale.getDefault())) {
    		messages = ResourceBundle.getBundle("MessagesBundle", us);
    		return messages.getString(message);
    	}
    	
    	messages = ResourceBundle.getBundle("MessagesBundle", us);
		return messages.getString(message);
    }
}
