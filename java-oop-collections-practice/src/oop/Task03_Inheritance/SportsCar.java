/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author parth
 */
public class SportsCar extends Car {

    private int topSpeed;

    public SportsCar(String brand, int year, int topSpeed) {
        super(brand, year);
        this.topSpeed = topSpeed;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public static void main(String[] args) {
        SportsCar sportsCar = new SportsCar("Ferrari", 2018, 200);
        System.out.println(sportsCar.getBrand());
        System.out.println(sportsCar.getYear());
        System.out.println(sportsCar.getTopSpeed());
    }
}
