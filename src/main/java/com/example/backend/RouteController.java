
package com.example.backend;

import java.util.Collection;

public class RouteController {

    
    public static Collection<Route> getRoutes() {
        return DataStore.routeMap.values();
    }

    static void filterByType(String type) {
        for (Route r : DataStore.routeMap.values()) {
            if (r.type.toLowerCase().contains(type.toLowerCase())) {
                System.out.println(r.id + " | " + r.source + " -> " + r.destination + " | " + r.type);
            }
        }
    }
}