package com.company;
import java.lang.Double;
public class CmdLineAvg {

    public static void main(String[] args)
    {
        double total = 0.0, avg = 0.0;
        for (String arg : args)
        {
            total = total + Double.parseDouble(arg);
        }
	    avg = total / args.length;
	    System.out.printf("The average is: %.3f", avg);
    }
}

