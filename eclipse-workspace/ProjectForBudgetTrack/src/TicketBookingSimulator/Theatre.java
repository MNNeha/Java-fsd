package TicketBookingSimulator;
import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private List<List<Seat>> seats; // 2D List representing rows and seats

    // Initialize theatre with seats
    public  Theatre(int numRows, int seatsPerRow) {
        seats = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Seat> row = new ArrayList<>();
            for (int j = 0; j < seatsPerRow; j++) {
                row.add(new Seat(j + 1));
            }
            seats.add(row);
        }
    }
    public void displaySeatingArrangement() {
        for (int i = 0; i < seats.size(); i++) {
            List<Seat> row = seats.get(i);
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < row.size(); j++) {
                Seat seat = row.get(j);
                if (seat.isBooked()) {
                    System.out.print("Seat " + seat.getSeatNumber() + ": Booked | ");
                } else {
                    System.out.print("Seat " + seat.getSeatNumber() + ": Available | ");
                }
            }
            System.out.println(); // Move to the next line for the next row
        }
    }
    public boolean isSeatAvailable(int row, int seatNum) {
        if (row >= 0 && row < seats.size()) {
            List<Seat> selectedRow = seats.get(row);
            if (seatNum >= 1 && seatNum <= selectedRow.size()) {
                Seat selectedSeat = selectedRow.get(seatNum - 1);
                return !selectedSeat.isBooked();
            }
        }
        return false; // Seat or row doesn't exist or out of range
    }
	public boolean getBookingStatus(int row, int seatNum) {
		 if (row >= 0 && row < seats.size()) {
		        List<Seat> selectedRow = seats.get(row);
		        if (seatNum >= 1 && seatNum <= selectedRow.size()) {
		            Seat selectedSeat = selectedRow.get(seatNum - 1);
		            return selectedSeat.isBooked(); // Return the booking status of the seat
		        }
		    }
		    return false; // If row or seat doesn't exist or out of range, return false
	}
	public void bookSeat(int row, int seatNum) {
		if (row >= 0 && row < seats.size()) {
	        List<Seat> selectedRow = seats.get(row);
	        if (seatNum >= 1 && seatNum <= selectedRow.size()) {
	            Seat selectedSeat = selectedRow.get(seatNum - 1);
	            if (!selectedSeat.isBooked()) {
	                selectedSeat.setBooked(true); // Mark the seat as booked
	                System.out.println("Seat " + seatNum + " in row " + (row + 1) + " has been booked.");
	            } else {
	                System.out.println("Seat " + seatNum + " in row " + (row + 1) + " is already booked.");
	            }
	        } else {
	            System.out.println("Invalid seat number for this row.");
	        }
	    } else {
	        System.out.println("Invalid row number.");
	    }
		
	}

}

