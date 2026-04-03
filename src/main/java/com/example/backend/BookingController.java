

package com.example.backend;
import java.util.*;

public class BookingController {

    static boolean checkAvailability(int routeId, String date) {
        int count = 0;

        for (Booking b : DataStore.bookingMap.values()) {
            if (b.routeId == routeId && b.date.equals(date)) {
                count++;
            }
        }

        return count < DataStore.routeMap.get(routeId).seats;
    }

    static void bookTicket(String user, int routeId, String date) {

        if (!checkAvailability(routeId, date)) {
            System.out.println("No seats available!");
            return;
        }

        int ticketId = (int)(System.currentTimeMillis() % 100000);

        Booking b = new Booking(ticketId, user, routeId, date);

        DataStore.bookingMap.put(ticketId, b);

        DataStore.userBookings.putIfAbsent(user, new ArrayList<>());
        DataStore.userBookings.get(user).add(b);

        FileManager.write("bookings.txt",
                ticketId + "," + user + "," + routeId + "," + date);

        System.out.println("Booked! Ticket ID: " + ticketId);
    }

    static void cancelTicket(int ticketId) {

        if (!DataStore.bookingMap.containsKey(ticketId)) {
            System.out.println("Invalid Ticket!");
            return;
        }

        Booking b = DataStore.bookingMap.get(ticketId);

        DataStore.bookingMap.remove(ticketId);
        DataStore.userBookings.get(b.username).remove(b);

        ArrayList<String> list = new ArrayList<>();
        for (Booking bk : DataStore.bookingMap.values()) {
            list.add(bk.ticketId + "," + bk.username + "," + bk.routeId + "," + bk.date);
        }

        FileManager.overwrite("bookings.txt", list);

        System.out.println("Cancelled!");
    }

    static void myBookings(String user) {

        if (!DataStore.userBookings.containsKey(user)) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking b : DataStore.userBookings.get(user)) {
            System.out.println("Ticket: " + b.ticketId +
                    " Route: " + b.routeId +
                    " Date: " + b.date);
        }
    }
}