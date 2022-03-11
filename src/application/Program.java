package application;

import model.entities.Reservation;
import model.exceptions.CustomException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Reservation reservation = new Reservation(4, sdf.parse("22/04/2022"), sdf.parse("29/04/2022"));
            System.out.println(reservation.toString());
            reservation.updateDates(sdf.parse("21/04/2023"), sdf.parse("20/04/2023"));
        } catch (ParseException e) {
            System.out.println("Invalid date format");
            e.printStackTrace();
        } catch (CustomException e) {
            System.out.println("Error in reservation " + e.getMessage());
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println("Other error");
            e.printStackTrace();
        }
    }
}
