
package com.example.backend;
import java.util.*;
public class DataStore {

    static HashMap<String, String> usersMap = new HashMap<>();
    static HashMap<Integer, Route> routeMap = new HashMap<>();
    static HashMap<Integer, Booking> bookingMap = new HashMap<>();
    static HashMap<String, ArrayList<Booking>> userBookings = new HashMap<>();

    public static void loadData() {

        // USERS
        for (String u : FileManager.read("src/main/resources/data/users.txt")) {
            String[] arr = u.split(",");
            usersMap.put(arr[0], arr[1]);
        }

        // ROUTES
        ArrayList<String> routes = FileManager.read("src/main/resources/data/routes.txt");
        for (int i = 1; i < routes.size(); i++) {
            String[] a = routes.get(i).split(",");

            Route r = new Route(
                Integer.parseInt(a[0]), a[1], a[2], a[3],
                Integer.parseInt(a[4]), Double.parseDouble(a[5]), a[6]
            );

            routeMap.put(r.id, r);
        }

        // BOOKINGS
        for (String b : FileManager.read("src/main/resources/data/bookings.txt")) {
            String[] a = b.split(",");

            Booking bk = new Booking(
                Integer.parseInt(a[0]), a[1],
                Integer.parseInt(a[2]), a[3]
            );

            bookingMap.put(bk.ticketId, bk);

            userBookings.putIfAbsent(bk.username, new ArrayList<>());
            userBookings.get(bk.username).add(bk);
        }
    }
    public static Collection<Route> getRoutes() {
        return DataStore.routeMap.values();
    }
}