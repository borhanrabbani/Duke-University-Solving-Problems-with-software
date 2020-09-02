package collection.framework;

import java.util.*;

public class Theatre {
	private final String theatreName;
	private List<Seat> seats = new ArrayList<>();

	static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {

		@Override
		public int compare(Seat seat1, Seat seat2) {
			if (seat1.getPrice() < seat2.getPrice()) {
				return -1;
			} else if (seat1.getPrice() > seat2.getPrice()) {
				return 1;
			} else {
				return 0;
			}
		}
	};

	public Theatre(String theatreName, int numRows, int seatPerRow) {

		this.theatreName = theatreName;

		int lastRow = 'A' + (numRows - 1);
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatPerRow; seatNum++) {
				double price = 12.00;

				if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
					price = 14.00;
				} else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
					price = 7.00;
				}

				Seat seat = new Seat(row + String.format("%02d", seatNum), price);
				seats.add(seat);
			}
		}
	}

	public String getTheatreName() {
		return theatreName;
	}

	public boolean reserveSeat(String seatNumber) {

		Seat requestedSeat = new Seat(seatNumber, 0);
		int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
		if (foundSeat >= 0) {
			return seats.get(foundSeat).reserve();
		} else {
			System.out.println("there is no seat " + seatNumber);
			return false;
		}

	}

	public Collection<Seat> getSeats() {
		return seats;
	}

	public static void main(String[] args) {
		Theatre theatre = new Theatre("Star Cineplex", 8, 12);

		if (theatre.reserveSeat("D12")) {
			System.out.println("Please pay for D12");
		} else {
			System.out.println("Seat already reserved");
		}
		if (theatre.reserveSeat("D12")) {
			System.out.println("Please pay for D12");
		} else {
			System.out.println("Seat already reserved");
		}

		if (theatre.reserveSeat("B13")) {
			System.out.println("Please pay for B13");
		} else {
			System.out.println("Seat already reserved");
		}
		
		List<Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
		Collections.reverse(reverseSeats);
		printList(reverseSeats);
		
		List<Seat> priceSeats = new ArrayList<>(theatre.getSeats());
		priceSeats.add(new Seat("B00", 13.00));
		priceSeats.add(new Seat("A00", 13.00));
		Collections.sort(priceSeats, Theatre.PRICE_ORDER);
		printList(priceSeats);

	}

	public static void printList(List<Seat> list) {
		for (Seat seat : list) {
			System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
		}
		System.out.println();
		System.out.println("===========================================");
	}

}
