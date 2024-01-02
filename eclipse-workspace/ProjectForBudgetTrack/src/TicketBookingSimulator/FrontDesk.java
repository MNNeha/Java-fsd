package TicketBookingSimulator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrontDesk {
	private String username;
	private String password;
	private Theatre theatre;
	
	 public FrontDesk(String username, String password, Theatre theatre) {
	        this.username = username;
	        this.password = password;
	        this.theatre = theatre;
	    }
	    public boolean login(String enteredUsername, String enteredPassword) {
	        System.out.println("Entered Username: " + enteredUsername);
	        System.out.println("Entered Password: " + enteredPassword);
	        System.out.println("Stored Username: " + username);
	        System.out.println("Stored Password: " + password);
	        
	        boolean isValid = enteredUsername.equals(username) && enteredPassword.equals(password);
	        System.out.println("Validation Result: " + isValid);
	        
	        return isValid;
	    }    
	
	// Getter for username
	    public String getUsername() {
	        return username;
	    }

	    // Setter for username
	    public void setUsername(String username) {
	        this.username = username;
	    }

	    // Getter for password
	    public String getPassword() {
	        return password;
	    }

	    // Setter for password
	    public void setPassword(String password) {
	        this.password = password;
	    }

	    // Getter for theatre
	    public Theatre getTheatre() {
	        return theatre;
	    }

	    // Setter for theatre
	    public void setTheatre(Theatre theatre) {
	        this.theatre = theatre;
	    }
	
	    public void updatePassword(String newPassword) {
	        this.password = newPassword;
	    }
	    public void bookTicket() {
	        Scanner scanner = new Scanner(System.in);

	        // Ask for date and show time
	        System.out.print("Enter date (MM/DD/YYYY): ");
	        String date = scanner.nextLine();
	        System.out.print("Enter show time: ");
	        String showTime = scanner.nextLine();

	        // Check seating arrangement and display available seats
	        theatre.displaySeatingArrangement();

	        System.out.println("Please enter the seat numbers for booking (e.g., 1A 2B 3C): ");
	        String seatSelection = scanner.nextLine().trim();

	        // Process the seatSelection string to extract the seat numbers chosen by the user
	        String[] selectedSeats = seatSelection.split("\\s+");

	        List<String> bookedSeats = new ArrayList<>();

	        for (String seat : selectedSeats) {
	            int row = Integer.parseInt(seat.substring(0, seat.length() - 1)) - 1;
	            int seatNum = seat.charAt(seat.length() - 1) - 'A';

	            if (theatre.isSeatAvailable(row, seatNum)) {
	                theatre.bookSeat(row, seatNum);
	                bookedSeats.add("Row " + (row + 1) + ", Seat " + (seatNum + 1));
	            } else {
	                System.out.println("Seat " + (seatNum + 1) + " in row " + (row + 1) + " is not available.");
	            }
	        }

	        if (!bookedSeats.isEmpty()) {
	            System.out.println("Successfully booked seats:");
	            for (String seat : bookedSeats) {
	                System.out.println(seat);
	            }
	        }
	    }
	    public void checkBookingStatus() {
	        Scanner scanner = new Scanner(System.in);

	        // Ask for seat details
	        System.out.print("Enter row number: ");
	        int row = scanner.nextInt();
	        System.out.print("Enter seat number: ");
	        int seat = scanner.nextInt();

	        // Display the booking status
	        if (theatre.getBookingStatus(row - 1, seat)) {
	            System.out.println("Seat is booked.");
	        } else {
	            System.out.println("Seat is available.");
	        }
	    }
	    public void displayMenu() {
	        System.out.println("Welcome to the Front Desk Menu:");
	        System.out.println("1. Book Ticket");
	        System.out.println("2. Check Booking Status");
	        System.out.println("3. Update Password");
	        System.out.println("4. Exit");
	    }

	    public void processUserChoice(int choice) {
	        Scanner scanner = new Scanner(System.in);

	        switch (choice) {
	            case 1:
	                bookTicket();
	                break;
	            case 2:
	                checkBookingStatus();
	                break;
	            case 3:
	                System.out.print("Enter new password: ");
	                String newPassword = scanner.nextLine();
	                updatePassword(newPassword);
	                System.out.println("Password updated successfully!");
	                break;
	            case 4:
	                System.out.println("Exiting...");
	                System.exit(0);
	                break;
	            default:
	                System.out.println("Invalid choice!");
	        }
	    }
	    public void startInteraction() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter username: ");
	        String enteredUsername = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String enteredPassword = scanner.nextLine();

	        if (login(enteredUsername, enteredPassword)) {
	            int choice;
	            do {
	                displayMenu();
	                System.out.print("Enter your choice: ");
	                choice = scanner.nextInt();
	                scanner.nextLine(); // Consume newline
	                processUserChoice(choice);
	            } while (choice != 4);
	        } else {
	            System.out.println("Invalid username or password. Exiting...");
	        }
	    }

}
