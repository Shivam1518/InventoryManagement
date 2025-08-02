package service;

import model.Item;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InventoryManager implements Serializable {
    private List<Item> items = new ArrayList<>();

    // ✅ Set items from file
    public void setItems(List<Item> items) {
        this.items = items;
    }

    // ✅ Add item
    public void addItem(Item item) {
        items.add(item);
        System.out.println("✔ Item added successfully!");
    }

    // ✅ View all items
    public void viewAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    // ✅ Search by ID
    public Item searchItemById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // ✅ Update item
    public boolean updateItem(int id, String name, int quantity, double price) {
        Item item = searchItemById(id);
        if (item != null) {
            item.setName(name);
            item.setQuantity(quantity);
            item.setPrice(price);
            return true;
        }
        return false;
    }

    // ✅ Delete item
    public boolean deleteItem(int id) {
        Item item = searchItemById(id);
        if (item != null) {
            items.remove(item);
            return true;
        }
        return false;
    }

    // ✅ Sort by price
    public void sortItemsByPrice() {
        Collections.sort(items, Comparator.comparingDouble(Item::getPrice));
        System.out.println("✔ Items sorted by price.");
    }

    // ✅ Get all items
    public List<Item> getAllItems() {
        return items;
    }
}
