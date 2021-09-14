package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-In date (dd/mm/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out date (dd/mm/yyyy)");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Checkout date must be after checkin date.");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation " + reservation);

			System.out.println();
			System.out.println("Enter data to update reservation");
			System.out.print("Check-In date (dd/mm/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/mm/yyyy)");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();

			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Checkout date must be after checkin date.");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation " + reservation);
			}

		}
		sc.close();
	}
}
