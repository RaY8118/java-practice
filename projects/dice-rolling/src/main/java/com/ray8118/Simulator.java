package com.ray8118;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Simulator {

    static String display(int value) {

        return switch (value) {
            case 1 -> "---------\n|       |\n|   o   |\n|       |\n---------";
            case 2 -> "---------\n| o     |\n|       |\n|     o |\n---------";
            case 3 -> "---------\n| o     |\n|   o   |\n|     o |\n---------";
            case 4 -> "---------\n| o   o |\n|       |\n| o   o |\n---------";
            case 5 -> "---------\n| o   o |\n|   o   |\n| o   o |\n---------";
            case 6 -> "---------\n| o   o |\n| o   o |\n| o   o |\n---------";
            default -> " Not a valid die value";
        };

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        try {
            System.out.println("How many dics would you like to roll?");
            int numberOfDice = scanner.nextInt();
            System.out.println("About to roll " + numberOfDice + " dice");

            for (int i = 0; i < numberOfDice; i++) {
                int rolledName = random.nextInt(6) + 1;
                System.out.println(display(rolledName));

            }
        } catch (InputMismatchException e) {
            System.out.println("That is not a valid number");
        }
        scanner.close();
    }

}
