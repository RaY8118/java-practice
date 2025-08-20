/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author parth
 */
public class Dog extends Animal {

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void printInfo() {
        System.out.println("Dog name is " + name + " and age is " + age);
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    public static void main(String[] args) {
        Animal dog = new Dog("Dog", 3);
        dog.printInfo();
        dog.eat();
    }
}
