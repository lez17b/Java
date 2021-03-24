//package com.company;

// **********************************************************************
// * Name: File Viewer App                                              *
// * Description: A code designed to display information of files in a  *
// *   in a directory. Has methods to display more detailed information *
// *   of each file, copy contents to a new file and also compare them. *
// * Author: Luciano Zavala                                             *
// * Date: March 10th, 2021                                             *
// **********************************************************************

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.io.*;

public class FileViewer
{
    public static void main(String[] args) throws IOException, FileNotFoundException
    {
        boolean compare = false;
        String viewParam = " ";
        String copyParam1 = " ";
        String copyParam2 = " ";

        String infoParam = " ";
        String compareParam1 = " ";
        String compareParam2 = " ";

        //****************************************
        //             No arguments              *
        //****************************************

        if(args.length == 0)
        {
            infoParam = ".";
            informationArgs1(infoParam);
        }

        //****************************************
        //*            one argument              *
        //****************************************

        else if(args.length == 1)
        {
            //If argument is -i

            if(args[0].equals("-i"))
            {
                infoParam = ".";
                informationArgs1(infoParam);
            }

        }

        //****************************************
        //*           two arguments              *
        //****************************************

        else if(args.length == 2)
        {
            //If argument is -i and a file or directory

            if(args[0].equals("-i"))
            {
                infoParam = args[1];
                informationArgs2(infoParam);
            }

            //If argument is -v and a file or directory

            else if(args[0].equals("-v"))
            {
                viewParam = args[1];
                viewFile(viewParam);
            }

            //If argument is -c and a file or directory

            else if(args[0].equals("-c"))
            {
                System.out.print("Usage: java -jar hw4.jar [-i [<file>|<directory>]|-v " +
                        "<file>|-c <sourceFile> <destFile>|-d <file1> <file2>]");
                return;
            }
            else {
                System.out.print("Usage: java -jar hw4.jar [-i [<file>|<directory>]|-v " +
                        "<file>|-c <sourceFile> <destFile>|-d <file1> <file2>]");
                return;
            }
        }

        //****************************************
        //*           three arguments            *
        //****************************************

        else if(args.length == 3)
        {
            //If argument is -c and two files or directory

            if(args[0].equals("-c"))
            {
                copyParam1 = args[1];
                copyParam2 = args[2];
                copyFile(copyParam1, copyParam2);

            }

            //If argument is -d and two files or directory

            else if(args[0].equals("-d"))
            {
                compare = true;
                compareParam1 = args[1];
                compareParam2 = args[2];
                //compareFile(compareParam1, compareParam2);
            }

            // Error message
            else{
                System.out.print("Usage: java -jar hw4.jar [-i [<file>|<directory>]|-v " +
                        "<file>|-c <sourceFile> <destFile>|-d <file1> <file2>]");
                return;
            }
        }

        //Error message
        else{
            System.out.print("Usage: java -jar hw4.jar [-i [<file>|<directory>]|-v " +
                    "<file>|-c <sourceFile> <destFile>|-d <file1> <file2>]");
            return;
        }

        //****************************************
        //*          Compare Method              *
        //****************************************

        //If compare == True

        if(compare)
        {
            //Iterators
            int x = 0;
            int y = 0;

            try{
                File file1 = new File(compareParam1);
                File file2 = new File(compareParam2);

                if(file1.length() == file2.length())
                {
                    // if same size continue on with the analysis
                    InputStream input1 = new BufferedInputStream(new FileInputStream(file1));

                    InputStream input2 = new BufferedInputStream(new FileInputStream(file2));

                    while(x != -1 || y != -1)
                    {
                        //This will return the next byte, or -1 if reached the end
                        x = input1.read();
                        y = input2.read();

                        // Print that the files are different
                        if(x != y)
                            System.out.println("The two files " + file1.getName()
                                    + " and " + file2.getName() + " are not the same.");
                    }
                    //Pritn that are the same
                    System.out.println("The two files" + file1.getName()
                            + " and " + file2.getName() + " are the same.");
                }
                else // if files are different size then are different by definition
                    System.out.println("The two files " + file1.getName()
                            + " and " + file2.getName() + " are not the same.");
            }
            // Catching the FIle not found exception
            catch(FileNotFoundException e)
            {
                System.out.println(e + "\n");
            }
        }


    }


    //****************************************************
    // Function: print Loop                              *
    // Description: Prints the content of a directory.   *
    // Author: Luciano Zavala                            *
    //****************************************************


    private static void printLoop(File[] filesList) {
        long size;
        for(File f : filesList)
        {
            size = f.length();

            if(f.isDirectory())
                System.out.print("*		");
            else
                System.out.print(size + "	 ");
            if(f.isDirectory())
                System.out.println(f.getName());
            if(f.isFile())
                System.out.println(f.getName());
        }
    }


    //****************************************************
    // Function: information Args1                       *
    // Description: compute and print the information on *
    //    on the directory.                              *
    // Author: Luciano Zavala                            *
    //****************************************************


    private static void informationArgs1(String f) {
        // code selected by user who passed the param "-i"
        //    and maybe a second parameter "file/folder"

        //create the file
        File file1 = new File(f);
        long size = 0;

        f = ".";

        System.out.println("Size   Filename");

        File[] filesArr = file1.listFiles();

        // Prints the list of files and directories with the size
        assert filesArr != null;

        printLoop(filesArr);
    }


    //****************************************************
    // Function: information Args2                       *
    // Description: compute and print the information on *
    //    on a specific file.                            *
    // Author: Luciano Zavala                            *
    //****************************************************


    private static void informationArgs2(String f) {

        File file1 = new File(f);
        long size = 0;

        //Evaluates if file is of file format
        if(file1.isFile())
        {
            long time = 0;

            // Print all the info of the file
            System.out.println("File Path: "+ file1.getAbsolutePath());
            System.out.print("Is executable? ");

            if(file1.canExecute())
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("Size: " + file1.length() + " bytes");

            // Set and print time frame of last time modified
            time = file1.lastModified();
            Date date = new Date(time);
            System.out.println("Last Modified Date: " + date);


        }
        //Evaluates if the file is a directory
        else if(file1.isDirectory())
        {
            f = ".";

            System.out.println("Size   Filename");
            File[] filesList = file1.listFiles();

            printLoop(filesList);
        }
        else
            // is NOT a valid if it is not a file OR directory
            System.out.print("Error: Invalid File");
    }


    //****************************************************
    // Function: View File                               *
    // Description: Creates an input and prints the      *
    //   the content of the file to the screen.          *
    // Author: Luciano Zavala                            *
    //****************************************************


    private static void viewFile(String f) {
        try{
            File file1 = new File(f);

            if(file1.isFile())
            {
                // set the input file
                Scanner fileInput = new Scanner(new File(f));

                while(fileInput.hasNextLine())
                {
                    // prints out each line while there are still lines to print
                    System.out.println(fileInput.nextLine());
                }
            }
            else
                System.out.print("Error: Invalid File");
        }
        // Catching block
        catch(FileNotFoundException ex)
        {
            // catch the file exception
            System.out.println(ex);
        }

    }


    //****************************************************
    // Function: Copy File                               *
    // Description: compute and copies the information   *
    //    on a file to a new one.                        *
    // Author: Luciano Zavala                            *
    //****************************************************


    private static Path copyFile(String f1, String f2){

        Path source = Paths.get(f1);
        Path destination = Paths.get(f2);

        if(Files.isRegularFile(source))
        {
            // source is a file
            if(Files.exists(destination))

                // destination is aleady a file. error, dont overwrite it!
                System.out.println("Error: Destination file already exists!");
            else {
                try
                {
                    Files.copy(source, destination);
                }
                catch(IOException ex)
                {
                    // catch the file reader exception
                    ex.getStackTrace();
                }
                System.out.println(source +
                        " was successfully copied to " + destination + "!\n");
            }
        }
        else
            System.out.print("Error: Source file is not valid");

        return destination;
    }


    //****************************************************
    // Function: Copy File                               *
    // Description: compute and compares the information *
    //    on a file to a the info in other.              *<------ If version: Function line 386 not working properly.
    // Author: Luciano Zavala                            *
    //****************************************************


/*
    private static void compareFile(String f1, String f2)
    {
        //Iterators
        int x = 0;
        int y = 0;

        try{
            File file1 = new File(f1);
            File file2 = new File(f1);

            if(file1.length() == file2.length())
            {
                // if same size continue on with the analysis
                InputStream input1 = new BufferedInputStream(new FileInputStream(file1));

                InputStream input2 = new BufferedInputStream(new FileInputStream(file2));

                while(x != -1 || y != -1)
                {
                    //This will return the next byte, or -1 if reached the end
                    x = input1.read();
                    y = input2.read();

                    // Print that the files are different
                    if(x != y)
                        System.out.println("The two files " + file1.getName()
                                + " and " + file2.getName() + " are not the same.");
                }
                //Pritn that are the same
                System.out.println("The two files" + file1.getName()
                        + " and " + file2.getName() + " are the same.");
            }
            else // if files are different size then are different by definition
                System.out.println("The two files " + file1.getName()
                        + " and " + file2.getName() + " are not the same.");
        }
        // Catching the FIle not found exception
        catch(FileNotFoundException e)
        {
            System.out.println(e + "\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }*/

}
