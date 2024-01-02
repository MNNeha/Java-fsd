package TicketBookingSimulator;

public class Seat {
	 private int seatNumber;
	    private boolean isBooked;
	    public Seat(int seatNumber) {
	        this.seatNumber = seatNumber;
	        this.isBooked = false; // Initially, seat is not booked
	    }

	    // Getter for seat number
	    public int getSeatNumber() {
	        return seatNumber;
	    }

	    // Getter for booking status
	    public boolean isBooked() {
	        return isBooked;
	    }

	    // Setter for booking status
	    public void setBooked(boolean booked) {
	        isBooked = booked;
	    }
}
