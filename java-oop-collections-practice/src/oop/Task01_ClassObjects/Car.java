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

    public void printCar() {
        System.out.println("The car brand is " + brand + " and manufactured year is " + year);
    }

    public static void main(String[] args) {
        Car car = new Car("BMW", 2020);
        car.printCar();
    }

}
