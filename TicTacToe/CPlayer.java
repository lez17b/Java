//package com.company;

// *********************************************************************
// * Name: Computer Player Class                                       *
// * Description: A Child Class that creates a player object with its  *
// *   respective constructors and a method to assign the token.       *
// *   The class also implements intelligenge for the responses with   *
// *   priority criteria. based on winning, blocking and then random   *
// *   moves.                                                          *
// * Author: Luciano Zavala                                            *
// * Date: Feb 18th, 2021                                              *
// *********************************************************************

import java.util.Random;

public class CPlayer extends Player
{
    //Inheritance constructor
    public CPlayer()
    {
        super();
    }

    // Indicates the number of player (inheritance)
    public CPlayer(int p)
    {
        super(p);
    }

    //*************************************************
    //           P l a y i n g  m e t h o d          **
    //*************************************************

    public int Play(Board b)
    {
        //token variable
        char Token;

        //Location variable
        int location = -1;

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

        //Takes a winning move if available
        location = locateWin(b, Token);

        if(location != -1)
        {
            b.AssignMove(Token, location);
            return location;
        }

        //Block opponent's win if threatened
        char opponent;
        if(Token == 'X')
            opponent = 'O';
        else if (Token == 'O')
            opponent = 'X';
        else
            opponent = '*';

        location = locateWin(b,opponent);
        if(location != -1)
        {
            b.AssignMove(Token,location);
            return location;
        }

        // Take the center square if possible
        if(b.gBoard[1][1] == ' ')
        {
            location = 5;
            b.AssignMove(Token,location);
            return location;
        }

        //Random Choice to play
        location = -1;
        while( location == -1)
        {
            Random rand = new Random();

            // Random number between 0 and 2;
            int iOne = rand.nextInt(3);
            int iTwo = rand.nextInt(3);


            //Random allocation based on the rand variable
            if(b.gBoard[iOne][iTwo] == ' ')
            {
                if(iOne == 0 && iTwo == 0)
                    location = 1;
                else if(iOne == 0 && iTwo == 1)
                    location = 2;
                else if(iOne == 0)
                    location = 3;
                else if(iOne == 1 && iTwo == 0)
                    location = 4;
                else if(iOne == 1 && iTwo == 1)
                    location = 5;
                else if(iOne == 1)
                    location = 6;
                else if(iTwo == 0)
                    location = 7;
                else if(iTwo == 1)
                    location = 8;
                else location = 9;
            }
        }

        //Assign position
        b.AssignMove(Token, location);
        return location;
    };

    //*************************************************
    //           Winning detection  m e t h o d      **
    //*************************************************

    private int locateWin(Board b, char playToken)
    {
        int location = -1;

        // HORIZONTAL CHECKING

        //*********
        // Row 1 **
        //*********

        if(b.gBoard[0][0] == playToken &&
                b.gBoard[0][1] == playToken &&
                b.gBoard[0][2] == ' ')
        {
            location = 3;
        }
        else if(b.gBoard[0][1] == playToken &&
                b.gBoard[0][2] == playToken &&
                b.gBoard[0][0] == ' ')
        {
            location = 1;
        }
        else if(b.gBoard[0][0] == playToken &&
                b.gBoard[0][2] == playToken &&
                b.gBoard[0][1] == ' ')
        {
            location = 2;
        }

        //*********
        // Row 2 **
        //*********

        else if(b.gBoard[1][0] == playToken &&
                b.gBoard[1][1] == playToken &&
                b.gBoard[1][2] == ' ')
        {
            location = 6;
        }
        else if(b.gBoard[1][1] == playToken &&
                b.gBoard[1][2] == playToken &&
                b.gBoard[1][0] == ' ')
        {
            location = 4;
        }
        else if(b.gBoard[1][0] == playToken &&
                b.gBoard[1][2] == playToken &&
                b.gBoard[1][1] == ' ')
        {
            location = 5;
        }

        //*********
        // Row 3 **
        //*********

        else if(b.gBoard[2][0] == playToken &&
                b.gBoard[2][1] == playToken &&
                b.gBoard[2][2] == ' ')
        {
            location = 9;
        }
        else if(b.gBoard[2][1] == playToken &&
                b.gBoard[2][2] == playToken &&
                b.gBoard[2][0] == ' ')
        {
            location = 7;
        }
        else if(b.gBoard[2][0] == playToken &&
                b.gBoard[2][2] == playToken &&
                b.gBoard[2][1] == ' ')
        {
            location = 8;
        }

        // VERTICAL CHECKING

        //*********
        // Col 1 **
        //*********
        else if(b.gBoard[0][0] == playToken &&
                b.gBoard[1][0] == playToken &&
                b.gBoard[2][0] == ' ')
        {
            location = 7;
        }
        else if(b.gBoard[2][0] == playToken &&
                b.gBoard[0][0] == playToken &&
                b.gBoard[1][0] == ' ')
        {
            location = 4;
        }
        else if(b.gBoard[1][0] == playToken &&
                b.gBoard[2][0] == playToken &&
                b.gBoard[0][0] == ' ')
        {
            location = 1;
        }

        //*********
        // Col 2 **
        //*********

        else if(b.gBoard[0][1] == playToken &&
                b.gBoard[1][1] == playToken &&
                b.gBoard[2][1] == ' ')
        {
            location = 8;
        }
        else if(b.gBoard[1][1] == playToken &&
                b.gBoard[2][1] == playToken &&
                b.gBoard[0][1] == ' ')
        {
            location = 2;
        }
        else if(b.gBoard[0][1] == playToken &&
                b.gBoard[2][1] == playToken &&
                b.gBoard[1][1] == ' ')
        {
            location = 5;
        }

        //*********
        // Col 3 **
        //*********

        else if(b.gBoard[0][2] == playToken &&
                b.gBoard[1][2] == playToken &&
                b.gBoard[2][2] == ' ')
        {
            location = 9;
        }
        else if(b.gBoard[0][2] == playToken &&
                b.gBoard[2][2] == playToken &&
                b.gBoard[1][2] == ' ')
        {
            location = 6;
        }
        else if(b.gBoard[1][2] == playToken &&
                b.gBoard[2][2] == playToken &&
                b.gBoard[0][2] == ' ')
        {
            location = 3;
        }

        // DAIGONAL CHECKING

        //*********
        // Dia / **
        //*********

        else if(b.gBoard[2][0] == playToken &&
                b.gBoard[1][1] == playToken &&
                b.gBoard[0][2] == ' ')
        {
            location = 3;
        }
        else if(b.gBoard[2][0] == playToken &&
                b.gBoard[0][2] == playToken &&
                b.gBoard[1][1] == ' ')
        {
            location = 5;
        }
        else if(b.gBoard[0][2] == playToken &&
                b.gBoard[1][1] == playToken &&
                b.gBoard[2][0] == ' ')
        {
            location = 7;
        }

        //*********
        // Dia \ **
        //*********

        else if(b.gBoard[0][0] == playToken &&
                b.gBoard[1][1] == playToken &&
                b.gBoard[2][2] == ' ')
        {
            location = 9;
        }
        else if(b.gBoard[1][1] == playToken &&
                b.gBoard[2][2] == playToken &&
                b.gBoard[0][0] == ' ')
        {
            location = 1;
        }
        else if(b.gBoard[0][0] == playToken &&
                b.gBoard[2][2] == playToken &&
                b.gBoard[1][1] == ' ')
        {
            location = 5;
        }
        else
        {
            location = -1;
        }

        return location;
    }
   
}
