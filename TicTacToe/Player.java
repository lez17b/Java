//package com.company;

// *********************************************************************
// * Name: Player Class                                                *
// * Description: A Parent Class that creates a player object with its *
// *   respective constructors and a method to assign the token.       *
// * Author: Luciano Zavala                                            *
// * Date: Feb 12th, 2021                                              *
// *********************************************************************

public abstract class Player
{
    protected int playerNum;

    //Constructor
    public Player()
    {
        playerNum = -1;
    }

    // Indicates the player number
    public Player(int player)
    {
        int x = 0;
        playerNum = player;
    }

    //Play token method
    public char playToken()
    {
        char token;

        // Defines either if will be X or O
        if(playerNum == 1)
        {
            token = 'X';
        }
        else if(playerNum == 2)
        {
            token = 'O';
        }
        else
            token = '*';

        return token;
    }

    //Abstract class
    public abstract int Play(Board b);
}