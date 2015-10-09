import java.util.*;

public class Internationalization {

	private String language;
    private String country;
    
    private Locale currentLocale;
    private ResourceBundle messages;

    public Internationalization() {
		// TODO Auto-generated constructor stub
    	
    	language = new String("en");
        country = new String("US");

	    currentLocale = new Locale(language, country);
	    messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    /**
     * @param message
     * @return string with correct language
     */
    public String returnMessage(String message) {   
	    return messages.getString(message);
    }
}
