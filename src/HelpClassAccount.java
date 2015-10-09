import java.io.Serializable;

public class HelpClassAccount  implements Serializable{
	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	

	public HelpClassAccount() {
		this(0, "Hans", "Engvik", 14.0);
	}
	
	public HelpClassAccount(int account, String firstName, String lastName, double balance) {
		this.account = account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
}
