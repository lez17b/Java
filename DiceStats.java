package com.company;

import java.util.Scanner;
import java.util.Random;


// ********************************************************************
// * Name: DiceStats program                                          *
// * Description: A program that accepts an user input for the number *
// *   of dices in play, also accepts the number of times the dice    *
// *   will be rolled. Then it computes the sum of each case and      *
// *   displays the percentage of each case that was rolled.          *                       
// * Author: Luciano Zavala                                           *
// * Date: January 11th, 2021                                         *
// ********************************************************************

public class DiceStats
{
    public static void main(String[] args)
    {
        int dice_nums;      //dice numbers
        int rolls;          //Number of rolls
        int total_sum;      //Total sum
        int [] freq;        //Frequency array
        double individual_sum,
                percentage;

        Scanner s = new Scanner(System.in);

        System.out.print("How many dice will constitute one roll? ");
        dice_nums = s.nextInt();

        System.out.print("How many rolls? ");
        rolls = s.nextInt();

        //Computation of the max value
        total_sum = dice_nums * 6;

        freq = new int[total_sum+1];

        Random rand = new Random();

        //loop to generate each dice roll
        for(int i = 0; i < rolls; i++)
        {
            int roll_sum = 0;
            for(int ii = 0; ii < dice_nums; ii++)
            {
                //Random generation
                roll_sum += (rand.nextInt(6)+1);
            }
            //Frequency assignation
            freq[roll_sum] = freq[roll_sum] + 1;
        }

        System.out.println();

        // Result display
        System.out.println("Sum     # of times      Percentage\n");

        // Loops to deisplay each case with the frequency and percentage
        for(int i = dice_nums; i < total_sum+1; i++)
        {
            System.out.printf("%-8d", i);
            System.out.printf("%-16d", freq[i]);

            individual_sum = freq[i];

            //Computation of the percentage
            percentage = ((individual_sum / rolls) * 100.0);

            System.out.printf("%.2f", percentage);
            System.out.print("%\n");
        }

        s.close();
    }

}