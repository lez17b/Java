package com.company;

// ********************************************************************
// * Name: Reverse program                                            *
// * Description: A program that accepts an user input long Integer,  *
// *   It converts it to a string an then it compiles a reverse digit *                         
// * Author: Luciano Zavala                                           *
// * Date: January 11th, 2021                                         *
// ********************************************************************

import java.util.Scanner;
import java.util.*;

public class Reverse
{

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        long choice;    //User Input
        String number;  //Reversed Number


        System.out.print("Please enter a long integer (0 to quit): ");
        choice = s.nextLong();

	// Loop until the user inputs an integer 0
        while (choice != 0)
        {
	    // Converts the integer into an string
            number = String.valueOf(choice);
            // Assigns each character of the string to an array
            char[] num = number.toCharArray();

            System.out.print("The number reversed is: ");
	   
	    // Loop to display each character after the other in reverse form
            for(int i = num.length-1; i >= 0; i--)
            {
                System.out.print(num[i]);
            }

            System.out.println();
            System.out.print("Please enter a long integer (0 to quit): ");
            choice = s.nextLong();
        }
        System.out.println("Goodbye!");
        


    }
}
