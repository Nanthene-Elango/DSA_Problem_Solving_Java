package Oops_Console_Projects.Movie_Ticket_Booking_System.com.movieticketbooking;

/**
 * class to store the details of the seat.
 */

public class Seat {

	private String seatId;
	private boolean isReserved;
	
	/**
	 * Constructor of the Seat class to initialize 
	 * seatId and isReserved.
	 * 
	 * @param seatId
	 */
	public Seat(String seatId) {
		this.seatId = seatId;
		isReserved = false;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public boolean getReserved() {
		return isReserved;
	}

	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	/**
	 * method to check whether the seat is available or not.
	 */
	public boolean isAvailable() {
		return !isReserved;
	}
	
	/**
	 * method used to reserve the seat.
	 */
	public void reserve() {
		isReserved = true;
	}
	
	/**
	 * method used to Unreserve the seat.
	 */
	public void unReserve() {
		isReserved = false;
	}
	
	/**
	 * method to display the details of the seat.
	 */
	public void DisplaySeatDetails() {
		System.out.println("Seat Details:");
		System.out.println("Seat ID: " + seatId);
		System.out.println("Is Reserved: " + isReserved);
	}
	
	@Override
	public String toString() {
		return seatId + " " + (isReserved?"[X]":"[ ]");
	}
}
