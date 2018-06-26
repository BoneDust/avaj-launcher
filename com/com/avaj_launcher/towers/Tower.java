package com.avaj_launcher.towers;

import com.avaj_launcher.aircrafts.*;
import java.util.ArrayList;

public class Tower
{
    private ArrayList<Flyable> observers = new ArrayList<>();

    protected void conditionsChanged()
    {
        for (int i = 0; i < observers.size(); i++)
            observers.get(i).updateConditions();
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
        logMessage +=  ((Aircraft) flyable).getName() + "(" + ((Aircraft) flyable).getId()  + ") registered to weather tower.";
        System.out.println(logMessage);
        observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        for (int i = 0; i <observers.size(); i++)
        {
            if (observers.get(i) == flyable)
            {
                String logMessage = "Tower says: " + getFlyableType(flyable);
                logMessage += ((Aircraft) flyable).getName() + "(" + ((Aircraft) flyable).getId()  + ") unregistered from weather tower.";
                System.out.println(logMessage);
                observers.remove(flyable);
                break;
            }
        }

    }
}
