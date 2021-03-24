//package com.company;

TicTacToe

public class IntegerSet
{
    boolean [] IntSet;


    //*********************************************************************
    //*** name: Constructor                                             ***
    //*** description:  Creates an array of booleans all set to false.  ***
    //*** Author: Luciano Zavala                                        ***
    //*********************************************************************

    public IntegerSet()
    {
        // Crates new integer set
        IntSet = new boolean[101];

        // Sets everything to false
        for(int i = 0; i < 100; i++)
        {
            IntSet[i] = false;
        }
    }

    //*********************************************************************
    //*** name: union                                                   ***
    //*** description:  Creates an array made by the union of two sets. ***
    //*** Author: Luciano Zavala                                        ***
    //*********************************************************************

    public IntegerSet union(IntegerSet iSet)
    {
        //creates a new Integer set of type IntegerSet
        IntegerSet unionSet = new IntegerSet();

        //Loops thorough the array to define the union
        for(int i = 0; i <= 100; i++)
        {
            if(this.IntSet[i])
            {
                unionSet.IntSet[i] = true;
            }
        }
        return unionSet;
    }

    //*********************************************************************
    //*** name: Intersection                                            ***
    //*** description: Creates an array made by the intersection of two ***
    //***   arrays.                                                     ***
    //*** Author: Luciano Zavala                                        ***
    //*********************************************************************

    public IntegerSet intersection(IntegerSet iSet)
    {
        //creates a new Integer set of type IntegerSet
        IntegerSet interSet = new IntegerSet();

        //Loops through  the array to define if both elements are present
        for(int i = 0; i < 100; i++)
        {
            //i set to true if both are present
            if(this.IntSet[i] && iSet.IntSet[i])
            {
                interSet.IntSet[i] = true;
            }

        }
        return interSet;
    }

    //*********************************************************************
    //*** name: InsertElement                                           ***
    //*** description: Inserts an element to the array.                 ***
    //*** Author: Luciano Zavala                                        ***
    //*********************************************************************

    public IntegerSet insertElement(int data)
    {
        // inserts the integer to the array
        this.IntSet[data] = true;

        // returns the array
        return this;
    }

    //*********************************************************************
    //*** name: InsertElement                                           ***
    //*** description: deletes an element to the array.                 ***
    //*** Author: Luciano Zavala                                        ***
    //*********************************************************************

    public IntegerSet deleteElement(int data)
    {
        // deletes an element of the array
        this.IntSet[data] = false;

        // returns the array
        return this;
    }

    //*********************************************************************
    //*** name: InsertElement                                           ***
    //*** description: Returns true if two sets are equal to each other.***
    //*** Author: Luciano Zavala                                        ***
    //*********************************************************************

    public boolean isEqualTo(IntegerSet iSet)
    {
        // boolean variable
        boolean ans = true;

        // Loops trough the array and if any element is different return false
        for(int i = 0; i < 100; i++)
        {
            if (this.IntSet[i] != iSet.IntSet[i])
            {
                ans = false;
                break;
            }

        }
        return ans;
    }

    //*********************************************************************
    //*** name: InsertElement                                           ***
    //*** description: Returns the string print of the array using the  ***
    //***    Stringbuilder class                                        ***
    //*** Author: Luciano Zavala                                        ***
    //*********************************************************************

    public String toString()
    {
        // Creates string builder
        StringBuilder printMe = new StringBuilder();

        //creates boolean variable
        boolean isEmpty = true;

        // Loops to determine which elements are present and prints it
        for(int i = 0; i <= 100; i++)
        {
            if(this.IntSet[i])
            {
                printMe.append(" ").append(i);
                isEmpty = false;
            }
        }

        // Is the array is empty prints ---
        if(isEmpty)
        {
            printMe = new StringBuilder("---");
        }

        // returns the string
        return printMe.toString();
    }


}
