package com.avaj_launcher.towers;

import com.avaj_launcher.aircrafts.Aircraft;
import com.avaj_launcher.aircrafts.Baloon;
import com.avaj_launcher.aircrafts.Flyable;
import com.avaj_launcher.aircrafts.JetPlane;

import java.util.ArrayList;

public class Tower
{
    private ArrayList<Flyable> observers = new ArrayList<>();

    protected void conditionsChanged()
    {
        //todo
    }

    private String getFlyableType(Flyable flyable)
    {
        if (flyable instanceof Baloon)
            return ("Baloon ");
        else if (flyable instanceof JetPlane)
            return ("JetPlane ");
        else
            return ("Helicopter ");
    }

    public void register(Flyable flyable)
    {
        String logMessage = "Tower says: " + getFlyableType(flyable);
        logMessage +=  ((Aircraft) flyable).getName() + "(" + ((Aircraft) flyable).getId()  + ") registered from weather tower.";
        System.out.println(logMessage);
        observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        for (Flyable aircraft :  observers )
        {
            if (aircraft == flyable)
            {
                String logMessage = "Tower says: " + getFlyableType(flyable);
                logMessage += ((Aircraft) aircraft).getName() + "(" + ((Aircraft) aircraft).getId()  + ") unregistered from weather tower.";
                System.out.println(logMessage);
                observers.remove(aircraft);
                break;
            }
        }

    }
}
