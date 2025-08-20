/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author parth
 */
public class Cat extends Animal {

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void printInfo() {
        System.out.println("Cat name is " + name + " and age is " + age);
    }

    public static void main(String[] args) {
        Animal cat = new Cat("Cat", 3);
        cat.printInfo();
        cat.eat();
    }
}
