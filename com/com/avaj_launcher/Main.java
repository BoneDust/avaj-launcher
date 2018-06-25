package com.avaj_launcher;

import com.avaj_launcher.aircrafts.Aircraft;
import com.avaj_launcher.aircrafts.AircraftFactory;
import com.avaj_launcher.aircrafts.Baloon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    int main (String[] args)
    {
        if (args.length == 1)
        {
            String filename = args[0];
            if (Validation.isScenarioValid(filename))
            {
                WeatherTower tower = new WeatherTower();
                int simulations = initScenario(tower, filename);
                while (simulations > 0)
                {
                    tower.changeWeather();
                    simulations--;
                }
            }
            else
                return (0);
        }
        else
            System.out.println("Incorrect usage. Supply only the name of the scenario file.");
        return (0);
    }

    private int initScenario(WeatherTower tower, String filename)
    {
        BufferedReader br;
        AircraftFactory factory = new AircraftFactory();
        int simulations = 0, lines = 0;
        try
        {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null)
            {

                lines++;
                line = line.trim();
                if (lines == 1)
                    simulations =  Integer.parseInt(line);
                else
                {
                    String items[] = line.split("\\s+");
                    int x = Integer.parseInt(items[2]), y = Integer.parseInt(items[2]), z = Integer.parseInt(items[3]);
                    factory.newAircraft(items[0], items[1], x, y, z).registerTower(tower);
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println("Error in reading file");
            System.exit(0);
        }
        return (simulations);
    }
}
