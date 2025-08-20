/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author parth
 */
public class Car {

    String brand;
    int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" + "brand=" + brand + ", year=" + year + '}';
    }

    public static void main(String[] args) {
        Car car = new Car("Audi", 2019);
        System.out.println(car);
    }
}
