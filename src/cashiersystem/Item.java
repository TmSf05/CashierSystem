/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cashiersystem;

/**
 *
 * @author User
 */
public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public String toTableRow() {
        return String.format("%-15s %5d %15s %15s",
                name,
                quantity,
                "₱ " + String.format("%.2f", price),
                "₱ " + String.format("%.2f", getTotalPrice()));
    }
}