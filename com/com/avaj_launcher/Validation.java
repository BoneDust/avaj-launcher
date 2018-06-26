package com.avaj_launcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Validation
{
    public static boolean isScenarioValid(String filename)
    {
        BufferedReader br;
        int simulations = -1, lines = 0;
        try
        {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null)
            {
                lines++;
                line = line.trim();
                if (simulations < 0 && isNumeric(line))//if we haven't received the number of simulations andthe current line happened to be a number
                    simulations = Integer.parseInt(line);
                else if (simulations >= 0)//if we've already obtained the number of simulations, i.e we must check if the line describes a valid aircraft.
                {
                    String  items[] = line.split("\\s+");
                    if ( !(items.length == 5 && isTypeValid(items[0]) && isNumeric(items[2]) && isNumeric(items[3]) &&isNumeric(items[4])))
                    {
                        System.out.println("Line " + lines + " is invalid or at the wrong position.");
                        return (false);
                    }
                }
                else // if we haven't received  the number of simulations and the current line is not a number
                {
                    System.out.println("Line " + lines + " is invalid or at the wrong position.");
                    return (false);
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println("Error in reading file");
            System.exit(0);
        }
        return (true);
    }

    private static boolean isNumeric(String line)
    {
        for (char c : line.toCharArray())
        {
            if (!Character.isDigit(c))
                return (false);
        }
        return (true);
    }

    private static boolean isTypeValid(String type)
    {
        if (type.equals("Baloon") || type.equals("JetPlane") || type.equals("Helicopter"))
            return (true);
        else
            return (false);
    }
}
