package avaj_launcher.towers;

import avaj_launcher.aircrafts.Flyable;

import java.util.ArrayList;

public class Tower
{
    private static ArrayList<Flyable> observers = new ArrayList<>();

    protected static void conditionsChanged()
    {
        //todo
    }

    public static void register(Flyable flyable)
    {
        observers.add(flyable);
    }

    public static void unregister(Flyable flyable)
    {
        for (Flyable aircraft :  observers )
        {
            if (aircraft == flyable)
            {
                observers.remove(aircraft);
                break;
            }
        }

    }
}
