//package com.company;

// ********************************************************************
// * Name: Board Class                                                *
// * Description: A Class that creates a Board for the TicTacToe Game *
// *   and also has methods to print and validate winners.            *
// * Author: Luciano Zavala                                           *
// * Date: Feb 17th, 2021                                             *
// ********************************************************************

public class Board
{
    protected char [][] gBoard = new char [3][3];


    //Assign values to the matrix

    public Board()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int ii = 0; ii < 3; ii++)
            {
                gBoard[i][ii] = ' ';
            }
        }
    }

    //****************************
    //     Print Board Method   **
    //****************************

    public void PrintBoard()
    {
        System.out.println("Game Board:                Positions:");
        System.out.println();

        System.out.print(" " + gBoard[0][0] + " | "
                + gBoard[0][1] + " | " + gBoard[0][2] + " ");
        System.out.print("                ");
        System.out.println(" 1 | 2 | 3 ");

        System.out.println("-----------                -----------");

        System.out.print(" " + gBoard[1][0] + " | "
                + gBoard[1][1] + " | " + gBoard[1][2] + " ");
        System.out.print("                ");
        System.out.println(" 4 | 5 | 6 ");

        System.out.println("-----------                -----------");

        System.out.print(" " + gBoard[2][0] + " | "
                + gBoard[2][1] + " | " + gBoard[2][2] + " ");
        System.out.print("                ");
        System.out.println(" 7 | 8 | 9 ");

        System.out.println();
    };

    //Victory check method, returns a value depending on the player number
    public int victoryCheck(char c)
    {
        int winner = 0;

        //                     Horizontal Victories

        // Victory 1
        if(gBoard[0][0] == c && gBoard[0][1] == c && gBoard[0][2] == c)
        {
            if(c=='X')
                winner = 1;
            else if(c=='O')
                winner = 2;
        }

        //Victory 2
        else if(gBoard[1][0] == c && gBoard[1][1] == c && gBoard[1][2] == c)
        {
            if(c=='X')
                winner = 1;
            else if(c=='O')
                winner = 2;
        }

        //Victory 3
        else if(gBoard[2][0] == c && gBoard[2][1] == c && gBoard[2][2] == c)
        {
            if(c=='X')
                winner = 1;
            else if(c=='O')
                winner = 2;
        }

        //                        Vertical Victories

        //Victory 1
        else if(gBoard[0][0] == c && gBoard[1][0] == c && gBoard[2][0] == c)
        {
            if(c=='X')
                winner = 1;
            else if(c=='O')
                winner = 2;
        }

        //Victory 2
        else if(gBoard[0][1] == c && gBoard[1][1] == c && gBoard[2][1] == c)
        {
            if(c=='X')
                winner = 1;
            else if(c=='O')
                winner = 2;
        }

        //Victory 3
        else if(gBoard[0][2] == c && gBoard[1][2] == c && gBoard[2][2] == c)
        {
            if(c=='X')
                winner = 1;
            else if(c=='O')
                winner = 2;
        }

        //                        Diagonal Victories

        //Victory 1
        else if(gBoard[0][0] == c && gBoard[1][1] == c && gBoard[2][2] == c)
        {
            if(c=='X')
                winner = 1;
            else if(c=='O')
                winner = 2;
        }

        //Victory 2
        else if(gBoard[0][2] == c && gBoard[1][1] == c && gBoard[2][0] == c)
        {
            if(c=='X')
                winner = 1;
            else if(c=='O')
                winner = 2;
        }

        //Victory 3
        else if(   gBoard[0][0] != ' ' && gBoard[0][1] != ' ' && gBoard[0][2] != ' '
                && gBoard[1][0] != ' ' && gBoard[1][1] != ' ' && gBoard[1][2] != ' '
                && gBoard[2][0] != ' ' && gBoard[2][1] != ' ' && gBoard[2][2] != ' ')

            winner = -1;

        //Return the winner number
        return winner;
    };

    //*****************************************************************
    // Assign Move Method: Designed to allocate the token on a spot  **
    //*****************************************************************

    public boolean AssignMove(char c, int position)
    {
        boolean validChoice;

        if(position >=1 && position <= 9)
        {
            validChoice = true;

            //Position allocation by cases
            switch(position)
            {
                //if player choose 1
                case 1:
                    if(gBoard[0][0] == ' ')
                    {
                        gBoard[0][0] = c;
                    }
                    else validChoice = false;
                    break;

                //if player choose 2
                case 2:
                    if(gBoard[0][1] == ' ')
                    {
                        gBoard[0][1] = c;
                    }
                    else validChoice = false;
                    break;

                //if player choose 3
                case 3:
                    if(gBoard[0][2] == ' ')
                    {
                        gBoard[0][2] = c;
                    }
                    else validChoice = false;
                    break;

                //if player choose 4
                case 4:
                    if(gBoard[1][0] == ' ')
                    {
                        gBoard[1][0] = c;
                    }
                    else validChoice = false;
                    break;

                //if player choose 5
                case 5:
                    if(gBoard[1][1] == ' ')
                    {
                        gBoard[1][1] = c;
                    }
                    else validChoice = false;
                    break;

                //if player choose 6
                case 6:
                    if(gBoard[1][2] == ' ')
                    {
                        gBoard[1][2] = c;
                    }
                    else validChoice = false;
                    break;

                //if player choose 7
                case 7:

                    if(gBoard[2][0] == ' ')
                    {
                        gBoard[2][0] = c;
                    }
                    else validChoice = false;
                    break;

                //if player choose 8
                case 8:
                    if(gBoard[2][1] == ' ')
                    {
                        gBoard[2][1] = c;
                    }
                    else validChoice = false;
                    break;

                //if player choose 9
                case 9:
                    if(gBoard[2][2] == ' ')
                    {
                        gBoard[2][2] = c;
                    }
                    else validChoice = false;
                    break;
                default:
                    validChoice = false;
            }
        }
        else
            validChoice = false;

        return validChoice;
    }
};

