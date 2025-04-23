/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cashiersystem;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Receipt {
    private List<Item> items;
    private double total;

    public Receipt() {
        items = new ArrayList<>();
        total = 0;
    }

    public void addItem(Item item) {
        items.add(item);
        total += item.getTotalPrice();
    }

    public void printReceipt() {
        System.out.println("======================[ RECEIPT ]======================");
        System.out.printf("%-15s %5s %15s %15s\n", "Item", "Qty", "Price", "Total");
        System.out.println("-------------------------------------------------------");
        for (Item item : items) {
            System.out.println(item.toTableRow());
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%44s ₱ %.2f\n", "Total:", total);
        System.out.println("=======================================================");
    }

    public void saveReceiptToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("========================[ RECEIPT ]====================\n");
            writer.write(String.format("%-15s %5s %15s %15s\n", "Item", "Qty", "Price", "Total"));
            writer.write("-------------------------------------------------------\n");
            for (Item item : items) {
                writer.write(item.toTableRow() + "\n");
            }
            writer.write("-------------------------------------------------------\n");
            writer.write(String.format("%44s ₱ %.2f\n", "Total:", total));
            writer.write("=======================================================\n");
            System.out.println("Receipt saved to: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}