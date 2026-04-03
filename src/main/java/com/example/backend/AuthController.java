
package com.example.backend;
public class AuthController {

    public static boolean register(String u, String p) {
        if (DataStore.usersMap.containsKey(u)) return false;

        DataStore.usersMap.put(u, p);
        FileManager.write("users.txt", u + "," + p);
        return true;
    }

    public static boolean login(String u, String p) {
        return DataStore.usersMap.containsKey(u) &&
               DataStore.usersMap.get(u).equals(p);
    }
}