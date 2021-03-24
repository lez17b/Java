//package com.company;

// *********************************************************************
// * Name: Human Player Class                                          *
// * Description: A Child Class that creates a player object with its  *
// *   respective constructors and a method to assign the token.       *
// * Author: Luciano Zavala                                            *
// * Date: Feb 14th, 2021                                              *
// *********************************************************************

import java.util.Scanner;

public class HPlayer extends Player
{
    //Inheritance constructor
    public HPlayer()
    {
        super();
    }

    // Indicates the player number
    public HPlayer(int player)
    {
        super(player);
    }

    //Defines the token and allows to play Method
    public int Play(Board b)
    {
        Scanner s = new Scanner(System.in);
        char Token;

        boolean cap = true;

        //Assigns the token X or O to the player
        if(playerNum == 1)
        {
            Token = 'X';
        }
        else if(playerNum == 2)
        {
            Token = 'O';
        }
        else
            Token = '*';

        // Verification of play
        while(cap)
        {
            if(b.AssignMove(Token,s.nextInt()))
            {
                cap = false;
            }
            else
                System.out.println("Invalid play. Try again: ");

        }

        return 0;
    };
};
