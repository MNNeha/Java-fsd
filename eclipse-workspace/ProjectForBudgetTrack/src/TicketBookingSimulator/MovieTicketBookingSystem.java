package TicketBookingSimulator;
public class MovieTicketBookingSystem {

   
	

	public static void main(String[] args) {
        // Create a Theatre instance
        Theatre theatre = new Theatre(10, 10); // Example: 10 rows, 10 seats per row

        // Create a FrontDesk instance
        FrontDesk frontDesk = new FrontDesk("username", "password", theatre);

        // Start interaction with the front desk
        frontDesk.startInteraction();
    }
}



