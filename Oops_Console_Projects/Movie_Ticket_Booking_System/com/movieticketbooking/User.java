package Oops_Console_Projects.Movie_Ticket_Booking_System.com.movieticketbooking;

/**
 * class to store the details of the user
 */

public class User {

	private final String userName;
	private String password;
	private String email;
	private long phoneNumber;

	/**
	 * Constructor of the User class to initialize
	 * the variable (userName and password)
	 * 
	 * @param userName represents the username of the users
	 * @param password represents the password of the users
	 */
	public User(String userName , String password) {
		
		this.userName = userName;
		this.password = password;
	
	}
 
	/**
	 * method to get the userName of the User
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * method to get the password of the User
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *method to set the password of the User
	 * 
	 * @param password 
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * validate the username and password entered by the user is correct.
	 */
	public boolean validate(String username , String password) {
		
		return (this.userName.equals(username) && this.password.equals(password));
	}
	
	/**
	 * method used to change the password of the user
	 * 
	 * @param newPassword
	 */
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	/**
	 * Overridden method to convert the user object into a string 
	 */
	@Override
	public String toString() {
		return "Username: " + userName + "\nPassword: " + password;
	}
	
}
