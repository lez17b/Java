package com.company;
import java.util.Scanner;

// ********************************************************************
// * Name: PI program                                                 *
// * Description: A program that computes the infinite series of PI,  *
// *   By an index introduced by the user.                            *
// * Author: Luciano Zavala                                           *
// * Date: January 10th, 2020                                         *
// ********************************************************************

public class PI {

    public static void main(String[] args)
    {
        int x;                                 // User Input
        double pi = 0, term;                   // Variable initiators

        Scanner s = new Scanner(System.in);

        System.out.print("Compute how many terms of the series: ");
        x = s.nextInt();

        //Table header
        System.out.print("Terms    PI approximation\n");

        //Loop to compute and display the values of the index and Pi
        for(int i = 1;i <= x; i++)
        {
            //Prints the input
            System.out.print(i);

            //Logic for computation
            if( i % 2 == 0)
            {
                term = -4.0 / (2.0 * i - 1);

            }
            else
            {
                term = 4.0 / (2.0 * i - 1);
            }

            //Pi value assignation
            pi += term;

            //Prints the value of Pi
            System.out.printf("         %.6f", pi);
            System.out.println();

        }

    }
}
