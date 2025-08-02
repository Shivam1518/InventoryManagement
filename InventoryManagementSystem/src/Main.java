import model.Item;
import service.InventoryManager;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        while (true) {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Search Item by ID");
            System.out.println("4. Update Item");
            System.out.println("5. Delete Item");
            System.out.println("6. Sort Items by Price");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    manager.addItem(new Item(id, name, qty, price));
                    break;

                case 2:
                    manager.viewAllItems();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();
                    Item item = manager.searchItemById(searchId);
                    if (item != null) {
                        System.out.println("Item Found: " + item);
                    } else {
                        System.out.println("❌ Item not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int newQty = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = scanner.nextDouble();
                    if (manager.updateItem(updateId, newName, newQty, newPrice)) {
                        System.out.println("✔ Item updated successfully.");
                    } else {
                        System.out.println("❌ Item not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (manager.deleteItem(deleteId)) {
                        System.out.println("✔ Item deleted.");
                    } else {
                        System.out.println("❌ Item not found.");
                    }
                    break;

                case 6:
                    manager.sortItemsByPrice();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
