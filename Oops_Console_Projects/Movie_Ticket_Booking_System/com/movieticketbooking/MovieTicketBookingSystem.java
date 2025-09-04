package Oops_Console_Projects.Movie_Ticket_Booking_System.com.movieticketbooking;

import java.util.Scanner;
import Oops_Console_Projects.Movie_Ticket_Booking_System.com.moviemanagement.Admin;

/**
 * Main class to manage the overall movie booking system.
 * 
 * @author Nanthene
 * @version 1
 * @since 25-12-2024
 */

public class MovieTicketBookingSystem {

    /**
     * Main method to manage the movie booking system,
     * prompts the user to choose a movie, showtime, and seat
     * for booking.
     * @param args
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        TicketBooking obj = new TicketBooking();

        System.out.println("\t\t\t\t\t   ===============================");
        System.out.println("__________________________________________|WELCOME TO MOVIE BOOKING SYSTEM|__________________________________________");
        System.out.println("\t\t\t\t\t   ===============================");
        System.out.println();

        while (true) {
        	
            try {
            	
                System.out.println("1.Admin\n2.User\n3.Guest\n4.Exit Application");
                System.out.print("Choose an option[1-4]: ");
                int option = obj.getInputInt();
                System.out.println();

                if (option == 1) {
                	
                    handleAdminOperations(input, obj);
                    
                } else if (option == 2) {
                	
                    handleUserOperations(input, obj);
                    
                }else if (option == 3) {
                	
                	handleGuestOperations(input , obj);
                	
                }else if (option == 4) {
                	
                    System.out.println("Closing Application....");
                    input.close();
                    return;
                    
                } else {
                	
                    System.out.println("Invalid Option!\nTry again\n");
                    
                }
                
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

	private static void handleAdminOperations(Scanner input, TicketBooking obj) {
    	
        try {
        	
            Admin a = new Admin();
            
            while (true) {
            	
                System.out.println("\t\t\t\t\t\t    =============");
                System.out.println("____________________________________________________|ADMIN LOGIN|____________________________________________________");
                System.out.println("\t\t\t\t\t\t    =============");
                System.out.println();

                System.out.println("Please enter your username and password to continue!");
                System.out.print("Username: ");
                String username = input.next();
                System.out.print("Password: ");
                String password = input.next();
                System.out.println();

                if (!a.validate(username, password)) {
                	
                    System.out.println("Invalid Username/Password[!]\n\n1.Try again\n2.Change password");
                    System.out.print("Enter an option: ");
                    int option = input.nextInt();
                    System.out.println();

                    if (option == 1) continue;

                    else if (option == 2) {
                    	
                        System.out.print("Enter a new password: ");
                        String newPassword = input.next();
                        a.changePassword(newPassword);
                        continue;
                        
                    } else {
                    	
                        System.out.println("Invalid option!");
                        
                    }
                    
                } else {
                	
                    System.out.println("                                 --------------------(Logged in)--------------------                                 \n");
                    break;
                    
                }
            }

            while (true) {
            	
                System.out.println("1.Movie Management\n2.Profile Management\n3.View user history\n4.Logout");
                System.out.print("Enter your option: ");
                int option = obj.getInputInt();
                System.out.println();

                if (option == 1) obj.movieManagement();
                
                else if (option == 2) obj.adminProfileManagement(a);
                
                else if (option == 3) obj.displayUserBookingHistory();
                
                else if (option == 4) {
                	
                    System.out.println("                                ----------------------(Logged out)--------------------                                \n");
                    break;
                    
                } else {
                	
                    System.out.println("Invalid option!\nTry again");
                    
                }
                
            }
            
        } catch (Exception e) {
        	
            System.out.println("An error occurred in Admin operations: " + e.getMessage());
            
        }
    }

    private static void handleUserOperations(Scanner input, TicketBooking obj) {
    	
        try {
            System.out.println("\t\t\t\t\t\t     ============");
            System.out.println("_____________________________________________________|USER LOGIN|_____________________________________________________");
            System.out.println("");

            loop:
            while (true) {
            	
                System.out.println("1.View Available Movies\n2.Book a movie\n3.Exit");
                System.out.print("Enter your option[1-3]: ");
                int option = obj.getInputInt();
                System.out.println();

                if (option == 1) obj.displayMovieDetails();

                else if (option == 2) {
                	
                    Customer user;
                    System.out.println("1.Register\n2.Login");
                    System.out.print("Choose an option: ");
                    int choice = obj.getInputInt();

                    if (choice == 1) user = obj.register();
                    
                    else if (choice == 2) user = obj.login();
                    
                    else {
                    	
                        System.out.println("Invalid option!\nTry again\n");
                        continue;
                        
                    }

                    while (true) {
                        System.out.println("\n1.View Available movies\n2.Book a movie\n3.View Profile\n4.Manage Profile\n5.Logout");
                        System.out.print("Choose an option[1-5]: ");
                        option = obj.getInputInt();

                        if (option == 1) obj.displayMovieDetails();
                        
                        else if (option == 2) obj.bookMovie(user);
                        
                        else if (option == 3) obj.displayCustomerDetails(user);
                        
                        else if (option == 4) obj.userProfileManagement(user);
                        
                        else if (option == 5) {
                        	
                            System.out.println("                                ----------------------(Logged out)--------------------                                \n");
                            continue loop;
                            
                        } else {
                        	
                            System.out.println("Invalid option!\nTry again\n");
                            
                        }
                    }
                    
                } else if (option == 3) {
                	
                    break;
                    
                }
            }
            

        } catch (Exception e) {
        	
            System.out.println("An error occurred in User operations: " + e.getMessage());
            
        }

    }
    
    private static void handleGuestOperations(Scanner input, TicketBooking obj) {
		
    	
    	System.out.println("\t\t\t\t===========");
		System.out.println("\t\t\t\tGUEST LOGIN");
		System.out.println("\t\t\t\t===========");
		
    	while (true) {

    		System.out.println();
		
    		System.out.println("1.Search Movie\n2.Exit");
    		System.out.print("Enter your choice: ");
    		int option = obj.getInputInt();
		
    		if (option == 1) obj.searchMovie();
		
    		else if (option == 2) {
    			
    			System.out.println();
    			return;
    		}
		
    		else {
    			System.out.println("Invalid option\ntry again\n");
    		}
    	}
	}
}
