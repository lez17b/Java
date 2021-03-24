package com.company;
import java.util.Scanner;

class Piglatin {

    // Main
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // Get the phrase from the user
        System.out.println("Enter a sentence and press enter: ");
        String phrase = s.nextLine();

        // Translate using the pigLatin function
        String pigLatin = pigLatin(phrase);

	System.out.println();
	System.out.println("The converted sentence is: ");
	System.out.println();

        //Prints the translated phrase
        System.out.println(pigLatin);
    }

    /*
     * Method to translate a sentence word by word.
     * By: Luciano Zavala
     */
    private static String pigLatin(String s)
    {
        //String builder creation
        StringBuilder pigLatin = new StringBuilder();

        int i = 0;
        //loops through the length of the phrase
        while (i < s.length())
        {

            // Take care of punctuation and spaces
            while (i < s.length() && !isLetter(s.charAt(i)))
            {
                //reconstructs the words
                pigLatin.append(s.charAt(i));
                i++;
            }

            // Stops if there are not any words left.
            if (i >= s.length())
            {
                break;
            }

            // Starts at the beginning of a word in case its now the final length
            int begin = i;
            while (i < s.length() && isLetter(s.charAt(i)))
            {
                i++;
            }

            // Translates the word
            int end = i;
            pigLatin.append(pigWord(s.substring(begin, end)));
        }

        return pigLatin.toString();
    }


    /*
     * Method to translate one word into pig latin.
     * By: Luciano Zavala
     */
    private static String pigWord(String word)
    {
        int split = firstVow(word);
        return word.substring(split) + word.substring(0, split)+"ay";
    }

    /*
     * Method designed to find the index of the first vowel in a word.
     * By: Luciano Zavala
     */

    private static int firstVow(String word)
    {
        // make the word lower case
        word = word.toLowerCase();

        // loops until vowel is identified and returns the index
        for (int i = 0; i < word.length(); i++)
        {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' ||
                    word.charAt(i) == 'i' || word.charAt(i) == 'o'
                    || word.charAt(i) == 'u')
            {
                return i;
            }
        }
        return 0;
    }

    /*
     * Method to test if a character is a letter or not
     * By: Luciano Zavala
     */
    private static boolean isLetter(char c)
    {
        //returns true if the char is a letter
        return( (c >='A' && c <='Z') || (c >='a' && c <='z') );
    }

}