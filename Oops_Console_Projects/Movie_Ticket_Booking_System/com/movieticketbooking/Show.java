package Oops_Console_Projects.Movie_Ticket_Booking_System.com.movieticketbooking;

import java.util.Arrays;

public class Show {

	Movie movie;
	String[] showTimings;
	Seat[][] seat;
	
	public Show(Movie movie , String[] shows) {
		
		this.movie = movie;
		this.showTimings = shows;
		this.seat = new Seat[shows.length][12];
		
	}
	
	
	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public String[] getShowTimings() {
		return showTimings;
	}


	public void setShowTimings(String[] showTimings) {
		this.showTimings = showTimings;
	}


	public Seat[][] getSeat() {
		return seat;
	}


	public void setSeat(Seat[][] seat) {
		this.seat = seat;
	}


	public void allocateSeats() {
		
		for (int i = 0 ; i < showTimings.length ; i++) {
			
			seat[i][0] = new Seat("A1");
			seat[i][1] = new Seat("A2");
			seat[i][2] = new Seat("A3");
			seat[i][3] = new Seat("B1");
			seat[i][4] = new Seat("B2");
			seat[i][5] = new Seat("B3");
			seat[i][6] = new Seat("C1");
			seat[i][7] = new Seat("C2");
			seat[i][8] = new Seat("C3");
			seat[i][9] = new Seat("C1");
			seat[i][10] = new Seat("C2");
			seat[i][11] = new Seat("C3");
		}

	}
	
	public void deallocateSeats() {
		for (int i = 0 ; i < showTimings.length ; i++) {
			
			seat[i][0] = null;
			seat[i][1] = null;
			seat[i][2] = null;
			seat[i][3] = null;
			seat[i][4] = null;
			seat[i][5] = null;
		}

	}

	public int getSeatsAvailable(int showIndex) {
		
		int count = 0;
		for (Seat seat : seat[showIndex]) {
			if (seat.isAvailable()) {
				count++;
			}
		}
		return count;
	}
	
	public int getShowIndex(String showTime) {
		
		for (int i = 0 ; i < showTimings.length ; i++) {
			if (showTimings[i].equalsIgnoreCase(showTime)) {
				return i;
			}
		}
		return -1;
		
	}
	
	/**
	 * method used to display the available show timings.
	 */
	public void displayShows() {
		//System.out.println("The Show timings of " + this.movie.getMovieTitle() + ": ");
		System.out.println(Arrays.toString(showTimings));
	}
	
	/**
	 * method used to display the seats availability for a specific show.
	 */
	public void displaySeats(int showIndex) {
		
		System.out.println("Seats Availability for " + this.showTimings[showIndex] + " show: ");
		int i = 0;
		while (i < seat[showIndex].length) {
			for (int j = 0 ; j < 3 ; j++) {
				System.out.print(seat[showIndex][i++] + " ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * method used to get a specific seat based on the showIndex and seatId;
	 */
	public Seat getSeat(int showIndex , String seatId) {
		
		for (Seat seat : this.seat[showIndex]) {
			if (seat.getSeatId().equals(seatId)) {
				return seat;
			}
		}
		return null;
	}
	
}
