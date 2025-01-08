package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			//Inserção de dados da reserva
			System.out.print("Room number: ");
			
			int number = sc.nextInt();
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out Date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			//Instancia do objeto Reserva
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println("");
			
			//Atualização de dados da reserva
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			reservation.updateDate(checkIn, checkOut);
			System.out.println(reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		

		
		sc.close();
	}

}
