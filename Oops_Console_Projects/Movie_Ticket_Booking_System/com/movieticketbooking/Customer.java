package Oops_Console_Projects.Movie_Ticket_Booking_System.com.movieticketbooking;

import java.util.ArrayList;

public class Customer extends User {

	
	private String Address;
	private ArrayList<Booking> bookingHistory;
	
	public Customer(String username , String password) {
		super(username , password);
		this.bookingHistory = new ArrayList<>();
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public ArrayList<Booking> getBookingHistory() {
		return bookingHistory;
	}

	public void setBookingHistory(ArrayList<Booking> bookingHistory) {
		this.bookingHistory = bookingHistory;
	}
	
	
	
}
