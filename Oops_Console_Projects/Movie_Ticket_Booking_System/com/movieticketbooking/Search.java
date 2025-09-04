package Oops_Console_Projects.Movie_Ticket_Booking_System.com.movieticketbooking;

import Oops_Console_Projects.Movie_Ticket_Booking_System.com.moviemanagement.MovieManagementSystem;

public class Search {


	MovieManagementSystem movies;
	
	Search(MovieManagementSystem m){
		this.movies = m;
		
	}
	
	public void searchByName(String name){
		
	
		boolean check = false;
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-20s %-15s %-15s %-10s %-10s %-15s%n", 
		    "Id", "Title", "Language", "Genre", "CBFC", "Duration", "Release Date");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		for (Movie m : movies.getMoviesList()) {
			
			if (m.getMovieTitle().equalsIgnoreCase(name)) {
				
				
				System.out.printf("%-5d %-20s %-15s %-15s %-10s %-10s %-15s%n",
				        m.getMovieID(), 
				        m.getMovieTitle(), 
				        m.getLanguage(), 
				        m.getGenre(), 
				        m.getSensorBoard(), 
				        m.getDuration(), 
				        m.getReleaseDate());
				
				check = true;
			}
		}
		
		if (!check) {
			System.out.println("\t\t\t\tNo Movies found");
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void searchByGenre(String genre) {
		
		boolean check = false;

		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-20s %-15s %-15s %-10s %-10s %-15s%n", 
		    "Id", "Title", "Language", "Genre", "CBFC", "Duration", "Release Date");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		
		for (Movie m: movies.getMoviesList()) {
			if (m.getGenre().toLowerCase().contains(genre.toLowerCase())) {

				
				System.out.printf("%-5d %-20s %-15s %-15s %-10s %-10s %-15s%n",
				        m.getMovieID(), 
				        m.getMovieTitle(), 
				        m.getLanguage(), 
				        m.getGenre(), 
				        m.getSensorBoard(), 
				        m.getDuration(), 
				        m.getReleaseDate());
				System.out.println("------------------------------------------------------------------------------------------------------------------------");
				
				check = true;
			}
		}
		
		if (!check) {
			System.out.println("\t\t\t\tNo movies found");
		}
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	
	public void searchByLanguage(String language) {
		
		
		boolean check = false;
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-20s %-15s %-25s %-10s %-10s %-15s%n", 
		    "Id", "Title", "Language", "Genre", "CBFC", "Duration", "Release Date");
		System.out.println("----------------------------------------------------------------------------------------------------");
		for (Movie m: movies.getMoviesList()) {
			if (m.getLanguage().equalsIgnoreCase(language)) {

				System.out.println("----------------------------------------------------------------------------------------------------");
				System.out.printf("%-5s %-20s %-15s %-25s %-10s %-10s %-15s%n", 
				    "Id", "Title", "Language", "Genre", "CBFC", "Duration", "Release Date");
				System.out.println("----------------------------------------------------------------------------------------------------");
				
				System.out.printf("%-5d %-20s %-15s %-25s %-10s %-10s %-15s%n",
				        m.getMovieID(), 
				        m.getMovieTitle(), 
				        m.getLanguage(), 
				        m.getGenre(), 
				        m.getSensorBoard(), 
				        m.getDuration(), 
				        m.getReleaseDate());
				
				
				check = true;
			}
		}
		
		if (!check) {
			System.out.println("\t\t\t\tNo movies found");
		}
		System.out.println("----------------------------------------------------------------------------------------------------");
		
	}
}
