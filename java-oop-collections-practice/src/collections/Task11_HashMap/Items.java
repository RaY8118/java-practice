
import java.util.HashMap;

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

    public static void main(String[] args) {
        HashMap<Integer, Items> items = new HashMap<>();
        items.put(1, new Items("milk", 10));
        items.put(2, new Items("bread", 5));
        items.put(3, new Items("butter", 20));

        System.out.println(items.get(1).name);
        System.out.println(items.get(2).name);
        System.out.println(items.get(1).quantity);
        System.out.println(items.get(2).quantity);

    }
}
