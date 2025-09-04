package Oops_Console_Projects.Movie_Ticket_Booking_System.com.movieticketbooking;

import java.util.Arrays;

/**
 * class to store and manage the movie booking made by user
 */
public class Booking {

	private Customer user;
	private Movie movie;
	private String showTime;
	private Seat seat[];
	private int noOfSeats;
	
	/**
	 * constructor of the class Booking to initialize the variables
	 * 
	 * @param user
	 * @param movie
	 * @param seat
	 * @param showTime
	 */
	public Booking(Customer user , Movie movie , Seat seat[] , String showTime , int noOfSeats) {
		
		this.user = user;
		this.movie = movie;
		this.seat = seat;
		this.showTime = showTime;
		this.noOfSeats = noOfSeats;
		
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public Seat[] getSeat() {
		return seat;
	}
	public void setSeat(Seat[] seat) {
		this.seat = seat;
	}
	
	@Override
	public String toString() {
	
		return "User name: " + this.user.getUserName() + ", Movie Booked: " + this.movie.getMovieTitle() 
			+ ", Show time: " + this.showTime + ", Seat Details: " + Arrays.toString(seat);
				
	}
	
	/**
	 * method used to display the booking confirmation details
	 */
	public void confirmBooking() {
		
		System.out.println("\t\t\t\t\t\t     ==============");
		System.out.println("-----------------------------------------------------|MOVIE TICKET|----------------------------------------------------");
		System.out.println("\t\t\t\t\t\t     ==============");
		System.out.println();
		
		System.out.println("Your Booking is confirmed!");
		System.out.println("Movie: " + this.movie.getMovieTitle());
		System.out.println("-----------------------");
		System.out.println("show time: " + this.getShowTime());
		System.out.print("Seat: ");
		for (int i = 0 ; i < noOfSeats ; i++) {
			System.out.print(this.seat[i].getSeatId() + " ");
		}
		System.out.println("\nAmount: Rs." + noOfSeats*150);
		System.out.println("\n-----------------------");
		System.out.println("ENJOY THE SHOW!!!\n");
		System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
		user.getBookingHistory().add(this);
	}
	

}
