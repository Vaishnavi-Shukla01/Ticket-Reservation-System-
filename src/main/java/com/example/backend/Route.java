

package com.example.backend;
public class Route {
	int id;
    String source;
    String destination;
    String type;
    int seats;
    double price;
    String category;

    public int getId() { return id; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public String getType() { return type; }
    public int getSeats() { return seats; }
    public double getPrice() { return price; }
    Route(int id, String s, String d, String t, int seats, double price, String c) {
        this.id = id;
        this.source = s;
        this.destination = d;
        this.type = t;
        this.seats = seats;
        this.price = price;
        this.category = c;
    }
}