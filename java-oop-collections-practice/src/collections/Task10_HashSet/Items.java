
import java.util.HashSet;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Items)) {
            return false;
        }
        Items items = (Items) o;
        return quantity == items.quantity && Objects.equals(name, items.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }

    public static void main(String[] args) {
        HashSet<Items> items = new HashSet<>();
        items.add(new Items("Apple", 10));
        items.add(new Items("Orange", 20));
        items.add(new Items("Banana", 30));
        items.add(new Items("Orange", 20));
        items.add(new Items("Banana", 30));
        System.out.println(items);
        items.remove(new Items("Apple", 10));
        items.remove(new Items("Orange", 20));
        System.out.println(items);
    }
}
