
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author parth
 */
public class Items {

    private final String name;
    private final int quantity;

    public Items(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Items{" + "name=" + name + ", quantity=" + quantity + '}';
    }

    public static void main(String[] args) {
        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items("Apple", 10));
        items.add(new Items("Orange", 20));
        items.add(new Items("Banana", 30));
        items.add(new Items("Mango", 40));
        items.add(new Items("Grapes", 50));
        System.out.println(items);
        items.remove(3);
        items.remove(2);
        System.out.println(items);
    }
}
