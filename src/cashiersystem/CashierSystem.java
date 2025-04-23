/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cashiersystem;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class CashierSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();

        System.out.println("=== Welcome to POS System ===");

        while (true) {
            System.out.print("Enter item name (or 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Item item = new Item(name, price, quantity);
            receipt.addItem(item);
        }

        receipt.printReceipt();
        receipt.saveReceiptToFile("receipt.txt");

        scanner.close();
    }
}