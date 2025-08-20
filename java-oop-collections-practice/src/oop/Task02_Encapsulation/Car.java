/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author parth
 */
public class Car {

    private String brand;
    private int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static void main(String[] args) {
        Car car = new Car("Audi", 2019);
        System.err.println(car.getBrand());
        System.out.println(car.getYear());
        car.setBrand("audi");
        car.setYear(2017);
        System.out.println(car.getBrand());
        System.out.println(car.getYear());

    }
}
