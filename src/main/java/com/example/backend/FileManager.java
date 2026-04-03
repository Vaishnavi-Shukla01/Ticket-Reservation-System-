
package com.example.backend;
import java.io.*;
import java.util.*;

public class FileManager {

    static ArrayList<String> read(String file) {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
        return list;
    }

    static void write(String file, String data) {
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(data + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error writing file");
        }
    }

    static void overwrite(String file, ArrayList<String> data) {
        try {
            FileWriter fw = new FileWriter(file);
            for (String line : data) {
                fw.write(line + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error updating file");
        }
    }
}