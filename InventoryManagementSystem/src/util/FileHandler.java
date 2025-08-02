package util;

import model.Item;

import java.io.*;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "inventory_data.dat";

    public static void saveToFile(List<Item> items) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(items);
            System.out.println("💾 Inventory saved to file.");
        } catch (IOException e) {
            System.out.println("❌ Error saving inventory: " + e.getMessage());
        }
    }

    public static List<Item> loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new java.util.ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Item>) in.readObject();
        } catch (Exception e) {
            System.out.println("❌ Error loading inventory: " + e.getMessage());
            return new java.util.ArrayList<>();
        }
    }
}
