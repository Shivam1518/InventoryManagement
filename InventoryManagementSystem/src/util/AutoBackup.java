package util;

import service.InventoryManager;

public class AutoBackup extends Thread {
    private final InventoryManager manager;

    public AutoBackup(InventoryManager manager) {
        this.manager = manager;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(60_000); // every 60 seconds
                FileHandler.saveToFile(manager.getAllItems());
                System.out.println("🛡️ Auto-backup complete.");
            }
        } catch (InterruptedException e) {
            System.out.println("⚠️ Auto-backup interrupted.");
        }
    }
}
