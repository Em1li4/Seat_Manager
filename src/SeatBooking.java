package com.lesson.lab.controller;

import com.lesson.lab.model.Seat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeatBooking {
    // List to store bookings
    private List<Seat> bookedSeatsList;
    // Constructor
    public SeatBooking() {
        this.bookedSeatsList = new ArrayList();
        // TODO 1 : this.bookedSeatsList = ?
    }
    // Method to add a new seat booking
    public void addNewBooking(String seatNumber) {
        for (int i = 0; i < bookedSeatsList.size(); i++) {
            Seat seat = bookedSeatsList.get(i);
            if (seat.getSeatNumber().equals(seatNumber) && seat.isBooked() && !seat.isCanceled()) {
                System.out.println(seatNumber + "is already booked");
                return;
            }
        }
        Seat newSeat = new Seat(seatNumber);
        newSeat.setSeatNumber(seatNumber);
        newSeat.setBooked(true);
        newSeat.setBookingDate(new Date());
        bookedSeatsList.add(newSeat);
        System.out.println("Seat " + seatNumber + " has been successfully booked");
        // TODO 2: check if the seat is already booked and not canceled
        // TODO 3 create a new Seat object for the booking, mark the seat as booked,
        // set the current date as the booking date
        // TODO 4: add the new seat to the bookedSeatsList
        // TODO 5: confirm the booking to the user
    }
    public void cancelBooking(String seatNumber) {
        for (Seat seat: bookedSeatsList) {
            if (seat.getSeatNumber().equals(seatNumber) && !seat.isCanceled()){
                seat.setCanceled(true);
                seat.setBooked(false);
                bookedSeatsList.remove(seat);
                System.out.println("Seat " + seatNumber + " has been succesfully removed");
                return;
            }
        }
        System.out.println("No booking found for seat number " + seatNumber );
        // TODO 6: iterate through the list of booked seats
        // TODO 7: check if the seat number matches and is not already canceled
        // mark the seat as canceled
        // mark the seat as not booked
        // confirm the cancellation to the user
        // TODO 8: inform the user if no booking was found for the seat number
    }
    // Method to update a booking seat number
    public void updateBooking(String oldSeatNumber, String newSeatNumber) {
        for (Seat seat : bookedSeatsList) {
            if (seat.getSeatNumber().equals(oldSeatNumber) && !seat.isCanceled()){
                seat.setBooked(false);
                bookedSeatsList.remove(seat);
                Seat newSeat = new Seat(newSeatNumber);
                newSeat.setSeatNumber(newSeatNumber);
                newSeat.setBooked(true);
                bookedSeatsList.add(newSeat);
                System.out.println("Seat " + oldSeatNumber + " has been updated to " + newSeatNumber + "!");
                return;
            }
        }
        System.out.println("Seat " + oldSeatNumber + " not found.");
        // TODO 9: iterate through the list of booked seats
        // TODO 10: check if the seat number matches the old seat number and is not canceled
        // TODO 11: update the seat number to the new seat number
        // confirm the update to the user
        // TODO 12: inform the user if no booking was found for the old seat number
    }
    // Method to display all bookings
    public void displayBookings() {
        if (bookedSeatsList.isEmpty()){
            System.out.println("No bookings have been made yet");
            return;
        }
        for (Seat seat : bookedSeatsList){
            if (seat.isBooked() && !seat.isCanceled()){
                System.out.println(seat.getBookingDate());
                System.out.println(seat.getSeatNumber());
            }
        }

        // TODO 13: check if the bookedSeatsList is empty, inform the user that no bookings have been made yet
        // TODO 14: iterate through the list of booked seats, Check if the seat is booked and not canceled
        // TODO 15: display the seat number and booking date

    }
}
