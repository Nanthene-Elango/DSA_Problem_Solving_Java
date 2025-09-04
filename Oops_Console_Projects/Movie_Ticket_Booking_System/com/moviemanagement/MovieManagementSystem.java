package Oops_Console_Projects.Movie_Ticket_Booking_System.com.moviemanagement;

import java.util.ArrayList;
import java.util.HashMap;


import Oops_Console_Projects.Movie_Ticket_Booking_System.com.movieticketbooking.Movie;
import Oops_Console_Projects.Movie_Ticket_Booking_System.com.movieticketbooking.Show;

public class MovieManagementSystem {

	private ArrayList<Movie> moviesList;
	private ArrayList<Show> showList;
	
	private HashMap<Movie,Show> movieAndShowList;
	
	//default Constructor
	public MovieManagementSystem() {
		
		this.moviesList = new ArrayList<>();
		this.showList = new ArrayList<>();
		this.movieAndShowList = new HashMap<>();
	}

	
	//Update movie title
	public boolean updateMovieTitle(int id, String newTitle) {
		
		for (Movie movie : moviesList) {
			if (movie.getMovieID() == id) {
				movie.setMovieTitle(newTitle);
				return true;
			}
		}
		
		return false;
	}
	
	//update movie language
	public boolean updateMovieLanguage(int id , String language) {
		
		for (Movie movie : moviesList) {
			if (movie.getMovieID() == id) {
				movie.setLanguage(language);
				return true;
			}
		}
		
		return false;
	}
	
	//update movie genre
	public boolean updateMovieGenre(int id , String genre) {
		
		for (Movie movie : moviesList) {
			if (movie.getMovieID() == id) {
				movie.setGenre(genre);
				return true;
			}
		}
		
		return false;
	}
	
	//update sensor details
	public boolean updateMovieSensor(int id ,String sensor) {
		
		for (Movie movie : moviesList) {
			if (movie.getMovieID() == id) {
				movie.setSensorBoard(sensor);
				return true;
			}
		}
		
		return false;
	}
	
	
	//update movie release Date
	public boolean updateMovieReleaseDate(int id , String date) {
		
		for (Movie movie : moviesList) {
			if (movie.getMovieID() == id) {
				movie.setReleaseDate(date);
				return true;
			}
		}
		
		return false;
	}
	

	//update movie duration
	public boolean updateMovieDuration(int id , String duration) {
		
		for (Movie movie : moviesList) {
			if (movie.getMovieID() == id) {
				movie.setDuration(duration);
				return true;
			}
		}
	
		return false;
	}
	
	//update showTimings
	public boolean updateShowTimings(int id, String shows[]) {
		
		for (Movie m : movieAndShowList.keySet()) {
			if (m.getMovieID() == id) {
				if (movieAndShowList.get(m) != null) {
					movieAndShowList.get(m).deallocateSeats();
				}
				addShows(id, shows);
				return true;
			}
		}
		
		return false;
		
	}
	
	//add a new Movie
	public Movie addMovie(String movieTitle , String language , String genre 
			, String sensorBoard ,String duration , String releaseDate) {
		
		Movie m =  new Movie(movieTitle , language , genre 
						,sensorBoard , duration , releaseDate);
		moviesList.add(m);
		movieAndShowList.put(m, null);
		return m;
		 
	}
	
	public void addShows(int id , String[] shows) {
		
		for (Movie i : movieAndShowList.keySet()) {
			if (i.getMovieID() == id) {
				
				Show show = new Show(i , shows);
				show.allocateSeats();
				showList.add(show);
				movieAndShowList.put(i, show);
				
			}
		}
		
	}
	
	public ArrayList<Movie> getMoviesList() {
		return moviesList;
	}


	public ArrayList<Show> getShowList() {
		return showList;
	}



	public HashMap<Movie, Show> getMovieAndShowList() {
		return movieAndShowList;
	}


	//delete a Movie
	public boolean deleteMovie(int movieID) {
		
		for (Movie m : moviesList) {
			if (m.getMovieID() == movieID) {
				moviesList.remove(m);
				movieAndShowList.remove(m, movieAndShowList.get(m));
				m = null;
				return true;
			}
		}
		
		return false;
	}
}
