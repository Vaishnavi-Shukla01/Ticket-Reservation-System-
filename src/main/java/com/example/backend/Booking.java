

package com.example.backend;

public class Booking {
	int ticketId;
    String username;
    int routeId;
    String date;

    Booking(int id, String u, int r, String d) {
        ticketId = id;
        username = u;
        routeId = r;
        date = d;
    }
}