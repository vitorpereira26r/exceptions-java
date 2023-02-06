import Model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        Integer number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after Check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date newCheckIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date newCheckOut = sdf.parse(sc.next());

            Date now = new Date();
            if(newCheckIn.before(now) || newCheckOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future dates.");
            } else if (!checkOut.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after Check-in date");
            } else {
                reservation.updateDates(newCheckIn, newCheckOut);
                System.out.println(reservation);
            }
        }





        sc.close();
    }
}