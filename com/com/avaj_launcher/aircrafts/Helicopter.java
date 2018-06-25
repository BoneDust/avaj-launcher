package com.avaj_launcher.aircrafts;

import com.avaj_launcher.WeatherTower;

import java.util.HashMap;
import java.util.Map;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;
    private  Map<String, String> dictionary = new HashMap<String, String>();
    {
        dictionary.put("SUN","Lets  enjoy this nice weather boys.");
        dictionary.put("RAIN","Dammit I hate this rain.");
        dictionary.put("FOG","Flying blind here.");
        dictionary.put("SNOW","This weather might freeze my rotors.");
    }

    Helicopter(String name, Coordinates coordinates)
    {
        super(name,coordinates);
    }

    public void updateConditions()
    {
        int x, y, z;
        String weather = weatherTower.getWeather(coordinates);
        switch (weather)
        {
            case "SUN":
                x = coordinates.getLongitude() + 10;
                y = coordinates.getLatitude();
                z = (coordinates.getHeight() + 2 >= 100) ? 100 : coordinates.getHeight() + 2;
                coordinates = new Coordinates(x, y, z);
                System.out.println("Helicopter " + getName() + "(" + getId() + "): " + dictionary.get("SUN"));
                break;
            case "RAIN":
                x = coordinates.getLongitude() + 5;
                y = coordinates.getLatitude();
                z = coordinates.getHeight();
                coordinates = new Coordinates(x, y, z);
                System.out.println("Helicopter " + getName() + "(" + getId() + "): " + dictionary.get("RAIN"));
                break;
            case "FOG":
                x = coordinates.getLongitude() + 1;
                y = coordinates.getLatitude();
                z = coordinates.getHeight();
                coordinates = new Coordinates(x, y, z);
                System.out.println("Helicopter " + getName() + "(" + getId() + "): " + dictionary.get("FOG"));
                break;
            case "SNOW":
                x = coordinates.getLongitude();
                y = coordinates.getLatitude();
                z = (coordinates.getHeight()  - 12 <= 0) ? 0 : coordinates.getHeight() - 12;
                coordinates = new Coordinates(x, y, z);
                if (coordinates.getHeight() == 0)
                {
                    System.out.println("Helicopter " + getName() + "(" + getId() + "): Landing");
                    weatherTower.unregister(this);
                }
                else
                    System.out.println("Helicopter " + getName() + "(" + getId() + "): " + dictionary.get("SNOW"));
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}