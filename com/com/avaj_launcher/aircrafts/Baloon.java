package com.avaj_launcher.aircrafts;

import com.avaj_launcher.towers.WeatherTower;

import java.util.HashMap;
import java.util.Map;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;
    private Map<String, String> dictionary = new HashMap<String, String>();
    {
        dictionary.put("SUN", "Sunny days are perfect to take the balloon for spin.");
        dictionary.put("RAIN","Dammit I need heat not rain.");
        dictionary.put("FOG","Its always exciting to be flying in foggy weather.");
        dictionary.put("SNOW","This ain't proper weather to fly a balloon in.");
    }

    Baloon(String name, Coordinates coordinates)
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
                x = coordinates.getLongitude() + 2;
                y = coordinates.getLatitude();
                z = (coordinates.getHeight() + 4 >= 100) ? 100 : coordinates.getHeight() + 4;
                coordinates = new Coordinates(x, y, z);
                System.out.println("Baloon " + getName() + "(" + getId() + "): " + dictionary.get("SUN"));
                break;
            case "RAIN":
                x = coordinates.getLongitude();
                y = coordinates.getLatitude();
                z = (coordinates.getHeight()  - 5 <= 0) ? 0 : coordinates.getHeight() - 5;
                coordinates = new Coordinates(x, y, z);
                if (coordinates.getHeight() == 0)
                {
                    System.out.println("Baloon " + getName() + "(" + getId() + "): Landing");
                    weatherTower.unregister(this);
                }
                else
                    System.out.println("Baloon " + getName() + "(" + getId() + "): " + dictionary.get("RAIN"));
                break;
            case "FOG":
                x = coordinates.getLongitude();
                y = coordinates.getLatitude();
                z = (coordinates.getHeight()  - 3 <= 0) ? 0 : coordinates.getHeight() - 3;
                coordinates = new Coordinates(x, y, z);
                if (coordinates.getHeight() == 0)
                {
                    System.out.println("Baloon " + getName() + "(" + getId() + "): Landing");
                    weatherTower.unregister(this);
                }
                else
                    System.out.println("Baloon " + getName() + "(" + getId() + "): " + dictionary.get("FOG"));
                break;
            case "SNOW":
                x = coordinates.getLongitude();
                y = coordinates.getLatitude();
                z = (coordinates.getHeight()  - 15 <= 0) ? 0 : coordinates.getHeight() - 15;
                coordinates = new Coordinates(x, y, z);
                if (coordinates.getHeight() == 0)
                {
                    System.out.println("Baloon " + getName() + "(" + getId() + "): Landing");
                    weatherTower.unregister(this);
                }
                else
                    System.out.println("Baloon " + getName() + "(" + getId() + "): " + dictionary.get("SNOW"));
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
