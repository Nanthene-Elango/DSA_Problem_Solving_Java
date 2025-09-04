package Oops_Console_Projects.Movie_Ticket_Booking_System.com.movieticketbooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import Oops_Console_Projects.Movie_Ticket_Booking_System.com.moviemanagement.Admin;
import Oops_Console_Projects.Movie_Ticket_Booking_System.com.moviemanagement.MovieManagementSystem;

public class TicketBooking {

	MovieManagementSystem movieManagement = new MovieManagementSystem();
	ArrayList<Customer> customers = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	
	
	//Method to display the Customers's booking history
	public void displayUserBookingHistory() {
	
		System.out.println("\t\t\t\t===============");
		System.out.println("\t\t\t\tBOOKING HISTORY");
		System.out.println("\t\t\t\t===============");
		
		if (customers.isEmpty()) {
			System.out.println("No users found!\n");
			return;
		}
		
		for (Customer c : customers) {
			
			if (c.getBookingHistory() != null) {
				System.out.println(c.getBookingHistory());
			}
			else {
				System.out.println("No Bookings done!");
			}
		}
		System.out.println();
	}
	
	//method to diplay the movie details
	public void displayMovieDetails() {
		
		System.out.println("\t\t\t\t\t\t\t-------------");
		System.out.println("\t\t\t\t\t\t\tMOVIE DETAILS");
		System.out.println("\t\t\t\t\t\t\t-------------");

		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-20s %-15s %-15s %-10s %-10s %-15s %-25s%n", 
		    "Id", "Title", "Language", "Genre", "CBFC", "Duration", "Release Date", "Show Timings");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");

		for (Movie m : movieManagement.getMovieAndShowList().keySet()) {
			
		    String[] showTimings = (movieManagement.getMovieAndShowList().get(m) != null)
		    		?(movieManagement.getMovieAndShowList().get(m).getShowTimings())
		    		:null ;
		    
		    String showTimesFormatted = (showTimings != null && showTimings.length > 0) 
		        ? String.join(", ", showTimings) 
		        : "No shows available";

		    System.out.printf("%-5d %-20s %-15s %-15s %-10s %-10s %-15s %-25s%n",
		        m.getMovieID(), 
		        m.getMovieTitle(), 
		        m.getLanguage(), 
		        m.getGenre(), 
		        m.getSensorBoard(), 
		        m.getDuration(), 
		        m.getReleaseDate(),
		        showTimesFormatted);
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------\n");

		return;
		
	}
	
	//method to manage the admin profile
	public void adminProfileManagement(Admin a) {
	
		while (true) {
			
			System.out.println("\t\t\t\t==================");
			System.out.println("\t\t\t\tPROFILE MANAGEMENT");
			System.out.println("\t\t\t\t==================");
			
			System.out.println("1.Update Details\n2.View Profile\n3.Exit");
			System.out.print("Enter your option: ");
			int option = input.nextInt();
			System.out.println();
			
			if (option == 1) {
				
				System.out.println("\t\t\t\t==============");
				System.out.println("\t\t\t\tUPDATE DETAILS");
				System.out.println("\t\t\t\t==============");
				
				System.out.println("1.Password\n2.Phone Number\n3.Email id");
				System.out.print("Choose an option[1-4]: ");
				option = input.nextInt();
				System.out.println();
				
				if (option == 1) {
					
					System.out.print("Enter a new password: ");
					String password = input.next();
					
					a.setPassword(password);
					
					System.out.println("Password updated successfully!\n");
					
				}
				else if (option == 2) {
					
					System.out.print("Enter phone number: ");
					long number = input.nextLong();
					
					a.setPhoneNumber(number);
					
					System.out.println("Phone number updated successfully!\n");
					
				}
				else if (option == 3) {
					
					System.out.print("Enter email Id: ");
					String email = input.next();
					
					a.setEmail(email);
					
					System.out.println("Email Id updated successfully!\n");
				}
			}
			else if (option == 2) {
				
				System.out.println("\t\t\t\t=============");
				System.out.println("\t\t\t\tADMIN PROFILE");
				System.out.println("\t\t\t\t=============");
				
				System.out.println("\t\t\t   Name        : " + a.getUserName());
				System.out.println("\t\t\t   Phone number: " + a.getPhoneNumber());
				System.out.println("\t\t\t   E-mail      : " + a.getEmail());
				System.out.println();
			}
			else if (option == 3) {
				
				return;
			}
			else {
				System.out.println("Invalid option\nTry again\n");
			}
		}
	}
	
	//method to validate the input value
	public int getInputInt(){
		
        while (!input.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            input.next();
        }
        
        return input.nextInt();
    }
	
	//method to add movie
	public void addMovie() {
		
		System.out.println("Enter movie details:");

		input.nextLine();
		System.out.print("Title                         : ");
		String title = input.nextLine();
		
		System.out.print("Language                      : ");
		String language = input.next();

		System.out.print("Genre                         : ");
		String genre = input.next();

		System.out.print("CBFC                          : ");
		String cbfc = input.next();

		System.out.print("Duration(e.g., 2h 15m)        : ");
		input.nextLine();
		String duration = input.nextLine();

		System.out.print("Release Date(e.g., 25-12-2024): ");
		String releaseDate = input.next();
	     
		Movie m = movieManagement.addMovie(title, language, genre, cbfc, duration, releaseDate);
		
		System.out.print("Do you want to add shows?(y/n): ");
		char ans = input.next().charAt(0);
		
		
		if (ans == 'y' || ans == 'Y') {
			
			System.out.println("\nEnter the details of the show");
			System.out.print("Enter the no of shows: ");
			int noOfShows = input.nextInt();
			
			String[] shows = new String[noOfShows];
			System.out.println("Enter the show timings(eg. 2:00PM): ");
			for (int i = 0 ; i < noOfShows ; i++) {
				System.out.print("Show " + (i+1) + " time: ");
				shows[i] = input.next();
			}
			System.out.println();
			movieManagement.addShows(m.getMovieID() , shows);
			
		}
		
		System.out.println("Movie added successfully!\n");
		
		return;
	}
	
	
	//method to update the movie details
	public void updateMovie() {
		
		while (true) {
			
			System.out.println("Which you want to update?");
			System.out.println("1.Title");
			System.out.println("2.Language");
			System.out.println("3.Genre");
			System.out.println("4.CBFC");
			System.out.println("5.Duration");
			System.out.println("6.Release Date");
			System.out.println("7.Show Timings");
			System.out.println("8.Exit");
			
			System.out.print("Enter yout option[1-8]: ");
			int option = getInputInt();
			System.out.println();
			
			if (option == 1) {
		
				System.out.print("Enter the movie id: ");
				int id = getInputInt();
				
				input.nextLine();
				System.out.print("Enter the new title: ");
				String newTitle = input.nextLine();
				
				if (!movieManagement.updateMovieTitle(id, newTitle)) {
					System.out.println("\nUpdation failed!\nNo movie found");
				}
				System.out.println("Updated Successfully!\n");
				
			}
			else if (option == 2) {
				
				System.out.print("Enter the movie Id: ");
				int id = getInputInt();
				System.out.print("Enter the language: ");
				String language = input.next();
				
				if (!movieManagement.updateMovieLanguage(id, language)) {
					System.out.println("\nUpdation failed!\nNo movie found");
				}
				System.out.println("Updated Successfully!\n");
				
			}
			else if (option == 3) {
				
				System.out.print("Enter the movie Id: ");
				int id = getInputInt();
				System.out.print("Enter the Genre: ");
				String genre = input.next();
				
				if (!movieManagement.updateMovieGenre(id, genre)) {
					System.out.println("\nUpdation failed!\nNo movie found");
				}
				System.out.println("Updated Successfully!\n");
				
			}
			else if (option == 4) {
				
				System.out.print("Enter the movie Id: ");
				int id = getInputInt();
				System.out.print("Enter the CBFC: ");
				String cbfc = input.next();
				
				if (!movieManagement.updateMovieSensor(id, cbfc)) {
					System.out.println("\nUpdation failed!\nNo movie found");
				}
				System.out.println("Updated Successfully!\n");
				
			}
			else if (option == 5) {
				
				System.out.print("Enter the movie Id: ");
				int id = getInputInt();
				System.out.print("Enter the Duration[hh'h' mm'm']: ");
				String duration = input.next();
				
				if (!movieManagement.updateMovieDuration(id, duration)) {
					System.out.println("\nUpdation failed!\nNo movie found");
				}
				System.out.println("Updated Successfully!\n");
				
			}
			else if (option == 6) {
				
				System.out.print("Enter the movie Id: ");
				int id = getInputInt();
				System.out.print("Enter the Release date: ");
				String date = input.next();
				
				if (!movieManagement.updateMovieReleaseDate(id, date)) {
					System.out.println("\nUpdation failed!\nNo movie found");
				}
				System.out.println("Updated Successfully!\n");
				
			}
			else if (option == 7) {
				
				System.out.print("Enter the movie Id: ");
				int id = getInputInt();
				System.out.print("Enter the no of shows: ");
				int noOfShows = input.nextInt();
				
				String[] shows = new String[noOfShows];
				System.out.println("Enter the show timings: ");
				for (int i = 0 ; i < noOfShows ; i++) {
					System.out.print("Show " + (i+1) + " time: ");
					shows[i] = input.next();
				}
				System.out.println();
				
				if (!movieManagement.updateShowTimings(id, shows)) {
					System.out.println("\nUpdation failed!\nNo movie found");
				}
				System.out.println("Updated Successfully!\n");
			}
			else if (option == 8) {
				return;
			}
			else {
				System.out.println("Invalid option!\nTry again..\n");
			}
		}

	}
	
	
	//method to delete the movie
	public void deleteMovie() {
		
		System.out.print("Enter the movie Id which you want to delete: ");
		int id = getInputInt();
		
		if (movieManagement.deleteMovie(id)) {
			System.out.println("Successfully deleted!\n");
		}
		else {
			System.out.println("Deletion Unsuccessful\nNo Movie Found!\n");
		}
		return;
	}
	
	
	//method to facilitate movie management
	public void movieManagement() {
		
		while (true) {
			
			System.out.println("\t\t\t\t\t\t  ==================");
			System.out.println("--------------------------------------------------|MOVIE MANAGEMENT|--------------------------------------------------");
			System.out.println("\t\t\t\t\t\t  ==================");
			System.out.println();
			
			System.out.println("1.Add a movie\n2.Update a movie\n3.Delete a Movie\n4.list movies\n5.Exit");
			System.out.print("Choose an option[1-3]: ");
			int option = getInputInt();
			System.out.println();
			
			if (option == 1) {
				
				while (true) {
					
					System.out.println("1.Add movie details\n2.Add show details\n3.back");
					System.out.print("Enter your option[1-3]: ");
					int choice = getInputInt();
					System.out.println();
					
					if (choice == 1) addMovie();
					
					else if (choice == 2) {
						System.out.print("Enter movie id to add show: ");
						int id = getInputInt();
						
						System.out.print("Enter the no of shows: ");
						int noOfShows = getInputInt();
						
						String[] shows = new String[noOfShows];
						
						System.out.println("Enter the show timings(eg. 2:00PM): ");
						for (int i = 0 ; i < noOfShows ; i++) {
							System.out.print("Show " + (i+1) + " time: ");
							shows[i] = input.next();
						}
						System.out.println();
						movieManagement.addShows(id , shows);
					}
					else if (choice == 3) {
						break;
					}
					else {
						System.out.println("Invalid option\nTry again!\n");
					}
				}
			}
			
			else if (option == 2) updateMovie();
			
			else if (option == 3) deleteMovie();
			
			else if (option == 4) displayMovieDetails();
	
			
			else if (option == 5) {
				
				System.out.println();
				return;
			}
			
			else System.out.print("Invalid option\ntry again!");
			
		}
		
	}
	
	//method to display the show timings for a particular movie
	public void displayShowTime(Movie m) {
	
		System.out.println("Available show Timings: ");
		System.out.println("---------------------------------------------");
		System.out.printf("%-5s %-20s %-25s%n", 
		    "Id", "Title", "Show Timings");
		System.out.println("---------------------------------------------");

		String[] showTimings = (movieManagement.getMovieAndShowList().get(m) != null)?(movieManagement.getMovieAndShowList().get(m).getShowTimings()):null ;
	    String showTimesFormatted = (showTimings != null && showTimings.length > 0) 
	        ? String.join(", ", showTimings) 
	        : "No shows available";

	    System.out.printf("%-5d %-20s %-25s%n",
	        m.getMovieID(), 
	        m.getMovieTitle(), 
	        showTimesFormatted);

		System.out.println("---------------------------------------------\n");

	}
	
	
	//method used to register the customer
	public Customer register() {
		
		boolean registered = false;
		String username = "", password = "";
		String email = "",address = "";
		long phoneNumber = 0;
		
		while (!registered) {
			
			System.out.println("\t\t\t\t\t\t     ==============");
			System.out.println("-----------------------------------------------------|REGISTRATION|----------------------------------------------------");
			System.out.println("\t\t\t\t\t\t     ==============");
			System.out.println();
			
			System.out.println("Enter your details to complete your registration!");
			System.out.print("Username    : ");
			username = input.next();
		
			for (Customer c : customers) {
				if (c.getUserName().equals(username)) {
					System.out.println("Username already exist\nTry other name!\n");
					continue;
				}
			}
			
			registered = true;
			System.out.print("Password    : ");
			password = input.next();
			
			System.out.print("Email       : ");	
			email = input.next();
			
			System.out.print("Phone number: ");
			phoneNumber = input.nextLong();
			
			System.out.print("Address     : ");
			address = input.next();
			
		}
		
		System.out.println();
		Customer user = new Customer(username , password);
		user.setAddress(address);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		customers.add(user);
		System.out.println("Registered Successfully!\n");
		return login();
	}
	
	
	//method used to login the customer
	public Customer login() {
		
		System.out.println("\t\t\t\t\t\t     ============");
		System.out.println("-----------------------------------------------------|USER LOGIN|----------------------------------------------------");
		System.out.println("\t\t\t\t\t\t     ============");
		System.out.println();
		
		System.out.println("Enter your username and password to login: ");
		System.out.print("Username: ");
		String username = input.next();
		
		System.out.print("Password: ");
		String password = input.next();
		System.out.println();
		
		for (Customer c : customers) {
			
			if (c.validate(username, password)) 
			{
				System.out.println("                                 --------------------(Logged in)--------------------                                 \n");
				return c;
			}
		}
		
		System.out.println("Invalid username or password!\ntry again\n");
		return login();
	}
	
	
	//Method used to book a movie
	public void bookMovie(Customer u) {
		
		
		Movie movie = null;
		Customer user = u;
		String showTime = null;
		Seat[] seat;
		
		while (true) {
			
			System.out.println("\t\t\t\t\t\t    ===============");
			System.out.println("----------------------------------------------------|MOVIE BOOKING|----------------------------------------------------");
			System.out.println("\t\t\t\t\t\t    ===============");
			System.out.println();
			
			System.out.print("Enter the movie Id: ");
			int movieId = getInputInt();
			System.out.println();
			
			
			for (Movie m : movieManagement.getMoviesList()) {
				
				if (m.getMovieID() == movieId) {
					movie = m;
					break;
				}
				
			}
			
			
			if (movie == null) {
				System.out.print("No movie found\ntry again\n");
				continue;
			}
			break;
			
			
		}
		
		if (movieManagement.getMovieAndShowList().get(movie).getShowTimings() == null) {
			System.out.println("No shows available for this movie");
			return;
		}
		
		HashMap<Movie,Show> map = movieManagement.getMovieAndShowList();
		int showIndex;
		
		while (true) {
			
			displayShowTime(movie);
			
			if (map.get(movie).getShowTimings() == null) {
				System.out.print("No shows currently available for this movie!");
				return;
			}
			
			System.out.print("Enter the show time(eg. 2:00PM): ");
			showTime = input.next();
			System.out.println();
			
			showIndex = map.get(movie).getShowIndex(showTime);
				
			if (showIndex == -1) {
				System.out.println("Invalid show time!\ntry again\n");
				continue;
			}
			break;
					
		}
		
		loop:
		while (true) {
					
			map.get(movie).displaySeats(showIndex);
			System.out.println();
			System.out.print("\nEnter the number of seats: ");
			int noOfSeats = getInputInt();
			seat = new Seat[noOfSeats];
			System.out.println();
			
			if (map.get(movie).getSeatsAvailable(showIndex) >= noOfSeats) {
				
				for (int i = 1 ; i <= noOfSeats ; i++) {
					
					System.out.print("Enter the seat " + i + " Id(eg. A1): ");
					String seatId = input.next();
					
					seat[i-1] = map.get(movie).getSeat(showIndex, seatId);
								
					if (seat[i-1] != null && seat[i-1].isAvailable()) {
						seat[i-1].reserve();
					}
					else {
						System.out.println("The seat id is invalid/reserved!\ntry again\n");
						continue loop;
					}
					
				}
				System.out.println();
				payment(user , movie , seat , showTime , noOfSeats);
				return;
				
			}
			else {
				System.out.println(noOfSeats + " seats are not available for this show!");
				return;
			}
						
		}
		
	}
	
	
	//Method used to process the payment
	public void payment(Customer user , Movie movie , Seat[] seat , String showTime , int noOfSeats) {
		
		
		System.out.println("\t\t\t\t\t\t       =========");
		System.out.println("-------------------------------------------------------|PAYMENT|------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t       =========");
		System.out.println();
		
		System.out.println("Payment options:");
		System.out.println("1.Credit card\n2.Cash\n");
		System.out.print("Enter your option: ");
		int option = getInputInt();
		
		if (option == 1) {
			System.out.println("\t\t\t\t\t\t     =================");
			System.out.println("-----------------------------------------------------|PAYMENT INVOICE|----------------------------------------------------");
			System.out.println("\t\t\t\t\t\t     =================");
			System.out.println();
			
			System.out.println("Amount : Rs." + (noOfSeats * 150));
			System.out.println("-------------------------------");
			System.out.print("Enter your card number: ");
			long cardNum = input.nextLong();
			System.out.print("Card holder name      : ");
			String name = input.next();
			System.out.print("Expiration date(mm/yy): ");
			String date = input.next();
			System.out.print("CVV                   : ");
			int cvv = input.nextInt();
			System.out.println("-------------------------------");
			
			System.out.print("Pay Rs." + (noOfSeats * 150) + " ?(y/n): ");
			char value = input.next().charAt(0);
			System.out.println();
			
			if (value == 'y' || value == 'Y') {
				System.out.println("Processing payment.......");
				System.out.println("Payment successful!!\n");
				
				Booking booking = new Booking(user,movie,seat,showTime , noOfSeats);
				booking.confirmBooking();
				System.out.println();
				return;
				
			}
			else {
				System.out.println("Payment Unsuccessful\ntry after sometimes..\n");
				for (int i = 0 ; seat[i] != null ; i++) {
					seat[i].unReserve();
				}
			}
		}
		else {
			
			Booking booking = new Booking(user, movie, seat, showTime , noOfSeats);
			booking.confirmBooking();
			System.out.println();
			return;
			
		}
		
		
	}
	

	//Method used to manage the user profile
	public void userProfileManagement(Customer user) {
		
		while (true) {
			
			System.out.println("\t\t\t\t==================");
			System.out.println("\t\t\t\tPROFILE MANAGEMENT");
			System.out.println("\t\t\t\t==================");
			
			System.out.println("1.Update Details\n2.Exit");
			System.out.print("Enter your option: ");
			int option = input.nextInt();
			System.out.println();
			
			if (option == 1) {
				
				System.out.println("\t\t\t\t==============");
				System.out.println("\t\t\t\tUPDATE DETAILS");
				System.out.println("\t\t\t\t==============");
				
				System.out.println("1.Password\n2.Phone Number\n3.Email id\n4.Address");
				System.out.print("Choose an option[1-4]: ");
				option = input.nextInt();
				System.out.println();
				
				if (option == 1) {
					
					System.out.print("Enter a new password: ");
					String password = input.next();
					
					user.setPassword(password);
					
					System.out.println("Password updated successfully!\n");
					
				}
				else if (option == 2) {
					
					System.out.print("Enter phone number: ");
					long number = input.nextLong();
					
					user.setPhoneNumber(number);
					
					System.out.println("Phone number updated successfully!\n");
					
				}
				else if (option == 3) {
					
					System.out.print("Enter email Id: ");
					String email = input.next();
					
					user.setEmail(email);
					
					System.out.println("Email Id updated successfully!\n");
				}
				else if (option == 4) {
					System.out.print("Enter your new Address: ");
					String address = input.nextLine();
					input.next();
					
					user.setAddress(address);
					System.out.println("Address updated successfully!\n");
				}
				else {
					System.out.println("Invalid option\nTry again\n");
				}
			}
			else if (option == 2) {
				
				return;
			}
			else {
				System.out.println("Invalid option\nTry again\n");
			}
		}
	}
	
	//Method user to display the user details
	public void displayCustomerDetails(Customer user) {
		
		System.out.println("\t\t\t\t============");
		System.out.println("\t\t\t\tUSER PROFILE");
		System.out.println("\t\t\t\t============");
		
		System.out.println("\t\t\t   Name        : " + user.getUserName());
		System.out.println("\t\t\t   Phone number: " + user.getPhoneNumber());
		System.out.println("\t\t\t   E-mail      : " + user.getEmail());
		System.out.println("\t\t\t   Address     : " + user.getAddress());
	}

	public void searchMovie() {

		Search s = new Search(movieManagement);
		
		System.out.println("\t\t\t\t=============");
		System.out.println("\t\t\t\tSEARCH MOVIES");
		System.out.println("\t\t\t\t=============");
		
		System.out.println();
		
		System.out.println("1.Search by title\n2.Search by genre\n3.Search by language\n4.Exit");
		System.out.print("Enter your choice[1-4]: ");
		int choice = getInputInt();
		
		if (choice == 1) {
			
			input.nextLine();
			System.out.print("Enter the title: ");
			String name = input.nextLine();
			s.searchByName(name);
		}
		else if (choice == 2) {
			
			input.nextLine();
			System.out.print("Enter the genre: ");
			String genre = input.next();
			s.searchByGenre(genre);
		}
		else if (choice == 3) {
			
			input.nextLine();
			System.out.print("Enter the language: ");
			String language = input.next();
			s.searchByLanguage(language);
			
		}
		else if (choice == 4) {
			
			return;
		}
		else {
			System.out.println("Invalid choice!try again");
		}
		
	}
	
}
