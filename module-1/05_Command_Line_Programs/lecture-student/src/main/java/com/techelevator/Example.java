package com.techelevator;

import java.util.Scanner;

public class Example {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter your name >>> ");
        String name = keyboard.nextLine();

        if (name.equals("Ryan")) {  // When comparing strings, == will not work
                                    // Use name.equals("String")
            System.out.println("You are correct!");
        } else {
            System.out.println("Welcome " + name);
        }


    }
}
