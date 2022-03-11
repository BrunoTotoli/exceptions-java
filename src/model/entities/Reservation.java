package model.entities;

import model.exceptions.CustomException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws CustomException {
        if (checkOut.before(checkIn)) {
            throw new CustomException("Check out date must be after check in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Reservation() {
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }


    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) {
        if(this.checkIn.after(checkIn) || this.checkOut.after(checkOut)){
            throw new CustomException("Reservation dates for update must be future dates");
        }
        if(checkOut.before(checkIn)){
            throw new CustomException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber + ", check-in: " + sdf.format(checkIn) +
                ", check-out: " + sdf.format(checkOut) + ", " + duration() + " nights";
    }
}
