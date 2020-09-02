package collection.framework;

public class Seat implements Comparable<Seat>{
	private final String seatNumber;
	private double price;
	private boolean reserved = false;
	
	public Seat(String seatNumber, double price) {
		this.seatNumber = seatNumber;
		this.price = price;
	}
	
	public boolean reserve() {
		if(!this.reserved) {
			this.reserved = true;
			System.out.println("Seat " + seatNumber + " is reserved");
			return true;
		}else {
			return false;
		}
	}
	
	public boolean cancel() {
		if(this.reserved) {
			this.reserved = false;
			System.out.println("Reservation of seat " + seatNumber + " cancelled");
			return true;
		}else {
			return false;
		}
	}
	
	public String getSeatNumber() {
		return seatNumber;
	}
	
	public double getPrice() {
		return price;
	}

	@Override
	public int compareTo(Seat seat) {
		return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
	}

}
