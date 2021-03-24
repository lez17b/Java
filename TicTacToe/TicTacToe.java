//package com.company;

// **********************************************************************
// * Name: TicTacToe Game                                               *
// * Description: A program designed to run a tictactoe game between    *
// *   two players or against the computer. The code run using different*
// *   classes and subclasses for the board and players.                *
// * Author: Luciano Zavala                                             *
// * Date: Feb 19th, 2021                                               *
// **********************************************************************

import java.io.IOException;

public class TicTacToe
{
    public static void main(String[] args) throws IOException
    {

        //********************************************
        //**           Two Human Players            **
        //********************************************


        if(args.length == 0)
        {
            int winner = 0;

            Board b = new Board();

            HPlayer p1 = new HPlayer(1);
            HPlayer p2 = new HPlayer(2);

            while(winner == 0)
            {
                b.PrintBoard();
                System.out.println("Player 1, please enter a move (1-9): ");

                p1.Play(b);
                winner = b.victoryCheck(p1.playToken());
                if(winner != 0)
                    break;
                b.PrintBoard();
                System.out.print("Player 2, please enter a move (1-9): ");
                p2.Play(b);
                winner = b.victoryCheck(p1.playToken());
            }


            b.PrintBoard();
            if(winner == 1)
                System.out.println("Player 1 Wins! Game Over!");
            else if(winner == 2)
                System.out.println("Player 2 Wins! Game Over!");
            else
                System.out.println("Game Over! It's a draw.");

        }


        //********************************************
        //**            Two CPU Players             **
        //********************************************


        else if(args.length==1)
        {
            // Input error checking
            if(!args[0].equals("-c"))
            {
                //Error message
                System.out.println("Usage:  java TicTacToe [-c [1|2] [-a]]");
                return;
            }

            int winner = 0;

            Board b = new Board();

            //New players Computers
            CPlayer p1 = new CPlayer(1);
            CPlayer p2 = new CPlayer(2);

            while(winner == 0)
            {
                // The order is represented thorough their member data
                b.PrintBoard();

                System.out.println("Player 1 (CPU) chooses position " + p1.Play(b));
                winner = b.victoryCheck(p1.playToken());

                // Check for winner
                if(winner != 0) {
                    break;
                }

                b.PrintBoard();

                System.out.println("Player 2 (CPU) chooses position " + p2.Play(b));
                winner = b.victoryCheck(p2.playToken());
            }

            b.PrintBoard();

            //If any player wins print:
            if(winner == 1)
                System.out.println("Player 1 Wins! Game Over!");
            else if(winner == 2)
                System.out.println("Player 2 Wins! Game Over!");
            else
                System.out.println("Game Over! It's a draw.");

        }


        //********************************************
        //**   One Computer Vs One Human Player     **
        //********************************************


        else if(args.length==2)
        {
            int winner = 0;

            Board b = new Board();

            HPlayer p1 = null;
            CPlayer p2 = null;
            CPlayer px = null;

            // Assignation of player 2 as human and CPU as player 1
            if(args[1].equals("1") && args[0].equals("-c"))
            {
                //Declaration of objects
                p1 = new HPlayer(2);
                p2 = new CPlayer(1);

                // The order is represented thorough their member data
                while(winner == 0)
                {
                    b.PrintBoard();

                    System.out.println("Player 1 (CPU) chooses position " + p2.Play(b));
                    winner = b.victoryCheck(p2.playToken());

                    if(winner != 0)
                    {
                        break;
                    }

                    b.PrintBoard();

                    System.out.print("Player 2, please enter a movie (1-9): ");
                    p1.Play(b);
                    winner = b.victoryCheck(p1.playToken());
                }
            }

            // Assignation of player 2 as human and CPU as player 1
            else if(args[1].equals("2") && args[0].equals("-c"))
            {
                //Declaration of objects
                p1 = new HPlayer(1);
                p2 = new CPlayer(2);

                // The order is represented thorough their member data
                while(winner == 0)
                {
                    b.PrintBoard();

                    System.out.print("Player 1, please enter a movie (1-9): ");
                    p1.Play(b);
                    winner = b.victoryCheck(p1.playToken());

                    if(winner != 0)
                    {
                        break;
                    }

                    b.PrintBoard();

                    System.out.println("Player 2 (computer) chooses position " + p2.Play(b));
                    winner = b.victoryCheck(p2.playToken());
                }
            }

            else if(args[1].equals("-a") && args[0].equals("-c"))		// 2 Advanced CPUs (Extra Credit)
            {
                px = new CPlayer(1);
                p2 = new CPlayer(2);

                while(winner == 0)
                {
                    b.PrintBoard();
                    System.out.println("Player 1 (computer) chooses position " + px.Play(b));
                    winner = b.victoryCheck(px.playToken());
                    if(winner != 0)
                        break;
                    b.PrintBoard();
                    System.out.println("Player 2 (computer) chooses position " + p2.Play(b));
                    winner = b.victoryCheck(p2.playToken());
                }

            }

            //FLAG: wrong action
            else
            {
                System.out.println("Usage:  java TicTacToe [-c [1|2] [-a]]");
                return;
            }

            // Verification of winning player
            b.PrintBoard();

            if(winner == 1)
                System.out.println("Player 1 Wins! Game Over!");
            else if(winner == 2)
                System.out.println("Player 2 Wins! Game Over!");
            else
                System.out.println("Game Over! It's a draw.");

        }
        

    }
}

